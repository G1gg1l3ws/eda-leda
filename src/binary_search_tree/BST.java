import java.util.ArrayList;

public class BST {

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
            return postOrder(current.left) + postOrder(current.right) + " " +  current.value ;
        }
    }

    public void remove(int val) {
        remove(search(val));
    }

    private void remove(Node toRemove) {
        if (this.isEmpty()) throw new RuntimeException();

        if (toRemove == null) {
            return;
        }

        if (toRemove.isLeaf()) {
            if (toRemove == this.root) {
                this.root = null;
            } else {
                if (toRemove.value < toRemove.parent.value) toRemove.parent.left = null;
                else toRemove.parent.right = null;
            }
        } else if (toRemove.hasLeft() && !toRemove.hasRight()) {
            if (toRemove == this.root) {
                this.root = toRemove.left;
                this.root.parent = null;
            } else {
                toRemove.left.parent = toRemove.parent;
                if (toRemove.value < toRemove.parent.value) toRemove.parent.left = toRemove.left;
                else toRemove.parent.right = toRemove.left;
            }
        } else if (!toRemove.hasLeft() && toRemove.hasRight()) {
            if (toRemove == this.root) {
                this.root = toRemove.right;
                this.root.parent = null;
            } else {
                toRemove.right.parent = toRemove.parent;

                if (toRemove.value < toRemove.parent.value) toRemove.parent.left = toRemove.right;  
                else toRemove.parent.right = toRemove.right;
            }
        } else {
            Node sucessor = this.sucessor(toRemove);

            toRemove.value = sucessor.value;

            remove(sucessor);
        }

        this.size -= 1;
    }

    public Node sucessor(Node node) {
        if (node == null) return null;

        if (node.right != null) {
            return min(node);
        }

        Node aux = node;
        while (aux != null && aux.value < node.value) {
            aux = aux.parent;
        }

        return aux;

    }

    private Node min(Node current) {
        if (current.left == null) return current;
        else return min(current.left);
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

    public boolean hasLeft() {
        return this.left != null;
    }

    public boolean hasRight() {
        return this.right != null;
    }
    
}
