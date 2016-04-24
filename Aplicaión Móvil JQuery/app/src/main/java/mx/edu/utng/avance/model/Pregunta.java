package mx.edu.utng.avance.model;

/**
 * Created by Pérez Godínez Jessica Magali on 03/02/2016.
 */

//Clase publica

public class Pregunta {

    //Declaración de variables
    private int idPregunta;
    private String descripcion;
    private int idExamen;

    //Constructor
    public Pregunta(int idPregunta, String descripcion, int idExamen) {
        this.idPregunta = idPregunta;
        this.descripcion = descripcion;
        this.idExamen = idExamen;
    }

    public Pregunta() {
        this(0,"",0);
    }
    //Métodos getters and setters

    public int getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(int idPregunta) {
        this.idPregunta = idPregunta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdExamen() {
        return idExamen;
    }

    public void setIdExamen(int idExamen) {
        this.idExamen = idExamen;
    }

    //toString
    @Override
    public String toString() {
        return "Pregunta{" +
                "idPregunta=" + idPregunta +
                ", descripcion='" + descripcion + '\'' +
                ", idExamen=" + idExamen +
                '}';
    }//Cierre de toString

}//Cierre de la clase

