package co.edu.uniquindio.model;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
public class Reserva {
    private String codigoUnico;
    private LocalDate fecha;
    private Cliente cliente;
    private Operador operador;
    private EstadoReserva estadoReserva;
    private List<EquipoAudiovisual> listEquipoAudiovisual;

    public Reserva(String codigoUnico, LocalDate fecha, Cliente cliente, Operador operador
    ,EstadoReserva estadoReserva) {
        this.codigoUnico = codigoUnico;
        this.fecha = fecha;
        this.cliente = cliente;
        this.operador = operador;
        this.estadoReserva = estadoReserva;
        this.listEquipoAudiovisual = new ArrayList<>();

    }
    public void agregarEquipo(EquipoAudiovisual equipoAudiovisual) {
        this.listEquipoAudiovisual.add(equipoAudiovisual);
    }
     public void asignarOperador(Operador operador){
        this.operador = operador;
    }
    public double calcularReserva() {

        for(EquipoAudiovisual equipoAudiovisual : listEquipoAudiovisual){

        }
    }



}






