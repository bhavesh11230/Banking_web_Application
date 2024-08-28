package bankingwebtemp.services;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bankingwebtemp.db.ConnectDB;

/**
 * Servlet implementation class AmountDeposit
 */
public class AmountDeposit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AmountDeposit() {
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
		float damount;
		float abal = 0;
		Connection con = ConnectDB.dbCon();
		try
		{
			int ano =Integer.parseInt( request.getParameter("ano"));
			damount = Float.parseFloat(request.getParameter("damount"));
			if(damount>=0)
			{
				
				PreparedStatement ps = con.prepareStatement("select abal from users where ano=?");
				ps.setInt(1, ano);
				ResultSet rs = ps.executeQuery();
				while(rs.next())
				{
					if(damount>0)
					{
						abal = rs.getFloat(1);
						abal = abal + damount;
						PreparedStatement ps1 = con.prepareStatement("update users set abal=? where ano=?");
						ps1.setFloat(1, abal);
						ps1.setInt(2, ano);
						int i = ps1.executeUpdate();
						if(i>0)
						{
							response.sendRedirect("depositsuccessful.html");
						}
						else
						{
							response.sendRedirect("deposit.html");
						}
					}
				}
			}
			else
			{
				response.sendRedirect("deposit.html");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
