package co.edu.uniquindio.model;

public abstract class EquipoAudiovisual {
    protected String codigo;
    protected String marca;
    protected String modelo;
    protected double costoDia; // Tarifa base o de referencia
    protected Condicion condicion; // Enum: DISPONIBLE, EN_MANTENIMIENTO, FUERA_DE_SERVICIO

    public EquipoAudiovisual(String codigo, String marca, String modelo, double costoDia, Condicion condicion) {
        this.codigo = codigo;
        this.marca = marca;
        this.modelo = modelo;
        this.costoDia = costoDia;
        this.condicion = condicion;
    }

    // Método abstracto que obliga a Camara, Dron y KitIluminacion a calcular su costo por hora
    public abstract double calcularCosto(int horas);

    // Getters comunes
    public String getCodigo() {
        return codigo;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public double getCostoDia() {
        return costoDia;
    }

    public Condicion getCondicion() {
        return condicion;
    }

    public void setCondicion(Condicion condicion) {
        this.condicion = condicion;
    }
}
