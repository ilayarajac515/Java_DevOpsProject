package LateShipmentProject;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Admin_And_Password_check")
public class Admin_And_Password_check extends HttpServlet {

	public static String username = "admin";
	public static String password = "admin@123";
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		
		PrintWriter z = res.getWriter();
		
		String name = req.getParameter("username");
		
		String pass = req.getParameter("password");
		
		if(name.equals(username))
		{
			if(pass.equals(password))
			{
				z.print("<html> <body> <center> <h1 style = 'color:lime;'> Login Successfully </h1> </center> </body> </html>");
				
				res.sendRedirect("SaveServlet.html");
				
				
//				RequestDispatcher c = req.getRequestDispatcher("SaveServlet.html");
//				c.forward(req, res);
				
			}else {
				z.print("<html> <body> <center> <h1 style='color:red;'> Login Failed </h1> </center> </body> </html>");
				
				RequestDispatcher x = req.getRequestDispatcher("index.html");
				x.include(req, res);
			}
		}
		else {
			z.print("<html> <body> <center> <h1 style='color:red;'> Login Failed </h1> </center> </body> </html>");
			
			RequestDispatcher x = req.getRequestDispatcher("index.html");
			x.include(req, res);
		}
		
		
	}
	
	
}
