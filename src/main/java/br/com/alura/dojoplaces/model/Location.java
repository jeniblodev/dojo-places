package br.com.alura.dojoplaces.model;
import jakarta.persistence.*;
import jdk.jfr.Enabled;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Table(name = "Location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String code;
    private String address;
    private String city;
    private LocalDateTime dateCreation = LocalDateTime.now();
    private LocalDateTime dateUpdate;

    public Location() {
    }

    public Location(String name, String code, String address, String city) {
        this.name = name;
        this.code = code;
        this.address = address;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public LocalDateTime getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDateTime dateCreation) {
        this.dateCreation = dateCreation;
    }

    public LocalDateTime getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(LocalDateTime dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    public Long getId() {
        return id;
    }

    public Location update(LocationEditDTO locationEditDTO) {
        this.name = locationEditDTO.getName();
        this.code = locationEditDTO.getCode();
        this.address = locationEditDTO.getAddress();
        this.city = locationEditDTO.getCity();
        this.setDateUpdate(LocalDateTime.now());

        return this;
    }
}
