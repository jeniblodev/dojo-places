package br.com.alura.dojoplaces.validator;

import br.com.alura.dojoplaces.model.LocationDTO;
import br.com.alura.dojoplaces.repository.LocationRepository;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


@Component
public class CreateLocationFormValidator implements Validator {
    private final LocationRepository locationRepository;

    public CreateLocationFormValidator(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) { return LocationDTO.class.isAssignableFrom(clazz); }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()) return;
        LocationDTO locationDTO = (LocationDTO) target;
        if (locationRepository.existsByCode(locationDTO.getCode())) {
            errors.rejectValue("code", "", "O código digitado já existe.");
        }
    }

}
