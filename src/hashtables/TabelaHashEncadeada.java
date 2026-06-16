package hashtables;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Esta classe representa a implementação de uma Tabela Hash que usa endereçamento fechado (encadeamento)
 * para resolver colisões.
 * 
 * A implementação abaixo apenas lida com objetos do tipo aluno. Essa foi uma decisão para fins didáticos. 
 * Naturalmente, por ser uma estrutura de propósito geral, uma tabela hash deve ser capaz de manipular objetos
 * de qualquer tipo.
 *
 * Esta é uma versão simplificada para fins didáticos. Não lidamos com resize e rehash aqui. Isso é assunto de um exercício específico.
 *  
 * @author João Arthur
 * @see <a href="http://joaoarthurbm.github.io/eda">http://joaoarthurbm.github.io/eda</a>
 * Computação @ UFCG
 */
public class TabelaHashEncadeada {

    private ArrayList<Aluno>[] tabela;
    private final int CAPACIDADE_DEFAULT = 20;

    /**
     * Cria uma nova tabela com a capacidade default 20.
     */
    public TabelaHashEncadeada() {
        this.tabela = new ArrayList[CAPACIDADE_DEFAULT];
    }
    
    /**
     * Cria uma nova tabela com a capacidade passada como parâmetro.
     * @param capacidade O número de posições da tabela.
     */
    public TabelaHashEncadeada(int capacidade) {
        this.tabela = new ArrayList[capacidade];
    }
    
    /**
     * Calcula o hash de uma determinada chave. A função de hash é simples
     * e usa o método da divisão.
     * @param chave A chave para a qual se deseja calcular o hash.
     * @return O hash calculado tendo como base a chave e o tamanho da tabela.
     */
    private int hash(Integer chave) {
        return chave % this.tabela.length;
    }

    public int hashMult(Integer chave) {
        return (int) (((chave * 0.635791423) % 1) * this.tabela.length);
    }
    
    /**
     * Adiciona o par chave, valor na tabela.
     * @param chave a matrícula do aluno a ser adicionado.
     * @param valor o objeto Aluno a ser adicionado na tabela.
     */
    public void put(Integer chave, Aluno valor) {
        int hash = this.hash(chave);

        if (this.tabela[hash] == null) {
            this.tabela[hash] = new ArrayList<Aluno>();
            this.tabela[hash].add(valor);

            return;
        }

        ArrayList<Aluno> chain = this.tabela[hash];
        for (int i = 0; i < chain.size(); i++) {
            Aluno a = chain.get(i);
            if (a.getMatricula().equals(chave)) {
                chain.set(i, valor);
                return;
            }
        }

        chain.add(valor);
    }

    /**
     * Recupera o aluno cuja chave é igual a passada como parâmetro.
     * @param chave a matrícula do aluno.
     * @return o aluno com a matrícula passada como parâmetro. null caso
     * nenhum aluno presente na tabela tenha a matrícula igual a passada como
     * parâmetro.
     */
    public Aluno get(Integer chave) {
        ArrayList<Aluno> chain = this.tabela[this.hash(chave)];
        if (chain == null) {
            return null;
        }

        Aluno value = null;
        Iterator<Aluno> it = chain.listIterator();

        while (it.hasNext()) {
            value = it.next();

            if (value.getMatricula().equals(chave)) {
                return value;
            }
        }

        return null;
    }

     public boolean containsKey(Integer chave) {
        int hash = this.hash(chave);
        if (this.tabela[hash] == null) 
            return false;

        ArrayList<Aluno> chain = this.tabela[this.hash(chave)];

        Aluno value = null;
        Iterator<Aluno> it = chain.iterator();
        while (it.hasNext()) {
            value = it.next();

            if (value.getMatricula().equals(chave)) {
                return true;
            }
        }
        
        return false;
    }

    public boolean containsValue(Aluno aluno) {
        return this.tabela[this.hash(aluno.getMatricula())].contains(aluno);
    }

    /**
     * Remove o aluno cuja matrícula é igual a chave passada como parâmetro.
     * @param chave A matrícula do aluno a ser removido.
     * @return O aluno a ser removido. null caso não haja aluno com a matrícula
     * passada como parâmetro. 
     */
    public Aluno remove(int chave) {
        ArrayList<Aluno> chain = this.tabela[this.hash(chave)];

        Aluno value = null;
        Iterator<Aluno> it = chain.iterator();

        while (it.hasNext()) {
            value = it.next();

            if (value.getMatricula().equals(chave)) {
                it.remove();
                return value;
            }
        }

        return null;
    }

}

class Aluno {

    private Integer matricula;
    private String nome;
    
    public Aluno(Integer matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
    }
    
    public Integer getMatricula() {
        return matricula;
    }
    
    public String getNome() {
        return nome;
    }
    
    @Override
    public int hashCode() {
        return this.matricula;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Aluno))
            return false;
        
        Aluno test = (Aluno) obj;
        return test.getMatricula().equals(this.matricula);
    }
    
    public String toString() {
        return nome;
    }

}
