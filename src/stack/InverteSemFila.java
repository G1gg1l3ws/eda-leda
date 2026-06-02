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
        }
        System.out.println(Arrays.toString(stack));
    }
    /*
    private static void push(int[] stack, int val, int top) {
        stack[top] = val;
    }

    private static int pop(int[] stack, int top) {
        return stack[top];
    }

    private static boolean isEmpty(int top) {
        return top == -1;
    }

    private static void inverte(int[] stack, int top) {
        int soma = 0;
        int temp = -1;

        while (!isEmpty(top)) {
            temp = pop(stack, top);
            soma += temp;
            top--;
        }

        while (soma > 0) {
            System.out.println(temp);
            soma -= temp;
            top++;
            top = push(stack, temp, top);
        }
    }
    */
}
