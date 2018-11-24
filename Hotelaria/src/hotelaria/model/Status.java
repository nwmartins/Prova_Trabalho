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
public enum Status {
    VAGO(1), 
    OCUPADO(2),
    ABERTO(3),
    FECHADA(4);
    
    private final int status;
    
    Status(int valorStatus){
        this.status = valorStatus;
    }
    
    public int getStatus(){ return status; }    
}
