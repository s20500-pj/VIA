package com.via.controller;

import com.via.model.Obszar;
import com.via.model.ObszarWithSerwisantView;
import com.via.model.Serwisant;
import com.via.service.ObszarService;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@AllArgsConstructor
@RestController
@RequestMapping("/api/obszary")
public class ObszarController {

    private ObszarService obszarService;

    @GetMapping
    public ResponseEntity<List<ObszarWithSerwisantView>> getAllObszars() {
        return ResponseEntity.ok(obszarService.getAllObszars());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Obszar> get(@NotNull @PathVariable Integer id) {
        return ResponseEntity.ok(obszarService.get(id));
    }

    @PutMapping("/{obszarId}/update-serwisant")
    public ResponseEntity<Obszar> updateSerwisantForObszar(@NotNull @PathVariable Integer obszarId,
                                                           @NotNull @RequestBody Serwisant serwisant) {
        Obszar updatedObszar = obszarService.updateSerwisantForObszar(obszarId, serwisant);
        return ResponseEntity.ok(updatedObszar);
    }
}