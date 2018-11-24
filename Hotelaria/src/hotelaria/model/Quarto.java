package hotelaria.model;

/**
 * @author Norton Wagner Martins  
 * @date 15/11/2018
 */
public class Quarto {
    private int codigo;
    private int andar;
    private String status;
    private int numQuarto;
    private String descricao;
    private Double valor;
    private int capPessoas;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getAndar() {
        return andar;
    }

    public void setAndar(int andar) {
        this.andar = andar;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getNumQuarto() {
        return numQuarto;
    }

    public void setNumQuarto(int numQuarto) {
        this.numQuarto = numQuarto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public int getCapPessoas() {
        return capPessoas;
    }

    public void setCapPessoas(int capPessoas) {
        this.capPessoas = capPessoas;
    }
    
    @Override
    public String toString() {
        return "Nº Quarto: " + numQuarto + " -  R$: " + valor;
    }
    
    
}
