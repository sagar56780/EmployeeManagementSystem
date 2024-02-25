package employeManagement.model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import employeManagement.model.dto.Employee;





public class EmployeeDao  {

		 
		String url;
		String user;
		String password;
		FileInputStream fis;
		Connection con;
		PreparedStatement ps;
		Statement st;
		ResultSet rs;
		Properties property=new Properties();
		public static void main(String[] args) {
			EmployeeDao deo=new EmployeeDao();
			Employee  e=new Employee();
			e.setId(100);
			e.setPassword("sag");
			System.out.println(deo.adminloginValidate(e)
);		}
		{
			try {
			Class.forName("org.postgresql.Driver");
			fis=new FileInputStream("D:\\e\\new adv java\\employeManagement\\db_config.properties");
			property.load(fis);
			url=property.getProperty("url");
			System.out.println("chek");
			con=DriverManager.getConnection(url,property);
			
			System.out.println("Connection established");
			
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("class not found exception");
				e.printStackTrace();
			}
			catch(FileNotFoundException f)
			{
				System.out.println("file not found");	
			}
			catch(IOException io)
			{
				System.out.println("io excetpion");	
			}
			catch(SQLException sql)
			{
				
			}
		}
		public boolean loginEmployee(int id,String password)
		{
			String querry="select id, password from employee where (id=? and password=? )";
			
			try {
				ps=con.prepareStatement(querry);
				ps.setInt(1, id);
				ps.setString(2, password);
			ResultSet rs= ps.executeQuery();
			if(rs!=null)
			{
				return true;
			}
			else {
				return false;
			}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			return false;
		}
		public List<Employee> viewAllEmployee()
		{
			List<Employee> li=new ArrayList<Employee>();
			String qurrry="select * from employee";
			try {
				ps=con.prepareStatement(qurrry);
				rs=ps.executeQuery();
				while(rs.next())
				{ 
					Employee e=new Employee();
					e.setId(rs.getInt(1));
					e.setName(rs.getString(2));
					e.setSalary(rs.getDouble(3));
					e.setNumber(rs.getLong(4));
					e.setPassword(rs.getString(5));
					e.setRoll(rs.getString(6));
					li.add(e);
					
			
					
				}
				return li;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			return null;
		}
		public boolean addEmploye(Employee e)
		{try {
	String querry="insert into employee values(?,?,?,?,?,?)";
			ps=con.prepareStatement(querry);
			ps.setInt(1, e.getId());
			ps.setString(2, e.getName());
			ps.setDouble(3, e.getSalary());
			ps.setLong(4,e.getNumber());
			ps.setString(5, e.getPassword());
			ps.setString(6, e.getRoll());
			  	ps.execute();
			  	return true;
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				return false;
			}
		}
		public Employee viewEmployee(int id)
		{
			String querry="select * from employee where id=? and roll=?";
			try {
				ps= con.prepareStatement(querry);
				ps.setInt(1, id);
				ps.setString(2, "employee");
				
				rs=ps.executeQuery();
				Employee e1=new Employee();
				
				while(rs.next())
				{
					e1.setId(rs.getInt(1));
					e1.setName(rs.getString(2));
					e1.setSalary(rs.getDouble(3));
					e1.setNumber(rs.getLong(4));
					e1.setPassword(rs.getString(5));
					e1.setRoll(rs.getString(6));
					
				return e1;
					
				}
				return null;
				
			
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		
		}
		public boolean updateAll(Employee e)
		{
			String querry="update employee set name=?,salary=?, number=?,password=?, roll=? where id=? and roll=?" ;
			try {ps=con.prepareStatement(querry);
				
				ps.setInt(6, e.getId());
				ps.setString(1, e.getName());
				ps.setDouble(2, e.getSalary());
				ps.setLong(3,e.getNumber());
				ps.setString(4, e.getPassword());
				ps.setString(5, e.getRoll());
				ps.setString(6, "employee");
				
				
			 if(0<ps.executeUpdate())
			 {
				
				 return true;
			 }
			 
			 else {
				 
				 return false;
			 }
			
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				
				e1.printStackTrace();
				return false;
			}
		}
		public boolean removeEmployee(int id)
		{
		  try {
			  String querry="delete from employee where id=? and roll=?";
			ps=con.prepareStatement(querry);
			ps.setInt(1, id);
			ps.setString(2, "employee");
			
		 
			int res= ps.executeUpdate();
			if(res>0)
			{
				return true;
			}
			else {
				return false;
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false;
		}
			
		}
		public Employee viewallDetail(int id) 
		{
			String querry="select * from employee where id=? and roll=?";
			try {
				
			ps=con.prepareStatement(querry);
			ps.setInt(1, id);
			ps.setString(2, "employee");
			
				rs=ps.executeQuery();
			
			
			if(rs.next())
			{
				return new Employee(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getLong(4),rs.getString(5),rs.getString(6));
				
			}
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
					
		}
		public boolean adminloginValidate(Employee e)  {
			PreparedStatement ps;
			ResultSet rs;
			String querry="select password,roll from employee where id=?";
			try {
				ps=con.prepareStatement(querry);
				ps.setInt(1, e.getId());
				rs=ps.executeQuery();
				if(rs.next())
				{ 
					if(rs.getString(1).equals(e.getPassword())&&rs.getString(2).equalsIgnoreCase("admin"))
					{
						return true;
					}
					else {
						return false;
					}
				}
				else
				{
					return false;
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return false;
			
			
		
		}
		public boolean updatePassword(int id,String cur_password, String new_password, String confirmPassword) {
			String querry="select password from employee where id='"+id+"' and password='"+cur_password+"'";
			try {
				st=con.createStatement();
				rs=st.executeQuery(querry);
				if(rs.next())
				{
					String password=rs.getString(1);
					if(password.equals(cur_password))
					{ 
						int res=st.executeUpdate("update employee set password='"+new_password+"'");
							if(res>0)
							{	
								return true;
							}
							else
							{
								return false;
							}
					}
					else
					{
						return false;
					}
				}
				else {
					return false;
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			return false;
			
		}
		
		

}
