package linkedlist;

import java.util.*;

class TrocaVizinhos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LinkedList ll = new LinkedList();
        
        int[] vals = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < vals.length; i++) {
            ll.addLast(vals[i]);
        }
        int index = Integer.parseInt(sc.nextLine());
        
        Node target = ll.get(index);
        ll.swap(target, target.next);

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

    public Node get(int index) {
        int i = 0;
        Node aux = this.head;
        while (aux.next != null && i < index) {
            aux = aux.next;
            i++;
        }
        
        return aux;
    }

    public void swap(Node n1, Node n2) {
        if (n1 == n2) {
            return;
        }

        if (n1 == head) {
            this.head = n2;
        } else if (n2 == head) {
            swap(n2, n1);
            return;
        }

        if (n1 == tail) {
            this.tail = n2;
        } else if (n2 == tail) {
            this.tail = n1;
        }

        if (n1.next != null) {
            n1.next.prev = n2;
        }
        if (n1.prev != null) {
            n1.prev.next = n2;
        }
        if (n2.next != null) {
            n2.next.prev = n1;
        }

        if (n1.next == n2) {
            Node tempPrev = n1.prev;
            n1.prev = n2.prev;
            n1.next = n2.next;
            n2.prev = tempPrev;
            n2.next = n1;
        } else {
            if (n2.prev != null) {
                n2.prev.next = n1;
            }

            Node tempNext = n1.next;
            Node tempPrev = n1.prev;
            n1.prev = n2.prev;
            n1.next = n2.next;
            n2.prev = tempPrev;
            n2.next = tempNext;
        }
    }

    public String toString() {
        String out = "";
        Node aux = this.head;
        int i = 0;
        while (i < this.size) {
            if (aux == this.tail) {
                out += "" + aux.value;
            } else {
                out += "" + aux.value + " ";
            }
            aux = aux.next;
            i++;
        }

        return out;
    }

    public boolean isEmpty() {
        return this.size == 0;
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

        this.size++;
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
