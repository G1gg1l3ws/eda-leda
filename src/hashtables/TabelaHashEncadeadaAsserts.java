package hashtables;

public class TabelaHashEncadeadaAsserts {
    
    public static void main(String[] args) {
        TabelaHashEncadeadaAsserts tests = new TabelaHashEncadeadaAsserts();
        tests.testPut();
        tests.testRemove();
        tests.testHashMultiplicacao();
    }

    // TODO: Implementar testes!
    public void testPut() {
        TabelaHashEncadeada hashTable = new TabelaHashEncadeada();

        assert hashTable.get(654065) == null;

        hashTable.put(202500, new Aluno(202500, "Guilherme"));
        assert hashTable.get(20) == null : "alguma coisa com matricula 20 foi adicionada";
        assert hashTable.get(202500).equals(new Aluno(202500, "Guilherme")): "o aluno adicionado esta com a matricula errada";
        assert hashTable.get(202500).getNome().equals("Guilherme") : "o nome do aluno esta errado";

        hashTable.put(23, new Aluno(23, "Joao Arthur"));
        assert hashTable.get(23).getMatricula() == 23 : "does not contian key 23";
        assert hashTable.get(1023) == null : "contains key 1023";
        assert hashTable.get(23).getNome().equals("Joao Arthur") : "value.name of 23 is not Joao Arthur";

        hashTable.put(202500, new Aluno(202500, "Outro cara"));
        assert hashTable.get(202500).getMatricula() == 202500 : "value.key is not 202500";
        assert hashTable.get(202500).getNome().equals("Outro cara") : "value.name was not changed";
        assert hashTable.get(0) == null : "exists value at key 0";

        hashTable.put(43, new Aluno(43, "Joao Arthur"));
        assert hashTable.get(43).getMatricula() == 43;
        assert hashTable.get(1043) == null;
        assert hashTable.get(43).getNome().equals("Joao Arthur");
    }

    public void testRemove() {
        TabelaHashEncadeada hashTable = new TabelaHashEncadeada();
        
        assert hashTable.get(24) == null;

        hashTable.put(1, new Aluno(1, "Jeff"));
        hashTable.put(21, new Aluno(21, "Joff"));
        hashTable.put(31, new Aluno(31, "Jaff"));

        assert hashTable.containsKey(1);
        assert hashTable.containsKey(31);
        assert hashTable.containsValue(new Aluno(1, ""));
        assert hashTable.containsValue(new Aluno(31, ""));

        hashTable.remove(31);

        assert !hashTable.containsKey(31);
        assert !hashTable.containsValue(new Aluno(31, ""));
        assert hashTable.containsKey(1);
        assert hashTable.containsValue(new Aluno(1, ""));

        hashTable.remove(1);
        assert hashTable.containsKey(21);
        assert !hashTable.containsKey(1);
        assert hashTable.containsValue(new Aluno(21, ""));
        assert !hashTable.containsValue(new Aluno(1, ""));
    }

    public void testHashMultiplicacao() {
        TabelaHashEncadeada hashTable = new TabelaHashEncadeada();
        assert hashTable.hashMult(31) == 14;
        assert hashTable.hashMult(20) == 14;

        assert hashTable.hashMult(0) == 0;
    }

}
