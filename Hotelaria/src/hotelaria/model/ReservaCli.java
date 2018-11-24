package hotelaria.model;

import java.util.List;

/**
 * @author Norton Wagner Martins  
 * @date 15/11/2018
 */
public class ReservaCli {
    private int codigo;
    private Reserva reserva;
    private Cliente cliente;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reservava) {
        this.reserva = reservava;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    @Override
    public String toString() {
        return "ReservaCli{" + "reserva=" + reserva;
    }
    
    

}
