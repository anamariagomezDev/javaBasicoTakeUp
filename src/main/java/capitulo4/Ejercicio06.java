package capitulo4;

public class Ejercicio06 {
    public static void main(String[] args) {
        if(args.length == 0){ //Si no se pasan argumentos.
            System.out.println("No se han recibido argumentos");
        }else{
            System.out.println("Los argumentos recibidos son:");
            for(int i=0; i<args.length; i++){
                //for (String arg : args) -> Solo muestra el valor del argumento, no la posición.
                System.out.println(i + " - " + args[i]);
            }
        }
    }
}
