package nlogn_sorting;

import java.util.*;

class QuickPasso {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int[] v = Arrays.stream(s.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        sort(v, 0, v.length-1);

        System.out.println(Arrays.toString(v));

        s.close();
    }

    public static void sort(int[] v, int ini, int fim) {
        if (ini >= fim)
            return;

        int index_pivot = particionamentoHoare(v, ini, fim);

        sort(v, ini, index_pivot-1);
        sort(v, index_pivot+1, fim);
    }

    public static int particionamentoHoare(int[] v, int ini, int fim) {
        int pivot = ini;
        int i = pivot+1;
        int j = fim;
        
        while (i <= j) {
            while (i <= j && v[i] <= v[pivot]) {
                i++;
            }

            while (i <= j && v[j] > v[pivot]) {
                j--;
            }
            
            if (i < j) {
                swap(v, i, j);
            }
        }
        swap(v, j, pivot);

        return j;
    }

    public static void swap(int[] v, int i, int j) {
        int aux = v[i];
        v[i] = v[j];
        v[j] = aux;
    }
}
