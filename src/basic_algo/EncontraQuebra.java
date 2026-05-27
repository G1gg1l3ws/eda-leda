package basic_algo;

import java.io.*;
import java.util.Arrays;

class EncontraQuebra {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            int[] vetor = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            System.out.println(encontraQuebra(vetor, 1, 0));

        } catch(IOException ioe) {}
    } 

    public static int encontraQuebra(int[] array, int next, int current) {
        if (current >= array.length-2) {
            return -1;
        }

        if (array[current] > array[next]) {
            return next;
        }

        return encontraQuebra(array, next+1, current+1);

    }
}
