package co.edu.uniquindio.model;

public class Dron extends EquipoAudiovisual {
    private int autonomiaMinutos;
    private boolean bateriaAdicional;

    public Dron(String codigo, String marca, String modelo, int autonomiaMinutos, boolean bateriaAdicional) {
        super(codigo, marca, modelo, 18000.0, Condicion.DISPONIBLE); // Asigna los $18.000 de tarifa base por hora[cite: 4]
        this.autonomiaMinutos = autonomiaMinutos;
        this.bateriaAdicional = bateriaAdicional;
    }

    @Override
    public double calcularCosto(int horas) {
        double costoTotal = precioPorHora * horas;

        // Se adicionan $20.000 cuando se solicita la batería adicional[cite: 4]
        if (bateriaAdicional) {
            costoTotal += 20000.0;
        }

        return costoTotal;
    }

    public int getAutonomiaMinutos() {
        return autonomiaMinutos;
    }

    public boolean isBateriaAdicional() {
        return bateriaAdicional;
    }
}