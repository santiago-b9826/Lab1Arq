/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.servlet;

import com.udea.ejb.VehiculoFacadeLocal;
import com.udea.entity.Vehiculo;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Juan Pablo Tobon Florez
 * @author Estefany Muriel Cano
 * @author Santiago Bedoya Betancur
 * @author Andrés Moreno Gonzáles
 */
public class VehiculoServlet extends HttpServlet {

    @EJB
    private VehiculoFacadeLocal vehiculoFacade;

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
        PrintWriter out = response.getWriter();
        try {
            String action = request.getParameter("action");
            String url = "index.jsp";
            if ("list".equals(action)) {
                List<Vehiculo> findAll = vehiculoFacade.findAll();
                request.getSession().setAttribute("vehiculos", findAll);
                url = "listVehiculos.jsp";
            } else if ("insert".equals(action)) {
                Vehiculo v = new Vehiculo();
                v.setColor(request.getParameter("color"));
                v.setEspecificaciones(request.getParameter("especificaciones").getBytes());
                v.setMarca(request.getParameter("marca"));
                v.setModelo(Integer.parseInt(request.getParameter("modelo")));
                v.setPrecio(Float.parseFloat(request.getParameter("precio")));
                v.setReferencia(request.getParameter("referencia"));
                vehiculoFacade.create(v);
                url = "index.jsp";
            } else if ("delete".equals(action)) {
                String placa = request.getParameter("placa");
                Vehiculo v = vehiculoFacade.find(Integer.valueOf(placa));
                vehiculoFacade.remove(v);
                url = "VehiculoServlet?action=list";
            } else if ("edit".equals(action)) {
                String placa = request.getParameter("placa");
                Vehiculo v = vehiculoFacade.find(Integer.valueOf(placa));
                vehiculoFacade.remove(v);
                v.setColor(request.getParameter("color"));
                v.setEspecificaciones(request.getParameter("especificaciones").getBytes());
                v.setMarca(request.getParameter("marca"));
                v.setModelo(Integer.parseInt(request.getParameter("modelo")));
                v.setPrecio(Float.parseFloat(request.getParameter("precio")));
                v.setReferencia(request.getParameter("referencia"));
                vehiculoFacade.create(v);
                url = "VehiculoServlet?action=list";
            }
            response.sendRedirect(url);
        } finally {
            out.close();
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
