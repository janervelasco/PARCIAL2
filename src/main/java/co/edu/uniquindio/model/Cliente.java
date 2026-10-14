package co.edu.uniquindio.model;

public class Cliente {
    private String nombre;
    private String telefono;
    private String correo;
    private String id;

    public Cliente(String nombre, String telefono, String correo, String id) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public String getId() {
        return id;
    }
}
