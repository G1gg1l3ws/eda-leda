import java.util.Scanner;
import java.util.Arrays;

class BuscaBin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int[] array = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int n = Integer.parseInt(sc.nextLine());

        buscaBinaria(array, n);
    }

    public static void buscaBinaria(int[] array, int n) {
        int fim = array.length-1;
        int ini = 0;

        while (ini <= fim) {
            int meio = (ini+fim)/2;
            System.out.println(meio);
            if (array[meio] < n) {
                ini = meio+1;
            } else if (array[meio] == n) {
                return;
            } else  {
                fim = meio-1;
            }
        }


        System.out.println(-1);
    }
}
