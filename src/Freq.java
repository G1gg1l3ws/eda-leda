import java.io.*;
import java.util.Arrays;

class Freq {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            
            int num = Integer.parseInt(reader.readLine());

            int[] array = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            
            int f = 0;

            for (int i = 0; i < array.length; i++) {
                if (array[i] == num) {
                    f += 1;
                }
            }
            System.out.println(f);

        } catch (IOException ioe) {}
    }
}
