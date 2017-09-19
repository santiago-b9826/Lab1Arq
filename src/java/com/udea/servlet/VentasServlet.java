/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.servlet;

import com.udea.ejb.VentasFacadeLocal;
import com.udea.entity.Cliente;
import com.udea.entity.Ventas;
import com.udea.entity.VentasPK;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
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
public class VentasServlet extends HttpServlet {

    @EJB
    private VentasFacadeLocal ventasFacade;

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
            if (null != action) switch (action) {
                case "list":
                    List<Ventas> findAll = ventasFacade.findAll();
                    request.getSession().setAttribute("ventas", findAll);
                    url = "listVentas.jsp";
                    break;
                case "insert":
                    Ventas v = new Ventas();
                    VentasPK vpk = new VentasPK();
                    vpk.setNumDocumento(Integer.parseInt(request.getParameter("numdoc")));
                    vpk.setNumVenta(Integer.parseInt(request.getParameter("numventa")));
                    v.setVentasPK(vpk);
                    v.setFecha(Date.valueOf(request.getParameter("fecha")));
                    v.setCantidad(Integer.valueOf(request.getParameter("cantidad")));
                    v.setPlacaCiudad(request.getParameter("placaciudad"));
                    v.setTotalVenta(Float.valueOf(request.getParameter("totalventa")));
                    ventasFacade.create(v);
                    url = "index.jsp";
                    break;
                case "delete":                    
                int numDocumento = Integer.parseInt(request.getParameter("numDocumento"));
                int numVenta = Integer.parseInt(request.getParameter("numVenta"));    
                Ventas v1 = ventasFacade.find(new VentasPK(numDocumento, numVenta));
                ventasFacade.remove(v1);
                url = "VentasServlet?action=list";
                    break;
                default:
                    break;
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
