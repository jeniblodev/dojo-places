package br.com.alura.dojoplaces.validator;

import br.com.alura.dojoplaces.model.LocationEditDTO;
import br.com.alura.dojoplaces.repository.LocationRepository;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


@Component
public class UpdateLocationFormValidator implements Validator {
    private final LocationRepository locationRepository;

    public UpdateLocationFormValidator(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) { return LocationEditDTO.class.isAssignableFrom(clazz); }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()) return;
        LocationEditDTO locationEditDTO = (LocationEditDTO) target;
        if (locationRepository.existsByCodeAndIdNot(locationEditDTO.getCode(), locationEditDTO.getId())) {
            errors.rejectValue("code", "", "O código digitado já existe.");
        }
    }

}
