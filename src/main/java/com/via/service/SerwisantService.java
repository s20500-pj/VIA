package com.via.service;

import com.via.model.DzialaniaForSerwisantView;
import com.via.model.Serwisant;
import com.via.repository.DzialaniaForSerwisantRepository;
import com.via.repository.SerwisantRepository;
import com.via.utils.NotifyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class SerwisantService {

    private SerwisantRepository serwisantRepository;
    private DzialaniaForSerwisantRepository dzialaniaForSerwisantRepository;

    private NotifyService notifyService;

    public List<Serwisant> getAllSerwisants() {
        return serwisantRepository.findAll();
    }

    public List<DzialaniaForSerwisantView> getAllDzialaniaForSerwisants() {
        return dzialaniaForSerwisantRepository.findAll();
    }

    public Serwisant save(Serwisant serwisant) {
        return serwisantRepository.save(serwisant);
    }

    public void sendEmails() {
        serwisantRepository.findAll().forEach(serwisant -> {
            String message = formatMessage(serwisant);
            notifyService.notify(serwisant.getEmail(), message);
        });
    }

    private String formatMessage(Serwisant serwisant) {
        String dzialaniaDetails = serwisant.getDzialania().stream()
                .map(dzialanie -> String.format("Opis: %s, Planowany czas: %d, Obszar: %s",
                        dzialanie.getOpisDzialania(),
                        dzialanie.getPlanowanyCzas(),
                        dzialanie.getObszar().getNazwa()))
                .collect(Collectors.joining("\n"));

        return String.format("Lista działań dla serwisanta %s:\n%s",
                serwisant.getNazwisko(),
                dzialaniaDetails);
    }
}