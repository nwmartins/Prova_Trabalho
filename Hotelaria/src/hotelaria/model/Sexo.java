/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelaria.model;

/**
 *
 * @author Norton Wagner Martins
 */
public enum Sexo {
    MASCULINO(0), 
    FEMININO(1),
    OUTROS(2);
    
    private int sexo;
    
    Sexo(int idSexo){
        this.sexo = idSexo;
    }
    
    public int getSexo(){ return sexo; }   
    
    public void setSexo(int sexo) {
        this.sexo = sexo;
    }
    
}
