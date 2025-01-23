package br.com.alura.dojoplaces.model;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class LocationDTO {
    @NotNull (message = "O nome é obrigatório.")
    @NotBlank (message = "O nome não pode estar em branco.")
    @Size(max = 100, message = "O nome não pode ultrapassar 100 caracteres.")
    private String name;

    @NotNull (message = "O código é obrigatório.")
    @NotBlank (message = "O código é obrigatório.")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "O código deve conter letras e números.")
    private String code;

    @NotNull (message = "O bairro é obrigatório.")
    @NotBlank (message = "O bairro é obrigatório.")
    @Size(max = 100, message = "O bairro não pode ultrapassar 100 caracteres.")
    private String address;

    @NotNull (message = "A cidade é obrigatória.")
    @NotBlank (message = "A cidade é obrigatória.")
    @Size(max = 100, message = "A cidade não pode ultrapassar 100 caracteres.")
    private String city;

    public LocationDTO() {
    }

    public LocationDTO(String name, String code, String address, String city) {
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

    public Location toModel() { return new Location(name, code, address, city);}
}
