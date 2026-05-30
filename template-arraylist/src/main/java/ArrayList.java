public class ArrayList {
    private int[] arrayList;
    private int last = -1;
    private int size = 0;
   
    public ArrayList(int capacidadeInicial) {
        this.arrayList = new int[capacidadeInicial];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(int valor) {
        // TODO
    }

    public void addLast(int valor) {
        // TODO
    }

    // adiciona um valor no índice passado como parâmetro
    public void add(int index, int valor) {
        //TODO
    }

    // você vai precisar desse método quando tentar adicionar e a fila já estiver cheia
    private void resize(int novaCapacidade) {
       // TODO 
    }

    public void assegureCapacidade(int capacidadePretendida) {
        if ()
    }

    public int getFirst() {
        // TODO
        return this.arrayList[0];
    }

    public int getLast() {
        //TODO
        return this.arrayList[last];
    }

    // retorna o elemento no índice passado como parâmetro
    // deve lançar IndexOutOfBoundsException se o índice não for válido.
    public int get(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of range" + index + "for ArrayList size" : + this.size);
        }
        return this.arrayList[index];
    }

    // deve lançar exceção caso a fila esteja vazia.
    public int removeFirst() {
        // TODO 
        return 0;
    }

    // deve lançar exceção caso a fila esteja vazia.
    public void removeLast() {
        //TODO
    }

    // remove o valor no índice passado como parâmetro. 
    // lançar exceção se o índice não for válido.
    public void remove(int index) {
        // TODO
    }

    // remove a primeira ocorrência do elemento cujo valor foi passado como parâmetro.
    // se não encontrar, não faça nada.
    public void removeByValue(int value) {
        // TODO
    }

    // retorna o índice da primeira ocorrência do valor passado como parâmetro.
    public int indexOf(int value) {
        // TODO
        return -1;
    }
   
    // Deve retornar a posição da última ocorrência do elemento passado como parâmetro. 
    public int lastIndexOf(int valor) {
        return -1;
    }
    
    // deve retornar uma string representando a lista. 
    public String toString() {
        return "";
    }
    
    public int size() {
        // TODO
        return this.size;
    }
}
