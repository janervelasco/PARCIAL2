package co.edu.uniquindio.model;

public class KitIluminacion extends  EquipoAudiovisual{
    private int cantidadLuces;
    private boolean tieneControlInalambrico;

    public KitIluminacion(String codigo, String modelo, String marca, Condicion condicion,
                          int cantidadLuces, boolean tieneControlInalambrico){
        super(codigo, modelo , marca, condicion);
        this.cantidadLuces = cantidadLuces;
        this.tieneControlInalambrico = tieneControlInalambrico;
    }
    @Override
    public double calcularCosto(int horas){
        double costo = 10000 * horas;
        if(tieneControlInalambrico){
            costo+= 12000;
        }
        return costo;
    }

    public int getCantidadLuces() {
        return cantidadLuces;
    }

    public boolean isTieneControlInalambrico() {
        return tieneControlInalambrico;
    }
}
