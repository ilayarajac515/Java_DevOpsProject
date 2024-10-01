package LateShipmentProject;

import java.io.IOException;  
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;


@WebServlet("/DeleteServlet")  
public class DeleteServlet extends HttpServlet {  
    protected void doGet(HttpServletRequest req, HttpServletResponse res)  throws ServletException, IOException {  
    	
        String sid=req.getParameter("employee_id");
        
        int id=Integer.parseInt(sid);
        
        Employee_main.delete(id);  
        
        res.sendRedirect("ViewServlet"); 
    }  
}  