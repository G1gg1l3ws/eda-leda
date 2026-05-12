import java.util.Arrays;
import java.util.Scanner;

class LomutoUltimo {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int[] v = Arrays.stream(s.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        particiona(v, 0, v.length-1);

        System.out.println(Arrays.toString(v));

        s.close();
    }

    public static void particiona(int[] v, int ini, int fim) {
        int pivot = v[fim];
        int i = fim;
        int j = fim-1;

        while (j >= ini) {
            if (v[j] > pivot) {
                swap(v, --i, j);
                System.out.println(Arrays.toString(v));
            }
            j--;
        }

        swap(v, fim, i);
        System.out.println(Arrays.toString(v));
    }

    public static void swap(int[] v, int i, int j) {
        int aux = v[i];
        v[i] = v[j];
        v[j] = aux;
    }
}
