/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Serverlets;

import Exceptions.InvalidIndexException;
import Exceptions.InvalidTitleException;
import Model.Blog;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author julia
 * Servlet to remove topic from the blog
 */
public class RemoveTopicsServlet extends HttpServlet {

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
        }   
        else {
            blog = (Blog) obj;
        }
        
        response.setContentType("text/html"); 
        response.setCharacterEncoding("UTF-8"); 
        PrintWriter out = response.getWriter();
        
              int topicIndex=-1;
        try{
          String topicIndexString=request.getParameter("topicIndex3");
         topicIndex=Integer.parseInt(topicIndexString);
        }catch(NumberFormatException|IllegalStateException e)
        {
            response.sendError(response.SC_BAD_REQUEST, "The index is invalid. Enter correct data!");
        }
        String topicTitle="";
        try{
        topicTitle=blog.getTopicByIndex(topicIndex).getTitle();
        blog.removeTopicByIndex(topicIndex);
        }catch(InvalidIndexException|IndexOutOfBoundsException|NullPointerException e)
        {
             response.sendError(response.SC_BAD_REQUEST, "There is no topic with this index!");
        }
        
        
       
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
              out.println(" <link rel=\"stylesheet\" href=\"style.css\">\n" +
"        <link href=\"https://fonts.googleapis.com/css2?family=Source+Code+Pro:ital,wght@0,600;1,400;1,800&display=swap\" rel=\"stylesheet\"> \n" +
"        <link href=\"https://fonts.googleapis.com/css2?family=Libre+Baskerville:ital@1&display=swap\" rel=\"stylesheet\">");
     
      
            out.println("<title>Remove topic</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<br></br>");
            out.println("<br></br>");
            out.println("<br></br>");
            out.println("<br></br>");
            out.println("<br></br>");
            out.println("<br></br>");
            out.println("<p class=\"center\">The topic with an index: "+topicIndex+" and title: "+topicTitle+" has been removed</p>");
            out.println("</body>");
            out.println("</html>");
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
        
    this.processRequest(request, response);
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
         this.processRequest(request, response);
          
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
