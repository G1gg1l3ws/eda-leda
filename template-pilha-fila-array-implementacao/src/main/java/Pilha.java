public class Pilha {

    private int[] pilha;
    private int topo;

    public Pilha(int capacidade) {
        this.pilha = new int[capacidade];
        this.topo = -1;
    }

    public boolean isEmpty() {
        return this.topo == -1;
    }

    public boolean isFull() {
        return this.topo == this.pilha.length - 1; 
    }

    // deve lançar exceção caso a pilha esteja cheia.
    public void push(int valor) {
        if (isFull())
            throw new IndexOutOfBoundsException("Pilha cheia");

        this.pilha[++this.topo] = valor;
    }

    // deve lançar exceção caso a pilha esteja vazia.
    public int pop() {
        if (isEmpty())
            throw new IndexOutOfBoundsException("Pilha vazia");
            
        return this.pilha[this.topo--];
    }

    // deve lançar exceção caso a pilha esteja vazia.
    public int peek() {
        if (isEmpty()) 
            throw new IndexOutOfBoundsException("Pilha vazia");
        

        return this.pilha[this.topo];
    }


    // deve retornar uma string representando a pilha. Veja os testes para a especificação
    // detalhada. Não é permitido iterar diretamente sobre o array ou criar arrays. Crie outra pilha, se preciso. Use as operações push, pop,
    // isEmpty etc. 
    public String toString() {
        String stackString = "";
        
        Pilha aux = new Pilha(this.pilha.length);
        while (!isEmpty()) {
            aux.push(this.pop());
        }

        while (!aux.isEmpty()) {
            if (aux.size() > 1) {
                stackString += aux.peek() + ", ";

            } else {
                stackString += aux.peek();
            }
            this.push(aux.pop());
        }

        return stackString;

    }
    
    // Deve retornar a posição da primeira ocorrência do elemento passado como parâmetro. Note que
    // o topo sempre está na primeira posição (0), abaixo do topo é a posição 1 etc. Não confunda
    // com os índices do array. Interprete os testes para a especificação mais detalhada.
    // Não é permitido iterar diretamente sobre o array. Use as operações push, pop,
    // isEmpty etc.
    public int indexOf(int valor) {
        Pilha aux = new Pilha(this.pilha.length);

        int position = -1;
        while (!this.isEmpty()) {
            if (this.peek() == valor) {
                position = this.size() - 1;
            }

            aux.push(this.pop());
        }

        while (!aux.isEmpty()) {
            this.push(aux.pop());
        }

        return position;
    }

    public int lastIndexOf(int valor) {
        Pilha aux = new Pilha(this.pilha.length);

        int position = -1;
        while (!this.isEmpty()) {
            if (this.peek() == valor) {
                position = this.size() - 1;
                break;
            }

            aux.push(this.pop());
        }

        while (!aux.isEmpty()) {
            this.push(aux.pop());
        }

        return position;
    }
    public int size() {
        return this.topo + 1;
    }


}
