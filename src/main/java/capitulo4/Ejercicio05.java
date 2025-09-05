package capitulo4;

public class Ejercicio05 {
    public static void main(String[] args) {
        //Meto el for each en un if - else por si no se pasan argumentos.
        if (args.length == 0) {
            System.out.println("No se han recibido argumentos");
        } else {
            System.out.println("Los argumentos recibidos son:");

            //For each loop para listar todos los argumentos que se pasaron al programa.
            for (String arg : args) {
                System.out.println(arg);
            }
        }
    }
}
