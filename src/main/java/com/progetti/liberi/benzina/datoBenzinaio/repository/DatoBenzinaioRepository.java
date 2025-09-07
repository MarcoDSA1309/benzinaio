package com.progetti.liberi.benzina.datoBenzinaio.repository;

import com.progetti.liberi.benzina.datoBenzinaio.model.DatoBenzinaio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface DatoBenzinaioRepository extends JpaRepository<DatoBenzinaio, Long> {
    List<DatoBenzinaio> findByData(LocalDate data);
    List<DatoBenzinaio> findByDataBetween(LocalDate start, LocalDate end);
    Optional<DatoBenzinaio> findTopByOrderByDataDesc();
}
