package br.com.alura.dojoplaces.util;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateFormatter {

    public static String formatDateDDMMYYYY(LocalDateTime date) {
        if (date != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            return date.format(formatter);
        }
        return "";
    }

    public static String formatDateByDays(LocalDateTime date) {
        if (date != null) {
            Duration duration = Duration.between(date, LocalDateTime.now());
            long days = duration.toDays();

            if (days == 0) {
                return "Atualizado hoje.";
            } else if (days == 1) {
                return "Atualizado há 1 dia";
            } else {
                return "Atualizado há " + days + " dias.";
            }
        }
        return "Sem atualizações";
    }

}
