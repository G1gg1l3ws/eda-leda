import java.util.NoSuchElementException;

public class LinkedList {
    private Node head;
    private Node tail;
    private int size;
    
    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
   
    public boolean isEmpty() {
        return this.head == null;
    }

    public void addFirst(int valor) {
        Node newNode = new Node(valor);
        if (this.isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.head.prev = newNode;
            newNode.next = this.head;
            this.head = newNode;
        }
        size++;
    }

    public void addLast(int valor) {
        Node newNode = new Node(valor);
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

    // adiciona um valor na posição passada como parâmetro
    public void add(int index, int valor) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            this.addFirst(valor);
            return;
        } else if (index == size) {
            this.addLast(valor);
            return;
        }

        Node newNode = new Node(valor);
        Node aux = this.head;


        for (int i = 0; i < index - 1; i++) {
            //passa pelo array até encontrar o elemento na posição correta
            aux = aux.next;
        }

        newNode.next = aux.next;
        aux.next.prev = newNode;
        newNode.prev = aux;
        aux.next = newNode;

        size++;
    }

    public int getFirst() {
        return this.head.value;
    }

    public int getLast() {
        return this.tail.value;
    }

    // retorna o elemento na posição  passada como parâmetro
    // deve lançar IndexOutOfBoundsException se o índice não for válido.
    public int get(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        Node aux = this.head;

        for (int i = 0; i < index; i++) {
            //passa pelo array até encontrar o elemento na posição correta
            aux = aux.next;
        }
         return aux.value;
    }

    // deve lançar exceção caso a fila esteja vazia.
    public int removeFirst() {
        if (this.isEmpty()) {
            throw new NullPointerException();
        }

        int val = this.head.value;
        if (this.head.next == null) {
            this.head = null;
            this.tail = null;
        } else {
            this.head = this.head.next;
            this.head.prev = null;
        }
        
        this.size -= 1;
        return val;
    }

    // deve lançar exceção caso a fila esteja vazia.
    public int removeLast() {
        if (this.isEmpty()) {
            throw new NullPointerException();
        }


        int val = this.tail.value;
        if (this.size == 1 /*equivale a this.head.next == null*/) {
            this.head = null;
            this.tail = null;
        } else {
            this.tail = this.tail.prev;
            this.tail.next = null;
        }

        this.size -= 1;

        return val;
    }

    // remove o valor no índice passado como parâmetro. retorna o valor removido.
    // lançar exceção se o índice não for válido.
    public int remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            return this.removeFirst();
        } else if (index == size - 1) {
            return this.removeLast();
        }

        Node aux = this.head;
        for (int i = 0; i < index; i++) {
            //passa pelo array até encontrar o elemento na posição correta
            aux = aux.next;
        }
        int val = aux.value;

        (aux.prev).next = aux.next;
        (aux.next).prev = aux.prev;
        aux = null;

        this.size -= 1;

        return val;
    }

    // remove a primeira ocorrência do elemento cujo valor foi passado como parâmetro.
    // se não encontrar, não faça nada. true se remover, false se não remover.
    public boolean removeByValue(int value) {
        int index = indexOf(value);
        if (index == -1) {
            return false;
        }

        this.remove(index);
        return true; 
    }

    // retorna a posição da primeira ocorrência do valor passado como parâmetro.
    public int indexOf(int value) {
        Node aux = this.head;

        for (int i = 0; i < this.size; i++) {
            if (aux.value == value) {
                return i;
            }
            aux = aux.next;
        }
        return -1;
    }

    public boolean contain(int v) {
        Node aux = this.head;
        for (int i = 0; i < this.size; i++) {
            if (aux.value == v) {
                return true; 
            }
            aux = aux.next;
        }

        return false;
    }
   
    // Deve retornar a posição da última ocorrência do elemento passado como parâmetro. 
    public int lastIndexOf(int valor) {
        Node aux = this.head;

        int index = -1;
        for (int i = 0; i < this.size; i++) {
            if (aux.value == valor) {
                index = i;
            }
            aux = aux.next;
        }
        return index;
    }
    
    // deve retornar uma string representando a lista. 
    public String toString() {
        if (isEmpty()) return "";

        Node aux = this.head;
        String out = "";
        while (aux != null) {
            out += aux.value + ", ";
            aux = aux.next;
        }
        return out.substring(0, out.length() - 2);
    }
    
    public int size() {
        return this.size;
    }

    public void moveToHead(int index) {
        this.addFirst(this.remove(index));
    }

 //   public void insereOrdenado(int v) {}

    public void swap(Node n1, Node n2) {
        if (n1 == head) {
            n1.next.prev = n2;
            n2.prev.next = n1;

            if (n2 == tail) {
                n2.next = n2.prev;
                n1.prev = n1.next;

                n2.prev = null;
                n1.next = null;

                this.tail = n1;
            } else {
                n1.next = n2.next;
                n2.next.prev = n1;

                n2.next = n2.prev;
                n1.prev = n2.next;

                n2.prev = null;
            }

            this.head = n2;

        } else if (n2 == head) {
            n2.next.prev = n1;
            n1.prev.next = n2;
            if (n1 == tail) {
                n1.next = n1.prev;
                n2.prev = n2.next;

                n1.prev = null;
                n2.next = null;

                this.tail = n2;
            } else {
                n2.next = n1.next;
                n1.next.prev = n2;

                n1.next = n1.prev;
                n2.prev = n1.next;

                n1.prev = null;

            }

            this.head = n1;
        } else if (n1 == n2) {
            return;
        } else {
            n1.prev.next = n2;
            n2.next.prev = n1;

            n1.next.prev = n2;
            n2.prev.next = n1;

            n2.prev = n1.prev;
            n1.next = n2.next;

            n2.next = n1;
            n1.prev = n2;
        }
    }

    public Node getNode(int index) {
        Node aux = this.head;
        for (int i = 0; i < index; i++) {
            //passa pelo array até encontrar o elemento na posição correta
            aux = aux.next;
        }

        return aux;
    }
}

class Node {

    int value;
    Node prev;
    Node next;

    Node(int v) {
        this.value = v;
    }



}
