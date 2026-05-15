import java.io.*;
import java.util.Arrays;

class SelectionSort {
    public static void main(String[] args) {
        try {

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            
            String[] tokens = reader.readLine().split(" ");
            
            int[] array = new int[tokens.length];
            for (int i = 0; i < tokens.length; i++)
                array[i] = Integer.parseInt(tokens[i]);

            selectionSort(array);

        } catch (IOException ioe) {}
    }
    
    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length-1; i++) {
            int idx_menor = i;
            for (int j = i+1; j < array.length; j++) {
                if (array[j] < array[idx_menor]) {
                    idx_menor = j;
                }
            }
            
        if (idx_menor != i) {
                int aux = array[i];
                array[i] = array[idx_menor];
                array[idx_menor] = aux;

                System.out.println(Arrays.toString(array));
            }
        }
    }
}
