package com.via.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "dzialanie", schema = "SIT")
public class Dzialanie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int identyfikator;
    private String opisDzialania;
    private int planowanyCzas;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "identyfikator_serwisanta")
    private Serwisant serwisant;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "identyfikator_obszaru")
    private Obszar obszar;
}