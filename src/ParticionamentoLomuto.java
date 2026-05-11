import java.util.Arrays;
import java.util.Scanner;

public class ParticionamentoLomuto {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int[] v = Arrays.stream(s.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        particionamento(v, 0, v.length-1);
        System.out.println(Arrays.toString(v));

        s.close();
    }

    public static void particionamento(int[] v, int ini, int fim) {
        int pivot = ini;
        int i = pivot;
        int j = i+1;
        
        while (j <= fim) {
            if (v[j] <= v[pivot]) {
                swap(v, ++i, j);
                System.out.println(Arrays.toString(v));
            }
            j++;
        }
        swap(v, i, pivot);
        System.out.println(Arrays.toString(v));
    }

    public static void swap(int[] v, int i, int j) {
        int aux = v[i];
        v[i] = v[j];
        v[j] = aux;
    }
}
