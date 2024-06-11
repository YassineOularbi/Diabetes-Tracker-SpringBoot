package com.diabetestracker.service;

import com.diabetestracker.exception.DiabeticNotFoundException;
import com.diabetestracker.model.Conseil;
import com.diabetestracker.model.Diabetic;
import com.diabetestracker.repository.ConseilRepo;
import com.diabetestracker.repository.DiabeticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConseilService {

    @Autowired
    private ConseilRepo conseilRepo;

    public List<Conseil> getAll(){
        return conseilRepo.findAll();
    }

    public Conseil save(Conseil conseil) {
        return conseilRepo.save(conseil);
    }

    public Conseil getById(Long id) {
        return conseilRepo.findById(id).orElseThrow(DiabeticNotFoundException::new);
    }

    public void delete(Long id) {
        conseilRepo.findById(id).orElseThrow(DiabeticNotFoundException::new);
        conseilRepo.deleteById(id);
    }
}
