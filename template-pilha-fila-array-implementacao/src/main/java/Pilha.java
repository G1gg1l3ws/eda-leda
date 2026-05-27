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

        this.topo += 1;
        this.pilha[this.topo] = valor;
    }

    // deve lançar exceção caso a pilha esteja vazia.
    public int pop() {
        if (isEmpty())
            throw new IndexOutOfBoundsException("Pilha vazia");
            
        int val = this.pilha[this.topo];
        this.topo -= 1;
        return val;
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
        
        int i = this.size();
        Pilha aux = new Pilha(this.size());
        while (i > 0) {
            aux.push(this.pop());
            i--;
        }
        
        System.out.println(aux.size());

        while (i < aux.size()) {
            //System.out.println(i);
            if (i < aux.size() - 1) {
                stackString += aux.peek() + ", ";

            } else {
                stackString += aux.peek();
            }
            this.push(aux.pop());
            i++;
        }

        return stackString;

    }
    
    // Deve retornar a posição da primeira ocorrência do elemento passado como parâmetro. Note que
    // o topo sempre está na primeira posição (0), abaixo do topo é a posição 1 etc. Não confunda
    // com os índices do array. Interprete os testes para a especificação mais detalhada.
    // Não é permitido iterar diretamente sobre o array. Use as operações push, pop,
    // isEmpty etc.
    public int indexOf(int valor) {
        Pilha aux = new Pilha(this.size());

        int i = this.size();
        int position = -1;
        while (i >= 0) {
            if (this.peek() == valor) {
                position = this.size();
                break;
            }

            aux.push(this.pop());
            i--;
        }

        while (i < this.size()) {
            this.push(aux.pop());
            i++;
        }

        return position;
    }

    public int lastIndexOf(int valor) {
        Pilha aux = new Pilha(this.size());

        int i = this.size();
        int position = -1;
        while (i >= 0) {
            if (this.peek() == valor) {
                position = this.size();
            }

            aux.push(this.pop());
            i--;
        }

        while (i < this.size()) {
            this.push(aux.pop());
            i++;
        }

        return position;
    }
    public int size() {
        return this.topo + 1;
    }

    public int top() {
        return this.topo;        
    }

}
