import java.util.Scanner;
import java.util.Arrays;

class Merge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] v = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        System.out.println(merge(v, 0, v.length));
    }

    public static int[] merge(int[] v, int left, int right) {
        int m = (left+right)/2;

        int rightHelper = right-left;
        int[] helper = new int[rightHelper + 1];
        for (int i = 0; i <= rightHelper; i++) {
            helper[i] = v[left + i];
        }
        
        int i = left;
        int j = m+1;
        int k = left;
        while (i <= m && j <= right) {
            if (helper[i] < helper[j]) {
                v[k] = helper[i];
                i++;
            } else {
                v[k] = helper[j];
                j++;
            }

            k++;
            System.out.println(Arrays.toString(v));
        }

        while (i <= m) {
            v[k] = helper[i];
            i++;
        }
        while (j <= right) {
            v[k] = helper[j];
            j++;
        }

        return v;
    }
}
