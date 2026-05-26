package basic_algo;

import java.io.*;
import java.util.Arrays;

class TrocaVizinhos {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new
            InputStreamReader(System.in));
            String line = "";

            while ((line = reader.readLine()) != null) {
                String[] v = line.split(" ");

                trocaVizinhos(v);
                
                System.out.println(Arrays.toString(v));
            }
        } catch(IOException ioe) {}
    }

    public static void trocaVizinhos(String[] v) {
        for (int i = 0; i < v.length-1; i+=2) {
            String temp = v[i];
            v[i] = v[i+1];
            v[i+1] = temp;
        }

    }

}
