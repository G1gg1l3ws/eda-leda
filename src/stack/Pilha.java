package stack;

public class Pilha {

    private int[] stack;
    private int top = -1;

    public Pilha(int cap) {
        this.stack = new int[cap];
    }
    
    public void push(int elem) throws StackOverflowError {
        if (isFull())
            throw new StackOverflowError("Maximum capacity reached");

        this.stack[++this.top] = elem;
    }

    public int pop() throws IndexOutOfBoundsException {
        if (isEmpty())
            throw new IndexOutOfBoundsException("Cannot remove from empty stack");

        return this.stack[this.top--];
    }

    public int peek() {
        return this.stack[this.top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == stack.length - 1;
    }

    public int size() {
        return top;
    }

}
