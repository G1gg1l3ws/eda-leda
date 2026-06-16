package stack;

import java.util.*;

class InverteFrase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] words = sc.nextLine().split(" ");
        
        Stack stack = new Stack(words.length);
        for (int i = 0; i < words.length; i++) {
            stack.push(words[i]);
        }

        System.out.println(stack.inverte());
        
        sc.close();
    }
}

class Stack {
    int top;
    int size;
    String[] stack;

    public Stack(int cap) {
        this.stack = new String[cap];
        this.top = -1;
        this.size = 0;
    }

    public void push(String s) {
        if (this.isFull()) {
            return;
        }

        this.stack[++this.top] = s;
        this.size++;
    }

    public String pop() {
        if (this.isEmpty()) {
            throw new IndexOutOfBoundsException();
        }

        this.size--;
        return this.stack[this.top--];
    }

    public String peek() {
        return this.stack[this.top];
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean isFull() {
        return this.size == this.stack.length;
    }

    public String inverte() {
        if (this.isEmpty()) {
            return "";
        }

        Stack aux = new Stack(this.size);
        String inverted = "";
        while (!this.isEmpty()) {
            if (this.top == 0) {
                inverted += this.peek();
            } else {
                inverted += this.peek() + " ";
            }
            aux.push(this.pop());
        }

        while (!aux.isEmpty()) {
            this.push(aux.pop());
        }

        return inverted;
    }
}
