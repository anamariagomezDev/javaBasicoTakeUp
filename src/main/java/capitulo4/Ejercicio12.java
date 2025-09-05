package capitulo4;

import java.util.Random;
import java.util.Scanner;

public class Ejercicio12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // ✅ ahora sí tenemos el Scanner
        Random random = new Random();

        System.out.println("=== Juego Piedra - Papel - Tijeras ===");
        System.out.println("Reglas:");
        System.out.println(" - Piedra gana a Tijeras");
        System.out.println(" - Tijeras gana a Papel");
        System.out.println(" - Papel gana a Piedra");
        System.out.println("Escribe tu jugada: Piedra, Papel, Tijeras o Salir");

        boolean seguir = true;

        while (seguir) {
            // pedir jugada al jugador
            System.out.print("\nTu jugada: ");
            String jugador = sc.nextLine().trim().toLowerCase();

            // comprobar si quiere salir
            if (jugador.equals("salir")) {
                System.out.println("Gracias por jugar. ¡Adiós!");
                seguir = false;
                continue;
            }

            // validar jugada
            if (!(jugador.equals("piedra") || jugador.equals("papel") || jugador.equals("tijeras"))) {
                System.out.println("Entrada inválida. Escribe: Piedra, Papel, Tijeras o Salir.");
                continue;
            }

            // jugada aleatoria del ordenador
            int num = random.nextInt(3); // 0, 1 o 2
            String ordenador = switch (num) {
                case 0 -> "piedra";
                case 1 -> "papel";
                default -> "tijeras";
            };

            System.out.println("Ordenador: " + ordenador);

            // decidir quién gana
            if (jugador.equals(ordenador)) {
                System.out.println("Resultado: ¡Empate!");
            } else if (
                    (jugador.equals("piedra") && ordenador.equals("tijeras")) ||
                            (jugador.equals("tijeras") && ordenador.equals("papel")) ||
                            (jugador.equals("papel") && ordenador.equals("piedra"))
            ) {
                System.out.println("Resultado: ¡Tú ganas!");
            } else {
                System.out.println("Resultado: Gana el ordenador.");
            }
        }

        sc.close();
    }
}
