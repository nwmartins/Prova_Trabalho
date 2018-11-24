package hotelaria.model;

import java.util.Date;
import java.util.List;

/**
 * @author Norton Wagner Martins  
 * @date 15/11/2018
 */
public class Reserva {
    private int codigo;
    private Quarto quarto;
    private Funcionario funcionario;
    private String status;
    private Date dtReserva;
    private Date dtEntrada;
    private int qtdDias;
    private List<Cliente> Clilist;

    public List<Cliente> getClilist() {
        return Clilist;
    }

    public void setClilist(List<Cliente> Clilist) {
        this.Clilist = Clilist;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDtReserva() {
        return dtReserva;
    }

    public void setDtReserva(Date dtEeserva) {
        this.dtReserva = dtEeserva;
    }

    public Date getDtEntrada() {
        return dtEntrada;
    }

    public void setDtEntrada(Date dtEntrada) {
        this.dtEntrada = dtEntrada;
    }

    public int getQtdDias() {
        return qtdDias;
    }

    public void setQtdDias(int qtdDias) {
        this.qtdDias = qtdDias;
    }

    @Override
    public String toString() {
        return "Reserva{" + "codigo=" + codigo + ", quarto=" + quarto + ", funcionario=" + funcionario + ", status=" + status + ", dtEeserva=" + dtReserva + ", dtEntrada=" + dtEntrada + ", qtdDias=" + qtdDias + '}';
    }
    
    
    
}
