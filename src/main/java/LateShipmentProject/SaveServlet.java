package LateShipmentProject;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse res)    throws ServletException, IOException {  
		  
	        PrintWriter out=res.getWriter();  
	          
	        String name=req.getParameter("name");  
	        String email=req.getParameter("email");  
	        long phone_number= Long.parseLong(req.getParameter("phone_number"));  
	        String department=req.getParameter("department");
	        String[] skills = req.getParameterValues("box");
	        
	        String convert = "";
	        
	        for(int i = 0 ; i < skills.length;i++)
	   		{
	        	convert+= skills[i]+",";
	      	}
	       
	        
	        Employee_class e=new Employee_class();  
	        
	        e.setEmployee_name(name);  
	        e.setEmployee_email(email);
	        e.setEmployee_phone_number(phone_number);
	        e.setDepartment(department);
	        e.setSkills(convert);
	        
	        Employee_main.save(e);  
	        
	            out.print("<html> <body> <center><h1 style='color:lime;'>Record saved successfully!</h1> </center> </body> </html>");  
	            req.getRequestDispatcher("SaveServlet.html").include(req, res);    
	    }  
	  
	}  
