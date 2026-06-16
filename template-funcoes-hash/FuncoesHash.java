import java.util.*;
import java.io.*;

public class FuncoesHash {

    public static void main(String[] args) {

        // lendo da entrada padrão
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String line = "";
            // Cabeçalho
            while ((line = reader.readLine()) != null) {
                String tokens = line;
                
                // TODO incluir aqui chamada para o método sob análise        
                int hash = hashMult(Integer.parseInt(tokens));
                // saída padrão: método tempo tamanho_da_entrada
                System.out.println(hash);

            }
        } catch (IOException ioe) {}

    }

    public static int hashMod(int key) {
        return key % 53;
    }

    public static int hashMult(int key) {
        return (int) (((key * 0.6180339887) % 1) * 53);
    }
}
