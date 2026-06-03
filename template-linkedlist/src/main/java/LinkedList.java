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
        if (this.head == null && this.tail == null) {
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
        if (this.head == null && this.tail == null) {
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
        Node aux = this.head;

        if (index == 0) {
            this.addFirst(valor);
            return;
        } else if (index == size) {
            this.addLast(valor);
            return;
        }

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
        Node aux = this.head;
        for (int i = 0; i < index - 1; i++) {
            //passa pelo array até encontrar o elemento na posição correta
            aux = aux.next;
        }
         return aux.value;
    }

    // deve lançar exceção caso a fila esteja vazia.
    public int removeFirst() {
        int val = this.head.value;
        this.head = this.head.next;
        this.head.prev = null;
        return val;
    }

    // deve lançar exceção caso a fila esteja vazia.
    public int removeLast() {
        int val = this.tail.value;
        this.tail.prev = this.tail;
        this.tail.next = null;
        return val;
    }

    // remove o valor no índice passado como parâmetro. retorna o valor removido.
    // lançar exceção se o índice não for válido.
    public int remove(int index) {
        return -1;
    }

    // remove a primeira ocorrência do elemento cujo valor foi passado como parâmetro.
    // se não encontrar, não faça nada. true se remover, false se não remover.
    public boolean removeByValue(int value) {
        return false;
    }

    // retorna a posição da primeira ocorrência do valor passado como parâmetro.
    public int indexOf(int value) {
        return -1;
    }

    public boolean contain(int v) {
        return false;
    }
   
    // Deve retornar a posição da última ocorrência do elemento passado como parâmetro. 
    public int lastIndexOf(int valor) {
        return -1;
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
        return -1;
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
