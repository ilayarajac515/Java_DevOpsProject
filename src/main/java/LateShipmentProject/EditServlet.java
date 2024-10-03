package LateShipmentProject;

import java.io.IOException; 


import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;


@WebServlet("/EditServlet")  
public class EditServlet extends HttpServlet
{  
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
       
    	response.setContentType("text/html");  
    
        PrintWriter out=response.getWriter();  
       
        out.println("<center> <h1>Update Employee</h1> </center>");  
        
        int id=Integer.parseInt(request.getParameter("employee_id"));
          
        Employee_class e=Employee_main.getEmployeeById(id);  
          
        out.print("<center><form action='EditServlet2' method='post'>");  
        out.print("<table cellpadding='10'>"); 
        
        out.print("<tr><td></td><td><input type='hidden' name='employee_id' value='"+e.getEmployee_id()+"' /></td></tr>");  
        
        out.print("<tr><td>Name:</td><td><input type='text' name='employee_name' value='"+e.getEmployee_name()+"'/></td></tr>");  
        
        out.print("<tr><td>Email</td><td><input type='email' name='employee_email' value='"+e.getEmployee_email()+"'/> "+ 
               " </td></tr>");  
        
        out.print("<tr><td>Phone_number:</td><td><input type='tel' name='employee_phone_number' value='"+e.getEmployee_phone_number()+"'/></td></tr>");  
        
        out.print("<tr><td>Department:</td><td>");  
        out.print("<select name='employee_department' style='width:150px'>");  
        out.print("<option value=\"Research and Development\">Research and Development</option>");  
        out.print("<option value=\"Product Development\">Product Development</option>");  
        out.print("<option value=\"Administration Department\">Administration Department</option>");  
        out.print("<option value=\"IT Services Development\">IT Services Development</option>"); 
        out.print("<option value=\"Support and Security department\">Support and Security department</option>");
        out.print("</select>");  
        out.print("</td></tr>");
        
        
        out.print("<tr><td>Skills:</td><td> ");
        out.print("<input type='checkbox' name='box' value='Java'>");
        out.print("<label>Java</label> <br>");
        out.print("<input type='checkbox' name='box' value='PHP'>");
        out.print("<label>PHP</label>  <br>");
        out.print("<input type='checkbox' name='box' value='C#'>");
        out.print("	<label>C#</label>   <br>");
        out.print("<input type='checkbox' name='box' value='JavaScript'>");
        out.print("<label>Javascript</label> <br>");
        out.print("<input type='checkbox' name='box' value='Flutter'>");
        out.print("<label>Flutter</label> <br>");
        out.print("<input type='checkbox' name='box' value='Ruby'>");
        out.print("	<label>Ruby</label> <br>");
        out.print("	<input type='checkbox' name='box' value='Go'>");
        out.print("<label>Go</label> <br>");
        out.print("</table> <br> <br>");
        
        
        out.print("<input type='submit' value='Edit & Save '/>");  
        out.print("<br></form></center>");  
            
    }  
}   