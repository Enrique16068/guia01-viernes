/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.occ.edu.sv.ingenieria.prn335.boundary;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import occ.ues.edu.sv.ingenieria.prn335.entity.Sucursal;
import occ.ues.edu.sv.ingenieria.prn335.control.Motor;

/**
 *
 * @author enrique
 */
@WebServlet(name = "FrmServlet", urlPatterns = {"/FrmServlet"})
public class FrmServlet extends HttpServlet {
    Motor proceso = new Motor();
    boolean estado;
    ArrayList<Sucursal> filtrado=new ArrayList<>();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Lista filtrada</title>");
            out.println("</head>");
            out.println("<body>");
            if (request.getParameter("editar") != null) {
                int id=Integer.parseInt(request.getParameter("id"))-1;
                if (request.getParameter("estado").equalsIgnoreCase("activo")) {
                    estado = true;
                } else if (request.getParameter("estado").equalsIgnoreCase("inactivo")) {
                    estado = false;
                }
                try {
                    proceso.modificarSucursal(id, request.getParameter("nombre"), request.getParameter("ciudad"), request.getParameter("departamento"), request.getParameter("contacto"), estado);
                    out.println("<table border=1 style=width:80%>");
                    out.println("<tr bgcolor=0D9387 >");

                    out.println("<th>ID</th>");
                    out.println("<th>Nombre</th>");
                    out.println("<th>Ciudad</th>");
                    out.println("<th>Departamento</th>");
                    out.println("<th>Estado</th>");

                    out.println("</tr>");
                    for (Sucursal producto : proceso.mostrarSucursales()) {
                        out.println("<tr bgcolor=65F90A >");

                        out.println("<td> " + producto.getId_sucursal() + "</td>");
                        out.println("<td> " + producto.getNombre() + "</td>");
                        out.println("<td> " + producto.getCiudad() + "</td>");
                        out.println("<td> " + producto.getDepartamento() + "</td>");
                        out.println("<td> " + producto.isEstado() + "</td>");

                        out.println("</tr>");
                    }
                    out.println("</table>");
                } catch (IllegalArgumentException e) {
                    out.println("<h1>" + e.getMessage() + "</h1>");
                }
            } else if (request.getParameter("filtrar") != null) {
                try {
                    filtrado=proceso.buscarActivos(request.getParameter("departamento"));
                    out.println("<table border=1 style=width:80%>");
                    out.println("<tr bgcolor=0D9387 >");

                    out.println("<th>ID</th>");
                    out.println("<th>Nombre</th>");
                    out.println("<th>Ciudad</th>");
                    out.println("<th>Departamento</th>");
                    out.println("<th>Estado</th>");

                    out.println("</tr>");
                    for (Sucursal producto : filtrado) {
                        out.println("<tr bgcolor=65F90A >");

                        out.println("<td> " + producto.getId_sucursal() + "</td>");
                        out.println("<td> " + producto.getNombre() + "</td>");
                        out.println("<td> " + producto.getCiudad() + "</td>");
                        out.println("<td> " + producto.getDepartamento() + "</td>");
                        out.println("<td> " + producto.isEstado() + "</td>");

                        out.println("</tr>");
                    }
                    out.println("</table>");
                } catch (IllegalArgumentException e) {
                    out.println("<h1>" + e.getMessage() + "</h1>");
                }
            }
            out.println("<form action=/guia01-viernes-master>");
            out.println("<input type=submit value=Regresar>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
