public class Fila {
    
    private int[] queue;
    private int tail;
    private int head;
    private int size;
    // sua fila deve seguir a abordagem circular que vimos em sala de aula.
    // isso implica em dizer quer adições e remoções são O(1).
    public Fila(int capacidade) {
        this.queue = new int[capacidade];
        this.tail = -1;
        this.head = -1;
        this.size = 0;
    }

    public boolean isEmpty() {
        return tail == -1 && head == -1;
    }

    public boolean isFull() {
        return this.size == this.queue.length;
    }

    // deve lançar exceção caso a fila esteja cheia.
    public void addLast(int valor) {
        if (isFull()) {
            throw new IndexOutOfBoundsException("Queue full");
        }
        if (isEmpty())
            this.head = 0;
        
        this.tail = ((this.tail + 1) % this.queue.length);
        this.queue[tail] = valor;
        this.size += 1;
    }

    // deve lançar exceção caso a fila esteja vazia.
    public int removeFirst() {
        int val = this.queue[this.head];
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Queue empty");
        }
        if (this.head == this.tail) {
            this.head = -1;
            this.tail = -1;
        } else {
            this.head = (this.head + 1) % this.queue.length;
        }

        this.size -= 1;

        return val;
    }

    // deve lançar exceção caso a fila esteja vazia. apenas retorna o primeiro da fila, sem
    // remover;
    public int getFirst() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Queue empty");
        }
     
        return this.queue[this.head];
    }

    // deve lançar exceção caso a fila esteja vazia. apenas retorna o último da fila, sem
    // remover;
    public int getLast() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Queue empty");
        }
        
        return this.queue[this.tail];
    }

    // deve retornar uma string representando a fila. 
    public String toString() {
        String out = "";

        Fila aux = new Fila(this.queue.length);

        while (!this.isEmpty()) {
            if (this.size() > 1) {
                out += this.getFirst() + ", ";
            } else {
                out += this.getFirst();
            }
            
            aux.addLast(this.removeFirst());
        }

        while (!aux.isEmpty()) {
            this.addLast(aux.removeFirst());
        }
        
        return out;
    }
    
    // Deve retornar a posição da primeira ocorrência do elemento passado como parâmetro. 
    public int indexOf(int valor) {
        Fila aux = new Fila(this.queue.length);

        int index = -1;
        while (!this.isEmpty()) {
            if (this.getFirst() == valor)
            index = this.head % this.queue.length;
            aux.addLast(this.removeFirst());
            break;
        }

        while (!aux.isEmpty()) {

            this.addLast(aux.removeFirst());
        }

        return index;
    }

    // Deve retornar a posição da última ocorrência do elemento passado como parâmetro. 
    public int lastIndexOf(int valor) {
        Fila aux = new Fila(this.queue.length);

        int index = -1;
        while (!this.isEmpty()) {
            if (this.getFirst() == valor)
            index = this.head % this.queue.length;
            aux.addLast(this.removeFirst());
        }

        while (!aux.isEmpty()) {

            this.addLast(aux.removeFirst());
        }

        return index;
    }
    
    public int size() {
        return this.size;
    }

}
