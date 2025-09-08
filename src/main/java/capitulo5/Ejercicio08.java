package capitulo5;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class Ejercicio08 {

    public static void main(String[] args) {
        // Definimos fecha actual
        LocalDateTime ahora = LocalDateTime.now();

        // ==== FORMATEO A STRING ====
        DateTimeFormatter formato1 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        DateTimeFormatter formato2 = DateTimeFormatter.ofPattern("EEEE, dd 'de' MMMM yyyy HH:mm:ss", new Locale("es", "ES"));

        String fechaStr1 = ahora.format(formato1);
        String fechaStr2 = ahora.format(formato2);

        System.out.println("Fechas formateadas:");
        System.out.println("Formato 1: " + fechaStr1);
        System.out.println("Formato 2: " + fechaStr2);

        // ==== PARSEO DE VUELTA A LocalDateTime ====
        // Ojo: formato2 tiene nombres de días/meses → se necesita locale
        LocalDateTime fechaParseada1 = LocalDateTime.parse(fechaStr1, formato1);
        LocalDateTime fechaParseada2 = LocalDateTime.parse(fechaStr2, formato2);

        System.out.println("\nFechas parseadas:");
        System.out.println("Parseada 1: " + fechaParseada1);
        System.out.println("Parseada 2: " + fechaParseada2);

        // ==== CONVERTIR LocalDateTime → java.util.Date ====
        Date fechaDate = Date.from(fechaParseada1.atZone(ZoneId.systemDefault()).toInstant());
        System.out.println("\nConvertida a java.util.Date: " + fechaDate);
    }
}
