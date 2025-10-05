package com.lord.saludando.service;

import com.lord.saludando.model.Tutor;
import com.lord.saludando.repository.TutorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TutorService {

    private final TutorRepository tutorRepository;

    public List<Tutor> findAll() {
        return tutorRepository.findAll();
    }

    public Tutor create(Tutor tutor) {
        return tutorRepository.save(tutor);
    }
}
