package linkedlist;

import java.util.*;

class TrimList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        LinkedList ll = new LinkedList();
        int[] v = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int index = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < v.length; i++) {
            ll.addLast(v[i]);
        }

        ll.trim(index);

        System.out.println(ll.toString());
        
        sc.close();
    }
}

class LinkedList {
    private Node head;
    private Node tail;
    private int size;

    public LinkedList() {
        this.size = 0;
    }

    public void addLast(int v) {
        Node newNode = new Node(v);
        if (this.isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            newNode.prev = this.tail;
            this.tail = newNode;
        }

        this.size += 1;
    }

    public void removeLast() {
        if (this.isEmpty()) {
            return;
        }

        if (this.tail.prev == null) {
            this.head = null;
            this.tail = null;
        } else {
            this.tail = this.tail.prev;
            this.tail.next = null;
        }

        this.size--;
    }

    public void removeFirst() {
        if (this.isEmpty()) {
            return;
        }

        if (this.head.next == null) {
            this.head = null;
            this.tail = null;
        } else {
            this.head = this.head.next;
            this.head.prev = null;
        }

        this.size--;
    }

    public void trim(int count) {
        trim(this.head, 0, count);
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    private void trim(Node current, int i, int count) {
        if (current == null) {
            return;
        }

        if (i >= count) {
            return;
        }

        this.removeFirst();
        this.removeLast();
        
        trim(this.head, i+1, count);
    }
    
    public String toString() {
        if (this.isEmpty())
            return "vazia";
        
        return toString(this.head, 0);
    }

    private String toString(Node current, int index) {

        if (current == null) {
            return "";
        }


        if (index < size-1) {
            return current.value + " " + toString(current.next, index+1);
        } else {
            return current.value + toString(current.next, index + 1);
        }

    }
}

class Node {
    Node next;
    Node prev;
    int value;

    public Node(int v) {
        this.value = v;
    }
}
