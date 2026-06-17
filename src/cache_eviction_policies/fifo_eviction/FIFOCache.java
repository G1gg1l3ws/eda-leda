public class FIFOCache {

    private String[] deque;
    private TabelaHash hashTable;
    private int head;
    private int tail;
    private int size;
    // sua fila deve seguir a abordagem circular que vimos em sala de aula.
    // isso implica em dizer quer adições e remoções são O(1).
    public FIFOCache(int capacidade) {
        this.hashTable = new TabelaHash(capacidade);
        this.deque = new String[capacidade];
        this.head = -1;
        this.tail = -1;
        this.size = 0;
    }

    public boolean isEmpty() {
        // TODO
        return this.tail == -1 && this.head == -1;
    }

    public boolean isFull() {
        // TODO
        return this.size == this.deque.length;
    }

    // deve sobrescerver o mais antigo caso a fila esteja cheia.
    public void addLast(String chave) {
        if (this.isFull()) {
            this.removeFirst();
        }

        if (this.isEmpty()) {
            this.head = 0;
        }

        this.tail = ((this.tail + 1) % this.deque.length);
        this.deque[tail] = chave;
        this.size += 1;
        this.hashTable.put(chave.hashCode(), chave);
    }

    // deve lançar exceção caso a fila esteja vazia.
    public String removeFirst() {
        String val = this.deque[this.head];

        if (this.isEmpty()) {
            throw new IllegalArgumentException();
        }

        this.hashTable.remove(this.deque[this.head].hashCode());
        if (this.head == this.tail) {
            this.head = -1;
            this.tail = -1;
        } else {
            this.head = (this.head + 1) % this.deque.length;
        }

        this.size -= 1;

        return val;
    }

    // deve lançar exceção caso a fila esteja vazia. apenas retorna o primeiro da fila, sem
    // remover;
    public String getFirst() {
        if (this.isEmpty()) {
            return null;
        }
        return this.deque[this.head];
    }

    // deve lançar exceção caso a fila esteja vazia. apenas retorna o último da fila, sem
    // remover;
    public String getLast() {
        if (this.isEmpty()) {
            return null;
        }
        return this.deque[this.tail];
    }

    // deve retornar uma string representando a fila. 
    public String toString() {
        String out = "";

        FIFOCache aux = new FIFOCache(this.deque.length);

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
    
    public int size() {
        // TODO
        return this.size;
    }

    public boolean contains(String chave) {
        return this.hashTable.containsValue(chave);
    }
}
