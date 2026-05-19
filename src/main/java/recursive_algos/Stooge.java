import java.util.Scanner;
import java.util.Arrays;
import java.lang.Math;

class Stooge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int[] array = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        sort(array, 0, array.length - 1);
        
        String out = Arrays.toString(array).replace("[", "");
        out = out.replace("]", "");
        out = out.replace(", ", " ");

        System.out.println(out);

        sc.close();
    }

    public static void sort(int[] v, int ini, int fim) {
        if (v[ini] > v[fim]) {
            swap(v, ini, fim);
        }

        if ((fim - ini + 1) >= 3) {
            int t = (fim - ini + 1) / 3;
            
            sort(v, ini, fim - t);
            sort(v, ini + t, fim);
            sort(v, ini, fim - t);
        }
        
        return;
    }

    public static void swap (int[] v, int i, int j) {
        int aux = v[i];
        v[i] = v[j];
        v[j] = aux;

    }
}
