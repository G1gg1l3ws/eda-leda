import java.util.*;
import java.lang.Math;

class MelhorPivot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] v = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        int[] pivots = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        sc.close();

        System.out.println("" + melhorPivot(v, pivots[0], pivots[1]));

    }

    public static int melhorPivot(int[] v, int pivot1, int pivot2) {
        int leftPivot1 = 0;
        int leftPivot2 = 0;
        int k = pivot1;
        int j = pivot2;

        for (int i = 0; i < v.length; i++) {
            if (v[i] < v[k]) {
                leftPivot1++;
            }
            if (v[i] < v[j]) {
                leftPivot2++;
            }
        }

        if ((Math.abs(v.length - leftPivot1 - 1) / 2) >= (Math.abs(v.length - leftPivot2 - 1) / 2)) {
            return pivot1;
        }

        return pivot2;
    }

}
