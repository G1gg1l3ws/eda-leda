import java.io.*;

class Fibonacci {
    public static void main(String[] args) {
        try {
            BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

            System.out.println(seqFibonacci(Integer.parseInt(r.readLine())));

        } catch(IOException io) {}

    }

    public static int seqFibonacci(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 0) {
            return 0;
        }

        return seqFibonacci(n-1) + seqFibonacci(n-2);

    }
}
