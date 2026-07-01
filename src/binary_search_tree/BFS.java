import java.util.*;

class BFS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] v1 = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        BST t1 = new BST();

        for (int i = 0; i < v1.length; i++) {
            t1.add(v1[i]);
        }

        System.out.println(t1.breadthFirstSearch());

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
    public String search(int element) {
        if (isEmpty()) return null;

        Node current = root;
        String out = "[" + current.value;

        while (current != null && !current.isLeaf()) {
            if (current.value == element) {
                return out + "]";
            } else if (element < current.value){
                current = current.left;
            }
            else {
                current = current.right;
            }
            out += ", " + current.value;
        }

        return out + "]";
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

    public String breadthFirstSearch() {
        if (this.isEmpty()) return "";

        ArrayList<Node> queue = new ArrayList<>();
        queue.add(this.root);
        String out = "";

        while (queue.size() != 0) {
            if (queue.get(0).left != null) {
                queue.add(queue.get(0).left);
            }
            if (queue.get(0).right != null) {
                queue.add(queue.get(0).right);
            }
            out += queue.get(0).value + " ";
            queue.remove(0);
        }

        return out.trim();
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
    
}
