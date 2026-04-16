import java.io.*;
import java.util.HashSet;

class Duplicados {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new
            InputStreamReader(System.in));
            String line = "";
            
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(" ");
                
                System.out.println(contemDuplicados(tokens));
            }

            reader.close();
        } catch(IOException ioe) {}
    }
    public static boolean contemDuplicados(String[] tokens) {
        HashSet<String> seen = new HashSet<>();
        for (int i = 0; i < tokens.length; i++) {
            if (seen.contains(tokens[i])){ return true;}

            seen.add(tokens[i]);
        }

        return false;
    }
}
