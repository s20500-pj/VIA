package com.via.controller;

import com.via.model.Dzialanie;
import com.via.service.DzialanieService;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@AllArgsConstructor
@RestController
@RequestMapping("/api/dzialania")
public class DzialanieController {

    private DzialanieService dzialanieService;

    @PostMapping("/add/{obszarId}/{serwisantId}")
    public ResponseEntity<Dzialanie> addDzialanieToObszar(@NotNull @PathVariable Integer obszarId,
                                                          @NotNull @PathVariable Integer serwisantId,
                                                          @NotNull @RequestBody Dzialanie dzialanie) {
        Dzialanie newDzialanie = dzialanieService.addDzialanieToObszar(obszarId, serwisantId, dzialanie);
        return ResponseEntity.ok(newDzialanie);
    }
}
