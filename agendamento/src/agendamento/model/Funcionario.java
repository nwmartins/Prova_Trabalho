package agendamento.model;

/**
 * @author Norton Wagner Martins  
 * @date 21/11/2018
 */
public class Funcionario extends Pessoa{
    private int numMatricula;
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumMatricula() {
        return numMatricula;
    }

    public void setNumMatricula(int numMatricula) {
        this.numMatricula = numMatricula;
    }

    @Override
    public String toString() {
        return nome + " - Matricula: "  + numMatricula;
    }
    
    
    

}
