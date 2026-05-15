package nlogn_sorting;

import java.util.*;

class EstatisticaOrdem {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int[] v = Arrays.stream(s.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        
        System.out.println(particiona(v, 0, v.length-1));

        System.out.println(Arrays.toString(v));

        s.close();
    }

    public static int particiona(int[] v, int ini, int fim) {
        int pivot = v[ini];
        int i = ini;
        int j = i+1;

        while (j <= fim) {
            if (v[j] < pivot) {
                swap(v, ++i, j);
            }
            j++;
        }

        swap(v, ini, i);
//        System.out.println(Arrays.toString(v));
        
        return i+1;
    }  

    public static void swap(int[] v, int i, int j) {
        int aux = v[i];
        v[i] = v[j];
        v[j] = aux;
    }
}
