package co.edu.uniquindio.model;


public class Dron extends EquipoAudiovisual {
    private int autonomiaVueloMinutos;
    private boolean tieneBateriaAdicional;

    public Dron(String codigo, String marca, String modelo, double costoDia, int autonomiaVueloMinutos, boolean tieneBateriaAdicional) {
        super(codigo, marca, modelo, costoDia, Condicion.DISPONIBLE);
        this.autonomiaVueloMinutos = autonomiaVueloMinutos;
        this.tieneBateriaAdicional = tieneBateriaAdicional;
    }

    @Override
    public double calcularCosto(int horas) {
        return (costoDia / 8) * horas;
    }

    public int getAutonomiaVueloMinutos() { return autonomiaVueloMinutos; }
    public boolean isTieneBateriaAdicional() { return tieneBateriaAdicional; }
}