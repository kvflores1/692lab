
package com.mycompany.lab2;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author student
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
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
    

   @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String username=(String) request.getParameter("username");
        String password=(String) request.getParameter("password");
        
        UserInfo uinfo=getUserInfo(username, password);
        
        if (uinfo==null){
            RequestDispatcher rd= request.getRequestDispatcher("loginfailed.jsp");
            rd.forward(request, response);
        }
        else{
            request.getSession().setAttribute("uname", username);
            request.setAttribute("OrderHistoryInfo", uinfo.getOrderHistory());
            
            RequestDispatcher rd= request.getRequestDispatcher("userorders.jsp");
            rd.forward(request, response);
            
        }
        
        
     
    }

    private UserInfo getUserInfo(String uname, String password) {
        /**
         * to be completed. For now, we just return a user info object that has a default book in a default date;
         * This method must return null when user name and password is incorrect
         * otherwise it must return an object containing all books that have been borrowed by the user, in addition to user information like name, address, ...
         */
        UserInfo uf= new UserInfo();
   
        
       try {
           uf.addOrder(new OrderHistory("Medicine A", "Company A", new SimpleDateFormat("YYYY-MM-dd").parse("2022-03-01"), true));
           uf.addOrder(new OrderHistory("Medicine B", "Company B", new SimpleDateFormat("YYYY-MM-dd").parse("2022-03-07"), false));
       } catch (ParseException ex) {
           Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
           System.out.println("Error");
       }
        return uf;
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

          doPost(request, response);

        
    }

}
