package bankingwebtemp.db;

import java.sql.*;

public class ConnectDB {
	public static Connection con = null;
	public static Connection dbCon()
	{
		try
		{
			if(con==null)
			{
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/banking_web","root","");
				System.out.println("Connection Estblished - "+con);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}
}

