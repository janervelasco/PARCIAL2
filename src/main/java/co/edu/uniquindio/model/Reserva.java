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
    private Turno turno;
    private List<EquipoAudiovisual> listEquipoAudiovisual;
    private List<Integer> listHoras;

    public Reserva(String codigoUnico, LocalDate fecha, Cliente cliente, Operador operador
            , EstadoReserva estadoReserva, Turno turno) {
        this.codigoUnico = codigoUnico;
        this.fecha = fecha;
        this.cliente = cliente;
        this.operador = operador;
        this.estadoReserva = EstadoReserva.SOLICITADO;
        this.listEquipoAudiovisual = new ArrayList<>();
        this.listHoras = new ArrayList<>();

    }

    public boolean agregarEquipo(EquipoAudiovisual equipoAudiovisual, int horas) {
        for (EquipoAudiovisual equipoActual : listEquipoAudiovisual) {
            if (equipoActual.getCodigo().equals(equipoAudiovisual.getCodigo())) {
                return false;
            }
        }
        if (equipoAudiovisual.getCondicion() != Condicion.DISPONIBLE) {

            return false;
        }
        listEquipoAudiovisual.add(equipoAudiovisual);
        listHoras.add(horas);
        return true;
    }

    public double calcularReserva() {
double total = 0.0;
int i = 0;
        for (EquipoAudiovisual equipoAudiovisual : listEquipoAudiovisual) {
             int horas = listHoras.get(i);
             total += equipoAudiovisual.calcularCosto(horas);
             i++;

        }
return total;
    }
    public void asignarOperador(Operador operador){
        this.operador = operador;
    }

    public String getCodigoUnico() {
        return codigoUnico;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Operador getOperador() {
        return operador;
    }

    public EstadoReserva getEstadoReserva() {
        return estadoReserva;
    }

    public Turno getTurno() {
        return turno;
    }

    public List<EquipoAudiovisual> getListEquipoAudiovisual() {
        return listEquipoAudiovisual;
    }

    public List<Integer> getListHoras() {
        return listHoras;
    }
}