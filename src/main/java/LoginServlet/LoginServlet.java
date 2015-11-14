package LoginServlet;


import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet{
  public void doGet(HttpServletRequest request, HttpServletResponse response)
                                   throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    String name = request.getParameter("email");
    
    out.println("<html>");
    out.println("<body>");
    out.println("Thanks"  + name +  "for visiting Snapi<br>" );
   
    out.println("</body></html>");
  }
}

