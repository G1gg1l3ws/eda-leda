public class BstAsserts {

    // TODO: Implementar testes!
    public void test() {
        BST tree = new BST();
        BST testTree = new BST();

        assert tree.search(10) == null;
        assert tree.height() == -1;
        assert tree.equals(testTree);
        assert tree.contaFolhas() == 0;
        assert tree.isEmpty();

        tree.add(100);
        testTree.add(100);

        assert tree.search(100) != null;
        assert tree.height() == 0;
        assert tree.size() == 1;
        assert tree.equals(testTree);
        assert tree.contaFolhas() == 1;
        assert !tree.isEmpty();

        tree.add(90);
        tree.add(200);
        tree.add(130);
        tree.add(75);
        tree.add(93);

        testTree.add(90);
        testTree.add(200);
        testTree.add(130);
        testTree.add(93);

        assert tree.search(90) != null;
        assert testTree.search(75) == null;
        assert tree.height() == 2;
        assert tree.size() == 6;
        assert !tree.equals(testTree);
        assert tree.contaFolhas() == 3;
        assert !tree.isEmpty();
        assert !tree.preOrder().equals(testTree.preOrder());

        testTree.add(75);

        assert testTree.search(75) != null;
        assert testTree.height() == 2;
        assert testTree.size() == 6;
        assert testTree.equals(tree);
        assert testTree.contaFolhas() == 3;
        assert !testTree.isEmpty();

        assert tree.preOrder().equals(testTree.preOrder());

        System.out.println(tree.inOrder());
        System.out.println(tree.postOrder());

    }

    public static void main(String[] args) {
        BstAsserts t = new BstAsserts();
        t.test();
    }

}
