package com.diabetestracker.repository;

import com.diabetestracker.model.Glycemie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface GlycemieRepository extends JpaRepository<Glycemie, Long> {
    @Query("SELECT g FROM Glycemie g WHERE g.date >= :startDate AND g.date < :endDate")
    List<Glycemie> findHourlyGlycemiaData(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);

    List<Glycemie> findAllByDate(LocalDateTime date);

    Glycemie findTopByOrderByDateDesc();
}
