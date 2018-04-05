package com.uaemex.armandosandoval.listacontactos;

/**
 * Created by Armando Sandoval on 03/04/2018.
 */

public class Contacto {
    String nombre,telefono,email;


    public Contacto(String nombre, String telefono,String correo) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email=correo;
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
}
