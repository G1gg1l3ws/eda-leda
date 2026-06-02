import java.util.*;

class Parenteses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String in = sc.nextLine();
            
        char[] stack = new char[in.length()];

        int top = stack.length;
        for (int i = in.length() - 1; i >= 0; i--) {
            top--;
            char c = in.charAt(i);
            push(stack, c, top);
        }

        if (isValid(stack, top)) {
            System.out.println('S');
        } else {
            System.out.println('N');
        }
        sc.close();
    }

    private static void push(char[] stack, char val, int top) {
        stack[top] = val;
    }

    private static char pop(char[] stack, int top) {
        return stack[top];
    }

    private static char peek(char[] stack, int top) {
        return stack[top];
    }

    private static boolean isEmpty(char[] stack, int top) {
        return top == stack.length;
    }

    private static boolean isValid(char[] stack, int top) {
        char[] aux = new char[stack.length];
        int auxTop = aux.length;
        while(!isEmpty(stack, top)) {
            if (peek(stack, top) == '(') {
                push(aux, pop(stack, top++), --auxTop);
            }
            else if (peek(stack, top) == ')') {
                if (!isEmpty(aux, auxTop)) {
                    pop(aux, auxTop++);
                    pop(stack, top++);
                } else {
                    push(aux, pop(stack, top++), --auxTop);
                    break;
                }
            }
        }

        return isEmpty(aux, auxTop);
    }
}
