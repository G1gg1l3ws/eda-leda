import java.util.Arrays;

public class MinHeap {

    private int[] heap;
    private int tail;

    public MinHeap(int capacidade) {
        this.tail = -1;
        this.heap = new int[capacidade];
    }

    public MinHeap(int[] heap) {
        this.tail = heap.length - 1;
        this.heap = heap;
        this.buildHeap();
    }
    public int left(int index) {
        return (2 * index) + 1;
    }

    public int right(int index) {
        return 2 * (index + 1);
    }

    public int parent(int index) {
        return (int) (index - 1) / 2;
    }

    public void add(int value) {
        if (this.tail >= heap.length - 1) {
            this.resize();
        }

        this.heap[++this.tail] = value;
        
        int index = this.tail;
        while (index > 0 && this.heap[index] < this.heap[parent(index)]) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    public int remove() {
        if (this.isEmpty()) {throw new IndexOutOfBoundsException();}
        int val = this.heap[0];
        this.heap[0] = this.heap[this.tail--];

        this.heapify(0);

        return val;
    }

    private void buildHeap() {
        for (int i = parent(this.tail); i >= 0; i--) {
            this.heapify(i);
        }
    }

    private void heapify(int index) {
        if (!isValidIndex(index) || isLeaf(index)) return;

        int minIndex = minIndex(left(index), right(index), index);

        if (minIndex != index) {
            swap(minIndex, index);
            heapify(minIndex);
        }
    }

    private int minIndex(int left, int right, int i) {
        if (heap[left] < heap[i]) {
            if (isValidIndex(right)) {
                if (heap[right] < heap[left]) {
                    return right;
                }
            }
            return left;

        } else {
            if (isValidIndex(right)) {
                if (heap[right] < heap[i]) {
                    return right;
                }
            }
            return i;
        }
    }

    private void swap(int i, int j) {
        int aux = this.heap[i];
        this.heap[i] = this.heap[j];
        this.heap[j] = aux;
    }

    private boolean isValidIndex(int index) {
        return index >= 0 && index <= tail;
    }
    
    private boolean isLeaf(int index) {
        return index > parent(tail) && index <= tail; 
    } 

    private void resize() {
        int[] novoHeap = new int[this.heap.length * 2];
        for (int i = 0; i <= tail; i++)
            novoHeap[i] = this.heap[i];
        
        this.heap = novoHeap;
    }
    
    public int size() {
        return this.tail + 1;
    }
    
    @Override
    public String toString() {
        return Arrays.toString(this.heap);
    }

    public boolean isEmpty() {
        return this.tail == -1;
    }
}
