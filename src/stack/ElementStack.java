package stack;

import java.util.*;

class ElementStack {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] stack = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int target = Integer.parseInt(sc.nextLine());
        
        System.out.println(searchStack(stack, target));

        sc.close();
    }
    
    private static String searchStack(int[] stack, int target) {
        int topStack = stack.length - 1;
        int topAux = -1;
        int[] aux = new int[stack.length];

        if (target > topStack) {
            return "indice invalido";
        }
        
        int val = 0;
        while (!isEmpty(topStack)) {
            if (topStack == target) {
                val = peek(stack, topStack);
            }
            push(aux, pop(stack, topStack), topAux);
            topStack--;
            topAux++;
        }

        while (!isEmpty(topAux)) {
            push(stack, pop(aux, topAux), topStack);
            topStack++;
            topAux--;
        }

        return Integer.toString(val);
    }
    
    private static void push(int[] s, int val, int top) {
        s[++top] = val;
    }

    private static int pop(int[] s, int top) {
        return s[top--];
    }

    private static int peek(int[] s, int top) {
        return s[top];
    }

    private static boolean isEmpty(int top) {
        return top == -1;
    }
    
}
