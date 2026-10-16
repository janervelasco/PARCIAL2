package co.edu.uniquindio.model;

public class KitIluminacion extends EquipoAudiovisual {
    private int cantidadLuces;
    private boolean controlInalambrico;

    public KitIluminacion(String codigo, String marca, String modelo, int cantidadLuces, boolean controlInalambrico) {
        super(codigo, marca, modelo, 10000.0, Condicion.DISPONIBLE); // Asigna los $10.000 de tarifa base por hora[cite: 4]
        this.cantidadLuces = cantidadLuces;
        this.controlInalambrico = controlInalambrico;
    }

    @Override
    public double calcularCosto(int horas) {
        double costoTotal = precioPorHora * horas;

        // Un incremento de $12.000 cuando disponen de dicho control[cite: 4]
        if (controlInalambrico) {
            costoTotal += 12000.0;
        }

        return costoTotal;
    }

    public int getCantidadLuces() {
        return cantidadLuces;
    }

    public boolean isControlInalambrico() {
        return controlInalambrico;
    }
}