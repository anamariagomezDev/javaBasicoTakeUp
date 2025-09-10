package capitulo5.arraylist;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListType {

    public static void main(String[] args) {

        ArrayList<String> obj = new ArrayList<String>();

        obj.add("Juan");
        obj.add("Harry");
        obj.add("Carlos");
        obj.add("David");
        obj.add("Pablo");
        System.out.println("Elements of the array: " + obj);

        obj.add(4, "Elena");
        obj.add(2, "Carla");
        obj.remove("David");
        obj.remove("Harry");
        obj.set(0, "Rob"); // corregido

        System.out.println(obj.isEmpty());
        System.out.println(obj.size());
        System.out.println(obj.contains("Carla"));
        System.out.println("Current array list is: " + obj);

        Collections.sort(obj);
        System.out.println("Sorted array list is: " + obj);

        obj.clear();
        System.out.println(obj.isEmpty());
    }
}
