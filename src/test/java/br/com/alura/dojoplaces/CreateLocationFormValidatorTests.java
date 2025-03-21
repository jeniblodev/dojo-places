package br.com.alura.dojoplaces;

import br.com.alura.dojoplaces.model.LocationDTO;
import br.com.alura.dojoplaces.model.LocationEditDTO;
import br.com.alura.dojoplaces.repository.LocationRepository;
import br.com.alura.dojoplaces.validator.CreateLocationFormValidator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.validation.Errors;

import static org.mockito.Mockito.when;

@SpringBootTest
public class CreateLocationFormValidatorTests {
    @Mock
    private LocationRepository locationRepository;

    @Mock
    private Errors errors;

    @Mock
    private CreateLocationFormValidator validator;

    @Test
    void validate_should_not_add_error_when_code_does_not_exist() {
        LocationDTO locationDTO = new LocationDTO("Sorveteria Pikachu", "123456", "Rua 61", "Sol");
        String code = locationDTO.getCode();

        when(locationRepository.existsByCode(code)).thenReturn(false);
        when(errors.hasErrors()).thenReturn(false);

        validator.validate(locationDTO, errors);

        Assertions.assertThat(errors.hasErrors()).isFalse();
    }

    @Test
    void validate_should_add_error_when_code_already_exists() {
        LocationDTO locationDTO = new LocationDTO("Sorveteria Pikachu", "123456", "Rua 61", "Sol");
        String code = locationDTO.getCode();

        when(locationRepository.existsByCode(code)).thenReturn(true);
        when(errors.hasErrors()).thenReturn(true);

        validator.validate(locationDTO, errors);

        Assertions.assertThat(errors.hasErrors()).isTrue();
    }
}
