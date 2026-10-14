package co.edu.uniquindio.model;

public class EquipoAudiovisual {
    private String codigo;
    private String modelo;
    private  String nombre;
    private Condicion condicion;

    public EquipoAudiovisual(String codigo, String modelo, String nombre,Condicion condicion){
        this.codigo = codigo;
        this.nombre = nombre;
        this.condicion = condicion;
    }
    public double calcularCosto(int horas){
        return 0.0;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public Condicion getCondicion() {
        return condicion;
    }

    public String getModelo() {
        return modelo;
    }
}
