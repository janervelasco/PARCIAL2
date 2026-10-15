package co.edu.uniquindio.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Reserva {
    private String codigoUnico;
    private LocalDate fecha;
    private Cliente cliente;
    private Operador operador;
    private EstadoReserva estado;
    private Turno turno;

    private List<Camara> listaCamaras = new ArrayList<>();
    private List<Dron> listaDrones = new ArrayList<>();
    private List<KitIluminacion> listaKits = new ArrayList<>();

    public Reserva(String codigoUnico, LocalDate fecha, Cliente cliente, Operador operador, EstadoReserva estado, Turno turno) {
        this.codigoUnico = codigoUnico;
        this.fecha = fecha;
        this.cliente = cliente;
        this.operador = operador;
        this.estado = estado;
        this.turno = turno;
    }

    // Método de cálculo de costo total estrictamente con ciclos tradicionales de índice i
    public double calcularCostoTotal(int numeroDias) {
        double subtotal = 0.0;

        for (int i = 0; i < listaCamaras.size(); i++) {
            subtotal += listaCamaras.get(i).costoDia();
        }

        for (int i = 0; i < listaDrones.size(); i++) {
            subtotal += listaDrones.get(i).costoDia();
        }

        for (int i = 0; i < listaKits.size(); i++) {
            subtotal += listaKits.get(i).costoDia();
        }

        return subtotal * numeroDias;
    }

    // Getters y Setters
    public String getCodigoUnico() { return codigoUnico; }
    public LocalDate getFecha() { return fecha; }
    public Cliente getCliente() { return cliente; }
    public Operador getOperador() { return operador; }
    public void setOperador(Operador operador) { this.operador = operador; }
    public EstadoReserva getEstado() { return estado; }
    public void setEstado(EstadoReserva estado) { this.estado = estado; }
    public Turno getTurno() { return turno; }

    public List<Camara> getListaCamaras() { return listaCamaras; }
    public List<Dron> getListaDrones() { return listaDrones; }
    public List<KitIluminacion> getListaKits() { return listaKits; }
}