import java.util.*;

class StackArray {

    private int[] stack;
    private int top = -1;

    public StackArray(int cap) {
        this.stack = new int[cap];
    }
    
    public String push(int elem) {
        if (isFull())
            return "full\n";

        this.stack[++this.top] = elem;
        return "";
    }

    public String pop() {
        if (isEmpty())
            return "empty\n";

        int val = this.stack[this.top--];
        return "";
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

    public String toString() {
        if (this.isEmpty()) {
            return "empty";
        }

        StackArray aux = new StackArray(this.stack.length);

        String out = "";
        while (!this.isEmpty()) {
            aux.push(this.peek());
            this.pop();
        }
        while (!aux.isEmpty()) {
            if (aux.top < 1) {
                out += aux.peek();
            } else {
                out += aux.peek() + " ";
            }
            this.push(aux.peek());
            aux.pop();
        }

        return out;
    }

    public int size() {
        return top + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cap = Integer.parseInt(sc.nextLine());
        
        StackArray stack = new StackArray(cap);

        while (true) {
            String command = sc.nextLine();
            String[] commands = command.split(" ");

            switch(commands[0]) {
                case "peek":
                    System.out.println(stack.peek());
                    break;
                case "pop":
                    System.out.print(stack.pop());
                    break;
                case "push":
                    System.out.print(stack.push(Integer.parseInt(commands[1])));
                    break;
                case "print":
                    System.out.println(stack.toString());
                    break;
                default:
                    sc.close();
                    return;
            }   
        }
    }
}
