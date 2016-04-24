package mx.edu.utng.avance.model;

/**
 * Created by Pérez Godínez Jessica Magali on 03/02/2016.
 */

//Clase publica
public class Examen {

    //Declaración de variables
    private int idExamen;
    private String descripcion;
    //Constructor
    public Examen(int idExamen, String descripcion) {
        this.idExamen = idExamen;
        this.descripcion = descripcion;
    }

    public Examen() {
        this(0,"");
    }
    //Métodos getters and setters

    public int getIdExamen() {
        return idExamen;
    }

    public void setIdExamen(int idExamen) {
        this.idExamen = idExamen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    //toString

    @Override
    public String toString() {
        return "Examen{" +
                "idExamen=" + idExamen +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }//Cierre de toString

}//Cierre de la clase
