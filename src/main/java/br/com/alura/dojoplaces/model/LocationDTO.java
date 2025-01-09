package br.com.alura.dojoplaces.model;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class LocationDTO {
    @NotNull
    @Size(max = 100)
    private String name;

    @NotNull
    private String code;

    @NotNull
    @Size(max = 100)
    private String address;

    @NotNull
    @Size(max = 100)
    private String city;

    @NotNull
    @PastOrPresent
    private LocalDate dateCreation;

    private LocalDate dateUpdate;

    public LocationDTO() {
    }

    public LocationDTO(String name, String code, String address, String city, LocalDate dateCreation) {
        this.name = name;
        this.code = code;
        this.address = address;
        this.city = city;
        this.dateCreation = dateCreation;
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

    public LocalDate getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDate dateCreation) {
        this.dateCreation = dateCreation;
    }

    public LocalDate getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(LocalDate dateUpdate) {
        this.dateUpdate = dateUpdate;
    }
}
