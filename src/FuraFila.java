import java.util.*;

class FuraFila {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] seq = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int index = Integer.parseInt(sc.nextLine());
        
        Fila fila = new Fila(seq.length);
        for (int i = 0; i < seq.length; i++) {
            fila.addLast(seq[i]);
        }

        fila.furaFila(index);
    }

}

class Fila {
    int head;
    int tail;
    int size;
    int[] queue;

    public Fila(int c) {
        this.head = -1;
        this.tail = -1;
        this.size = 0;
        this.queue = new int[c];
    }

    public boolean isEmpty() {
        return tail == -1 && head == -1;
    }

    public boolean isFull() {
        return this.size == this.queue.length;
    }

    public void addLast(int v) {
        if (this.isFull()) {
            return;
        }

        if (this.isEmpty()) {
            this.head = 0;
        } 

        this.tail = (this.tail + 1) % this.queue.length;
        this.queue[this.tail] = v;
        this.size += 1;
    }

    public void furaFila(int index) {
        Fila aux = new Fila(this.size);
        for (int i = this.queue.length-1; i > index; i--) {
            aux.addLast(this.removeFirst());
            this.addLast(this.removeFirst());
        }
        
        System.out.println(Arrays.toString(this.queue));
    }

    public int removeFirst() {
        if (this.isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        
        int val = this.queue[this.head];
        if (this.head == this.tail) {
            this.head = -1;
            this.tail = -1;
        } else {
            this.head = (this.head + 1) % this.queue.length;
        }
        this.size -= 1;
        return val;
    }

    private void swap(int x, int y) {
        int aux = x;
        x = y;
        y = aux;
    }

}
