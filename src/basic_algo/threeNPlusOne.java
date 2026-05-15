package basic_algo;

import java.util.Scanner;

class threeNPlusOne {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        sc.nextLine();

        int j = sc.nextInt();
        sc.nextLine();

        int maxCount = 0;

        while (i <= j) {
            int count = collatz(i);

            if (count > maxCount) {
                maxCount = count;
            }
            i++;
        }
        System.out.println(maxCount);
        sc.close();
    }

    public static int collatz(int n) {
        int step_count = 0;

        while (n != 1) {
            step_count ++;
            if (n % 2 == 1) {
                n = 3*n + 1;
            } else {
                n = (int) n / 2;
            }
        } 
        return step_count + 1;
    }
}
