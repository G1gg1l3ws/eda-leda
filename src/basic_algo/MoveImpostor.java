package basic_algo;

import java.util.Arrays;
import java.io.*;

class MoveImpostor {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int[] array = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            System.out.println(Arrays.toString(moveImpostor(array)));
        } catch(IOException ioe) {}
    }

    public static int[] moveImpostor(int[] in) {
        for (int i = 0; i < in.length - 1; i++) {
            int x = in[i];
            int y = in[i + 1];
            if (x > y) {
                for (int j = i + 1; j > 0; j--) {
                    if (in[j] < in[j - 1]) {
                        in[j] = in[j] ^ in[j - 1];
                        in[j - 1] = in[j] ^ in[j - 1];
                        in[j] = in[j] ^ in[j - 1];
                    }
                }
                return in;
            }
        }
        return in;
    }
}