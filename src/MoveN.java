import java.util.Scanner;
import java.util.Arrays;

class MoveN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] array = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        moveElemento(array);
    }

    public static void moveElemento(int[] array) {
        //caso nao haja quebra da sequencia, esse valor impede que o segundo laço seja executado
        int impostorIndex = array.length;
        for (int i = 0; i < array.length-1; i++) {
            if (array[i] > array[i+1]) {
                impostorIndex = i+1;
            }
        }

        for (int i = impostorIndex; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j] < array[j-1]) {
                    array[j] = array[j]^array[j-1];
                    array[j-1] = array[j]^array[j-1];
                    array[j] = array[j]^array[j-1];

                    System.out.println(Arrays.toString(array));
                }
            }
        }

    }
}
