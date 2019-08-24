/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package occ.ues.edu.sv.ingenieria.prn335.entity;

/**
 *
 * @author Esperanza
 */

public class Sucursal {
    public int id_sucursal;
    public String nombre;
    public String ciudad;
    public String departamento;
    public String contacto;
    public boolean estado;

    public Sucursal(int id_sucursal, String nombre, String ciudad, String departamento, String contacto, boolean estado) {
        this.id_sucursal = id_sucursal;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.departamento = departamento;
        this.contacto = contacto;
        this.estado = estado;
    }

    public Sucursal() {}

    public int getId_sucursal() {
        return id_sucursal;
    }

    public void setId_sucursal(int id_sucursal) {
        this.id_sucursal = id_sucursal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}