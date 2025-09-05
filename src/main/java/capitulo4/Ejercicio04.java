package capitulo4;

public class Ejercicio04 {
    public static void main(String[] args) {

        //Comprobar número de argumentos que recibe el programa
        int numArgs = args.length;
        //Si no recibe argumentos, se avisa al usuario.
        if (numArgs == 0) {
            System.out.println("No se han recibido argumentos");
        //Si recibe hasta 4 argumentos, se avisa al usuario cuantos ha recibido.
        } else if (numArgs <= 4) {

                System.out.println("Se han recibido " + numArgs + " argumentos");
            }
        //Sí recibe más de 4 argumentos, se avisa al usuario.
        else {
            System.out.println("Se han recibido mas de 4 argumentos");
        }
    }
}
