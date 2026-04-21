import java.util.Scanner;
import java.util.Arrays;

class TopN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] array = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int n = Integer.parseInt(sc.nextLine());
        
        array = selectionSort(array);

        for (int i = 0; i < n; i++) {
            if (i != n-1) {
                System.out.print(Integer.toString(array[i]) + " ");
            } else {
                System.out.println(Integer.toString(array[i]));
            }
        }
        sc.close();
    }
    public static int[] selectionSort(int[] array) {
        for (int i = 0; i < array.length-1; i++) {
            //seleciona max
            int indexMax = i;
            for (int j = i+1; j < array.length; j++) {
                if (array[j] > array[indexMax]) {
                    indexMax = j;
                }
            }
            if (indexMax != i) {
                array[i] = array[i]^array[indexMax];
                array[indexMax] = array[i]^array[indexMax];
                array[i] = array[i]^array[indexMax];
            }
        }

        return array;
    }
}
