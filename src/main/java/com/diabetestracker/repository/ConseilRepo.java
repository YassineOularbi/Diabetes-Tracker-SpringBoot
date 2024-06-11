package com.diabetestracker.repository;

import com.diabetestracker.enums.Level;
import com.diabetestracker.model.Conseil;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConseilRepo extends JpaRepository<Conseil,Long> {
    Conseil findByLevel(Level level);


}
