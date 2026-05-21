import java.util.*;

class InverteArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] v = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        inverte(v);
        
        String out = Arrays.toString(v);
        out = ((out.replace("]", "")).replace("[", "")).replace(", ", " ");
        out = out.trim();

        System.out.println(out);

        sc.close();
    }

    public static void inverte(int[] v) {
        int i = 0;
        int j = v.length - 1;

        while (i < j) {
            swap(v, i, j);

            i++;
            j--;
        }
    }

    public static void swap(int[] v, int i, int j) {
        int aux = v[i];
        v[i] = v[j];
        v[j] = aux;
    }

}
