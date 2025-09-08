package capitulo5;

public class Ejercicio02 {
    public static void main(String[] args) {


        //Datos de ejemplo
        String nombre = "Ana María";
        String apellido1 = "Gómez";
        String apellido2 = "Fandiño";

        //Usando String (concatenación)
        String nombreCompleto1 = nombre + " " + apellido1.toUpperCase() + " " + apellido2.toUpperCase();
        System.out.println("Usando String: " + nombreCompleto1);

        //Usando StringBuilder
        StringBuilder nombreCompleto2 = new StringBuilder();
        nombreCompleto2.append(nombre);
        nombreCompleto2.append(" ");
        nombreCompleto2.append(apellido1.toUpperCase());
        nombreCompleto2.append(" ");
        nombreCompleto2.append(apellido2.toUpperCase());
        System.out.println("Usando StringBuilder: " + nombreCompleto2);
    }

}
