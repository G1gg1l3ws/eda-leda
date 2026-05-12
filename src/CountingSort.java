import java.util.*;

class CountingSort {
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int[] v = Arrays.stream(s.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int k = Integer.parseInt(s.nextLine());

        int[] sorted = sort(v, k);
        
        System.out.println(formataVetor(sorted));

        s.close();
    }

    public static int[] sort(int[] v, int k) {
        int[] c = new int[k+1];
        int[] sorted = new int[v.length];
        
        //freq
        for (int i = 0; i < v.length; i++) {
            c[v[i]]++;
            System.out.println(formataVetor(c));
        }
        
        //cumsum
        for (int j = 1; j < c.length; j++) {
            c[j] += c[j-1];
        }
        System.out.println("Cumulativa do vetor de contagem - " + formataVetor(c));

        for (int l = 0; l < sorted.length; l++) {
            sorted[c[v[l]]-1] = v[l];
            c[v[l]]--;
        }

        System.out.println(formataVetor(c));
        
        return sorted;
    }

    public static String formataVetor(int[] v) {
        String out = "";

        for (int i = 0; i < v.length; i++) {
            if (i >= v.length-1) {
                out += v[i];
            } else
                out += v[i] + " ";
        }
        
        return out;
    }
}
