package agendamento.model;

import java.util.Date;

/**
 * @author Norton Wagner Martins  
 * @date 21/11/2018
 */
public class Motorista extends Pessoa{
    private Funcionario funcionario;
    private String numCNH;
    private Date dtVencimento;

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public String getNumCNH() {
        return numCNH;
    }

    public void setNumCNH(String numCNH) {
        this.numCNH = numCNH;
    }

    public Date getDtVencimento() {
        return dtVencimento;
    }

    public void setDtVencimento(Date dtVencimento) {
        this.dtVencimento = dtVencimento;
    }

    @Override
    public String toString() {
        return funcionario.getCodigo() + " - " + funcionario.getNome() + " CNH:" + numCNH + " - " + dtVencimento;
    }
    
    
    

}
