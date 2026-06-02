import java.util.*;

class InvertePilhaIndex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = Integer.parseInt(sc.nextLine());
            
        int[] stack = new int[size];
        String[] elems = sc.nextLine().split(" ");

        int index = Integer.parseInt(sc.nextLine());

        int top = stack.length;
        for (int i = 0; i < elems.length; i++) {
            top--;
            push(stack, Integer.parseInt(elems[i]), top);
        }
        System.out.println("-");
        inverte(stack, top, index); 
        sc.close();
    }

    private static void push(int[] stack, int val, int top) {
        stack[top] = val;
    }

    private static int pop(int[] stack, int top) {
        return stack[top];
    }

    private static boolean isEmpty(int[] stack, int top) {
        return top == stack.length;
    }

    private static int[] desempilha(int[] stack, int top, int index) {
        int[] aux = new int[stack.length];
        int topAux = aux.length;
        while (top <= index) {
            topAux--;
            push(aux, pop(stack, top), topAux);
            top++;
        }

        return aux;
    }

    private static void inverte(int[] stack, int top, int index) {
        int[] aux = desempilha(stack, top, index);
        int topAux = stack.length - index - 1;
        top = index + 1;

        while (!isEmpty(aux, topAux)) {
            System.out.println(pop(aux, topAux));
            topAux++;
        }

        while (!isEmpty(stack, top)) {
            System.out.println(pop(stack, top));
            top++;
        }
    }
}