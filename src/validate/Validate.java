package validate;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Validate")
public class Validate extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		String user = request.getParameter("uname");
		String pass = request.getParameter("pwd");

		if (user.equals("admin") && pass.equals("admin123")) {
			out.println("welcome Admin");
			HttpSession session = request.getSession(true);
			session.setAttribute("username", user);
			RequestDispatcher rd = request.getRequestDispatcher("AdminHome.jsp");
			rd.forward(request, response);
		} else {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/psdata?useSSL=false&allowPublicKeyRetrieval=true", "root",
						"admin");
				Statement stmt = con.createStatement();
				ResultSet res = stmt.executeQuery("select * from register");
				int flag = 0;
				while (res.next()) {

					String usrdb = res.getString("username");
					String pwddb = res.getString("password");

					if (usrdb.equals(user) && pwddb.equals(pass)) {
						out.println("welcome User");

						flag = 1;

						HttpSession session = request.getSession(true);
						session.setAttribute("username", user);
						RequestDispatcher rd = request.getRequestDispatcher("UserHome.jsp");
						rd.forward(request, response);
					}
				}
				if (flag == 0) {
					out.println("sorry");
					RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
					rd.include(request, response);
				}

			} catch (ClassNotFoundException e) {
				System.out.println(e.getMessage());
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}

		}

	}

}
