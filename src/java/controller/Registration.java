package controller;

import model.pojo.User;
import model.util.DBConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.util.DBMethods;

public class Registration extends HttpServlet {

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
        
         // metodo para realizar prueba de conexión y en caso de error invocar pag. error.jsp
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
        
        User newUser = new User();
        newUser.setIdentification_type(request.getParameter("identificationType"));
        newUser.setIdentification_number(request.getParameter("identificationNumber"));
        newUser.setFirstname(request.getParameter("firstname"));
        newUser.setMiddlename(request.getParameter("middlename"));
        newUser.setLastname(request.getParameter("lastname"));
        newUser.setSecond_lastname(request.getParameter("secondLastname"));
        newUser.setPhone_number(request.getParameter("phoneNumber"));
        newUser.setEmail(request.getParameter("email"));
        newUser.setUsername(request.getParameter("username"));
        newUser.setPassword(request.getParameter("pass"));
        
        DBMethods newRegisteredUser = new DBMethods();
        if (newRegisteredUser.register(newUser)) {
            response.sendRedirect("menu.jsp");
        } else {
            response.sendRedirect("index.jsp");
        }

        //try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
          //  out.println("<!DOCTYPE html>");
            //out.println("<html>");
            //out.println("<head>");
            //out.println("<title>Servlet registration</title>");            
            //out.println("</head>");
            //out.println("<body>");
            //out.println("<h1>Servlet registration at " + request.getContextPath() + "</h1>");
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
