package LateShipmentProject;

import java.io.IOException;  
import java.io.PrintWriter;  
import java.util.List;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse; 

@WebServlet("/ViewServlet")  

public class ViewServlet extends HttpServlet {  

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
		
         
        PrintWriter out=response.getWriter();  
        out.println("<html> <body> <center> <a href='SaveServlet.html'>Add New Employee</a>");  
        out.println("<h1>Employees List</h1> </center> </body> </html>");  
          
        List<Employee_class> list=Employee_main.getAllEmployees();  
          
        out.print("<table border='1' width='100%'");  
        out.print("<tr><th>Id</th><th>Name</th><th>Email</th><th>Employee Phone</th><th>Department</th><th>Skills</th><th>Edit</th><th>Delete</th></tr>");  
        for(Employee_class e:list){  
         out.print("<tr><td>"+e.getEmployee_id()+"</td><td>"+e.getEmployee_name()+"</td><td>"+e.getEmployee_email()+"</td><td>"+e.getEmployee_phone_number()+"</td><td>"+e.getDepartment()+"</td><td>"+e.getSkills()+"</td><td><a href='EditServlet?employee_id="+e.getEmployee_id()+"'>edit</a></td><td><a href='DeleteServlet?employee_id="+e.getEmployee_id()+"'>delete</a></td></tr>");  
        }  
        out.print("</table>");  
          
    }  
}  
