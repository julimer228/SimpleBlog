/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Serverlets;

import Exceptions.InvalidIndexException;
import Exceptions.InvalidTitleException;
import Model.Blog;
import Model.Topic;
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
 * Servlet to show all the posts from one topic
 */
public class ShowPostServlet extends HttpServlet {

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
        
        try{
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
        Topic t=null;
        response.setContentType("text/html"); 
        response.setCharacterEncoding("UTF-8"); 
        PrintWriter out = response.getWriter();
        try{
             int topicIndex=Integer.parseInt(request.getParameter("topicindex4"));
            t=blog.getTopicByIndex(topicIndex);
        }catch(InvalidIndexException|NullPointerException|IndexOutOfBoundsException e)
        {
             response.sendError(response.SC_BAD_REQUEST, "The index is invalid!");
        }
        
       
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
             out.println(" <link rel=\"stylesheet\" href=\"style.css\">\n" +
"        <link href=\"https://fonts.googleapis.com/css2?family=Source+Code+Pro:ital,wght@0,600;1,400;1,800&display=swap\" rel=\"stylesheet\"> \n" +
"        <link href=\"https://fonts.googleapis.com/css2?family=Libre+Baskerville:ital@1&display=swap\" rel=\"stylesheet\">");
            //out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
            out.println("<title>Show posts</title>");
            out.println("</head>");
            out.println("<body>");
             out.println("<p class=\"center\">"+blog.getTitle()+"</p>");
            out.println("<br></br>");
            out.println("<p class=\"section-title\">"+t.getTitle()+"</p>");
           
            for(int i=0; i<t.getNumberOfPosts(); i++)
            {
                out.println("<p> "+t.getPosts().get(i).toString()+" </p>");
            }
            out.println("</body>");
            out.println("</html>");
            session.setAttribute("blog", blog);

        
        }catch(IOException | NumberFormatException e){
                     response.sendError(response.SC_BAD_REQUEST, "The index is invalid!");
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
