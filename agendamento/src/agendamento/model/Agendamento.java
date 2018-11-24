package agendamento.model;

import java.util.Date;

/**
 * @author Norton Wagner Martins  
 * @date 21/11/2018
 */
public class Agendamento {
    private int codigo;
    private Veiculo veiculo;
    private String origem;
    private String destino;
    private Motorista motorista;
    //private Funcionario funcionario;
    private Date dtSaida;
    private Date dtRetorno;
    private int numPassageiros;
    private String obs;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }

    public Date getDtSaida() {
        return dtSaida;
    }

    public void setDtSaida(Date dtSaida) {
        this.dtSaida = dtSaida;
    }

    public Date getDtRetorno() {
        return dtRetorno;
    }

    public void setDtRetorno(Date dtRetorno) {
        this.dtRetorno = dtRetorno;
    }

    public int getNumPassageiros() {
        return numPassageiros;
    }

    public void setNumPassageiros(int numPassageiros) {
        this.numPassageiros = numPassageiros;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    @Override
    public String toString() {
        return codigo + " veiculo:" + veiculo +" origem=" + origem + " destino=" + destino + " motorista=" + motorista + " dtSaida=" + dtSaida + ", dtRetorno=" + dtRetorno + ", numPassageiros=" + numPassageiros;
    }
    
    
    
    

}
