package com.via.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "serwisant", schema = "SIT")
public class Serwisant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int identyfikator;
    private String nazwisko;
    private boolean aktywny;
    private String email;

    @JsonIgnore
    @OneToMany(mappedBy = "serwisant")
    private List<Obszar> obszary = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "serwisant")
    private List<Dzialanie> dzialania = new ArrayList<>();
}