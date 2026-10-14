package co.edu.uniquindio.model;

public class Dron extends EquipoAudiovisual {
    private int autonomiaVueloMinutos;
    private boolean tieneBateriaAdicioal;
    public Dron(String codigo, String modelo, String marca, Condicion condicion,
    int autonomiaVueloMinutos, boolean tieneBateriaAdicioal){
        super(codigo, modelo, marca, condicion);
        this.autonomiaVueloMinutos = autonomiaVueloMinutos;
        this.tieneBateriaAdicioal = tieneBateriaAdicioal;
    }
    @Override
    public  double calcularCosto(int horas){
        double costo = 18000 * horas;
        if(tieneBateriaAdicioal){
            costo+= 20000;
        }
                 return costo;
    }

    public int getAutonomiaVueloMinutos() {
        return autonomiaVueloMinutos;
    }

    public boolean isTieneBateriaAdicioal() {
        return tieneBateriaAdicioal;
    }
}
