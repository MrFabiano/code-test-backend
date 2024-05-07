package cross;

import jakarta.enterprise.context.ApplicationScoped;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@ApplicationScoped
public class ZonedDateFactory {

    // Método para obter a data atual com o fuso horário padrão
    public LocalDate getCurrentDate() {
        return ZonedDateTime.now(ZoneId.systemDefault()).toLocalDate();
    }
}
