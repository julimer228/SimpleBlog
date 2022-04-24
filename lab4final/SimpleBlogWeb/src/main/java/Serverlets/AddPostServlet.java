/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Serverlets;

import Exceptions.EmptyFilePathException;
import Exceptions.InvalidImageParamException;
import Exceptions.InvalidIndexException;
import Exceptions.InvalidTitleException;
import Model.Blog;
import Model.Image;
import Model.Post;
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
 * Servlet to add new post to the blog
 */
public class AddPostServlet extends HttpServlet {

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
        
         if(request.getParameter("topicIndex1").length()==0
                 ||request.getParameter("x").length()==0||request.getParameter("width").length()==0||
                 request.getParameter("height").length()==0)
        {
            response.sendError(response.SC_BAD_REQUEST, "The form is empty! You have to fill the form to create a post");
        }
        
        int topicIndex=Integer.parseInt(request.getParameter("topicIndex1"));
        int x=Integer.parseInt(request.getParameter("x"));
        int y=Integer.parseInt(request.getParameter("y"));
        int width=Integer.parseInt(request.getParameter("width"));
        int height=Integer.parseInt(request.getParameter("height"));
        
        String filepath=request.getParameter("filepath");
        String caption=request.getParameter("caption");
        String text=request.getParameter("text");
        String postTitle=request.getParameter("postTitle");
        
        
         if(filepath.length()==0||caption.length()==0||text.length()==0||postTitle.length()==0)
        {
            response.sendError(response.SC_BAD_REQUEST, "The form is empty! You have to fill the form to create a post");
        }
    
        try{
           
            Image img=new Image(x,y, height, width,filepath, caption);
            Post p=new Post(postTitle, img, text);
            blog.getTopicByIndex(topicIndex).addPost(p);
        }catch(InvalidTitleException|InvalidImageParamException|NumberFormatException e)
        {
             response.sendError(response.SC_BAD_REQUEST, "The parameters are incorrect!");
        } catch (EmptyFilePathException ex) {
            response.sendError(response.SC_BAD_REQUEST, "The filepath is incorrect");
        } catch (InvalidIndexException ex) {
            response.sendError(response.SC_BAD_REQUEST, "The index of the topic is incorrect");
        }
        
       
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
            out.println("<p class=\"center\"> The post has been added</p>");
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
