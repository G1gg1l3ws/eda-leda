package recursive_algos;

import java.io.*;

class Potencia {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            int p = Integer.parseInt(reader.readLine());

            int e = Integer.parseInt(reader.readLine());

            System.out.println(exponencial(p, e));

        } catch (IOException ioe) {}
    }
    public static int exponencial(int p, int e) {
        if (e == 0) {
            return 1;
        }
        
        return p * exponencial(p, e-1);
    }
}
