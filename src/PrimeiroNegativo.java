import java.io.*;

class PrimeiroNegativo {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new
            InputStreamReader(System.in));
            String line = "";
            //System.out.println("alg time size");
            while ((line = reader.readLine()) != null) {

                String[] v = line.split(" ");
                
                long ini = System.nanoTime();

                String n = primeiroNegativo(v, 0);

                long fim = System.nanoTime();
                
                System.out.println(n);

                //System.out.println("primeiroNegativo " + (fim-ini) + " " + v.length);

            }

            reader.close();

        } catch (IOException ioe) {} 

    }

    public static String primeiroNegativo(String[] v, int index) {
        if (index == v.length) {
            return "-";
        }

        if (Integer.parseInt(v[index]) < 0) {
            return v[index];
        } else {
            return primeiroNegativo(v, index + 1);
        }

    }

}
