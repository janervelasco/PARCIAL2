package co.edu.uniquindio.model;

public class KitIluminacion extends EquipoAudiovisual {
    private int cantidadLuces;
    private double potenciaTotal;

    public KitIluminacion(String codigo, String marca, String modelo, double costoDia, int cantidadLuces, double potenciaTotal) {
        super(codigo, marca, modelo, costoDia, Condicion.DISPONIBLE);
        this.cantidadLuces = cantidadLuces;
        this.potenciaTotal = potenciaTotal;
    }

    @Override
    public double calcularCosto(int horas) {
        return (costoDia / 8) * horas;
    }

    public int getCantidadLuces() { return cantidadLuces; }
    public double getPotenciaTotal() { return potenciaTotal; }
}