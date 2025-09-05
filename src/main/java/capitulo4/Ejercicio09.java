package capitulo4;

public class Ejercicio09 {

    //Compruebo que se haya recibido un argumento
    public static void main(String[] args) {
        //meto un argumento para probar
        args = new String[]{"2"};
        //Compruebo que se haya recibido solo un argumento
        if(args.length != 1){
            System.out.println("Debe ingresar un solo número de mes");
            return; //salto del programa
        }

        try{
            //Convierto el qargumento en un número entero porque args es un array de String
            //Lo hago envolviendolo con la clase padre y parseandolo como entero.
            int mes = Integer.parseInt(args[0]); //
            //Si el usuario escribe algo que no es un número (hola), lanza NumberFormatException.

            //Uso un swith para decir los días.
            //Ignoro los los años bisiestos, o sea, febrero=28

            switch (mes){
                case 1:  // enero
                case 3:  // marzo
                case 5:  // mayo
                case 7:  // julio
                case 8:  // agosto
                case 10: // octubre
                case 12: // diciembre
                    System.out.println("El mes " + mes + " tiene 31 días.");
                    break;

                case 4:  // abril
                case 6:  // junio
                case 9:  // septiembre
                case 11: // noviembre
                    System.out.println("El mes " + mes + " tiene 30 días.");
                    break;

                case 2:  // febrero (sin bisiesto)
                    System.out.println("El mes 2 tiene 28 días.");
                    break;

                default:
                    System.out.println("Número de mes inválido. Debe estar entre 1 y 12.");
                    break;
            }

        }catch(NumberFormatException e){
            System.out.println("El argumento debe ser un número entero");
        }



    }

}
