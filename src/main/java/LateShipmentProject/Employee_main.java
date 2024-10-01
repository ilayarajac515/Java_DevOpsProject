package LateShipmentProject;

import java.util.*;  
import java.sql.*;  
  
public class Employee_main{  
  
    public static Connection getConnection(){  
        
    	Connection con=null;  
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Emp_db","root","root");  
        }catch(Exception e)
        {
        	System.out.println(e);
        }  
       
        return con;  
    }  
    
    
    
    public static void save(Employee_class e){  
   
        try{  
            Connection con=Employee_main.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "insert into employee(employee_name,employee_email,employee_phone_number,employee_department,employee_skills) values (?,?,?,?,?)");  
            ps.setString(1,e.getEmployee_name());  
            ps.setString(2,e.getEmployee_email());  
            ps.setLong(3,e.getEmployee_phone_number());  
            ps.setString(4,e.getDepartment());  
            ps.setString(5,e.getSkills());
              
            ps.executeUpdate();    
        }catch(Exception ex)
        {
        	ex.printStackTrace();  
        }
          
    }  
    
    
    
    public static int update(Employee_class e){  
        int status=0;  
        try{  
            Connection con=Employee_main.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "update employee set employee_name=?,employee_email=?,employee_phone_number=?,employee_department=?,employee_skills=? where employee_id=?");  
            ps.setString(1,e.getEmployee_name());  
            ps.setString(2,e.getEmployee_email());  
            ps.setLong(3,e.getEmployee_phone_number());  
            ps.setString(4,e.getDepartment());  
            ps.setString(5,e.getSkills());  
            ps.setInt(6,e.getEmployee_id());
              
            status=ps.executeUpdate();  
              
        }catch(Exception ex)
        {
        	ex.printStackTrace();
        }  
          
        return status;  
    }
    
    public static Employee_class getEmployeeById(int id){  
        Employee_class e=new Employee_class();  
          
        try{  
            Connection con=Employee_main.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from employee where employee_id=?");  
            ps.setInt(1,id);  
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
                e.setEmployee_id(rs.getInt(1));  
                e.setEmployee_name(rs.getString(2));  
                e.setEmployee_email(rs.getString(3));  
                e.setEmployee_phone_number(rs.getLong(4));  
                e.setDepartment(rs.getString(5)); 
                e.setSkills(rs.getString(6));
            }  
            
        }catch(Exception ex)
        {
        	ex.printStackTrace();
        }  
          
        return e;  
    }  
    
    public static void delete(int id){  
        try{ 
        	
            Connection con=Employee_main.getConnection();  
            PreparedStatement ps=con.prepareStatement("delete from employee where employee_id=?");  
            ps.setInt(1,id);  
            
            ps.executeUpdate();  
              
            
        }catch(Exception e)
        {
        	e.printStackTrace();
        }  
          
          
    }  
    
    public static List<Employee_class> getAllEmployees(){  
        List<Employee_class> list=new ArrayList<Employee_class>();  
          
        try{  
            Connection con=Employee_main.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from employee");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
            	Employee_class e=new Employee_class ();  
                e.setEmployee_id(rs.getInt(1));  
                e.setEmployee_name(rs.getString(2));  
                e.setEmployee_email(rs.getString(3));  
                e.setEmployee_phone_number(rs.getLong(4));  
                e.setDepartment(rs.getString(5));
                e.setSkills(rs.getString(6)); 
                list.add(e);  
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
    }  
}