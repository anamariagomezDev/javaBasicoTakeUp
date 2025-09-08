package capitulo5;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

public class Ejercicio09 {

    public static void main(String[] args) {
        // === Fechas/hora actuales ===
        LocalDate hoy = LocalDate.now();
        LocalDateTime ahora = LocalDateTime.now();
        ZoneId zona = ZoneId.systemDefault();

        System.out.println("Hoy: " + hoy);
        System.out.println("Ahora: " + ahora);
        System.out.println("Zona: " + zona);
        System.out.println();

        // === Crear fechas específicas ===
        LocalDate fechaCumple = LocalDate.of(1990, Month.MARCH, 15);
        LocalDateTime fechaHoraEspecifica = LocalDateTime.of(2025, 12, 31, 23, 59, 59);
        System.out.println("Fecha específica: " + fechaCumple);
        System.out.println("Fecha y hora específica: " + fechaHoraEspecifica);
        System.out.println();

        // === Suma / Resta (dias, meses, años, horas, minutos) ===
        LocalDate dentro7Dias = hoy.plusDays(7);
        LocalDate hace2Semanas = hoy.minusWeeks(2);
        LocalDate dentro3Meses = hoy.plusMonths(3);
        LocalDate hace1Anio = hoy.minusYears(1);

        LocalDateTime en90Min = ahora.plusMinutes(90);
        LocalDateTime menos12Horas = ahora.minusHours(12);

        System.out.println("Hoy + 7 días: " + dentro7Dias);
        System.out.println("Hoy - 2 semanas: " + hace2Semanas);
        System.out.println("Hoy + 3 meses: " + dentro3Meses);
        System.out.println("Hoy - 1 año: " + hace1Anio);
        System.out.println("Ahora + 90 min: " + en90Min);
        System.out.println("Ahora - 12 horas: " + menos12Horas);
        System.out.println();

        // === Ajustes útiles de calendario ===
        LocalDate primeroMes = hoy.with(TemporalAdjusters.firstDayOfMonth());
        LocalDate ultimoMes = hoy.with(TemporalAdjusters.lastDayOfMonth());
        LocalDate proximoLunes = hoy.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        LocalDate viernesAnteriorOSame = hoy.with(TemporalAdjusters.previousOrSame(DayOfWeek.FRIDAY));

        System.out.println("Primer día del mes: " + primeroMes);
        System.out.println("Último día del mes: " + ultimoMes);
        System.out.println("Próximo lunes: " + proximoLunes);
        System.out.println("Viernes anterior (o hoy si es viernes): " + viernesAnteriorOSame);
        System.out.println();

        // === Fin de mes “seguro” al sumar meses (manejo de 30/31/28-29) ===
        // Si hoy es 31, plusMonths puede “rebotar” al último día del mes resultante
        LocalDate finDeMesActual = hoy.with(TemporalAdjusters.lastDayOfMonth());
        LocalDate mismoDiaEn3MesesFinSeguro = finDeMesActual.plusMonths(3).with(TemporalAdjusters.lastDayOfMonth());
        System.out.println("Fin de este mes: " + finDeMesActual);
        System.out.println("Fin de mes dentro de 3 meses: " + mismoDiaEn3MesesFinSeguro);
        System.out.println();

        // === Diferencias entre fechas (Period y ChronoUnit) ===
        LocalDate inicio = LocalDate.of(2024, 1, 1);
        LocalDate fin = LocalDate.of(2025, 9, 8);

        long diasEntre = ChronoUnit.DAYS.between(inicio, fin);
        long mesesEntre = ChronoUnit.MONTHS.between(inicio, fin);
        long aniosEntre = ChronoUnit.YEARS.between(inicio, fin);

        Period periodo = Period.between(inicio, fin); // años, meses, días “calendario”
        System.out.println("Entre " + inicio + " y " + fin + " -> días: " + diasEntre +
                ", meses: " + mesesEntre + ", años: " + aniosEntre);
        System.out.println("Period (calendario): " + periodo.getYears() + " años, " +
                periodo.getMonths() + " meses, " + periodo.getDays() + " días");
        System.out.println();

        // === Duraciones (para tiempos con hora) ===
        LocalDateTime t1 = LocalDateTime.of(2025, 9, 8, 8, 0);
        LocalDateTime t2 = LocalDateTime.of(2025, 9, 8, 17, 30);
        Duration duracion = Duration.between(t1, t2);
        System.out.println("Duración entre " + t1 + " y " + t2 + ": " +
                duracion.toHours() + " h (" + duracion.toMinutes() + " min)");
        System.out.println();

        // === YearMonth y operaciones por mes (facturación, cierres, etc.) ===
        YearMonth ymActual = YearMonth.now();
        YearMonth ymSiguiente = ymActual.plusMonths(1);
        LocalDate primerDiaYmSig = ymSiguiente.atDay(1);
        LocalDate ultimoDiaYmSig = ymSiguiente.atEndOfMonth();
        System.out.println("YearMonth actual: " + ymActual);
        System.out.println("Siguiente YearMonth: " + ymSiguiente);
        System.out.println("1er día del próximo mes: " + primerDiaYmSig);
        System.out.println("Último día del próximo mes: " + ultimoDiaYmSig);
        System.out.println();

        // === Formateo de salida ===
        DateTimeFormatter fmtEs = DateTimeFormatter.ofPattern("EEEE, dd 'de' MMMM yyyy HH:mm:ss", new java.util.Locale("es", "ES"));
        System.out.println("Ahora (bonito ES): " + ahora.format(fmtEs));

        // === Zonas horarias (opcional) ===
        ZonedDateTime madrid = ZonedDateTime.now(ZoneId.of("Europe/Madrid"));
        ZonedDateTime ny = madrid.withZoneSameInstant(ZoneId.of("America/New_York"));
        System.out.println("Madrid: " + madrid);
        System.out.println("Nueva York (mismo instante): " + ny);
    }
}
