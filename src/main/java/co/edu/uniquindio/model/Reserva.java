package co.edu.uniquindio.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;






public class Reserva {
    private String codigoUnico;
    private Cliente cliente;
    private LocalDate fecha;
    private Turno turno;
    private EstadoReserva estado;
    private Operador operador;

    // Arreglos paralelos de tamaño 10 para los equipos y sus respectivas horas
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

    public boolean agregarEquipoReserva(EquipoAudiovisual equipo, int horas) {
        // Verificar que el equipo esté disponible
        if (equipo.getCondicion() != Condicion.DISPONIBLE) {
            return false;
        }

        // Verificar que no esté repetido en la reserva
        for (int i = 0; i < listEquipos.length; i++) {
            if (listEquipos[i] != null && listEquipos[i].getCodigo().equals(equipo.getCodigo())) {
                return false;
            }
        }

        // Buscar espacio libre y guardarlo de forma paralela usando la misma posición i
        for (int i = 0; i < listEquipos.length; i++) {
            if (listEquipos[i] == null) {
                listEquipos[i] = equipo;
                listHoras[i] = horas;
                return true;
            }
        }
        return false;
    }

    // Cálculo del costo total utilizando los arreglos paralelos y polimorfismo por horas
    public double calcularCostoTotal() {
        double total = 0.0;
        for (int i = 0; i < listEquipos.length; i++) {
            if (listEquipos[i] != null) {
                total += listEquipos[i].calcularCosto(listHoras[i]);
            }
        }
        return total;
    }

    // Getters y Setters
    public String getCodigoUnico() { return codigoUnico; }
    public Cliente getCliente() { return cliente; }
    public LocalDate getFecha() { return fecha; }
    public Turno getTurno() { return turno; }
    public EstadoReserva getEstado() { return estado; }
    public void setEstado(EstadoReserva estado) { this.estado = estado; }
    public Operador getOperador() { return operador; }
    public void setOperador(Operador operador) { this.operador = operador; }
    public EquipoAudiovisual[] getListEquipos() { return listEquipos; }
    public int[] getListHoras() { return listHoras; }
}