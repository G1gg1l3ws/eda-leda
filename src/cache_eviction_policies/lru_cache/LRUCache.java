public class LRUCache {

    private LinkedList ll;
    private int CAPACIDADE_MAXIMA;
    // o tamanho da sua linkedlist não pode passar de `capacidade`.
    public LRUCache(int capacidade) {
        ll = new LinkedList();
        this.CAPACIDADE_MAXIMA = capacidade;
    }

    public boolean isEmpty() {
        return this.ll.isEmpty();
    }

    public boolean isFull() {
        // TODO
        return this.ll.size() == CAPACIDADE_MAXIMA;
    }

    // deve ser O(1)
    public void addLast(String chave) {
        if (this.isFull()) {
            return;
        }

        this.ll.addLast(chave);
    }

    // deve ser O(n)
    // retorna o próprio valor se encontrar ou null.
    // Encontrando ou não, o elemento deve ser movido para o final da lista
    public String get(String value) {
        Node val = ll.getNode(value);
        if (val != null) {
            ll.moveToTail(val);
            return ll.getValueOfNode(val);
        }
        
        if (isFull()) {
            ll.removeFirst();
        }
        return null;
    }

    // O(1)
    public String getFirst() {
        return ll.getFirst();
    }

    // O(1)
    public String getLast() {
        return ll.getLast();
    }

    // deve retornar uma string representando a fila. 
    @Override
    public String toString() {
        return ll.toString();
    }
    
    public int size() {
        return ll.size();
    }
}
