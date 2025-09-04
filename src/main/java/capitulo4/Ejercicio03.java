package capitulo4;

public class Ejercicio03 {
    public static void main(String[] args) {
        // Verificar que se pasaron exactamente 2 argumentos
        if (args.length != 2) {
            System.out.println("Uso: java capitulo4.Ejercicio02 <lado1> <lado2>");
            return;
        }

        try {
            // Convertir argumentos a números
            long base = Long.parseLong(args[0]);
            long altura = Long.parseLong(args[1]);

            // Calcular área
            long area = base * altura;

            // Imprimir resultado
            System.out.println("El rectángulo de " + base + " por " + altura + " tiene un área de " + area);
        } catch (NumberFormatException e) {
            System.out.println("Error: los argumentos deben ser números enteros.");
        }
    }
}
