package br.com.alura.dojoplaces;

import br.com.alura.dojoplaces.util.DateFormatter;
import jakarta.validation.constraints.Size;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.assertj.core.api.Assertions;

import java.time.LocalDateTime;

@SpringBootTest
public class DateFormatterTests {

    @Test
    void formatDateDDMMYYYY__should_return_the_date_formatted_when_date_is_valid() {
        LocalDateTime data = LocalDateTime.of(2025, 2, 5, 10, 10, 10);
        String formattedDate = DateFormatter.formatDateDDMMYYYY(data);
        Assertions.assertThat(formattedDate).isEqualTo("05/02/2025");
    }

    @Test
    void formatDateByDays_should_return_the_number_of_days_when_date_is_valid() {
        LocalDateTime data = LocalDateTime.of(2025, 2, 5, 10, 10, 10);
        String formattedDate = DateFormatter.formatDateByDays(data);


    }

}
