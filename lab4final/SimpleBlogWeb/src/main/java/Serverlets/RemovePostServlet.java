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
 * Class to remove the post from the blog
 */
public class RemovePostServlet extends HttpServlet {

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
        
        response.setContentType("text/html"); 
        response.setCharacterEncoding("UTF-8"); 
        PrintWriter out = response.getWriter();
       
        int topicIndex=Integer.parseInt(request.getParameter("topicIndex2"));
        int postIndex=Integer.parseInt(request.getParameter("postIndex"));
        String postTitle="";
        String topicTitle="";
        
        try{
            topicTitle=blog.getTopicByIndex(topicIndex).getTitle();
            postTitle=blog.getTopicByIndex(topicIndex).getPosts().get(postIndex).getTitle();
             blog.getTopicByIndex(topicIndex).removePost(postIndex);
        }catch(InvalidIndexException|NumberFormatException|IndexOutOfBoundsException|NullPointerException e)
        {
             response.sendError(response.SC_BAD_REQUEST, "The index is incorrect!");
        }
        
       
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            //out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
            out.println("<title>Remove post</title>");
              out.println(" <link rel=\"stylesheet\" href=\"style.css\">\n" +
"        <link href=\"https://fonts.googleapis.com/css2?family=Source+Code+Pro:ital,wght@0,600;1,400;1,800&display=swap\" rel=\"stylesheet\"> \n" +
"        <link href=\"https://fonts.googleapis.com/css2?family=Libre+Baskerville:ital@1&display=swap\" rel=\"stylesheet\">");
           
            out.println("</head>");
            out.println("<body>");
            out.println("<br></br>");
            out.println("<br></br>");
            out.println("<br></br>");
            out.println("<br></br>");
            out.println("<br></br>");
            out.println("<br></br>");
            out.println("<p class=\"center\"> The post with the index: "+postIndex+" and title: \""+postTitle+
                     "\" has been removed from the topic with index:" +topicIndex+" and title: "+topicTitle+" </h1>");
            out.println("</body>");
            out.println("</html>");
            session.setAttribute("blog", blog);
            
            
            
            
            
            
            
            
}catch(IOException | NumberFormatException e){response.sendError(response.SC_BAD_REQUEST, "The index is incorrect!");}
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
