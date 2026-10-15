package co.edu.uniquindio.model;

public class KitIluminacion extends EquipoAudiovisual {
    private int numeroLuces;
    private double potenciaTotalWatts;

    public KitIluminacion(String codigo, String marca, String modelo, double costoDia, int numeroLuces, double potenciaTotalWatts) {
        super(codigo, modelo, marca, costoDia);
        this.numeroLuces = numeroLuces;
        this.potenciaTotalWatts = potenciaTotalWatts;
    }

    public int getNumeroLuces() { return numeroLuces; }
    public double getPotenciaTotalWatts() { return potenciaTotalWatts; }
}