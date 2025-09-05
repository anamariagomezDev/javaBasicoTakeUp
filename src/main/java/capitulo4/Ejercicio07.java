package capitulo4;

public class Ejercicio07 {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No se han recibido argumentos");
        } else {
            int i = 0;
            System.out.println("Los argumentos recibidos son:");
            // Bucle while:
            // Se repite mientras:
            //   1)  (i < args.length) < por que empieza la posición en 0
            //   2) equals compara el contenido de la cadena. == referencia en memoria
            //   3) args[i].equals("fin") resulta falsa, por lo que el bucle ni siquiera entra a imprimirlo.
            while (i < args.length && !args[i].equals("fin")) {
                System.out.println(args[i]);
                i++;
            }
        }
    }
}
