

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.When;

//import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String fName = request.getParameter("name");
		String Password1 = request.getParameter("password1");
		String Password2 = request.getParameter("password2");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/shantanu", "root","Project@1234");
			java.sql.PreparedStatement ps_1 = con.prepareStatement("insert into shantanu values(?,?,?)");
			ps_1.setString(1, fName);
			ps_1.setString(2, Password1);
			ps_1.setString(3, Password2);
			
			int i=ps_1.executeUpdate();
			if(i>0) {
				out.print("You are successfully registerd");
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.include(request, response);
			}
			
//			if(Password1 == Password2) {
//				int i=ps_1.executeUpdate();
//				if(i>0) {
//					out.print("You are successfully registerd");
//					RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
//					rd.include(request, response);
//				}
//				
//			}
//			else {
//				out.print("Password1 and Password2 are not same.");
//			}
			
		} catch (Exception e) {
			out.println("exception occoured");
		}
		out.close();
	}

}
