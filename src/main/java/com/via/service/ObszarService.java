package com.via.service;

import com.via.model.Obszar;
import com.via.model.ObszarWithSerwisantView;
import com.via.model.Serwisant;
import com.via.repository.ObszarRepository;
import com.via.repository.ObszarWithSerwisantRepository;
import com.via.repository.SerwisantRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ObszarService {

    private ObszarRepository obszarRepository;
    private ObszarWithSerwisantRepository obszarWithSerwisantRepository;
    private SerwisantRepository serwisantRepository;

    public List<ObszarWithSerwisantView> getAllObszars() {
        return obszarWithSerwisantRepository.findAll();
    }

    public Obszar get(Integer id) {
        Optional<Obszar> obszar = obszarRepository.findById(id);
        if (obszar.isPresent()) {
            return obszar.get();
        }
        throw new EntityNotFoundException();
    }

    @Transactional
    public Obszar updateSerwisantForObszar(int obszarId, Serwisant updatedSerwisant) {
        Obszar obszar = obszarRepository.findById(obszarId)
                .orElseThrow(() -> new EntityNotFoundException("Obszar not found with id " + obszarId));

        Serwisant serwisant = serwisantRepository.findById(updatedSerwisant.getIdentyfikator())
                .orElseThrow(() -> new EntityNotFoundException("Serwisant not found with id " + updatedSerwisant.getIdentyfikator()));

        serwisant.setNazwisko(updatedSerwisant.getNazwisko());
        serwisant.setEmail(updatedSerwisant.getEmail());
        serwisant.setAktywny(updatedSerwisant.isAktywny());
        serwisantRepository.save(serwisant);

        obszar.setSerwisant(serwisant);
        return obszarRepository.save(obszar);
    }
}