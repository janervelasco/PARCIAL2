package co.edu.uniquindio.model;

public abstract class EquipoAudiovisual {
    protected String codigo;
    protected String marca;
    protected String modelo;
    protected double precioPorHora;
    protected Condicion condicion;

    public EquipoAudiovisual(String codigo, String marca, String modelo, double precioPorHora, Condicion condicion) {
        this.codigo = codigo;
        this.marca = marca;
        this.modelo = modelo;
        this.precioPorHora = precioPorHora;
        this.condicion = condicion;
    }

    public abstract double calcularCosto(int horas);

    // Getters y Setters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPrecioPorHora() {
        return precioPorHora;
    }

    public void setPrecioPorHora(double precioPorHora) {
        this.precioPorHora = precioPorHora;
    }

    public Condicion getCondicion() {
        return condicion;
    }

    public void setCondicion(Condicion condicion) {
        this.condicion = condicion;
    }
}