package com.progetti.liberi.benzina.datoBenzinaio.service.impl;

import com.progetti.liberi.benzina.datoBenzinaio.model.DatoBenzinaio;
import com.progetti.liberi.benzina.datoBenzinaio.repository.DatoBenzinaioRepository;
import com.progetti.liberi.benzina.datoBenzinaio.service.DatoBenzinaioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class DatoBenzinaioServiceStandard implements DatoBenzinaioService {

    private final DatoBenzinaioRepository datoBenzinaioRepository;

    @Autowired
    public DatoBenzinaioServiceStandard(DatoBenzinaioRepository datoBenzinaioRepository){
        this.datoBenzinaioRepository = datoBenzinaioRepository;
    }

    @Override
    public Optional<DatoBenzinaio> findById(long id) {
        return datoBenzinaioRepository.findById(id);
    }

    @Override
    public List<DatoBenzinaio> findAll() {
        return datoBenzinaioRepository.findAll();
    }

    @Override
    public List<DatoBenzinaio> findByData(LocalDate data) {
        return datoBenzinaioRepository.findByData(data);
    }

    @Override
    public List<DatoBenzinaio> findByDataBetween(LocalDate start, LocalDate end) {
        return datoBenzinaioRepository.findByDataBetween(start,end);
    }

    public Optional<DatoBenzinaio> getLatestData(){
        return datoBenzinaioRepository.findTopByOrderByDataDesc();
    }
}
