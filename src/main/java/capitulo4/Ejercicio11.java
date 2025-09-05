package capitulo4;

public class Ejercicio11 {
    public static void main(String[] args) {
        //. OPERADOR TERNARIO – Se deberá calcular el valor absoluto de un float.
        float num = - 0.5f;
        //Para calcular el valor absoluto de un float con el operador ternario:
        //- Si el número es menor que 0, devuelve su opuesto (-x).
        //- Si no, devuelve el mismo número.
        System.out.println("El valor absoluto de " + num + " es: " + (num < 0 ? -num : num));
    }
}
