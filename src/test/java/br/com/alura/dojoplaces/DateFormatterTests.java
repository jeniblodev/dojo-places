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
    void formatDateByDays_should_return_todays_message_when_date_is_today() {
        LocalDateTime data = LocalDateTime.now();
        String formattedDate = DateFormatter.formatDateByDays(data);
        Assertions.assertThat(formattedDate).isEqualTo("Atualizado hoje.");
    }

    @Test
    void formatDateByDays_should_return_1day_message_when_date_is_yesterday() {
        LocalDateTime data = LocalDateTime.now().minusDays(1);
        String formattedDate = DateFormatter.formatDateByDays(data);
        Assertions.assertThat(formattedDate).isEqualTo("Atualizado há 1 dia.");
    }

    @Test
    void formatDateByDays_should_return_number_of_days_message_when_date_is_more_than_1_day() {
        LocalDateTime data = LocalDateTime.now().minusDays(5);
        String formattedDate = DateFormatter.formatDateByDays(data);
        Assertions.assertThat(formattedDate).isEqualTo("Atualizado há 5 dias.");
    }

    @Test
    void formatDateByDays_should_return_not_updated_message_when_location_not_updated() {
        LocalDateTime data = null;
        String formattedDate = DateFormatter.formatDateByDays(data);
        Assertions.assertThat(formattedDate).isEqualTo("Sem atualizações");
    }

}
