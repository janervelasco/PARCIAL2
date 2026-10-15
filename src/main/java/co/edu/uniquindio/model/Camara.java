package co.edu.uniquindio.model;

public class Camara extends EquipoAudiovisual {
    private String resolucionMax;
    private boolean lentesIntercambiables;

    public Camara(String codigo, String marca, String modelo, double costoDia, String resolucionMax, boolean lentesIntercambiables) {
        super(codigo, modelo, marca, costoDia);
        this.resolucionMax = resolucionMax;
        this.lentesIntercambiables = lentesIntercambiables;
    }

    public String getResolucionMax() { return resolucionMax; }
    public boolean isLentesIntercambiables() { return lentesIntercambiables; }
}