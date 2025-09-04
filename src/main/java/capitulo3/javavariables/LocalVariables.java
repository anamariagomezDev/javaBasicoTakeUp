package capitulo3.javavariables;

public class LocalVariables {
    /*
     * Variable de instancia myVar
     */
    public String myVar = "instance variable";

    public void myMethod() {
        /*
         * Variable local myVar
         */
        String myVar = "Inside Method";
        System.out.println(myVar);
    }

    public static void main(final String args[]) {
        /*
         * Se crea un objeto LocalVariables llamado obj
         */
        LocalVariables obj = new LocalVariables();
        System.out.println("Calling Method");
        obj.myMethod();
        System.out.println(obj.myVar);
    }

}
