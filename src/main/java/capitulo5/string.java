package capitulo5;

public class string {
    public static void main(final String[] args) {
        char[] helloArray = {'h', 'e', 'l', 'l', 'o'};
        String helloString = new String(helloArray); //no se usa.toString() porque imprime el valor de la referencia
        System.out.println(helloString);

        int len = helloString.length();
        System.out.println("String Length is: " + len);

        helloString = helloString.concat(" World   ");
        System.out.println(helloString);

        System.out.println("String Index 6 is: " + helloString.charAt(6));

        System.out.println(helloString.indexOf('1')); //devuelve -1 si no encuentra el caracter

        System.out.println(helloString.indexOf('l'));//devulve la posición de la primera aparicion del caracter

        /*
                    ¿Para qué se usa .substring()?
                - Extraer palabras clave de una frase
                - Dividir URLs o rutas de archivos
                - Obtener iniciales de nombres
                - Recortar texto para mostrar solo una parte
                - Procesar datos en formularios o archivos

        */
        System.out.println(helloString.substring(3));

        System.out.println(helloString.toUpperCase());

        /*
            compara el contenido de dos cadenas, no si son el mismo objeto
            en memoria. Es la forma correcta de comparar textos en Java.
        */
        System.out.println(helloString.equals("ABC"));


        System.out.println(helloString.startsWith("a"));

        System.out.println(helloString.contains("W"));

        System.out.println(helloString.replace('l', 'a'));

        /*
        * .trim()); // Elimina los espacios en blanco al inicio y al final de la cadena helloString
        * */
        System.out.println(helloString.trim());

        String str = "world";
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        System.out.println(sb);


    }
}
