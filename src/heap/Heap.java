import java.util.Arrays;

public class Heap {
    
    private int[] heap;
    private int tail;
    
    public Heap(int capacidade) {
        this.heap = new int[capacidade];
        this.tail = -1;
    }
    
    public Heap(int[] heap) {
        this.heap = heap;
        this.tail = this.heap.length - 1;
        this.buildHeap();
    }

    public boolean isEmpty() {
        return this.tail == -1;
    }

    public int left(int i) {
        return 2 * i + 1; 
    }

    public int right(int i) {
        return (i + 1) * 2;
    }

    public int parent(int i) {
        return (int) (i - 1) / 2;
    }

    public void add(int n) {
        if (this.tail >= heap.length - 1) {
            this.resize();
        }

        this.heap[++this.tail] = n;

        int index = this.tail;
        while (index > 0 && heap[index] > heap[parent(index)]) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    private void buildHeap() {
        for (int i = parent(tail); i >= 0; i--) {
            this.heapify(i);
        }
    }
    
    public int remove() {
        if (isEmpty()) throw new RuntimeException();

        int toRemove = this.heap[0];
        this.heap[0] = this.heap[this.tail--];

        this.heapify(0);

        return toRemove;
    }
        
    private void heapify(int index) {
        if (isLeaf(index) || !isValidIndex(index)) return;

        int maxIndex = maxIndex(index, left(index), right(index));

        if (maxIndex != index) {
            swap(maxIndex, index);
            heapify(maxIndex);
        }
    } 
    
    private int maxIndex(int index, int left, int right) {
        if (this.heap[index] > this.heap[left]) {
            if (isValidIndex(right)) {
                if (this.heap[right] > this.heap[index]) {
                    return right;
                }
            }
            return index;

        } else {
            if (isValidIndex(right)) {
                if (this.heap[right] > this.heap[left]) {
                    return right;
                }
            }

            return left;
        }
    }

    private boolean isValidIndex(int index) {
        return index >= 0 && index <= tail;
    }
    
    private boolean isLeaf(int index) {
        return index > parent(tail) && index <= tail; 
    } 
    
    private void swap(int i, int j) {
        int aux = this.heap[i];
        this.heap[i] = this.heap[j];
        this.heap[j] = aux;
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
    
    public String toString() {
        System.out.println(Arrays.toString(this.heap));
        return Arrays.toString(this.heap);
    }

}
