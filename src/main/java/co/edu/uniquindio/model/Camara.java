package co.edu.uniquindio.model;

public class Camara extends EquipoAudiovisual {
    private String resolucionMax;
    private boolean incluyeLentes;

    public Camara(String codigo, String marca, String modelo, double costoDia, String resolucionMax, boolean incluyeLentes) {
        super(codigo, marca, modelo, costoDia, Condicion.DISPONIBLE);
        this.resolucionMax = resolucionMax;
        this.incluyeLentes = incluyeLentes;
    }

    @Override
    public double calcularCosto(int horas) {
        return (costoDia / 8) * horas;
    }

    public String getResolucionMax() { return resolucionMax; }
    public boolean isIncluyeLentes() { return incluyeLentes; }
}