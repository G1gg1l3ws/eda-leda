package stack;

import java.util.*;

class MaxPilha {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] nums = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        Stack stack = new Stack(nums.length);
        for (int i = 0; i < nums.length; i++) {
            stack.push(nums[i]);
        }

        System.out.println(stack.maxElement());

        sc.close();
    }
}

class Stack {
    int[] stack;
    int top;
    int size;

    public Stack(int cap) {
        this.top = -1;
        this.size = 0;
        this.stack = new int[cap];
    }
    
    public boolean isFull() {
        return this.size == this.stack.length;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void push(int v) {
        if (this.isFull()) {
            return;
        }

        this.stack[++this.top] = v;
        this.size += 1;
    }

    public int pop() {
        if (this.isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        
        this.size -= 1;
        return this.stack[this.top--];
    }

    public int peek() {
        return this.stack[this.top];
    }

    public int maxElement() {
        Stack aux = new Stack(this.size);
        
        int maxNum = Integer.MIN_VALUE;
        while (!this.isEmpty()) {
            if (this.peek() > maxNum) {
                maxNum = this.peek();
            }

            aux.push(this.pop());
        }

        while (!aux.isEmpty()) {
            this.push(aux.pop());
        }
        
        return maxNum;
    }
}
