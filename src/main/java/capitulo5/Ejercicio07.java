package capitulo5;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Ejercicio07 {

    public static void main(String[] args) {
        // Fecha y hora actual
        LocalDateTime ahora = LocalDateTime.now();

        // Formatos básicos
        DateTimeFormatter formato1 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        DateTimeFormatter formato2 = DateTimeFormatter.ofPattern("EEEE, dd 'de' MMMM yyyy HH:mm:ss", new Locale("es", "ES"));
        DateTimeFormatter formato3 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter formato4 = DateTimeFormatter.ofPattern("MMMM dd, yyyy hh:mm a", Locale.ENGLISH);

        System.out.println("========= FORMATOS EN ESPAÑOL =========");
        System.out.println("Formato 1 (dd/MM/yyyy HH:mm:ss): " + ahora.format(formato1));
        System.out.println("Formato 2 (largo en español):   " + ahora.format(formato2));

        System.out.println("\n========= FORMATOS EN INGLÉS =========");
        System.out.println("Formato 3 (ISO-like):           " + ahora.format(formato3));
        System.out.println("Formato 4 (Mes dd, yyyy hh:mm a): " + ahora.format(formato4));

        System.out.println("\n========= OTROS IDIOMAS =========");
        DateTimeFormatter formatoFr = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy HH:mm:ss", Locale.FRENCH);
        DateTimeFormatter formatoDe = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy HH:mm:ss", Locale.GERMAN);
        DateTimeFormatter formatoIt = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy HH:mm:ss", Locale.ITALIAN);

        System.out.println("Francés:  " + ahora.format(formatoFr));
        System.out.println("Alemán:   " + ahora.format(formatoDe));
        System.out.println("Italiano: " + ahora.format(formatoIt));
    }
}
