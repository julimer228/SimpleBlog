/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Serverlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author julia
 * Class contains the example with cookies
 */
public class CookieServlet extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            
            Cookie[] cookies = request.getCookies();
            String cookieString = "cookie";
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("cookie")) {
                        cookieString = cookie.getValue();
                        break;
                    }
                }
            }
            
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println(" <link rel=\"stylesheet\" href=\"style.css\">\n" +
"        <link href=\"https://fonts.googleapis.com/css2?family=Source+Code+Pro:ital,wght@0,600;1,400;1,800&display=swap\" rel=\"stylesheet\"> \n" +
"        <link href=\"https://fonts.googleapis.com/css2?family=Libre+Baskerville:ital@1&display=swap\" rel=\"stylesheet\">");
       
            
            
            out.println("<title>Cookies example</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<br><\br>");
            out.println("<br><\br>");
            out.println("<br><\br>");
            out.println("<br><\br>");
            out.println("<p class=\"center\">Your last cookie was: " + cookieString+ "</p>");
            out.println("</body>");
            out.println("</html>");
            
            String cookieKind="";
            
             Calendar cal = GregorianCalendar.getInstance();
        switch (cal.get(Calendar.SECOND)/2) {
            case 0:
                cookieKind = "Chocolate cookie";
                break;
            case 1:
                cookieKind = "Carmel cookie";
                break;
            case 2:
                cookieKind = "Lemon pie";
                break;
            case 3:
                cookieKind = "Apple pie";
                break;
            case 4:
                cookieKind = "Banana cookie";
                break;
            default:
                cookieKind = "Carmel cake";
        }
            
            Cookie cookie = new Cookie("cookie", cookieKind);
            response.addCookie(cookie);
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
