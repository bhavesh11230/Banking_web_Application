package bankingwebtemp.services;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bankingwebtemp.db.ConnectDB;


public class AddUser extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public AddUser() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection con = ConnectDB.dbCon();
        try {
            String aname = request.getParameter("aname");
            String amob = request.getParameter("amob");
            String acity = request.getParameter("acity");
            double abal = Double.parseDouble(request.getParameter("abal"));

            String sql = "INSERT INTO users (aname, amob, acity, abal) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, aname);
            ps.setString(2, amob);
            ps.setString(3, acity);
            ps.setDouble(4, abal);

            int i = ps.executeUpdate();
            if (i > 0) {
                response.sendRedirect("viewAccount.jsp");
            } else {
                response.sendRedirect("addAccount.html");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }
}
