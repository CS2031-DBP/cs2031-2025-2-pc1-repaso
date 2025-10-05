package com.lord.saludando.service;

import com.lord.saludando.model.Salon;
import com.lord.saludando.model.dto.SalonCreateDTO;
import com.lord.saludando.repository.SalonRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SalonService {

    private final SalonRepository salonRepository;
    private final ModelMapper modelMapper;

    public Salon crearSalon(Salon salon) {
        return salonRepository.save(salon);
    }

    public Salon crearSalonDTO(SalonCreateDTO dto){
        Salon salonToSave = modelMapper.map(dto, Salon.class);
        return salonRepository.save(salonToSave);
    }

}
