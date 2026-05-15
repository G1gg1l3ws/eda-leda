public class QuickSort implements SortingStrategy {


  
    /*
       A mediana de uma sequência de tamanho ímpar é o valor que divide uma sequência ao meio, isto é, 
       metado dos valores são menores que ela, enquanto metade são maiores. Implemente o método abaixo
       que recebe uma sequência de tamanho ímpar e retorna a mediana dessa sequência.
    */
    public int mediana(int[] v) {
        int ini = 0;
        int fim = v.length-1;
        MergeSort m = new MergeSort();
        m.sort(v, ini, fim);

        int meio = (ini+fim)/2;


        return v[meio];
    }

    /**
    * Implemente a versão do quick sort usando o particionamento Hoare, que está descrito
    * neste material: https://joaoarthurbm.github.io/eda/posts/particionamento-hoare/
    */
    public void sort(int[] v, int ini, int fim) {
        if (ini >= fim)
            return;

        int index_pivot = particionamentoHoare(v, ini, fim);

        sort(v, ini, index_pivot-1);
        sort(v, index_pivot+1, fim);
    }
    
    /*
    * Método chamado por sort() que realiza o algoritmo de particionamento,
    * por enquanto, realiza o Lomuto
    *
    *
    private static int particionamentoLomuto(int[] v, int ini, int fim) {
        int pivot = ini;
        int i = pivot;
        int j = i+1;
        
        while (j <= fim) {
            if (v[j] <= v[pivot]) {
                swap(v, ++i, j);
                System.out.println(Arrays.toString(v));
            }
            j++;
        }
        swap(v, i, pivot);

        return i;
    }
    */

    private static int particionamentoHoare(int[] v, int ini, int fim) {
        int pivot = ini;
        int i = pivot+1;
        int j = fim;
        
        while (i <= j) {
            while (i <= j && v[i] <= v[pivot]) {
                i++;
            }

            while (i <= j && v[j] > v[pivot]) {
                j--;
            }
            
            if (i < j) {
                swap(v, i, j);
            }
        }
        swap(v, j, pivot);

        return j;
    }

    private static void swap(int[] v, int i, int j) {
        int aux = v[i];
        v[i] = v[j];
        v[j] = aux;
    }


    /**
    * Nós discutimos em sala de aula que uma tentativa para melhorar a escolha do pivot é
    * decidir usar o valores mediano (não média, cuidado) entre o primeiro elemento do array,
    * o elemento central e o último.

    * Implemente o método abaixo que retorna o valor que seria escolhido como pivot seguindo
    * a abordagem acima.
    * 
    * Interprete os testes para saber qual valor usar como elemento central para calcular a mediana de três.
    */
    public int medianaDeTres(int[] v) {
        int fim = v.length - 1;
        int meio = (fim + 0) / 2;
        if (v[0] <= v[meio] && v[meio] <= v[fim])
            return v[meio];
        if ((v[meio] <= v[0] && v[0] <= v[fim]) || (v[fim] <= v[0] && v[0] <= v[meio]))
            return v[0];

        return v[fim];

    }
}
