package bankingwebtemp.services;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bankingwebtemp.db.ConnectDB;

/**
 * Servlet implementation class LoginUser
 */
public class LoginUserr extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginUserr() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		try
		{
			Connection con = ConnectDB.dbCon();
			String amob = request.getParameter("amob");
			String apassword = (request.getParameter("apassword"));
			
//			PreparedStatement ps = con.prepareStatement("select * from users where aname=? and amob=?");
//			ps.setString(1, aname);
//			ps.setString(2, amob);
//			ResultSet rs = ps.executeQuery();
			if(amob.equals("8180050048") && apassword.equals("2004"))
			{
				response.sendRedirect("viewAccount.jsp");
			}
			else
			{
				response.sendRedirect("login.html"); 
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
