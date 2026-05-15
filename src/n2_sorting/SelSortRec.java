import java.io.*;
import java.util.Arrays;

class SelSortRec {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            
            int[] array = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            array = selectionSort(array, 0);
        } catch (IOException ioe) {}
    }

    public static int[] selectionSort(int[] array, int index) {
        if (!(index < array.length-1))
            return array;

        int min_index = selectMin(array, index+1, index);

        if (min_index != index) {
            array[index] = array[index]^array[min_index];
            array[min_index] = array[index]^array[min_index];
            array[index] = array[index]^array[min_index];
        }

        System.out.println(Arrays.toString(array));
        
        return selectionSort(array, index+1);
    }

    public static int selectMin(int[] array, int index, int current_min) {

        if (!(index < array.length)) {
            return current_min;
        }

        if (array[current_min] > array[index]) {
            current_min = index;
        }

        return selectMin(array, index+1, current_min);
    }
}
