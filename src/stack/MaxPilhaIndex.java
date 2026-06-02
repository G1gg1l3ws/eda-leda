import java.util.*;

class MaxPilhaIndex {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] nums = sc.nextLine().split(" ");
        int[] stack = new int[nums.length];

        int index = Integer.parseInt(sc.nextLine());

        int top = stack.length;
        for (int i = 0; i < nums.length; i++) {
            push(stack, Integer.parseInt(nums[i]), --top);
        }

        System.out.println(max(stack, top, index));
        sc.close();
    }

    private static void push(int[] stack, int val, int top) {
        stack[top] = val;
    }

    private static int pop(int[] stack, int top) {
        return stack[top++];
    }

    private static boolean isEmpty(int[] stack, int top) {
        return top == stack.length;
    }

    private static int peek(int[] stack, int top) {
        return stack[top];
    }

    private static int max(int[] stack, int top, int index) {
        int[] aux = new int[stack.length];
        int auxTop = aux.length;

        int maior = peek(stack, top);
        push(aux, pop(stack, top++), --auxTop);
        while (top <= index) {
            if (peek(stack, top) > maior) {
                maior = peek(stack, top);
            }
            push(aux, pop(stack, top++), --auxTop);
        }

        while (!isEmpty(aux, auxTop)) {
            push(stack, pop(aux, auxTop++), --top);
        }

        return maior;
    }

}
