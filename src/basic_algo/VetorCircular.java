package basic_algo;

import java.io.*;
import java.util.Arrays;

class VetorCircular {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            int[] array = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int n = Integer.parseInt(reader.readLine());
            

            String[] out = new String[n];
            for (int i = 0; i < n; i++) {
                out[i] = Integer.toString(array[i%array.length]);
            }

            System.out.println(String.join(" ", out));

        } catch (IOException ioe) {}
    }

}
