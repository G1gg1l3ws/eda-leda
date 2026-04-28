import java.io.*;
import java.util.Arrays;

class BuscaLinR {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            int[] v = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int n = Integer.parseInt(reader.readLine());
            
            System.out.println(encontraNumero(v, n, 0));

        } catch(IOException ioe) {}
    }

    public static int encontraNumero(int[] v, int n, int i) {
        if (i >= v.length) {
            return -1;
        }

        if (v[i] == n) {
            return i;
        }
        
        return encontraNumero(v, n, i+1);
    }
}
