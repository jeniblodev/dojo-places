package br.com.alura.dojoplaces.model;

import jakarta.validation.constraints.*;

public class LocationEditDTO {

    private Long id;

    @Size(max = 100, message = "O nome não pode ultrapassar 100 caracteres.")
    private String name;

    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "O código deve conter letras e números.")
    private String code;

    @Size(max = 100, message = "O bairro não pode ultrapassar 100 caracteres.")
    private String address;

    @Size(max = 100, message = "A cidade não pode ultrapassar 100 caracteres.")
    private String city;

    public LocationEditDTO() {
    }

    public LocationEditDTO(String name, String code, String address, String city) {
        this.name = name;
        this.code = code;
        this.address = address;
        this.city = city;
    }

    public LocationEditDTO(Location location) {
        this.id = location.getId();
        this.name = location.getName();
        this.code = location.getCode();
        this.address = location.getAddress();
        this.city = location.getCity();
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Location toModel() { return new Location(name, code, address, city);}
}
