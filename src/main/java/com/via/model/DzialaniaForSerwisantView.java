package com.via.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "dzialania_for_serwisant_view")
public class DzialaniaForSerwisantView {

    @Id
    private Integer dzialanieId;
    private String opisDzialania;
    private Integer planowanyCzas;
    private Integer serwisantId;
    private String nazwisko;
    private String email;
    private String obszarNazwa;
}