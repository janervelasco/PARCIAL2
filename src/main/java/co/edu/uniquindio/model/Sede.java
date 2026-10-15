package co.edu.uniquindio.model;

import java.util.ArrayList;
import java.util.List;

public class Sede {
    private String nombre;
    private String direccion;
    private String ciudad;

    // Listas asociadas a la sede usando estructura tradicional con índice i
    private List<Camara> camarasSede = new ArrayList<>();
    private List<Dron> dronesSede = new ArrayList<>();
    private List<KitIluminacion> kitsSede = new ArrayList<>();

    public Sede(String nombre, String direccion, String ciudad) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.ciudad = ciudad;
    }

    public String getNombre() { return nombre; }
    public String getDireccion() { return direccion; }
    public String getCiudad() { return ciudad; }

    public List<Camara> getCamarasSede() { return camarasSede; }
    public List<Dron> getDronesSede() { return dronesSede; }
    public List<KitIluminacion> getKitsSede() { return kitsSede; }
}