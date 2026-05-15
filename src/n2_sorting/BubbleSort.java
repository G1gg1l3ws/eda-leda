import java.util.*;

class BubbleSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int[] v = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        sort(v);

        sc.close();
    }

    public static void sort(int[] v) {
        int[] copia = Arrays.copyOf(v, v.length);
        for (int i = 0; i < v.length; i++) {
            boolean trocou = false;
            for (int j = 0; j < v.length-1-i; j++) {
                if (v[j] > v[j+1]) {
                    swap(v, j, j+1);
                    trocou = true;
                }
            }
            if (trocou) {
                printVetor(v);
            }
            else if (Arrays.equals(v, copia)) {
                printVetor(v);
                break;
            } else
                break;
        }
    }

    public static void printVetor(int[] v) {
        String out = "";

        for (int i = 0; i < v.length; i++) {
            if (i >= v.length-1) {
                out += v[i];
            } else
                out += v[i] + " ";
        }

        System.out.println(out);
    }

    public static void swap(int[] v, int i, int j) {
        int aux = v[i];
        v[i] = v[j];
        v[j] = aux;
    }
}
