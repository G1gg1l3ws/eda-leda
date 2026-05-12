import java.util.Scanner;
import java.util.Arrays;

class Merge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int[] v = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        mergeSort(v, 0, v.length-1);

        sc.close();
    }

    public static void mergeSort(int[] v, int left, int right) {
        System.out.println(Arrays.toString(Arrays.copyOfRange(v, left, right+1)));
        if (left == right) {
            return;
        }

        int middle = (left+right) / 2;
        mergeSort(v, left, middle);
        mergeSort(v, middle+1, right);

        merge(v, left, right);
    }

    public static void merge(int[] v, int left, int right) {
        int auxRight = right - left;

        int auxMiddle = auxRight / 2;
        
        int[] aux = new int[auxRight+1];
        for (int i = 0; i < aux.length; i++) {
            aux[i] = v[left + i];
        }

        int i = 0;
        int k = left;
        int j = auxMiddle+1;
        while (i < auxMiddle+1 && j < auxRight+1) {
            if (aux[i] < aux[j]) {
                v[k] = aux[i];
                i++;
            } else {
                v[k] = aux[j];
                j++;
            }
            k++;
        }
        while (i < auxMiddle+1) {
            v[k] = aux[i];
            i++;
            k++;
        }
        while (j < auxRight+1) {
            v[k] = aux[j];
            j++;
            k++;
        }
        System.out.println(Arrays.toString(Arrays.copyOfRange(v, left, right+1)));
    }
}
