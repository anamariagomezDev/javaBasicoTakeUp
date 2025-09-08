package capitulo5.arrays;

import java.util.Arrays;

public class ArrayType {
    public static void main(String[] args) {
        int[] myList = {1, 2, 3, 4};

        System.out.println("Arreglo original:");
        printArray(myList);

        // Guardamos el resultado del método reverse
        myList = reverse(myList);

        System.out.println("Arreglo invertido:");
        printArray(myList);

        // para ordenarlo:
        // Arrays.sort(myList);

        // Ejemplo de búsqueda binaria (solo funciona bien si está ordenado)
         System.out.println(Arrays.binarySearch(myList, 3));
    }

    public static void printArray(int[] myList) {
        for (int i = 0; i < myList.length; i++) {
            System.out.print(myList[i] + " ");
        }
        System.out.println();
    }

    public static int[] reverse(int[] list) {
        int[] result = new int[list.length];
        for (int i = 0, j = result.length - 1; i < list.length; i++, j--) {
            result[j] = list[i];
        }
        return result;
    }
}
