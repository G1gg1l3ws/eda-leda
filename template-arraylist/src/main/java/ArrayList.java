public class ArrayList {
    private int[] list;
    private int last = -1;
    private int size = 0;
   
    public ArrayList(int capacidadeInicial) {
        this.list = new int[capacidadeInicial];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(int valor) {
        if (this.isFull()) {
            resize(this.size() * 2);
        }

        //move todos os elementos do inicio até o último
        shiftRight(0, last);
        last++;
        
        this.list[0] = valor;
        this.size++;
    }

    public void addLast(int valor) {
        if (this.isFull()) {
            resize(this.size() * 2);
        }
        
        this.list[++last] = valor;
        this.size++;
    }

    // adiciona um valor no índice passado como parâmetro
    public void add(int index, int valor) {
        if (this.isFull()) {
            resize(this.size() * 2);
        }
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of range " + index + " for ArrayList size: " + this.size());
        }

        shiftRight(index, last);
        last++;
        
        this.list[index] = valor;
        this.size++;
    }

    private boolean isFull() {
        return this.size() == this.list.length;
    }

    private void shiftRight(int left, int right) {
        for (int i = right; i >= left; i--) {
            this.list[i + 1] = this.list[i];
        }
    }

    private void shiftLeft(int left, int right) {
        for (int i = left; i < right; i++) {
            this.list[i] = this.list[i + 1];
        }
    }

    // você vai precisar desse método quando tentar adicionar e a fila já estiver cheia
    private void resize(int novaCapacidade) {
        int[] listResize = new int[novaCapacidade];

        for (int i = 0; i <= last; i++) {
            listResize[i] = this.list[i];
        }

        this.list = listResize;
    }

    public void assegureCapacidade(int capacidadePretendida) {
        if (capacidadePretendida <= this.size()) {
            return;
        }
        
        resize(Math.max(this.list.length * 2, capacidadePretendida));
    }

    public int getFirst() {
        if (this.isEmpty()) {
            throw new IndexOutOfBoundsException("Index out of range" + -1 + "for ArrayList size: " + this.size());
        }
        return this.list[0];
    }

    public int getLast() {
        if (this.isEmpty()) {
            throw new IndexOutOfBoundsException("Index out of range" + -1 + "for ArrayList size: " + this.size());
        }
        return this.list[last];
    }

    // retorna o elemento no índice passado como parâmetro
    // deve lançar IndexOutOfBoundsException se o índice não for válido.
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range" + index + "for ArrayList size: " + this.size());
        }
        return this.list[index];
    }

    // deve lançar exceção caso a fila esteja vazia.
    public int removeFirst() {
        if (this.isEmpty()) {
            throw new IllegalArgumentException("Cannot remove from empty ArrayList");
        }

        int val = this.list[0];
        shiftLeft(0, last);
        this.size--;
        this.last--;
        return val;
    }

    // deve lançar exceção caso a fila esteja vazia.
    public void removeLast() {
        if (this.isEmpty()) {
            throw new IllegalArgumentException("Cannot remove from empty ArrayList");
        }

        this.last--;
        this.size--;
    }

    // remove o valor no índice passado como parâmetro. 
    // lançar exceção se o índice não for válido.
    public void remove(int index) {
        if (this.isEmpty()) {
            throw new IllegalArgumentException("Cannot remove from empty ArrayList");
        }

        shiftLeft(index, last);
        this.size--;
        this.last--;
    }

    // remove a primeira ocorrência do elemento cujo valor foi passado como parâmetro.
    // se não encontrar, não faça nada.
    public void removeByValue(int value) {
        int index = -1;
        for (int i = 0; i < this.size(); i++) {
            if (this.list[i] == value) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            shiftLeft(index, last);
            this.size--;
            this.last--;
        }
    }

    // retorna o índice da primeira ocorrência do valor passado como parâmetro.
    public int indexOf(int value) {
        int index = -1;
        for (int i = 0; i < this.size(); i++) {
            if (this.list[i] == value)
                return i;
        }

        return index;
    }
   
    // Deve retornar a posição da última ocorrência do elemento passado como parâmetro. 
    public int lastIndexOf(int valor) {
        int index = -1;
        for (int i = 0; i < this.size(); i++) {
            if (this.list[i] == valor)
                index = i;
        }
        return index;
    }
    
    // deve retornar uma string representando a lista. 
    public String toString() {
        String out = "";
        for (int i = 0; i <= last; i++) {
            if (i == last) {
                out += "" + this.list[i];
            } else {
                out += "" + this.list[i] + ", ";
            }
        }

        return out;
    }
    
    public int size() {
        // TODO
        return this.size;
    }
}
