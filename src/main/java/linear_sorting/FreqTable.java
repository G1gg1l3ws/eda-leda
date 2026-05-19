import java.util.*;

class FreqTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] v = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        System.out.println(calculaFrequencia(v));

        sc.close();
    }

    public static String calculaFrequencia(int[] v) {
        int m = procuraMaior(v);

        int[] frequencies = new int[m + 1];
        boolean[] countedNumbers = new boolean[m + 1];

        for (int i = 0; i < v.length; i++) {
            frequencies[v[i]]++;

            if (frequencies[v[i]] == 0) {
                countedNumbers[v[i]] = false;
            } else {
                countedNumbers[v[i]] = true;
            }
        }
        
        String out = "";
        for (int i = 0; i < v.length; i++) {

            if (countedNumbers[v[i]] == true) {
                out += v[i] + "," + frequencies[v[i]] + " ";
                countedNumbers[v[i]] = false;
            }
        }

        return out.trim();
    }

    public static int procuraMaior(int[] v) {
        int maior = v[0];
        for (int i = 1; i < v.length; i++) {
            if (v[i] > maior)
                maior = v[i];
        }

        return maior;
    }
}
