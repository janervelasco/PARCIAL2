package co.edu.uniquindio.model;

public class EquipoAudiovisual {
    protected String codigo;
    protected String modelo;
    protected String marca;
    protected double costoDia;

    public EquipoAudiovisual(String codigo, String modelo, String marca, double costoDia) {
        this.codigo = codigo;
        this.modelo = modelo;
        this.marca = marca;
        this.costoDia = costoDia;
    }

    public double costoDia() {
        return costoDia;
    }

    public String getCodigo() { return codigo; }
    public String getModelo() { return modelo; }
    public String getMarca() { return marca; }
}
