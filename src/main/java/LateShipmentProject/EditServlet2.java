package LateShipmentProject;

import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse; 

@WebServlet("/EditServlet2")  
public class EditServlet2 extends HttpServlet {  

	protected void doPost(HttpServletRequest req, HttpServletResponse res)   throws ServletException, IOException {  
        
		res.setContentType("text/html");  
        
        PrintWriter out=res.getWriter();  
          
        int id=Integer.parseInt(req.getParameter("employee_id"));  
        String name=req.getParameter("employee_name");  
        String email=req.getParameter("employee_email");  
        Long phone_number = Long.parseLong(req.getParameter("employee_phone_number"));  
        String department=req.getParameter("employee_department"); 
        String skills[] = req.getParameterValues("box");
        
        String skill = "";
        for(int i = 0 ; i < skills.length; i++)
        {
        	skill+=skills[i]+",";
        }
        
        Employee_class e=new Employee_class();  
        
        e.setEmployee_id(id);  
        e.setEmployee_name(name);  
        e.setEmployee_email(email);  
        e.setEmployee_phone_number(phone_number);  
        e.setDepartment(department);
        e.setSkills(skill);
          
        int status=Employee_main.update(e); 
        
        if(status>0)
        {  
            res.sendRedirect("ViewServlet");  
        }
        else
        {  
            out.println("Sorry! unable to update record");  
        }  
          

    }  
  
}  