/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.prueba.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.prueba.dao.PruebaDAO;
import org.prueba.model.Compania;
import org.prueba.model.CuerpoEjercito;

/**
 *
 * @author david
 */
public class CombosServlet extends HttpServlet {

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
            
            int opcion = Integer.parseInt(request.getParameter("opcion"));
            
            PruebaDAO pruebaDAO = new PruebaDAO();
            
            switch(opcion){
                case 1://compania
                    
                    List<Compania> companias = pruebaDAO.traerCompanias();
                    out.println("<option value='0'>.:eleccione:.</option>");
                    for (Compania c: companias){
                        out.println("<option value='"+c.getId()+"'>"+c.getNombreCompania()+"</option>");
                    }
                    
                    
                    //https://www.objectdb.com/api/java/jpa
                    
                    
                    break;
                    
                case 2://cuerpo
                    
                     List<CuerpoEjercito> cupEjer = pruebaDAO.traerCuerpos();
                    out.println("<option value='0'>.:eleccione:.</option>");
                    for (CuerpoEjercito c: cupEjer){
                        out.println("<option value='"+c.getId()+"'>"+c.getNombreCuerpo()+"</option>");
                    }
                    break;
                            
                            
            }                                     
            
            
            
            
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
