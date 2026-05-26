package linear_sorting;

import java.util.*;

class RadixSortTres {
	public int[] radixSort(int[] v, int n) {
        int[] sorted = new int[v.length];
        //quantas vezes iterar: tamanho do primeiro elem / 2
        for (int x = 1; x <= n/3; x++) {
            //separa os digitos de cada numero
            int[] bucket = new int[v.length];
            for (int i = 0; i < bucket.length; i++) {
                bucket[i] = (int) Math.floor((v[i] % Math.pow(1000, x)) / Math.pow(1000, x - 1));
            }

            int[] c = new int[1000];
            for (int i = 0; i < bucket.length; i++) {
                c[bucket[i]]++;
            }
            //cumsum bucket
            for (int j = 1; j < c.length; j++) {
                c[j] += c[j-1];
            }

            for (int l = sorted.length-1; l >= 0; l--) {
                sorted[c[bucket[l]] - 1] = v[l];
                c[bucket[l]]--;
            }

            for (int i = 0; i < sorted.length; i++) {
                v[i] = sorted[i];
            }
            System.out.println(Arrays.toString(sorted));
        }

        return sorted;
	}

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] v = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = Integer.parseInt(sc.nextLine());
        

        RadixSortTres r = new RadixSortTres();

        r.radixSort(v, n);

        sc.close();
    }
}
