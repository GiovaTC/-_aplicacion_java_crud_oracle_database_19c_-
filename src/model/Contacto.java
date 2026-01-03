package model;

public class Contacto {

    private int id;
    private String nombre;
    private String correo;

    public Contacto() {}

    public Contacto(int id, String nombre, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
    }

    public int getId() {return id;}
    public String getNombre() {return nombre;}
    public String getCorreo() {return correo;}

    public void setId(int id) {this.id = id;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public void setCorreo(String correo) {this.correo = correo;}
}
