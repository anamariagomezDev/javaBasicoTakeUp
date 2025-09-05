package capitulo4;

public class Ejercicio08 {
    public static void main(String[] args) {
        if(args.length == 0){
            System.out.println("No se han recibido argumentos");
        }else {
            int i = 0;
            System.out.println("Los argumentos recibidos son:");

            //se ejecuta al menos una vez. por lo que cuando llegue a fin lo imprime
            do {
                //imprimo el argumento actual.
                System.out.println(args[i]);
                //avanzo al siguiente argumento.
                i++;
            }

            //Sigo mientras no haya llegado al final de los argumentos.
            //y mientras el argumento anterior no sea "fin"
            //No es sino hasta el final que se detiene cuando encuentra fin para garantizar que se imprima.
            while(i < args.length && !args[i -1].equals("fin"));

        }
    }
}
