package linear_sorting;

import java.util.*;

class CountingSortPlus {
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int[] v = Arrays.stream(s.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int k = Integer.parseInt(s.nextLine());
        int m = Integer.parseInt(s.nextLine());

        int[] sorted = sort(v, k, m);
        
        System.out.println(Arrays.toString(sorted));

        s.close();
    }

    public static int[] sort(int[] v, int k, int m) {
        int[] c = new int[k + 1 - m];
        int[] sorted = new int[v.length];
        
        //freq
        for (int i = 0; i < v.length; i++) {
            c[v[i] - m]++;
            System.out.println(Arrays.toString(c));
        }
        
        //cumsum
        for (int j = 1; j < c.length; j++) {
            c[j] += c[j-1];
        }
        System.out.println("Cumulativa do vetor de contagem - " + Arrays.toString(c));

        for (int l = 0; l < sorted.length; l++) {
            sorted[c[v[l] - m] - 1] = v[l];
            c[v[l] - m]--;
        }

        System.out.println(Arrays.toString(c));
        
        return sorted;
    }

}
