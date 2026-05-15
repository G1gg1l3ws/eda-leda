package n2_sorting;

import java.io.*;
import java.util.Arrays;

class InsertionSortRec {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            String[] array = reader.readLine().split(" ");

            insertionSort(array, 1);
            
        } catch(IOException ioe) {}
    }

    public static String[] insertionSort(String[] array, int i) {
        if (i == array.length) {
            return array;
        } 

        array = insereOrdenado(array, i);
        System.out.println(Arrays.toString(array));
        return insertionSort(array, i+1);
    }

    public static String[] insereOrdenado(String[] array, int j) {
        if (j == 0) {
            return array;
        }

        if (Integer.parseInt(array[j]) < Integer.parseInt(array[j-1])) {
            String temp = array[j];
            array[j] = array[j-1];
            array[j-1] = temp;

            return insereOrdenado(array, j-1);
        }
        
        return array;
    }
}
