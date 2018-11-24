package hotelaria.model;

import java.util.Date;

/**
 * @author Norton Wagner Martins  
 * @date 15/11/2018
 */
public class Cliente extends PessoaFisica { 
    private Date dtCadastro;

    public Date getDtCadastro() {
        return dtCadastro;
    }

    public void setDtCadastro(Date dtCadastro) {
        this.dtCadastro = dtCadastro;
    }

    @Override
    public String toString() {
        return Cliente.super.getCodigo() + " - " + Cliente.super.getNome();
    }
    
    
}
