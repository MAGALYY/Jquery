package mx.edu.utng.avance.model;


/**
 * Created by Pérez Godínez Jessica Magali on 03/02/2016.
 */

//Clase publica
public class RespuestaExamen {
    //Declaración de variables privadas
    private int idUsuario;
    private int idExamen;
    private int idPregunta;
    private boolean estadoPregunta;

    //Constructor
    public RespuestaExamen(int idUsuario, int idExamen, int idPregunta, boolean estadoPregunta) {
        this.idUsuario = idUsuario;
        this.idExamen = idExamen;
        this.idPregunta = idPregunta;
        this.estadoPregunta = estadoPregunta;
    }

    //Métodos getters and setters
    public RespuestaExamen() {
        this(0,0,0,false);
    }

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

    public int getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(int idPregunta) {
        this.idPregunta = idPregunta;
    }

    public boolean isEstadoPregunta() {
        return estadoPregunta;
    }

    public void setEstadoPregunta(boolean estadoPregunta) {
        this.estadoPregunta = estadoPregunta;
    }
    //Método toString
    @Override
    public String toString() {
        return "RespuestaExamen{" +
                "idUsuario=" + idUsuario +
                ", idExamen=" + idExamen +
                ", idPregunta=" + idPregunta +
                ", estadoPregunta=" + estadoPregunta +
                '}';
    }//Cierre de toString

}//Cierre de la clase
