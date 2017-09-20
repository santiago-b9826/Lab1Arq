/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.servlet;

import com.udea.ejb.VehiculoFacadeLocal;
import com.udea.entity.Vehiculo;
import com.udea.entity.VehiculoPK;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;

/**
 *
 * @author Juan Pablo Tobon Florez
 * @author Estefany Muriel Cano
 * @author Santiago Bedoya Betancur
 * @author Andrés Moreno Gonzáles
 */
@MultipartConfig
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
            String url = "manager.jsp";
            if (null != action) {
                switch (action) {
                    case "list":
                        List<Vehiculo> findAll = vehiculoFacade.findAll();
                        request.getSession().setAttribute("vehiculos", findAll);
                        url = "listVehiculos.jsp";
                        break;
                    case "insert": {
                        Vehiculo v = new Vehiculo();
                        VehiculoPK vpk = new VehiculoPK();
                        vpk.setCiudad(request.getParameter("ciudad"));
                        vpk.setPlaca(request.getParameter("placa"));
                        v.setVehiculoPK(vpk);
                        v.setColor(request.getParameter("color"));
                        v.setEspecificaciones(request.getParameter("especificaciones").getBytes());
                        v.setMarca(request.getParameter("marca"));
                        v.setModelo(Integer.parseInt(request.getParameter("modelo")));
                        v.setPrecio(Float.parseFloat(request.getParameter("precio")));
                        v.setReferencia(request.getParameter("referencia"));
                        Part part = request.getPart("file");
                        InputStream is = part.getInputStream();
                        v.setImage(VehiculoServlet.readFully(is));
                        vehiculoFacade.create(v);
                        url = "manager.jsp";
                        break;
                    }
                    case "delete": {
                        String placa = request.getParameter("placa");
                        Vehiculo v = vehiculoFacade.find(Integer.valueOf(placa));
                        vehiculoFacade.remove(v);
                        url = "VehiculoServlet?action=list";
                        break;
                    }
                    case "buscar": {
                        String placa = request.getParameter("placa");
                        List<Vehiculo> findAllf = vehiculoFacade.findAll();
                        Vehiculo v = new Vehiculo();
                        for (Vehiculo vehiculo : findAllf) {
                            if(vehiculo.getVehiculoPK().getPlaca().equals(placa)){
                                v = vehiculo;
                            }
                        }
                        List<Vehiculo> lista = new ArrayList<>();
                        lista.add(v);
                        request.getSession().setAttribute("vehiculos", lista);
                        url = "listVehiculos.jsp";
                        break;
                    }
                    default:
                        break;
                }
            }
            response.sendRedirect(url);
        } finally {
            out.close();
        }
    }

    public static byte[] readFully(InputStream input) throws IOException {
        byte[] buffer = new byte[16777216];
        int bytesRead;
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        while ((bytesRead = input.read(buffer)) != -1) {
            output.write(buffer, 0, bytesRead);
        }
        return output.toByteArray();
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
