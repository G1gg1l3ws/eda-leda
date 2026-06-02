import java.util.*;

class FilaArray {
    private int head;
    private int tail;
    private int[] queue;
    private int size;

    public FilaArray(int cap) {
        this.queue = new int[cap];
        this.head = -1;
        this.tail = -1;
        this.size = 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //
        int cap = Integer.parseInt(sc.nextLine());
        FilaArray fila = new FilaArray(cap);
        //
        while (true) {
            String command = sc.nextLine();
            String[] commands = command.split(" ");

            switch(commands[0]) {
                case "print":
                    System.out.print(fila.toString());
                    break;
                case "element":
                    System.out.println(fila.elementFila());
                    break;
                case "add":
                    System.out.print(fila.addLast(Integer.parseInt(commands[1])));
                    break;
                case "remove":
                    System.out.print(fila.removeFirst());
                    break;
                default:
                    sc.close();
                    return;
            }   
        }
    }

    public String elementFila() {
        if (this.isEmpty()) {
            return "empty\n";
        }

        return "" + this.queue[this.head];

    }

    private boolean isEmpty() {
        return this.tail == -1 && this.head == -1;
    }
    private boolean isFull() {
        return this.size == this.queue.length;
    }

    public String addLast(int val) {
        if (this.isFull()) {
            return "full\n";
        }

        if (this.isEmpty()) {
            this.head = 0;
            this.tail = 0;
        } else {
            this.tail = (this.tail + 1) % this.queue.length;
        }

        this.queue[this.tail] = val;
        this.size += 1;

        return "";
    }

    public String removeFirst() {
        if (this.isEmpty()) {
            return "empty\n";
        }

        if (this.head == this.tail) {
            this.head = -1;
            this.tail = -1;
        } else {
            head = (head + 1) % this.queue.length;
        }

        this.size -= 1;
        
        return "";
    }

    public String toString() {
        if (this.isEmpty()) {
            return "empty\n";
        }

        String out = "";

        FilaArray aux = new FilaArray(this.queue.length);

        while (!this.isEmpty()) {
            if (this.size > 1) {
                out += this.elementFila() + " ";
            } else {
                out += this.elementFila();
            }
            
            aux.addLast(Integer.parseInt(this.elementFila()));
            this.removeFirst();
        }

        while (!aux.isEmpty()) {
            this.addLast(Integer.parseInt(aux.elementFila()));
            aux.removeFirst();
        }
        
        return out + "\n";

    }
}
