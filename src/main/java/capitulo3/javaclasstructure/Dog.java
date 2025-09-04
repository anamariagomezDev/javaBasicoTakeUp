/*
 * Copyright 2018
 */
package capitulo3.javaclasstructure;

/*
 * Capítulo 3: Bloques básicos en Java
 * Esta clase define objetos tipo Dog.
 * Los tres atributos de la clase Dog son breed, age y color.
 * @author SopraSteria
 */
public class Dog {

    /*
     * Atributos de la clase Dog.
     */
    String breed;
    int age;
    String color;



/*
 * Los tres métodos de la clse Dog son barking, hungry y sleeping.
 */

/*
 * Método que realiza un ladrido
 * @param bark contiene el número de ladridos
 * @return bark un enteri con el número de ladridos modificado
 */

public int barking(int bark) {
    bark = bark + 1;
    return bark;
} //Cierre método barking

    /*
     *Método en blanco
     */
void hungry() {}

    /*
     *Método en blanco
     */
void sleeping() {}

}//Cierre de la clase dog