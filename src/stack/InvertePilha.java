import java.util.*;

class InverteSemFila {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = Integer.parseInt(sc.nextLine());
            
        int[] stack = new int[size];
        String[] elems = sc.nextLine().split(" ");

        int top = -1;
        for (int i = 0; i < elems.length; i++) {
            top++;
            push(stack, Integer.parseInt(elems[i]), top);
        }
        inverte(stack, top); 
        System.out.println(Arrays.toString(stack));
    }
}
