package capitulo3.destroyingobjects;

public class DestroyingObjects {

    public static void main(final String args[]) {
        DestroyingObjects obj = new DestroyingObjects();
        /*
         * El objeto al que hace referencia obj es destruído y recogido por el GC
         */
        obj = null;
        DestroyingObjects a = new DestroyingObjects();
        DestroyingObjects b = new DestroyingObjects();
        /*
         * El objeto al que apunaba b es recogido por el GB al cambiar
         * su referencia al objeto al que apunta a
         */
        b = a;

        /*
         * Se invoca al Garbage Collector
         */
        System.gc();
    }

    /*
    @Override
    protected void finalize() throws Throwable {
        System.out.println("Garbage collection is performed by JVM");
    }
    */

}
