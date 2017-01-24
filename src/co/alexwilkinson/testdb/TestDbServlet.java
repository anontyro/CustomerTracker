package co.alexwilkinson.testdb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 * Servlet implementation class TestDbServlet
 */
@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//setup connection vars
		String user = "root";
		String pass = "root";
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false"; 
		
		String driver = "com.mysql.jdbc.Driver";
		
		//get database connection
		try{
			
			PrintWriter out = response.getWriter();
			
			out.println("connection to database: " +jdbcUrl + "<br>");
			
			Class.forName(driver);
			
			Connection myCon = DriverManager.getConnection(jdbcUrl, user, pass);
			
			out.println("Connected");
			
			myCon.close();
			
		}catch(Exception ex){
			ex.getStackTrace();
		}
		
	}

	
	
	
	
	
	
	
}
