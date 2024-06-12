package com.diabetestracker.service;

import com.diabetestracker.enums.Level;
import com.diabetestracker.model.Conseil;
import com.diabetestracker.repository.ConseilRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ConseilService {
    @Autowired
    private ConseilRepo conseilRepo;

    @Autowired
    private GlycemieService glycemieService;

    public Optional<Conseil> getConseilByLevel(Level level) {
        return conseilRepo.findByLevel(level);
    }


    public void saveConseil(Conseil conseil) {
        conseilRepo.save(conseil);
    }

    public java.lang.Object getAllConseils() {
        return null;
    }

    public void deleteConseilById(java.lang.Long id) {
    }
}
