//package cscorner;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter out=response.getWriter();
			response.setContentType("text/html");
			Class.forName("com.mysql.jdbc.Driver");
			
			//java.sql.Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shantanu","root","cscorner@1234");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shantanu","root","Project@1234");
			String n=request.getParameter("name");
			String p=request.getParameter("password1");
		
			//PreparedStatement ps= con.prepareStatement("select uname from login where uname=? and password=?");
			PreparedStatement ps= con.prepareStatement("select * from shantanu where uname=? and password1=?"); //(shantanu/shantanu1 :> Table)
			ps.setString(1, n);
			ps.setString(2, p);
			ResultSet rs =ps.executeQuery();
			if(rs.next())
			{
				//
				HttpSession hs=request.getSession();
				hs.setAttribute("uname", n);
				//
				RequestDispatcher rd= request.getRequestDispatcher("welcome.jsp");
				rd.forward(request, response);
			}
			else 
			{
				out.println("<font color=red size=18>Login Failed!!<br>");
				out.println("<font color=red size=18>May be you are not registerd !!<br>");
				out.println("<a href=login.jsp>Try AGAIN!!</a>");
			}
			
			con.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		};
	}

}
