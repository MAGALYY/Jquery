package mx.edu.utng.avance.model;

/**
 * Created by Pérez Godínez Jessica Magali on 03/02/2016.
 */

//Clase publica
public class EstadoExamen {

    //Declaración de variables
    private int idUsuario;
    private int idExamen;
    private boolean estado;

    //Constructor
    public EstadoExamen(int idUsuario, int idExamen, boolean estado) {
        this.idUsuario = idUsuario;
        this.idExamen = idExamen;
        this.estado = estado;
    }


    public EstadoExamen() {
        this(0,0,false);
    }


    //Métodos getters and setters

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdExamen() {
        return idExamen;
    }

    public void setIdExamen(int idExamen) {
        this.idExamen = idExamen;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    //toString

    @Override
    public String toString() {
        return "EstadoExamen{" +
                "idUsuario=" + idUsuario +
                ", idExamen=" + idExamen +
                ", estado=" + estado +
                '}';
    }//Cierre de toString

}//Cierre de la clase
