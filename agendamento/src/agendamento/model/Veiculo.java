package agendamento.model;

/**
 * @author Norton Wagner Martins  
 * @date 21/11/2018
 */
public class Veiculo {
    private int codigo;
    private String placa;
    private int ano;
    private int numPassageiros;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getNumPassageiros() {
        return numPassageiros;
    }

    public void setNumPassageiros(int numPassageiros) {
        this.numPassageiros = numPassageiros;
    }

    @Override
    public String toString() {
        return codigo + " - " + placa;
    }
    
    

}
