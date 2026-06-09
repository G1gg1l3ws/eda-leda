package linkedlist;

import java.util.*;

class RemoveIndex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        LinkedList ll = new LinkedList();
        int[] v = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int index = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < v.length; i++) {
            ll.addLast(v[i]);
        }

        ll.remove(index);

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

    private Node get(int index) {
        int i = 0;
        Node aux = this.head;

        while (aux.next != null && i < index) {
            i++;
            aux = aux.next;
        }

        return aux;
    }

    public void remove(int index) {
        Node target = this.get(index);
        
        if (target == this.head) {
            this.removeFirst();
        } else if (target == this.tail) {
            this.removeLast();
        } else {
            target.prev.next = target.next;
            target.next.prev = target.prev;
            target.prev = null;
            target.next = null;
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
    }

    public void removeLast() {
        
        if (this.tail.prev == null) {
            this.head = null;
            this.tail = null;
        } else {
            this.tail = this.tail.prev;
            this.tail.next = null;
        }
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

        size++;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public String toString() {
        String out = "";

        Node aux = this.head;
        while (aux != null) {
            if (aux.next == null) {
                out += "" + aux.value;
            } else {
                out += "" + aux.value + " ";
            }

            aux = aux.next;
        }

        return out;
    }
}

class Node {
    Node prev;
    Node next;
    int value;

    public Node(int v) {
        this.value = v;
    }

}
