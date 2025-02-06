package br.com.alura.dojoplaces.model;

import br.com.alura.dojoplaces.util.DateFormatter;

public class LocationListDTO {
    private String name;
    private String code;
    private String address;
    private String city;
    private String dateCreation;
    private String dateUpdate;

    public LocationListDTO(Location location) {
        this.name = location.getName();
        this.code = location.getCode();
        this.address = location.getAddress();
        this.city = location.getCity();
        this.dateCreation = DateFormatter.formatDateDDMMYYYY(location.getDateCreation());
        this.dateUpdate = DateFormatter.formatDateByDays(location.getDateUpdate());
    }

    public String getDateUpdate() {
        return dateUpdate;
    }

    public String getDateCreation() {
        return dateCreation;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }


}
