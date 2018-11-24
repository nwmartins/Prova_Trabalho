package hotelaria.model;

import java.util.Date;

/**
 * @author Norton Wagner Martins  
 * @date 15/11/2018
 */
public class Funcionario extends PessoaFisica{
    private Date dtContratacao;
    private Double salario;

    public Date getDtContratacao() {
        return dtContratacao;
    }

    public void setDtContratacao(Date dtContratacao) {
        this.dtContratacao = dtContratacao;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return Funcionario.super.getCodigo() + " - " + Funcionario.super.getNome();
    }
    
    

}
