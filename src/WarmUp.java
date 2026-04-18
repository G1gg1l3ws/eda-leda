import java.util.Scanner;

class WarmUp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        sc.nextLine();
        
        String[] array = sc.nextLine().split(" ");

        String out = "";

        for (int i = 0; i < array.length; i++) {
            out += Integer.toString(Integer.parseInt(array[i]) * n) + " ";
        }

        System.out.println(out.trim());

        sc.close();
    }
}
