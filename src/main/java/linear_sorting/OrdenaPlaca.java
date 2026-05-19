package linear_sorting;

import java.util.*;

class OrdenaPlaca {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] p = sc.nextLine().split(",");

        int[] v = filtraDigitos(p);

        RadixSort r = new RadixSort();

        System.out.println(Arrays.toString(r.radixSort(v, 4)));

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
}
