/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Serverlets;

import Exceptions.InvalidGradeException;
import Exceptions.InvalidTitleException;
import Model.Blog;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author julia
 * Servlet to add new grade to the blog and count the average grade
 */
public class AddGradeServlet extends HttpServlet {

    /**
     * Method to initialize servlet
     */
   @Override
   public void init()
   {
       
   }

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
  Blog blog=null;
        HttpSession session = request.getSession(true);
        Object obj = session.getAttribute("blog");
        if (obj == null) {
    
        try{   
        blog = new Blog("New blog");
        }catch(InvalidTitleException e){}    
        } else {
        blog = (Blog) obj;
        }

         if(request.getParameter("gradeInt").length()==0)
        {
            response.sendError(response.SC_BAD_REQUEST, "You have to choose the valid grade!");
        }
         
           if(request.getParameter("gradeInt").isEmpty())
        {
            response.sendError(response.SC_BAD_REQUEST, "You have to choose the valid grade!");
        }
        
        int gradeInt=Integer.parseInt(request.getParameter("gradeInt"));
        try{
            blog.addGrade(gradeInt);
        } catch (InvalidGradeException ex) {
          response.sendError(response.SC_BAD_REQUEST, "You have to choose the valid grade!");
       }
        
        
            response.setContentType("text/html"); 
            response.setCharacterEncoding("UTF-8"); 
            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
                   out.println(" <link rel=\"stylesheet\" href=\"style.css\">\n" +
"        <link href=\"https://fonts.googleapis.com/css2?family=Source+Code+Pro:ital,wght@0,600;1,400;1,800&display=swap\" rel=\"stylesheet\"> \n" +
"        <link href=\"https://fonts.googleapis.com/css2?family=Libre+Baskerville:ital@1&display=swap\" rel=\"stylesheet\">");
            //out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
            out.println("<title>The post has been removed</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<br></br>");
            out.println("<br></br>");
            out.println("<br></br>");
            out.println("<br></br>");
            out.println("<br></br>");
            out.println("<br></br>");
            out.println("<br></br>");
            switch(gradeInt)
            {
                case 1:
                    out.println("<p class=\"center\">Sorry! We very much regret that our blog have caused you so much trouble.</p>");
                    break;
                case 2:
                    out.println("<p class=\"center\">Sorry! We will try to make our application better!</p>");
                    break;
                case 3:
                    out.println("<p class=\"center\">Not so bad, but we will try to improve our blog.</p>");
                    break;
                case 4:
                    out.println("<p class=\"center\">Thank you! We will continue working on our website.</p>");
                    break;
                case 5:
                    out.println("<p class=\"center\">Thank you! We are so happy that you like our website.</p>");
                    break;
            }
            out.println("<br></br>");
            out.println("<br></br>");
           
            String gradeString=String.format("%.2f",blog.CountAverageGrade());
            
            out.println("<p class=\"center\">The average is: "+gradeString+"</p>");
            out.println("</body>");
            out.println("</html>");
            session.setAttribute("blog", blog);
        
        
        session.setAttribute("blog", blog);
        
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
