/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.servlet;

import com.udea.ejb.ClienteFacadeLocal;
import com.udea.entity.Cliente;
import com.udea.entity.ClientePK;
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
public class ClienteServlet extends HttpServlet {

    @EJB
    private ClienteFacadeLocal clienteFacade;

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
                        List<Cliente> findAll = clienteFacade.findAll();
                        request.getSession().setAttribute("clientes", findAll);
                        url = "listClientes.jsp";
                        break;
                    case "insert": {
                        Cliente c = new Cliente();
                        ClientePK cpk = new ClientePK();
                        cpk.setTipoDocumento(request.getParameter("tipodoc"));
                        cpk.setNumDocumento(Integer.valueOf(request.getParameter("numdoc")));
                        c.setClientePK(cpk);
                        c.setNombre(request.getParameter("nombre"));
                        c.setTelefono(Integer.valueOf(request.getParameter("telefono")));
                        c.setEmail(request.getParameter("email"));
                        c.setDireccion(request.getParameter("direccion"));
                        clienteFacade.create(c);
                        url = "manager.jsp";
                        break;
                    }
                    case "delete": {
                        int numDocumento = Integer.parseInt(request.getParameter("numDocumento"));
                        String tipoDocumento = request.getParameter("tipoDocumento");
                        Cliente c = clienteFacade.find(new ClientePK(tipoDocumento,numDocumento));
                        clienteFacade.remove(c);
                        url = "ClienteServlet?action=list";
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
