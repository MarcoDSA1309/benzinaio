package com.progetti.liberi.benzina.datoBenzinaio.service;

import com.progetti.liberi.benzina.datoBenzinaio.model.DatoBenzinaio;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


public interface DatoBenzinaioService {
    Optional<DatoBenzinaio> findById(long id);
    List<DatoBenzinaio> findAll();
    List<DatoBenzinaio> findByData(LocalDate data);
    List<DatoBenzinaio> findByDataBetween(LocalDate start, LocalDate end);
    Optional<DatoBenzinaio> getLatestData();
}
