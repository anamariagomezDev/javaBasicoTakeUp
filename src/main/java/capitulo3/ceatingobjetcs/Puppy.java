package capitulo3.ceatingobjetcs;

public class Puppy {
    /*
     * Constructor vacío
     */
    public Puppy() {}

    /*
     * Constructor con un parámetro de tipo String llamado name
     */
    public Puppy(String name) {
        System.out.println("Passed Name is : " + name);
    }

    public static void main(String[] args) {
        /*
         * Se crea un objeto Puppy al que se llama myPuppy y se hace uso para ello
         * del constructor con parámetros
         * Es importante remarcar que siempre que se cree un objeto, se hará uso de
         la palabra reservada new
         */
        Puppy myPuppy = new Puppy("Tommy");


    }
}
