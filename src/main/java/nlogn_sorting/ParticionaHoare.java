

import java.util.*;

class ParticionaHoare {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int[] v = Arrays.stream(s.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        particionamentoHoare(v, 0, v.length-1);

        s.close();
    }

    public static void particionamentoHoare(int[] v, int ini, int fim) {
        int pivot = v[ini];
        int i = ini-1;
        int j = fim+1;
        
        while (true) {
            do {
                i++;
            } while(v[i] < pivot);

            do {
                j--;
            } while(v[j] > pivot);

            if (i >= j) {
                break;
            }

            swap(v, i, j);
        }

        System.out.println(Arrays.toString(v));
    }

    public static void swap(int[] v, int i, int j) {
        int aux = v[i];
        v[i] = v[j];
        v[j] = aux;
    }
}
