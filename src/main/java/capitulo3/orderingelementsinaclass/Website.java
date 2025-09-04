/*
 * Declaración del package (primera línea de la clase).
 */
package capitulo3.orderingelementsinaclass;
/*
 * Imports, después de la declaración del paquete.
 */

import java.util.Calendar;
import java.util.Date;

/*
 * Capítulo 3: Bloques básicos en Java
 *
 * @author SopraSteria
 *
 * Esta clase pretende mostrar la estructura de una clase Java sencilla.
 * Como se puede ver, los comentarios pueden estar en cualquier parte de la clase.
 *
 */
/*
 * Declaración de la clase
 */
public class Website {
    /*
     * Variables de instancia
     */
    String webName;
    int webAge;

    /*
     * Constructor de la clase
     */
    Website(String name, int age) {
        this.webName = name;
        this.webAge = age;
    }

    /*
     * Métodos de la clase
     */
    public Date fechaActual() {
        Calendar c1 = Calendar.getInstance();
        return c1.getTime();
    }
}