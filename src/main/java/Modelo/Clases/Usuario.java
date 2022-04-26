package Modelo.Clases;

import java.sql.Date;
import java.sql.Time;

public class Usuario {

    private long id;
    private String nombre;
    private Long puntaje;
    private Date fecha;
    private Time hora;

    public Usuario() {
    }

    public Usuario(String nombre, Long puntaje, Date fecha, Time hora) {
        this.nombre = nombre;
        this.fecha=fecha;
        this.puntaje=puntaje;
        this.hora=hora;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(Long puntaje) {
        this.puntaje = puntaje;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {this.hora=hora;}

    @Override
    public String toString() {
        return "Nombre: "+nombre+", Puntaje: "+puntaje+", Fecha: "+fecha+" ("+hora+")"+", Id: "+id;
    }
}
