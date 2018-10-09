/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cliente;

import com.sun.xml.internal.fastinfoset.util.StringArray;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ecasas
 */
@WebServlet(name = "AccederDatos", urlPatterns = {"/AccederDatos"})
public class AccederDatos extends HttpServlet {

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
            out.println("<title>Servlet AccederDatos</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AccederDatos at " + request.getContextPath() + "</h1>");
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
        doPost(request, response);
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
        //processRequest(request, response);
        try {
            request.setCharacterEncoding("UTF-8");
                    
            CRUD crud = new CRUD();
            
            List<String[]> array1;
            String action = request.getParameter("action");
            array1 = crud.getEstudiante();
            
            String fill = "";
            for(int i=0; i < array1.size(); i++){
                fill += "<option value='" + array1.get(i)[0] + "'>"
                        + array1.get(i)[1] + "</option>";
            }
            request.setAttribute("estudiante", fill);
            fill = "";
            
            array1 = crud.getProfesor();
            for(int i=0; i < array1.size(); i++){
                fill += "<option value='" + array1.get(i)[0] + "'>"
                        + array1.get(i)[1] + "</option>";
            }
            request.setAttribute("profesor", fill);
            fill = "";
            
            array1 = crud.getAsignatura();
            for(int i=0; i < array1.size(); i++){
                fill += "<option value='" + array1.get(i)[0] + "'>"
                        + array1.get(i)[1] + "</option>";
            }
            request.setAttribute("asignatura", fill);
            //fill = "";
            
            switch(action){
                case "create":
                    int estudiante = Integer.parseInt(request.getParameter("estudiante"));
                    int profesor = Integer.parseInt(request.getParameter("profesor"));
                    int asignatura = Integer.parseInt(request.getParameter("asignatura"));
                    String horario = request.getParameter("horario");
                    
                    //boolean create = create(asignatura, estudiante, profesor, horario);
                    boolean create = crud.create(estudiante,asignatura, profesor, horario);
                    //crud.create();
                    if(create){
                        request.setAttribute("message", "<h3>Se ha inscrito la asignatura satisfactoriamente, "
                                + "puedes verificarla en la secci&oacute;n de consultas.</h3>");
                    }else{
                        request.setAttribute("message", "<h3>No se ha inscrito la asignatura, "
                                + "por favor intenta m&aacute;s tarde.</h3>");
                    }
                    
                    break;
                case "read":
                    String operacion = request.getParameter("operacion");
                    int id = Integer.parseInt(request.getParameter("idpp"));
                    
                    array1 = CRUD.buscar2(operacion, id);
                    String code;
                    code = "<th>ID</th><th>Nombre Estudiante</th><th>Asignatura</th>"
                            + "<th>Nombre Profesor</th><th>Horario</th>";
                    for(int i=0; i < array1.size(); i++){
                        code += "<tr><td>" + array1.get(i)[0] + "</td>"
                                + "<td>" + array1.get(i)[1] + "</td>"
                                + "<td>" + array1.get(i)[2] + "</td>"
                                + "<td>" + array1.get(i)[3] + "</td>"
                                + "<td>" + array1.get(i)[4] + "</td></tr>";
                    }
                    request.setAttribute("message", code);
                    break;
                case "update":
                    operacion = request.getParameter("operacion");
                    id = Integer.parseInt(request.getParameter("idpp"));
            
                    boolean update = crud.update(id, operacion);
                    
                    if(update){
                        request.setAttribute("message", "<h3>Se ha realizado el cambio satisfactoriamente, "
                                + "puedes verificarla en la secci&oacute;n de consultas.</h3>");
                    }else{
                        request.setAttribute("message", "<h3>No se ha realizado el cambio, "
                                + "por favor intenta m&aacute;s tarde.</h3>");
                    }
                    
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("idpp"));
            
                    boolean delete = crud.delete(id);
                    
                    if(delete){
                        request.setAttribute("message", "<h3>Se ha eliminado el registro satisfactoriamente, "
                                + "puedes verificarlo en la secci&oacute;n de consultas.</h3>");
                    }else{
                        request.setAttribute("message", "<h3>No se ha realizado la eliminaci&oacute;n, "
                                + "por favor intenta m&aacute;s tarde.</h3>");
                    }
                    break;
                default:
                    array1 = null;
                    break;
            }
        
        } catch (Exception ex) {
            Logger.getLogger(AccederDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        request.getRequestDispatcher("index.jsp").forward(request, response);
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
