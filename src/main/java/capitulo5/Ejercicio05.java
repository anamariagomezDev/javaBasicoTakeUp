package capitulo5;

import java.text.Normalizer;

public class Ejercicio05 {

    public static void main(String[] args) {
        String palabraConAcentos = "gómez corazón música piñata árbol maría";
        String resultado = quitarAcentos(palabraConAcentos);

        System.out.println("Original: " + palabraConAcentos);
        System.out.println("Sin acentos: " + resultado);
    }

    public static String quitarAcentos(String texto) {
        // Normaliza el texto para separar letras de sus acentos
        String normalizado = Normalizer.normalize(texto, Normalizer.Form.NFD);
        // Elimina los diacríticos (acentos y tildes)
        return normalizado.replaceAll("\\p{M}", "");
    }
}
