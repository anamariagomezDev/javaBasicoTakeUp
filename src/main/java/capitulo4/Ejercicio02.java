package capitulo4;

public class Ejercicio02 {

    private long base;
    private long hauteur;

    // Constructor
    public Ejercicio02(long base, long hauteur) {
        this.base = base;
        this.hauteur = hauteur;
    }

    // Método que devuelve el área
    public String aire() {
        long aire = base * hauteur;
        return "El rectángulo de base: " + base + " y altura: " + hauteur + " tiene un área de: " + aire;
    }

    public static void main(String[] args) {
        // Crear objeto con base y altura
        Ejercicio02 rectangle1 = new Ejercicio02(10, 10);

        // Mostrar resultado
        System.out.println(rectangle1.aire());
    }
}
