package capitulo5;

public class Ejercicio03 {

    //Un trigrama es, en general, una secuencia de 3 caracteres
    // (pueden ser letras, números o símbolos).
    public static void main(String[] args) {

        //Datos de ejemplo
        String nombre = "Ana María";
        String apellido1 = "Gomez";
        String apellido2 = "Fandiño";

        // --- Usando String ---
        char inicialNombre = nombre.charAt(0);
        char inicialApellido1 = apellido1.charAt(0);
        char finalApellido2 = apellido2.charAt(apellido2.length() - 1);

        String trigrama = "" + inicialNombre + inicialApellido1 + finalApellido2;
        System.out.println("Trigrama (String): " + trigrama.toUpperCase());

        // --- Usando StringBuilder ---
        StringBuilder sb = new StringBuilder();
        sb.append(inicialNombre)
                .append(inicialApellido1)
                .append(finalApellido2);

        System.out.println("Trigrama (StringBuilder): " + sb.toString().toUpperCase());

    }
}
