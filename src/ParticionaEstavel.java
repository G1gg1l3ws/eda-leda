import java.util.*;

class ParticionaEstavel {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int[] v = Arrays.stream(s.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        particiona(v, 0, v.length-1);

        s.close();
    }

    public static void particiona(int[] v, int ini, int fim) {
        int pivot = v[ini];
        int i = ini;
        int j = i+1;

        while (j <= fim) {
            if (v[j] < pivot) {
                swap(v, ++i, j);
            }
            j++;
        }

        int k = ini;
        while (k < i) {
            swap(v, k, k+1);
            k++;
        }
        System.out.println(Arrays.toString(v));
    }

    public static void swap(int[] v, int i, int j) {
        int aux = v[i];
        v[i] = v[j];
        v[j] = aux;
    }
}

