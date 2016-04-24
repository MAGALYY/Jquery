package mx.edu.utng.avance.model;

/**
 * Created by Pérez Godínez Jessica Magali on 03/02/2016.
 */

//Clase publica
public class Usuario {

    //Declaración de variables privadas
    private int idUsuario;
    private String nombre;
    private String apellidop;
    private String apellidom;
    private String usuario;
    private String password;
    private String correo;

    //Constructor
    public Usuario(int idUsuario, String nombre, String apellidop, String apellidom, String usuario, String password, String correo) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellidop = apellidop;
        this.apellidom = apellidom;
        this.usuario = usuario;
        this.password = password;
        this.correo = correo;
    }

    public Usuario() {
        this(0, "","","","","","");
    }

    //Métodos getters and setters

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getApellidop() {
        return apellidop;
    }

    public void setApellidop(String apellidop) {
        this.apellidop = apellidop;
    }

    public String getApellidom() {
        return apellidom;
    }

    public void setApellidom(String apellidom) {
        this.apellidom = apellidom;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    //Método toString

    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario=" + idUsuario +
                ", nombre='" + nombre + '\'' +
                ", apellidop='" + apellidop + '\'' +
                ", apellidom='" + apellidom + '\'' +
                ", usuario='" + usuario + '\'' +
                ", password='" + password + '\'' +
                ", correo='" + correo + '\'' +
                '}';
    }//Cierre de toString

}//Cierre de la clase

