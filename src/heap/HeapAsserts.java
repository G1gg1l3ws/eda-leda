import java.util.Arrays;

public class HeapAsserts {

    public void testLeft() {
        MinHeap heap = new MinHeap(15);

        heap.add(100);
        heap.add(90);
        heap.add(85);
        heap.add(30);
        heap.add(45);
        heap.add(60);
        heap.add(70);
        heap.add(20);

        assert heap.left(0) == 1;
        assert heap.left(2) == 5;
        assert heap.left(1) == 3;
    }

    public void testRight() {
        MinHeap heap = new MinHeap(15);

        heap.add(100);
        heap.add(90);
        heap.add(85);
        heap.add(30);
        heap.add(45);
        heap.add(60);
        heap.add(70);
        heap.add(20);
        heap.add(113);

        assert heap.right(0) == 2;
        assert heap.right(2) == 6;
        assert heap.right(1) == 4;
    }

    public void testParent() {
        MinHeap heap = new MinHeap(15);

        heap.add(100);
        heap.add(90);
        heap.add(85);
        heap.add(30);
        heap.add(45);
        heap.add(60);
        heap.add(70);
        heap.add(20);

        assert heap.parent(5) == 2;
        assert heap.parent(3) == 1;
        assert heap.parent(4) == 1;
    }

    public void testRemove() {
        int[] expected = new int[]{30, 33, 45, 43, 38, 65, 52, 82, 56, 62, 0, 0, 0, 0, 0};

        MinHeap heap = new MinHeap(15);

        for (int i = 0; i <= 9; i++) {
            heap.add(expected[i]);
        }

        assert heap.toString().equals(Arrays.toString(expected));

        assert heap.remove() == 30;
        expected = new int[]{33, 38, 45, 43, 62, 65, 52, 82, 56, 62, 0, 0, 0, 0, 0};
        assert heap.toString().equals(Arrays.toString(expected));

        assert heap.remove() == 33;
        expected = new int[]{38, 43, 45, 56, 62, 65, 52, 82, 56, 62, 0, 0, 0, 0, 0};
        assert heap.toString().equals(Arrays.toString(expected));

        assert heap.remove() == 38;
        expected = new int[]{43, 56, 45, 82, 62, 65, 52, 82, 56, 62, 0, 0, 0, 0, 0};
        assert heap.toString().equals(Arrays.toString(expected));

        assert heap.remove() == 43;
        expected = new int[]{45, 56, 52, 82, 62, 65, 52, 82, 56, 62, 0, 0, 0, 0, 0};
        assert heap.toString().equals(Arrays.toString(expected));

        assert heap.remove() == 45;
        expected = new int[]{52, 56, 65, 82, 62, 65, 52, 82, 56, 62, 0, 0, 0, 0, 0};
        assert heap.toString().equals(Arrays.toString(expected));

        assert heap.remove() == 52;
        expected = new int[]{56, 62, 65, 82, 62, 65, 52, 82, 56, 62, 0, 0, 0, 0, 0};
        assert heap.toString().equals(Arrays.toString(expected));

        assert heap.remove() == 56;
        expected = new int[]{62, 82, 65, 82, 62, 65, 52, 82, 56, 62, 0, 0, 0, 0, 0};
        assert heap.toString().equals(Arrays.toString(expected));

        assert heap.remove() == 62;
        expected = new int[]{65, 82, 65, 82, 62, 65, 52, 82, 56, 62, 0, 0, 0, 0, 0};
        assert heap.toString().equals(Arrays.toString(expected));

        assert heap.remove() == 65;
        expected = new int[]{82, 82, 65, 82, 62, 65, 52, 82, 56, 62, 0, 0, 0, 0, 0};
        assert heap.toString().equals(Arrays.toString(expected));

        assert heap.remove() == 82;
        expected = new int[]{82, 82, 65, 82, 62, 65, 52, 82, 56, 62, 0, 0, 0, 0, 0};
        assert heap.toString().equals(Arrays.toString(expected));
        
        try {
            heap.remove();
            assert false;
        } catch (Exception e) {}
    }

    public static void main(String[] args) {
        HeapAsserts tests = new HeapAsserts();

        tests.testLeft();
        tests.testRight();
        tests.testParent();
        tests.testRemove();
        System.out.println("all tests passed");
    }
    
}
