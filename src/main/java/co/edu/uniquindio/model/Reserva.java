package co.edu.uniquindio.model;

import java.time.LocalDate;

public class Reserva {
    private String codigoUnico;
    private Cliente cliente;
    private LocalDate fecha;
    private Turno turno;
    private EstadoReserva estado;
    private Operador operador;

    // Arreglos paralelos de tamaño 10 para los equipos y sus respectivas horas de uso
    private EquipoAudiovisual[] listEquipos;
    private int[] listHoras;

    public Reserva(String codigoUnico, Cliente cliente, LocalDate fecha, Turno turno) {
        this.codigoUnico = codigoUnico;
        this.cliente = cliente;
        this.fecha = fecha;
        this.turno = turno;
        this.estado = EstadoReserva.SOLICITADO; // Toda nueva reserva inicia como solicitada
        this.listEquipos = new EquipoAudiovisual[10];
        this.listHoras = new int[10];
    }

    public boolean agregarEquipoReserva(EquipoAudiovisual equipoAudiovisual, int cantidadHoras) {
        // Verificar que el equipo esté disponible
        if (equipoAudiovisual.getCondicion() != Condicion.DISPONIBLE) {
            return false;
        }

        // Verificar que el equipo no esté repetido en la reserva
        for (int i = 0; i < listEquipos.length; i++) {
            if (listEquipos[i] != null && listEquipos[i].getCodigo().equals(equipoAudiovisual.getCodigo())) {
                return false;
            }
        }

        // Buscar espacio libre y guardarlo de forma paralela usando la misma posición i
        for (int i = 0; i < listEquipos.length; i++) {
            if (listEquipos[i] == null) {
                listEquipos[i] = equipoAudiovisual;
                listHoras[i] = cantidadHoras;
                return true;
            }
        }
        return false;
    }

    // Cálculo del costo total utilizando los arreglos paralelos y polimorfismo por horas
    public double calcularCostoTotal() {
        double costoTotalAcumulado = 0.0;
        for (int i = 0; i < listEquipos.length; i++) {
            if (listEquipos[i] != null) {
                costoTotalAcumulado += listEquipos[i].calcularCosto(listHoras[i]);
            }
        }
        return costoTotalAcumulado;
    }

    // Getters y Setters
    public String getCodigoUnico() { return codigoUnico; }
    public void setCodigoUnico(String codigoUnico) { this.codigoUnico = codigoUnico; }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public Turno getTurno() { return turno; }
    public void setTurno(Turno turno) { this.turno = turno; }

    public EstadoReserva getEstado() { return estado; }
    public void setEstado(EstadoReserva estado) { this.estado = estado; }

    public Operador getOperador() { return operador; }
    public void setOperador(Operador operador) { this.operador = operador; }

    public EquipoAudiovisual[] getListEquipos() { return listEquipos; }
    public int[] getListHoras() { return listHoras; }
}