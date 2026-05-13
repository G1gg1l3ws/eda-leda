package roteiro_counting;

public class CountingSort {
   
    /**
    * Implemente a versão clássica do counting sort que vimos em sala de aula. Você pode
    * criar métodos auxiliares se precisar.
    */
    public int[] classicCountingSort(int[] a, int k) {
        int[] c = new int[k];
        int[] sorted = new int[a.length];
        
        //freq
        for (int i = 0; i < a.length; i++) {
            c[a[i] - 1]++;
        }
        
        //cumsum
        for (int j = 1; j < c.length; j++) {
            c[j] += c[j-1];
        }

        for (int l = 0; l < sorted.length; l++) {
            sorted[c[a[l] - 1] - 1] = a[l];
            c[a[l] - 1]--;
        }

        
        return sorted;
    }

    /**
    * Implemente uma versão do counting sort que aceita valor 0 na coleção original.
    */
    public int[] zeroCountingSort(int[] v, int k) {
        int[] c = new int[k + 1];
        int[] sorted = new int[v.length];
        
        //freq
        for (int i = 0; i < v.length; i++) {
            c[v[i]]++;
        }
        
        //cumsum
        for (int j = 1; j < c.length; j++) {
            c[j] += c[j-1];
        }

        for (int l = 0; l < sorted.length; l++) {
            sorted[c[v[l]] - 1] = v[l];
            c[v[l]]--;
        }

        
        return sorted;
    }

    /**
    * Implemente uma versão do counting sort que aceita valores negativos na coleção original. Você
    * vai precisar identificar o menor elemento do array. FAça isso no início do método.
    */
    public int[] negativosCountingSort(int[] v, int k) {
        int m = procuraMenor(v);

        int[] c = new int[k + 1 - m];
        int[] sorted = new int[v.length];
        
        //freq
        for (int i = 0; i < v.length; i++) {
            c[v[i] - m]++;
        }
        
        //cumsum
        for (int j = 1; j < c.length; j++) {
            c[j] += c[j-1];
        }

        for (int l = 0; l < sorted.length; l++) {
            sorted[c[v[l] - m] - 1] = v[l];
            c[v[l] - m]--;
        }

        
        return sorted;
    }

    private int procuraMenor(int[] v) {
        int menor = v[0];

        for (int i = 0; i < v.length; i++) {
            if (v[i] < menor)
                menor = v[i];
        }

        return menor;
    }

}
