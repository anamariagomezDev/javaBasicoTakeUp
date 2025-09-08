package capitulo5;

import java.util.StringJoiner;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ejercicio06 {

    private static final int MAX = 30000;

    public static void main(String[] args) {
        // Calentamiento (JIT warm-up)
        buildWithPlus();
        buildWithStringBuilder();
        buildWithStringBuffer();
        buildWithStringJoiner();
        buildWithStreams();

        System.out.println("Comparando técnicas para generar: 1-2-3-...-" + MAX);
        System.out.println();

        bench("String (+ en bucle)", Ejercicio06::buildWithPlus);
        bench("StringBuilder", Ejercicio06::buildWithStringBuilder);
        bench("StringBuffer", Ejercicio06::buildWithStringBuffer);
        bench("StringJoiner", Ejercicio06::buildWithStringJoiner);
        bench("Streams + joining", Ejercicio06::buildWithStreams);
    }

    private static void bench(String name, Supplier<String> builder) {
        // Forzar GC (no garantiza nada, pero ayuda a “limpiar” antes de medir)
        System.gc();
        sleepQuiet(100);

        Runtime rt = Runtime.getRuntime();
        long usedBefore = usedMemory(rt);
        long t0 = System.nanoTime();

        String s = builder.get();

        long t1 = System.nanoTime();
        long usedAfter = usedMemory(rt);

        // Validación mínima
        boolean ok = s.startsWith("1-2-") && s.endsWith(String.valueOf(MAX));

        long timeMs = (t1 - t0) / 1_000_000;
        long deltaBytes = Math.max(0, usedAfter - usedBefore);

        System.out.printf("%-20s | tiempo: %6d ms | memoria: %10d bytes | len=%d | ok=%s%n",
                name, timeMs, deltaBytes, s.length(), ok ? "sí" : "no");
    }

    private static long usedMemory(Runtime rt) {
        return rt.totalMemory() - rt.freeMemory();
    }

    private static void sleepQuiet(long ms) {
        try { Thread.sleep(ms); } catch (InterruptedException ignored) {}
    }

    // ===================== Técnicas =====================

    // 1) String con + (ineficiente)
    private static String buildWithPlus() {
        String res = "";
        for (int i = 1; i <= MAX; i++) {
            res += i;
            if (i < MAX) res += "-";
        }
        return res;
    }

    // 2) StringBuilder (rápido y eficiente)
    private static String buildWithStringBuilder() {
        StringBuilder sb = new StringBuilder(MAX * 6); // capacidad aproximada
        for (int i = 1; i <= MAX; i++) {
            sb.append(i);
            if (i < MAX) sb.append('-');
        }
        return sb.toString();
    }

    // 3) StringBuffer (sincronizado; más lento)
    private static String buildWithStringBuffer() {
        StringBuffer sb = new StringBuffer(MAX * 6);
        for (int i = 1; i <= MAX; i++) {
            sb.append(i);
            if (i < MAX) sb.append('-');
        }
        return sb.toString();
    }

    // 4) StringJoiner
    private static String buildWithStringJoiner() {
        StringJoiner joiner = new StringJoiner("-");
        for (int i = 1; i <= MAX; i++) {
            joiner.add(Integer.toString(i));
        }
        return joiner.toString();
    }

    // 5) Streams + Collectors.joining("-")
    private static String buildWithStreams() {
        return IntStream.rangeClosed(1, MAX)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining("-"));
    }
}
