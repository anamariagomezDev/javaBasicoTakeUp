package capitulo4;

public class Ejercicio10 {
    public static void main(String[] args) {
        // Meto los argumentos manualmente para probar (ancho=10, alto=5)
        args = new String[]{"10", "5"};
        //Verificar que se han recibido solo dos argumentos
        if (args.length != 2) {
            System.out.println("Deben ser dos argumentos");
            return; // para método breack para bucles
        }
        int ancho = Integer.parseInt(args[0]);
        int alto = Integer.parseInt(args[1]);
        System.out.println("Ancho: " + ancho + " Alto: " + alto);

        //Calculo el área
        int area = ancho * alto;

        //Elijo el cáracter según el resto de la división por 3
        char caracter;
        if (area % 3 == 0) {
            caracter = '#';
        } else if (area % 3 == 1) {
            caracter = '%';
        } else {
            caracter = 'X';
        }

        //Dibujar el rectángulo
        for (int fila = 0; fila < alto; fila++) {
            for (int col = 0; col < ancho; col++) {
                System.out.print(caracter);

            }
            System.out.println();
        }
    }
}
