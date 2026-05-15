import java.io.*;

class Mariana {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            
            String[] v = reader.readLine().split(",");
            insertionSort(v);

        } catch (IOException ioe) {}

    }
    
    public static void insertionSort(String[] v) {
        for (int i = 0; i < v.length; i++) {
            for (int j = i; j > 0; j--) {
                if (v[j].compareTo(v[j-1]) < 0) {
                    String temp = v[j];
                    v[j] = v[j-1];
                    v[j-1] = temp;
                }
            }

            System.out.println(String.join(", ", v));
        }

    }
}
