package co.edu.uniquindio.model;

public class Camara extends EquipoAudiovisual {
    private String resolucionMax;
    private boolean incluyeLentes;

    public Camara(String codigo, String marca, String modelo, double costoDia, String resolucionMax, boolean incluyeLentes) {
        super(codigo, marca, modelo, 12000.0, Condicion.DISPONIBLE);
        this.resolucionMax = resolucionMax;
        this.incluyeLentes = incluyeLentes;
    }

    @Override
    public double calcularCosto(int horas) {
        double costoTotal = precioPorHora * horas;

        // Si incluye lentes (o estabilizador), se adicionan $15.000 al valor resultante[cite: 4]
        if (incluyeLentes) {
            costoTotal += 15000.0;
        }

        return costoTotal;
    }

    public String getResolucionMax() { return resolucionMax; }
    public boolean isIncluyeLentes() { return incluyeLentes; }
}