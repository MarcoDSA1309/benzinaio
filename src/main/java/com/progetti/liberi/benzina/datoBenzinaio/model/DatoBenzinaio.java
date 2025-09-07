package com.progetti.liberi.benzina.datoBenzinaio.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "dati_benzinai")
@Getter
@NoArgsConstructor
public class DatoBenzinaio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate data;

    private Long codice_benzinaio;

    private Double prezzo_desiel;

    private Double prezzo_benziana;

    private Double servito_desiel;

    private Double servito_benzina;

    @CreationTimestamp
    @Column(updatable = false, name = "created_at")
    private LocalDateTime creationDate;



}
