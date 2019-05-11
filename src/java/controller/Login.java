package controller;

import model.util.DBMethods;
import model.util.DBConnection;
import Model.pojo.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet {

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
        
        // metodo para realizar prueba de conexión y en caso de error invocar pag. erro.jsp
        try {
            Connection cx = DBConnection.getConexion();
            System.out.println("Conexión exitosa");
        } catch (Exception ex) {
            String message = ex.getMessage();
            StringWriter errors = new StringWriter();
            ex.printStackTrace(new PrintWriter(errors));
            String StackTrace = errors.toString();
            
            // variables de sesion
            request.setAttribute("message", message);
            request.setAttribute("StackTrace", StackTrace);

            RequestDispatcher view = request.getRequestDispatcher("/error.jsp");
            view.forward(request, response);
            
        }
        
        // metodo para validar los datos de ingreso, capturados en el inicio de sesión de index.jsp
        User sesionUser = new User();
        sesionUser.setUsername(request.getParameter("username"));
        sesionUser.setPassword(request.getParameter("pass"));
        //String username = request.getParameter("username");
        //String password = request.getParameter("pass");
        DBMethods autenticar = new DBMethods();
        
        if (autenticar.autenticacion(sesionUser)) {
            response.sendRedirect("menu.jsp");
        } else {
            response.sendRedirect("index.jsp");
        }

        //try (PrintWriter out = response.getWriter()) {
        /* TODO output your page here. You may use following sample code. */
        //out.println("<!DOCTYPE html>");
        //out.println("<html>");
        //out.println("<head>");
        //out.println("<title>Servlet Login</title>");            
        //out.println("</head>");
        //out.println("<body>");
        //out.println("<h1>Servlet Login at " + request.getContextPath() + "</h1>");
        //out.println("</body>");
        //out.println("</html>");
        //}
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
