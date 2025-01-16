package br.com.alura.dojoplaces.model;
import jakarta.persistence.*;
import jdk.jfr.Enabled;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String code;
    private String address;
    private String city;
    private LocalDateTime dateCreation = LocalDateTime.now();
    private LocalDateTime dateUpdate  = LocalDateTime.now();

    public Location() {
    }

    public Location(String name, String code, String address, String city, LocalDateTime dateCreation, LocalDateTime dateUpdate) {
        this.name = name;
        this.code = code;
        this.address = address;
        this.city = city;
        this.dateCreation = dateCreation;
        this.dateUpdate = dateUpdate;
    }
}
