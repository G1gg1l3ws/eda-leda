import java.util.*;
import java.lang.Math;

class Predecessor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] v = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        BST tree = new BST();

        for (int n: v) {
            tree.add(n);
        }

        System.out.println(tree.findPrev(Integer.parseInt(sc.nextLine())));

        sc.close();
    }
}

class BST {

    private Node root;
    private int size;
    
    public boolean isEmpty() {
        return this.root == null;
    }
    
    /**
     * Implementação iterativa da adição de um elemento em uma árvore binária de pequisa.
     * @param element o valor a ser adicionado na árvore.
     */
    public void add(int element) {
        this.size += 1;
        if (isEmpty())
            this.root = new Node(element);
        else {
            
            Node aux = this.root;
            
            while (aux != null) {
                
                if (element < aux.value) {
                    if (aux.left == null) { 
                        Node newNode = new Node(element);
                        aux.left = newNode;
                        newNode.parent = aux;
                        return;
                    }
                    
                    aux = aux.left;
                } else {
                    if (aux.right == null) { 
                        Node newNode = new Node(element);
                        aux.right = newNode;
                        newNode.parent = aux;
                        return;
                    }
                    
                    aux = aux.right;
                }
            }
        }
        
    }
    
    
    /**
     * Busca o nó cujo valor é igual ao passado como parâmetro. Essa é a implementação 
     * iterativa clássica da busca binária em uma árvore binária de pesquisa.
     * @param element O elemento a ser procurado.
     * @return O nó contendo o elemento procurado. O método retorna null caso
     * o elemento não esteja presente na árvore.
     */
    public Node search(int element) {
        if (isEmpty()) return null;

        Node current = root;

        while (current != null) {
            if (current.value == element) return current;
            else if (element < current.value) current = current.left;
            else current = current.right;
        }

        return null;
    }
    
    /**
     * Retorna a altura da árvore.
     */
    public int height() {
        if (this.isEmpty()) return -1;
        return this.height(this.root);
    }
    private int height(Node current) {
        if (current == null) return -1;
        return 1 + Math.max(height(current.left), height(current.right));
    }


    public boolean equals(BST outra) {
        if (this.isEmpty() && outra.isEmpty()) return true;

        else return this.equals(this.root, outra.root);
    }
    private boolean equals(Node current, Node outro) {
        if (current == null && outro == null) {
            return true;
        } else if (current != null && outro != null) {
            if (current.value != outro.value) {
                return false;
            }

            return equals(current.left, outro.left) && equals(current.right, outro.right);

        } else return false;
    }

    /**
    * Retorna o número de folhas da árvore.
    */
    public int contaFolhas() {
        if (this.isEmpty()) return 0;

        int folhas = 0;
        ArrayList<Node> queue = new ArrayList<>();
        queue.add(this.root);

        while (queue.size() != 0) {
            if (queue.get(0).isLeaf()) {
                folhas += 1;
            }

            if (queue.get(0).left != null) {
                queue.add(queue.get(0).left);
            }

            if (queue.get(0).right != null) {
                queue.add(queue.get(0).right);
            }

            queue.remove(0);
        }

        return folhas;
    }

    /**
     * @return o tamanho da árvore.
     */
    public int size() {
        return this.size;
    }

    public String preOrder() {
        return preOrder(this.root);

    }
    
    private String preOrder(Node current) {
        if (current == null) return "";
        
        else {
            return current.value + " " + preOrder(current.left) + preOrder(current.right);
        }
    }

    public String inOrder() {
        return inOrder(this.root);

    }
    
    private String inOrder(Node current) {
        if (current == null) return "";
        
        else {
            return inOrder(current.left) + " " + current.value + inOrder(current.right);
        }
    }

    public String postOrder() {
        return postOrder(this.root);

    }
    
    private String postOrder(Node current) {
        if (current == null) return "";
        
        else {
            return postOrder(current.left) + postOrder(current.right) + " " +  current.value;
        }
    }

    public String findPrev(int p) {
        if (this.isEmpty())
            return "";

        return findPrev(this.search(p), p);
    }

    private String findPrev(Node current, int p) {
        if (current.left != null) {
            return "[" + current.value + ", " + max(current.left) + "]";
        }

        String out = "[" + current.value;
        if (current != root) {
            Node aux = current.parent;
            while (aux.parent != null && aux.value >= p)
                if (aux != null) {
                    out += ", " + aux.value;
                    aux = aux.parent;
                }

            return out + ", " + aux.value + "]";
        }

        return "[" + current.value + "]";
    }

    private String max(Node current) {
        if (current == null) return "";
        else if (current.right == null) return "" + current.value;
        else return current.value + ", " + max(current.right);
    }
}


class Node {
    
    int value;
    Node left;
    Node right;
    Node parent;
    
    Node(int v) {
        this.value = v;
    }

    public boolean isLeaf() {
        return left == null && right == null;
    }

    public String toString() {
        return this.value + "";
    }
    
}
