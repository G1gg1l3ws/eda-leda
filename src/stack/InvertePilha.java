import java.util.*;

class InvertePilha {
    private int size;
    private int[] stack;
    private int top;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cap = Integer.parseInt(sc.nextLine());
        InvertePilha pilha = new InvertePilha(cap);

        String[] elems = sc.nextLine().split(" ");


        for (int i = 0; i < elems.length; i++) {
            pilha.push(Integer.parseInt(elems[i]));
        }
        pilha.inverte(); 
        sc.close();
    }

    public InvertePilha(int cap) {
        this.stack = new int[cap];
        this.top = this.stack.length;
        this.size = 0;
    }

    public void push(int val) {
        stack[--top] = val;
        size += 1;
    }

    public int pop() {
        size -= 1;
        return stack[top++];
    }

    public boolean isEmpty() {
        return top == this.stack.length;
    }

    public InvertePilha desempilha() {
        InvertePilha aux = new InvertePilha(this.stack.length);
        while (!this.isEmpty()) {
            aux.push(this.pop());
        }

        return aux;
    }

    public int peek() {
        return this.stack[top];
    }

    public void inverte() {
        InvertePilha aux = desempilha();

        while (!aux.isEmpty()) {
            System.out.println(aux.peek());
            this.push(aux.pop());
        }
    }
}
