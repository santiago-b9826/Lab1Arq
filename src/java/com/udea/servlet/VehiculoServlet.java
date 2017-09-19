/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.servlet;

import static com.sun.xml.ws.spi.db.BindingContextFactory.LOGGER;
import com.udea.ejb.VehiculoFacadeLocal;
import com.udea.entity.Vehiculo;
import com.udea.entity.VehiculoPK;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Part;
import javax.validation.ValidationException;

/**
 *
 * @author Juan Pablo Tobon Florez
 * @author Estefany Muriel Cano
 * @author Santiago Bedoya Betancur
 * @author Andrés Moreno Gonzáles
 */
@WebServlet(
        name = "Servlet",
        urlPatterns = {"/url"},
        loadOnStartup = 1
)
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
            if ("list".equals(action)) {
                List<Vehiculo> findAll = vehiculoFacade.findAll();
                request.getSession().setAttribute("vehiculos", findAll);
                url = "listVehiculos.jsp";
            } else if ("insert".equals(action)) {
                Vehiculo v = new Vehiculo();
                VehiculoPK vpk = new VehiculoPK();
                vpk.setCiudad(request.getParameter("placa"));
                vpk.setPlaca(request.getParameter("ciudad"));
                v.setVehiculoPK(vpk);
                v.setColor(request.getParameter("color"));
                v.setEspecificaciones(request.getParameter("especificaciones").getBytes());
                v.setMarca(request.getParameter("marca"));
                v.setModelo(Integer.parseInt(request.getParameter("modelo")));
                v.setPrecio(Float.parseFloat(request.getParameter("precio")));
                v.setReferencia(request.getParameter("referencia"));
                //process only if its multipart content
                Part part = request.getPart("image");
                InputStream is = part.getInputStream();
                ByteArrayOutputStream buffer = new ByteArrayOutputStream();
                int nRead;
                byte[] data = new byte[16384];
                while ((nRead = is.read(data, 0, data.length)) != -1) {
                    buffer.write(data, 0, nRead);
                }
                buffer.flush();
                v.setImage(buffer.toByteArray());
                vehiculoFacade.create(v);
                url = "manager.jsp";
            } else if ("delete".equals(action)) {
                String placa = request.getParameter("placa");
                Vehiculo v = vehiculoFacade.find(Integer.valueOf(placa));
                vehiculoFacade.remove(v);
                url = "VehiculoServlet?action=list";
            } else if ("buscar".equals(action)) {
                String placa = request.getParameter("placa");
                Vehiculo v = vehiculoFacade.find(Integer.valueOf(placa));
                request.getSession().setAttribute("vehiculos", v);
                url = "listVehiculos.jsp";
            }
            response.sendRedirect(url);
        } finally {
            out.close();
        }
    }

    /**
     * Reads the HttpServletRequest for a key-value pair and returns the value
     * where the key is equal to the given key.
     *
     * @param httpRequest A "multipart/form-data" request that contains the
     * parameter that has a key value 'key'.
     * @param key The key for the value we are after in the 'httpRequest'.
     * @return Returns null if there is no such key in the request or if, after
     * reading the object, it has a length of 0. Otherwise, it returns the value
     * associated with the key as a byte array.
     * @throws ServletException Thrown if the 'httpRequest' is not a
     * "multipart/form-data" request.
     * @throws IOException Thrown if there is an error reading the value fromthe
     * request's input stream.
     * @throws IllegalStateException Thrown if the entire request is largerthan
     * the maximum allowed size for a request or if the value of the requested
     * key is larger than the maximum allowed size for a single value.
     */
    protected byte[] getMultipartValue(HttpServletRequest httpRequest, String key) throws ValidationException {
        try {
            Part part = httpRequest.getPart(key);
            if (part == null) {
                return null;
            }
            InputStream partInputStream = part.getInputStream();
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            byte[] chunk = new byte[4096];
            int amountRead;
            while ((amountRead = partInputStream.read(chunk)) != -1) {
                outputStream.write(chunk, 0, amountRead);
            }
            if (outputStream.size() == 0) {
                return null;
            } else {
                return outputStream.toByteArray();
            }
        } catch (ServletException e) {
            throw new ValidationException(e);
        } catch (IOException e) {
            throw new ValidationException(e);
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
