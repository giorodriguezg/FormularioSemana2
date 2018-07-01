package co.grgiral.formulario;

import java.util.Date;

/**
 * Created by grgiral on 02/04/2018.
 */

public class Contacto {

    private String nombre;
    private String telefono;
    private String email;
    private Date fecha;

    public Contacto(String nombre, String telefono, String email, Date fecha) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }



    public void setNombre(String nombre) {
        this.nombre = nombre;

    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}

