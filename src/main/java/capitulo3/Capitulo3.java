package capitulo3;

import java.util.Random; //sí uso * se importa todo el paquete

public class Capitulo3 {

    public static String TEXTO1 = "Esto es un String";

    //se inicializa como null y luego en el main se asigna un valor
    public static String TEXTO2;

    /**Primitivo #1 entero */
    private int num;
    // Primitivo #2 flotante
    private double decimal;

    /** Atributo de tipo random*/
    private Random randomAtribute;

    //Bloque 1 (al principio de la clase): imprime el valor actual de num
    {
        System.out.println("Bloque #1 Valor actual de num: " + num);
    }

    /**
     * Constructor público que inicializa los tres primeros atributos
     * (num, decimal y random).
     *
     * @param num valor para el campo {@link #num}
     * @param decimal valor para el campo {@link #decimal}
     * @param randomAtribute instancia de {@link Random}
     */
    public Capitulo3(int num, double decimal, Random randomAtribute) {

        //12. variaable local de constructor (no accesible fuera de este bloque)
        String localEnConstructor = "Esta variable solo es accesible en este bloque";
        this.num = num;
        this.decimal = decimal;
        this.randomAtribute = (randomAtribute != null) ? randomAtribute : new Random();

        //Uso de la variable local para evitar warning de no utilizada
        System.out.println("Constructor: " + localEnConstructor);

    }
        //Bloque #2 (al final de la clase): muestra mensaje
    {
        System.out.println("“Este bloque es\n" +
                "un inicializador de instancia”");
    }

    //----Métodos ---

    /**
     * Devuelve un número aleatorio en el rango [0, 5] usando el atributo {@link # randomAtribute}.
     * @return entero entre 0 y 5, ambos inclusive.
     */

    private int aleatorio0a5() {
        return randomAtribute.nextInt(6); // 0---5
    }

    public int getNum() {
        return num;
    }

    public double getDecimal() {
        return decimal;
    }

    public Random getRandomAtribute() {
        return randomAtribute;
    }

    /**
     * AVISO: {@code finalize()} está obsoleto y su ejecución NO está garantizada.

    @Override
    @SuppressWarnings("deprecation")
    protected void finalize() throws Throwable {
        try {
            System.out.println("finalize() llamado para Capitulo3 con num=" + num);
        } finally {
            super.finalize();
        }
    }
     */

    /*
     * @Param args si hay alguno, mostrará: "Me has mandado el texto: " + args[0]
     */
    public static void main(String[] args) {

        System.out.println("Estoy aprendiendo a programar en Java");

        //5. Mostrar el primer argumento si existe
        if(args != null && args.length > 0){
            /* System.out.println no tiene una sobrecarga que reciba dos
             * argumentos separados por coma (String, Object). Por eso,uso
             * printf y el placeholder
             */
            System.out.printf("Me has mandado el texto: %s", args[0]);
        }

        //6 Crear un objeto de tipo Random
        Random random = new Random();

        /* Imprimo aleatorio entre 0 y 9 */
        System.out.println("Aleatorio 0..9: " + random.nextInt(10));

        //10. Crear un objeto Capitulo3 con un literal numérico en hexadecimal
        int numHex = 0x2A; //42 en decimal
        double dec = 3.14;
        Capitulo3 obj_capitulo3 = new Capitulo3(numHex, dec, random);

        //11 Mostrar los dos String estáticos
        System.out.println("TEXTO1: " + TEXTO1);
        System.out.println("TEXTO2: " + TEXTO2);

        //11. Mostrar los tres atributos (random entre 0..5)
        System.out.println("num: " + obj_capitulo3.getNum());
        System.out.println("decimal: " + obj_capitulo3.getDecimal());
        System.out.println("randomAtribute 0..5: " + obj_capitulo3.aleatorio0a5());

        // 14. Crear dos objetos y dejarlos sin referencia; sugerir GC
        Capitulo3 o1 = new Capitulo3(010, 1.0, null); // 010 es octal (=8)
        Capitulo3 o2 = new Capitulo3(0xF, 2.0, null); // 0xF es hexadecimal (=15)
        o1 = null;
        o2 = null;

        // Sugerencias al GC (no garantizan nada)
        System.gc();
        //System.runFinalization();

    }

}
