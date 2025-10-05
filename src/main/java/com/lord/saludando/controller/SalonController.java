package com.lord.saludando.controller;

import com.lord.saludando.model.Salon;
import com.lord.saludando.model.dto.SalonCreateDTO;
import com.lord.saludando.service.SalonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class SalonController {

    private final SalonService salonService;

    @PostMapping("/salon")
    public ResponseEntity<Salon> createTutor(@Validated @RequestBody SalonCreateDTO dto) {

        Salon salon = Salon.builder()
                .codigo(dto.getCodigo())
                .grado(dto.getGrado())
                .build();

        Salon savedSalon = salonService.crearSalon(salon);

        return new ResponseEntity<>(savedSalon, HttpStatus.CREATED);
    }

    @PostMapping("salon/fix")
    public ResponseEntity<Salon> createSalon (@Validated @RequestBody SalonCreateDTO dto) {
        Salon savedSalon = salonService.crearSalonDTO(dto);
        return new ResponseEntity<>(savedSalon, HttpStatus.CREATED);
    }
}
