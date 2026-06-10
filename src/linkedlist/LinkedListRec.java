import java.util.NoSuchElementException;

public class LinkedList {
    private Node head;
    private Node tail;
    private int size;

    public LinkedList() {
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

        Node newNode = new Node(valor);
        if (index == 0) {
            this.addFirst(valor);
        } else if (index == this.size) {
            this.addLast(valor);
        } else {
            Node aux = getNode(this.head, index);
            aux.prev.next = newNode;
            newNode.prev = aux.prev;
            newNode.next = aux;
            aux.prev = newNode;

            size++;
        }

    }

    public int getFirst() {
        return this.head.value;
    }

    public int getLast() {
        return this.tail.value;
    }

    // retorna o elemento na posição passada como parâmetro
    // deve lançar IndexOutOfBoundsException se o índice não for válido.
    public int get(int index) {
        System.out.println(index >= this.size);
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        return get(this.head, index);
    }

    private int get(Node current, int index) {
        if (current == null) {
            return -1;
        }

        if (index == 0) {
            return current.value;
        }

        return get(current.next, --index);
    }

    // deve lançar exceção caso a fila esteja vazia.
    public int removeFirst() {
        int val = this.head.value;

        if (this.isEmpty()) {
            throw new NoSuchElementException();
        }

        if (this.head == this.tail) {
            this.head = null;
            this.tail = null;
        } else {
            Node aux = this.head;
            this.head = this.head.next;
            this.head.prev = null;
            aux.next = null;
        }

        this.size--;
        return val;
    }

    // deve lançar exceção caso a fila esteja vazia.
    public int removeLast() {
        int val = this.tail.value;

        if (this.isEmpty()) {
            throw new NoSuchElementException();
        }

        if (this.head == this.tail) {
            this.head = null;
            this.tail = null;
        } else {
            Node aux = this.tail;
            this.tail = this.tail.prev;
            this.tail.next = null;
            aux.prev = null;
        }

        this.size--;
        return val;
    }

    // remove o valor no índice passado como parâmetro. retorna o valor removido.
    // lançar exceção se o índice não for válido.
    public int remove(int index) {
        Node aux = getNode(this.head, index);

        int val = aux.value;
        
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        

        if (index == 0) {
            this.removeFirst();
        } else if (index == size) {
            this.removeLast();
        } else {
            aux.prev.next = aux.next;
            aux.next.prev = aux.prev;
            aux.prev = null;
            aux.next = null;

            this.size--;
        }

        return val;
    }

    // remove a primeira ocorrência do elemento cujo valor foi passado como
    // parâmetro.
    // se não encontrar, não faça nada. true se remover, false se não remover.
    public boolean removeByValue(int value) {
        int index = indexOf(value);
        
        if (index == -1) return false;
        
        remove(index);
        return true;
    }

    // retorna a posição da primeira ocorrência do valor passado como parâmetro.
    public int indexOf(int value) {
        return indexOf(this.head, value);
    }

    private int indexOf(Node current, int value) {
        if (current == null) {
            return -size - 1;
        }

        if (current.value == value) {
            return 0;
        }

        return 1 + indexOf(current.next, value);
    }

    public boolean contains(int v) {
        return contains(this.head, v);
    }

    private boolean contains(Node current, int v) {
        if (current == null) {
            return false;
        }

        if (current.value == v) {
            return true;
        }

        return contains(current.next, v);
    }

    // Deve retornar a posição da última ocorrência do elemento passado como
    // parâmetro.
    public int lastIndexOf(int valor) {
        return lastIndexOf(this.head, valor, -1, 0);
    }

    private int lastIndexOf(Node current, int v, int last, int index) {
        if (current == null) {
            return last;
        }
        
        if (current.value == v) {
            last = index;
            return lastIndexOf(current.next, v, last, index + 1);
        }

        return lastIndexOf(current.next, v, last, index + 1);

    }

    // deve retornar uma string representando a lista.
    public String toString() {
        if (isEmpty())
            return "";

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

    private Node getNode(Node current, int index) {
        if (current == null) {
            return null;
        }

        if (index == 0) {
            return current;
        }

        return getNode(current.next, --index);
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
