package basic_algo;

import java.io.*;

class Palindromo {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String line = reader.readLine();
            System.out.println(verificaPalindromo(line));
        } catch (IOException ioe) {}
    }
    public static boolean verificaPalindromo(String palavra) {
        int i = 0;
        int j = palavra.length() - 1;

        while (i < j) {
            if (palavra.charAt(i) != palavra.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        
        return true;
    }
}
