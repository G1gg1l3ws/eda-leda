

import java.util.Arrays;


public class MergeSort {

    /**
    * Implemente o método abaixo, que recebe dois arrays ordenados em forma crescente
    * e retorna um novo array também ordenado em forma crescente.
    */
    public static int[] mergeOrdenadosCrescente(int[] a, int[] b) {
        int i = 0;
        int j = 0;

        int[] helper = new int[a.length+b.length];

        int k = 0;
        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) 
                helper[k++] = a[i++];
            else
                helper[k++] = b[j++];
        }

        while (j < b.length)
            helper[k++] = b[j++];


        return helper;
    }
    
    /**
    * Implemente o método abaixo, que recebe dois arrays ordenados em forma decrescente
    * e retorna um novo array ordenado em forma crescente.
    */
    public static int[] mergeOrdenadosDecrescente(int[] a, int[] b) {
        int i = 0;
        int j = 0;

        int[] helper = new int[a.length+b.length];

        int k = a.length + b.length - 1;
        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) 
                helper[k--] = a[i++];
            else
                helper[k--] = b[j++];

        }

        while (i < a.length)
            helper[k--] = a[i++];

        return helper;
    }
   
    /**
    * Implemente o método abaixo, que recebe dois arrays: a, ordenado em forma crescente e b, ordenado
    * em forma descrescente. Seu método deve retornar um array ordenado em forma crescente.
    */
    public static int[] mergeOrdenadosDistintos(int[] a, int[] b) {
        int i = 0;
        int j = b.length - 1;

        int[] helper = new int[a.length+b.length];

        int k = 0;
        while (i < a.length && j >= 0) {
            if (a[i] <= b[j]) 
                helper[k++] = a[i++];
            else
                helper[k++] = b[j--];

        }

        while (j >= 0)
            helper[k++] = b[j--];

        return helper;
    }
   
    /**
    * Implemente a versão clássica do merge sort que vimos em sala de aula. Você pode
    * criar métodos auxiliares se precisar.
    */
    public void sort(int[] v, int ini, int fim) {
        if (ini >= fim)
            return;
        
        int meio = (ini+fim)/2;

        sort(v, ini, meio);
        sort(v, meio+1, fim);
        merge(v, ini, meio, fim);
    }

    public static void merge(int[] v, int ini, int meio, int fim) {
        int[] helper = Arrays.copyOf(v, v.length);

        int i = ini;
        int j = meio+1;
        int k = ini;

        while (i <= meio && j <= fim) {
            if (helper[i] <= helper[j])
                v[k++] = helper[i++];
            else
                v[k++] = helper[j++];
        }
        
        while (i <= meio)
            v[k++] = helper[i++];
        }  
    
    public static void main(String[] args) {
        MergeSort m = new MergeSort();
        int[] a = new int[] {1, 2, 3, 4, 6};
        int[] b = new int[] {5, 7, 8, 9, 10};

        int[] revA = new int[] {9, 8, 0, 7, -2, 5, 6, -1, 4, 3, 2, 1};
        int[] revB = new int[] {10, 9, 8, 7, 5};

        System.out.println(Arrays.toString(MergeSort.mergeOrdenadosCrescente(a, b)));
        System.out.println(Arrays.toString(MergeSort.mergeOrdenadosDistintos(a, revB)));
        m.sort(revA, 0, revA.length-1);
        System.out.println(Arrays.toString(revA));
    }
}

