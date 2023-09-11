package prodcuts;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddProduct")
public class AddProduct extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String productName = request.getParameter("pname");
			String productDesc = request.getParameter("pdesc");
			String productPrice = request.getParameter("price");

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/psdata?useSSL=false&allowPublicKeyRetrieval=true", "root", "admin");
			Statement stmt = con.createStatement();

			int value = stmt.executeUpdate("insert into productdetails (productname,productdesc,productprice) values('"
					+ productName + "','" + productDesc + "','" + productPrice + "')");

			if (value == 1) {
				System.out.println("insert Sucessfully");
				RequestDispatcher rd = request.getRequestDispatcher("AdminHome.jsp");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
