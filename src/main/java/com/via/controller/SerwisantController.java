package com.via.controller;

import com.via.model.DzialaniaForSerwisantView;
import com.via.model.Serwisant;
import com.via.service.SerwisantService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@AllArgsConstructor
@RestController
@RequestMapping("/api/serwisanci")
public class SerwisantController {

    private SerwisantService serwisantService;

    @GetMapping
    public List<Serwisant> getAllSerwisants() {
        return serwisantService.getAllSerwisants();
    }

    @GetMapping("/dzialania")
    public List<DzialaniaForSerwisantView> getDzialaniaForAllSerwisants() {
        return serwisantService.getAllDzialaniaForSerwisants();
    }

    @PostMapping
    public Serwisant save(@RequestBody Serwisant serwisant) {
        return serwisantService.save(serwisant);
    }

    @PostMapping("/wyslij-dzialania")
    public void sendEmails() {
        serwisantService.sendEmails();
    }
}