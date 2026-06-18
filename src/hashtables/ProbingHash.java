package hashtables;

import java.util.ArrayList;
import java.util.*;

class ProbingHash {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] in;
        TabelaHash ht = new TabelaHash(Integer.parseInt(sc.nextLine()));

        do {
            in = sc.nextLine().split(" ");

            switch (in[0]) {
                case "put":
                    ht.put(Integer.parseInt(in[1]), in[2]);
                    System.out.println(ht.toString());
                    break;
                case "remove":
                    ht.remove(Integer.parseInt(in[1]));
                    System.out.println(ht.toString());
                    break;
                case "keys":
                    System.out.println(ht.keySet());
                    break;
                case "values":
                    System.out.println(ht.valueSet());
                    break;
            }

        } while (!in[0].equals("end"));
        sc.close();
    }

}

class TabelaHash {
    private Pair[] tabela;

    public TabelaHash(int capacidade) {
        this.tabela = new Pair[capacidade];    
    }

    public int hash(int key) {
        return key % this.tabela.length;
    }
    
    public void put(int key, String value) {
        int hash = this.hash(key);
        
        for (int i = 0; i < this.tabela.length; i++) {
            hash = (hash + i) % this.tabela.length;
            if (this.tabela[hash] == null ||
                this.tabela[hash].key == key ||
                this.tabela[hash].key == -1) {
                    this.tabela[hash] = new Pair(key, value);
                    return;
            }
        }
    }

    public Pair remove(int key) {
        int hash = this.hash(key);
        Pair p = null;

        if (this.tabela[hash] == null) {
            return p;
        }

        for (int i = 0; i < this.tabela.length; i++) {
            hash = (hash + i) % this.tabela.length;

            if (this.tabela[hash].key == key) {
                p = this.tabela[hash];
                this.tabela[hash] = new Pair(-1, "del");
                return p;
            }
        }

        return p;
    }

    public String toString() {
        return Arrays.toString(this.tabela);
    }

    public String keySet() {
        ArrayList<Integer> keySet = new ArrayList<>();

        for (int i = 0; i < this.tabela.length; i++) {
            if (this.tabela[i] != null && this.tabela[i].key != -1) {
                keySet.add(this.tabela[i].key);
            }
        }

        Integer[] out = new Integer[keySet.size()];
        out = keySet.toArray(out);
        Arrays.sort(out);
        return Arrays.toString(out);
    }

    public String valueSet() {
        ArrayList<String> valueSet = new ArrayList<>();

        for (int i = 0; i < this.tabela.length; i++) {
            if (this.tabela[i] != null && this.tabela[i].key != -1) {
                valueSet.add(this.tabela[i].value);
            }
        }

        String[] out = new String[valueSet.size()];
        out = valueSet.toArray(out);
        Arrays.sort(out);
        return Arrays.toString(out);
    }

}

class Pair {
    int key;
    String value;

    public Pair(int k, String v) {
        this.key = k;
        this.value = v;
    }

    public String toString() {
        if (this.key == -1)
            return "null";
        return "<" + this.key + ", " + this.value + ">";
    }
}
