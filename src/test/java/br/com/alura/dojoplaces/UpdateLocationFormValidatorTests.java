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
public class UpdateLocationFormValidatorTests {
    @Mock
    private LocationRepository locationRepository;

    @Mock
    private Errors errors;

    @Mock
    private CreateLocationFormValidator validator;

    @Test
    void validate_should_not_add_error_when_code_does_not_exist_or_belong_to_same_id() {
        LocationEditDTO locationEditDTO = new LocationEditDTO("Sorveteria Pikachu", "123456", "Rua 61", "Sol");
        String code = locationEditDTO.getCode();
        Long id = locationEditDTO.getId();

        when(locationRepository.existsByCodeAndIdNot(code, id)).thenReturn(false);
        when(errors.hasErrors()).thenReturn(false);

        validator.validate(locationEditDTO, errors);

        Assertions.assertThat(errors.hasErrors()).isFalse();
    }

    @Test
    void validate_should_add_error_when_code_already_exists_for_different_id() {
        LocationEditDTO locationEditDTO = new LocationEditDTO("Sorveteria Pikachu", "123456", "Rua 61", "Sol");
        String code = locationEditDTO.getCode();
        Long id = locationEditDTO.getId();

        when(locationRepository.existsByCodeAndIdNot(code, id)).thenReturn(true);
        when(errors.hasErrors()).thenReturn(true);

        validator.validate(locationEditDTO, errors);

        Assertions.assertThat(errors.hasErrors()).isTrue();
    }
}
