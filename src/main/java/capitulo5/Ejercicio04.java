package capitulo5;

import java.text.Normalizer;
import java.util.*;
import java.util.stream.Collectors;

public class Ejercicio04 {

    public static void main(String[] args) {
        List<Person> personas = new ArrayList<>(List.of(
                new Person("Ana"),
                new Person("Ángel"),
                new Person("Ángela"),
                new Person("Andrés"),
                new Person("Antonia"),
                new Person("Óscar"),
                new Person("Oso"),
                new Person("Luz"),
                new Person("Lu"),
                new Person("Luis"),
                new Person("Lucía"),
                new Person("Álvaro"),
                new Person("Alba")
        ));

        // Mapa <Trigrama, Conteo>
        Map<String, Long> conteos = personas.stream()
                .map(p -> trigram(p.getNombre()))
                .collect(Collectors.groupingBy(t -> t, Collectors.counting()));

        // Ordenar por frecuencia desc y luego alfabético
        List<Map.Entry<String, Long>> ranking = conteos.entrySet().stream()
                .sorted(Comparator.<Map.Entry<String, Long>>comparingLong(Map.Entry::getValue).reversed()
                        .thenComparing(Map.Entry::getKey))
                .collect(Collectors.toList());

        // Salida
        System.out.println("=== Estadísticas por trigrama ===");
        for (Map.Entry<String, Long> e : ranking) {
            System.out.printf("%s -> %d%n", e.getKey(), e.getValue());
        }

        // (Opcional) mostrar qué personas pertenecen a cada trigrama
        System.out.println("\n=== Detalle por trigrama ===");
        Map<String, List<String>> detalle = personas.stream()
                .collect(Collectors.groupingBy(
                        p -> trigram(p.getNombre()),
                        Collectors.mapping(Person::getNombre, Collectors.toList())
                ));

        ranking.forEach(e -> {
            System.out.printf("%s: %s%n", e.getKey(), detalle.get(e.getKey()));
        });

        // === Estadísticas adicionales ===
        System.out.println("\n=== Resumen ===");

        long totalPersonas = personas.size();
        long trigramasDistintos = conteos.size();
        long trigramasUnicos = conteos.values().stream().filter(v -> v == 1).count();
        long maxFrecuencia = conteos.values().stream().mapToLong(Long::longValue).max().orElse(0);
        long minFrecuencia = conteos.values().stream().mapToLong(Long::longValue).min().orElse(0);
        double promedio = conteos.values().stream().mapToLong(Long::longValue).average().orElse(0.0);

        // Buscar trigramas más y menos frecuentes
        List<String> masComunes = conteos.entrySet().stream()
                .filter(e -> e.getValue() == maxFrecuencia)
                .map(Map.Entry::getKey)
                .toList();

        List<String> menosComunes = conteos.entrySet().stream()
                .filter(e -> e.getValue() == minFrecuencia)
                .map(Map.Entry::getKey)
                .toList();

        System.out.println("Total de personas: " + totalPersonas);
        System.out.println("Trigramas distintos: " + trigramasDistintos);
        System.out.println("Trigramas únicos (solo 1 persona): " + trigramasUnicos);
        System.out.println("Frecuencia máxima: " + maxFrecuencia + " -> " + masComunes);
        System.out.println("Frecuencia mínima: " + minFrecuencia + " -> " + menosComunes);
        System.out.printf("Promedio de frecuencia: %.2f%n", promedio);

        // Histograma simple
        System.out.println("\n=== Histograma ===");
        ranking.forEach(e -> {
            System.out.printf("%-5s | %s (%d)%n",
                    e.getKey(),
                    "*".repeat(Math.toIntExact(e.getValue())),
                    e.getValue());
        });
    }

    // Calcula el trigrama de un nombre (3 primeras letras sin acentos/espacios, en mayúsculas)
    private static String trigram(String nombre) {
        if (nombre == null) return "";
        String normalizado = Normalizer.normalize(nombre, Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "");          // quita acentos
        String soloLetras = normalizado.replaceAll("[^A-Za-z]", ""); // quita no letras
        String up = soloLetras.toUpperCase(Locale.ROOT);
        return up.length() <= 3 ? up : up.substring(0, 3);
    }

    // POJO simple
    public static class Person {
        private final String nombre;
        public Person(String nombre) { this.nombre = nombre; }
        public String getNombre() { return nombre; }
        @Override public String toString() { return nombre; }
    }
}
