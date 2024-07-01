package com.via.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "obszar")
public class Obszar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int identyfikator;
    private String nazwa;
    private boolean aktywny;

    @ManyToOne
    @JoinColumn(name = "identyfikator_serwisanta")
    private Serwisant serwisant;

    @OneToMany(mappedBy = "obszar")
    private List<Dzialanie> dzialania = new ArrayList<>();
}