package capitulo6;

public class DemoCapitulo6 {
    public static void main(String[] args) {
        // 10. OBJETOS – Declarar un ciclista con su bici
        Ciclista ciclista = new Ciclista("Ana", "Madrid", "Gran Vía", 15, true);

        Luz del = new Luz("Blanco", 80);
        Luz tras = new Luz("Rojo", 90);
        Bicicleta bici = new Bicicleta("Azul", 7, del, tras);

        ciclista.comprarBici(bici); // añade a su colección

        // 11. MENSAJES – Encender luces, arrancar, acelerar a 10 km/h y usar la segunda marcha
        System.out.println("\n--- Secuencia de acciones ---");

        // (a) Encender luces (desde el ciclista, elige la bici índice 0)
        ciclista.encenderLucesDeBici(0);
        ciclista.apagarLucesDeBici(0);

        // (b) Arrancar: marcha y velocidad pasan a 1
        bici.arrancar();
        bici.setMarchaActual(1);
        bici.setVelocidadActual(1);
        bici.frenar(1);


        // (c) Acelerar hasta 10 km/h (si ya está a 1, incrementa 9)
        double objetivo = 10.0;
        double delta = Math.max(0, objetivo - bici.getVelocidadActual());
        if (delta > 0) bici.acelerar(delta);

        // (e) Usar la segunda marcha
        if (bici.getMarchaActual() < 2) bici.subirMarcha(); // de 1 -> 2
        else { bici.setMarchaActual(2); System.out.println("Se ha puesto la marcha a 2."); }

        // Mostrar estado final
        System.out.println("\nEstado final:");
        System.out.println(ciclista);
        System.out.println(bici);
    }
}
