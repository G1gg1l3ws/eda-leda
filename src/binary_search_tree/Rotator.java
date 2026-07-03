public class Rotator {

	public void rotateLeft(Node node) {
        if (node == null) {
            throw new RuntimeException();
        }

        Node newRoot = node.right;
        newRoot.parent = node.parent;

        node.right = newRoot.left;
        newRoot.left = node;

        node.parent = newRoot;
        
        if (newRoot.parent != null) {
            if (newRoot.parent.left == node)
                newRoot.parent.left = newRoot;
            else
                newRoot.parent.right = newRoot;
        } else {
            newRoot.parent = null;
        }

        if (node.right != null) {
            node.right.parent = node;
        }
    }

	public void rotateRight(Node node) {
        if (node == null) {
            throw new RuntimeException();
        }

        Node newRoot = node.left;
        newRoot.parent = node.parent;

        node.left = newRoot.right;
        newRoot.right = node;

        node.parent = newRoot;
        
        if (newRoot.parent != null) {
            if (newRoot.parent.left == node)
                newRoot.parent.left = newRoot;
            else
                newRoot.parent.right = newRoot;
        } else {
            newRoot.parent = null;
        }

        if (node.left != null) {
            node.left.parent = node;
        }
    }
}
