package challenges;
import java.util.*;

class DoubleSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] v = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int n = Integer.parseInt(sc.nextLine());
        
        System.out.println(checkSum(v, n));

        sc.close();
    }

    public static String checkSum(int[] v, int n) {
        int i = 0;
        while (i < v.length) {
            int j = i + 1;
            while (j < v.length) {
                if ((v[i] + v[j]) == n) {
                    return "" + v[i] + " " + v[j];
                }
                j++;
            }
            i++;
        }
        return "-1";
    }

}
