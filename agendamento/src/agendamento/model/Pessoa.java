package agendamento.model;

/**
 * @author Norton Wagner Martins  
 * @date 21/11/2018
 */
public abstract class Pessoa {
    private int codigo;
    //private String nome;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return String.valueOf(codigo) ;
    }
    
    

}
