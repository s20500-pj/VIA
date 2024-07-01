package com.via.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "obszar_with_serwisant_view")
public class ObszarWithSerwisantView {
    @Id
    private Integer obszarId;
    private String obszarNazwa;
    private boolean obszarAktywny;
    private Integer serwisantId;
    private String serwisantNazwisko;
    private String serwisantEmail;
}
