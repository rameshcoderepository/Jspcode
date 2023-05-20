package validate;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddUser")
public class AddUser extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		String user = request.getParameter("uname");
		String pass = request.getParameter("pwd");

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/psdata?useSSL=false&allowPublicKeyRetrieval=true", "root", "admin");
			Statement stmt = con.createStatement();
			int res = stmt
					.executeUpdate("insert into register(username,password) values('" + user + "','" + pass + "')");
			if (res == 1) {
				out.println("insert sucess");
			}

		} catch (ClassNotFoundException e) {

		} catch (SQLException e) {

		}

	}

}
