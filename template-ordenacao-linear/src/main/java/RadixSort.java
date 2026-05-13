import java.util.*;

public class RadixSort {

	// Você pode assumir que todos os valores possuem a mesma quantidade de dígitos
	// Caso precise do counting sort, use o que você já implementou na outra classe.
	public int[] radixSort(int[] v) {
        int exp = 1;
        int[] sorted = new int[v.length];
        //quantas vezes iterar: tamanho do primeiro elem

        while (v[0] / Math.pow(10, exp) > 1) {
            int[] bucket = new int[v.length];

            for (int i = 0; i < bucket.length; i++) {
                bucket[i] = (int) Math.floor((v[i] % Math.pow(10, exp)) / Math.pow(10, exp - 1));
            }

            int[] c = new int[10];
            for (int i = 0; i < bucket.length; i++) {
                c[bucket[i]]++;
            }
            
            //cumsum bucket
            for (int j = 1; j < c.length; j++) {
                c[j] += c[j-1];
            }

            for (int l = 0; l < sorted.length; l++) {
                sorted[c[bucket[l]] - 1] = v[l];
                c[bucket[l]]--;
            }
           
            System.out.println(Arrays.toString(sorted));

            exp++;
        }

        return sorted;

	}

}
