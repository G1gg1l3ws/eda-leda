package linear_sorting;

import java.util.*;

class OrdenaPlaca {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] p = sc.nextLine().split(",");

        int[] v = filtraDigitos(p);

        System.out.println(String.join(", ", radixSort(p, v, 4)));

        sc.close();
    }

    private static int[] filtraDigitos(String[] p) {

        int[] v = new int[p.length];
        for (int i = 0; i < p.length; i++) {
            char[] iterable = p[i].toCharArray();

            String d = "";
            for (int j = 4; j < 8; j++) {
                d += iterable[j];
            }

            v[i] = Integer.parseInt(d);
        }

        return v;
    }

	private static String[] radixSort(String[] p, int[] v, int n) {
        int[] sorted = new int[v.length];
        String[] sorted_plates = new String[p.length];
        //quantas vezes iterar: tamanho do primeiro elem
        for (int x = 1; x <= n; x++) {
            //separa os digitos de cada numero
            int[] bucket = new int[v.length];
            for (int i = 0; i < bucket.length; i++) {
                bucket[i] = (int) Math.floor((v[i] % Math.pow(10, x)) / Math.pow(10, x - 1));
            }

            int[] c = new int[10];
            for (int i = 0; i < bucket.length; i++) {
                c[bucket[i]]++;
            }
            //cumsum bucket
            for (int j = 1; j < c.length; j++) {
                c[j] += c[j-1];
            }

            for (int l = sorted.length-1; l >= 0; l--) {
                sorted[c[bucket[l]] - 1] = v[l];
                sorted_plates[c[bucket[l]] - 1] = p[l];
                c[bucket[l]]--;
            }

            for (int i = 0; i < sorted.length; i++) {
                v[i] = sorted[i];
                p[i] = sorted_plates[i];
            }
        }

        return sorted_plates;
	}
}
