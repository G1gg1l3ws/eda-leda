public class BstAsserts {
    public static void main(String[] args) {
        BST bst = new BST();
        assert bst.isAVL();

        int[] values = new int[]{41,20,11,29,32,65,50,91,72,99};
        for (int i : values)
            bst.add(i);
        assert bst.isAVL();

        bst = new BST();
        bst.add(1);
        assert bst.isAVL();
        bst.add(2);
        assert bst.isAVL();
        bst.add(3);
        assert !bst.isAVL();

        bst = new BST();
        bst.add(1);
        assert bst.isAVL();
        bst.add(3);
        assert bst.isAVL();
        bst.add(2);
        assert !bst.isAVL();

        bst = new BST();
        bst.add(10);
        assert bst.isAVL();
        bst.add(5);
        assert bst.isAVL();
        bst.add(1);
        assert !bst.isAVL();

        bst = new BST();
        bst.add(10);
        assert bst.isAVL();
        bst.add(5);
        assert bst.isAVL();
        bst.add(6);
        assert !bst.isAVL();

        bst = new BST();
        values = new int[]{90,13,4,8,37,16,24,44,42,88,51,72,81,84,92};
        for (int i : values)
            bst.add(i);
        assert !bst.isAVL();

        bst = new BST();
        values = new int[]{23, 12, 40, 9, 25, 60, 50};
        for (int i : values)
            bst.add(i);
        assert bst.isAVL();
    }
}
