package capitulo6;

public class StaticTest {
    //capo privado (clase) y estático (compartido por todas las instancias)
    private static int x = 10;

    //Campo de instancia (cada objeto tiene su propio valor)
    private int y = 20;

    public static void StaticNumX(){
        x++;
        System.out.println("x is: "+x);
    }


    public void NormalNum(){
        y++;
        System.out.println("y is: "+y);

    }
    public static void main(String[] args) {

        StaticTest obj1 = new StaticTest();
        StaticTest obj2 = new StaticTest();
        obj1.StaticNumX();
        obj2.NormalNum();

    }
}
