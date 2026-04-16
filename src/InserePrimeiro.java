import java.io.*;
import java.util.Arrays;

class InserePrimeiro {
    public static void main(String args[]) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            
            String[] v = reader.readLine().split(" ");
            insereOrdenado(v);

            System.out.println(Arrays.toString(v));
        } catch (IOException ioe) {}
    }

    public static void insereOrdenado(String[] v) {
        for (int i = 0; i < v.length-1; i++) {

            int n = Integer.parseInt(v[i]);
            int next = Integer.parseInt(v[i+1]);

            if (n > next) {
                n = n^next;
                next = n^next;
                n = n^next;

                v[i] = Integer.toString(n);
                v[i+1] = Integer.toString(next);
            } else {
                return;
            }
        }
    
    }
}
