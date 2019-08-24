/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package occ.ues.edu.sv.ingenieria.prn335.control;

import java.util.ArrayList;

import occ.ues.edu.sv.ingenieria.prn335.entity.Sucursal;

/**
 *
 * @author Esperanza
 */
public class Motor {

    ArrayList<Sucursal> sucursales = new ArrayList<Sucursal>();

    public Motor() {
        sucursales.add(new Sucursal(1, "Cinepolis Metrocentro", "Santa Ana", "Santa Ana", "Juan Perez", true));
        sucursales.add(new Sucursal(2, "Cinepolis La Gran Via", "Antiguo Cuscatlan", "San Salvador", "Luis Lopez", true));
        sucursales.add(new Sucursal(3, "Cinepolis Metrocento SM", "San Miguel", "San Miguel", "Will Salgado", false));
        sucursales.add(new Sucursal(4, "Cinemark Metrocentro", "Soyapango", "San Salvador", "Encargado 1", false));
        sucursales.add(new Sucursal(5, "Cinepolis Metrocentro Sonso", "Sonsonate", "Sonsonate", "Encargado 2", true));
        sucursales.add(new Sucursal(6, "Cine La Union", "Puerto de la union", "La Union", "Encargado 3", true));
        sucursales.add(new Sucursal(7, "Cine La Union 2", "Ciudad de la union", "La Union", "Encargado 3", true));
    }

    public ArrayList<Sucursal> mostrarSucursales() {
        return sucursales;
    }

    public ArrayList<Sucursal> buscarActivos(String departamento) {
        ArrayList<Sucursal> activos = new ArrayList<>();
        for (Sucursal sucursal : sucursales) {
            if (sucursal.estado && sucursal.departamento.equalsIgnoreCase(departamento) && !sucursal.contacto.equalsIgnoreCase("Will Salgado")) {
                activos.add(sucursal);
            }
        }
        return activos;
    }

    public Boolean modificarSucursal(int id_sucursal, String nombre, String ciudad, String departamento, String contacto, boolean estado​) throws IllegalArgumentException {
        if (sucursales.get(id_sucursal).estado) {
            throw new IllegalArgumentException("Error! no se puede modificar una sucursal que este activa");
        } else {
            sucursales.get(id_sucursal).setNombre(nombre);
            sucursales.get(id_sucursal).setCiudad(ciudad);
            sucursales.get(id_sucursal).setDepartamento(departamento);
            sucursales.get(id_sucursal).setContacto(contacto);
            sucursales.get(id_sucursal).setEstado(estado);
        }
        return true;
    }

}
