import java.io.*;

class PrimeiroNegativoIterativo {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String line = "";

            while ((line = reader.readLine()) != null) {

                String[] v = line.split(" ");
                
                long ini = System.nanoTime();

                String n = primeiroNegativo(v);

                long fim = System.nanoTime();
                
//                System.out.println(n);

                System.out.println("primeiroNegativoIterativo " + (fim-ini) + " " + v.length);

            }

        } catch (IOException ioe) {} 

    }

    public static String primeiroNegativo(String[] v) {
        for (int i = 0; i < v.length; i++) {
            if (v[i].isEmpty()) continue;
            if (Integer.parseInt(v[i]) < 0) {
                return v[i];
            }
        }
        return "-";
    }

}
