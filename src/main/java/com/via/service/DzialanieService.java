package com.via.service;

import com.via.model.Dzialanie;
import com.via.model.Obszar;
import com.via.model.Serwisant;
import com.via.repository.DzialanieRepository;
import com.via.repository.ObszarRepository;
import com.via.repository.SerwisantRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class DzialanieService {

    private DzialanieRepository dzialanieRepository;
    private ObszarRepository obszarRepository;
    private SerwisantRepository serwisantRepository;

    @Transactional
    public Dzialanie addDzialanieToObszar(int obszarId, int serwisantId, Dzialanie dzialanie) {
        Obszar obszar = obszarRepository.findById(obszarId)
                .orElseThrow(() -> new EntityNotFoundException("Obszar not found with id " + obszarId));
        Serwisant serwisant = serwisantRepository.findById(serwisantId)
                .orElseThrow(() -> new EntityNotFoundException("Serwisant not found with id " + serwisantId));

        dzialanie.setObszar(obszar);
        dzialanie.setSerwisant(serwisant);
        return dzialanieRepository.save(dzialanie);
    }
}
