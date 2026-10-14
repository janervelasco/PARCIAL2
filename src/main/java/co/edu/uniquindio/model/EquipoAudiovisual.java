package co.edu.uniquindio.model;

public class EquipoAudiovisual {
    private String codigo;
    private  String nombre;
    private Condicion condicion;

    public EquipoAudiovisual(String codigo, String nombre,Condicion condicion){
        this.codigo = codigo;
        this.nombre = nombre;
        this.condicion = condicion;
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
}
