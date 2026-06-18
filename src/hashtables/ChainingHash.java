package hashtables;

import java.util.ArrayList;
import java.util.Iterator;

import Pair;
import TabelaHash;

import java.util.*;

class ChainingHash {
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
    }

}

class TabelaHash {
    private ArrayList<Pair>[] tabela;

    public TabelaHash(int capacidade) {
        this.tabela = new ArrayList[capacidade];    
        for (int i = 0; i < this.tabela.length; i++) {
            this.tabela[i] = new ArrayList<>();
        }
    }

    public int hash(int key) {
        return key % this.tabela.length;
    }
    
    public void put(int key, String value) {
        int hash = this.hash(key);

        ArrayList<Pair> chain = this.tabela[hash];
        for (int i = 0; i < chain.size(); i++) {
            if (chain.get(i).key == key) {
                chain.set(i, new Pair(key, value));
                return;
            }
        }
        
        chain.add(new Pair(key, value));
    }

    public Pair remove(int key) {
        int hash = this.hash(key);

        Pair p = null;
        Iterator<Pair> it = this.tabela[hash].iterator();

        while (it.hasNext()) {
            p = it.next();
            if (p.key == key) {
                it.remove();
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

            ArrayList<Pair> chain = this.tabela[i];
            for (int j = 0; j < chain.size(); j++) {
                keySet.add(chain.get(j).key);
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

            ArrayList<Pair> chain = this.tabela[i];
            for (int j = 0; j < chain.size(); j++) {
                valueSet.add(chain.get(j).value);
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
        return "<" + this.key + ", " + this.value + ">";
    }
}
