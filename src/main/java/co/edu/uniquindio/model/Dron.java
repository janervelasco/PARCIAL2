package co.edu.uniquindio.model;

public class Dron extends EquipoAudiovisual {
    private int autonomiaVueloMinutos;
    private boolean tieneBateriaAdicional;

    public Dron(String codigo, String marca, String modelo, double costoDia, int autonomiaVueloMinutos, boolean tieneBateriaAdicional) {
        super(codigo, modelo, marca, costoDia);
        this.autonomiaVueloMinutos = autonomiaVueloMinutos;
        this.tieneBateriaAdicional = tieneBateriaAdicional;
    }

    public int getAutonomiaVueloMinutos() { return autonomiaVueloMinutos; }
    public boolean isTieneBateriaAdicional() { return tieneBateriaAdicional; }
}