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
public class TabelaHash {

    private ArrayList<String>[] tabela;
    private final int CAPACIDADE_DEFAULT = 20;

    /**
     * Cria uma nova tabela com a capacidade default 20.
     */
    public TabelaHash() {
        this.tabela = new ArrayList[CAPACIDADE_DEFAULT];
    }
    
    /**
     * Cria uma nova tabela com a capacidade passada como parâmetro.
     * @param capacidade O número de posições da tabela.
     */
    public TabelaHash(int capacidade) {
        this.tabela = new ArrayList[capacidade];
    }
    
    public int hash(Integer chave) {
        return (int) (((chave * 0.635791423) % 1) * this.tabela.length);
    }
    
    /**
     * Adiciona o par chave, valor na tabela.
     * @param chave a matrícula do aluno a ser adicionado.
     * @param valor o objeto Aluno a ser adicionado na tabela.
     */
    public void put(int chave, String valor) {
        int hash = this.hash(chave);

        if (this.tabela[hash] == null) {
            this.tabela[hash] = new ArrayList<String>();
            this.tabela[hash].add(valor);

            return;
        }

        ArrayList<String> chain = this.tabela[hash];
        for (int i = 0; i < chain.size(); i++) {
            String v = chain.get(i);
            if (v.hashCode() == chave) {
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
    public String get(int chave) {
        ArrayList<String> chain = this.tabela[this.hash(chave)];
        if (chain == null) {
            return null;
        }

        String value = null;
        Iterator<String> it = chain.listIterator();

        while (it.hasNext()) {
            value = it.next();

            if (value.hashCode() == chave) {
                return value;
            }
        }

        return null;
    }

     public boolean containsKey(Integer chave) {
        int hash = this.hash(chave);
        if (this.tabela[hash] == null) 
            return false;

        ArrayList<String> chain = this.tabela[this.hash(chave)];

        String value = null;
        Iterator<String> it = chain.iterator();
        while (it.hasNext()) {
            value = it.next();

            if (value.hashCode() == chave) {
                return true;
            }
        }
        
        return false;
    }

    public boolean containsValue(String valor) {
        int hash = this.hash(valor.hashCode());
        if (this.tabela[hash] == null) {
            return false;
        }

        return this.tabela[hash].contains(valor);
    }

    /**
     * Remove o aluno cuja matrícula é igual a chave passada como parâmetro.
     * @param chave A matrícula do aluno a ser removido.
     * @return O aluno a ser removido. null caso não haja aluno com a matrícula
     * passada como parâmetro. 
     */
    public String remove(int chave) {
        ArrayList<String> chain = this.tabela[this.hash(chave)];

        String value = null;
        Iterator<String> it = chain.iterator();

        while (it.hasNext()) {
            value = it.next();

            if (value.hashCode() == chave) {
                it.remove();
                return value;
            }
        }

        return null;
    }

}
