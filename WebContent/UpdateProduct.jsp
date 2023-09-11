<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<table align="center" border="2">
		<tr>
			<th>Product_Name</th>
			<th>Product_Desc</th>
			<th>Product_Price</th>
		</tr>

		<%
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/psdata?useSSL=false&allowPublicKeyRetrieval=true", "root", "admin");
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery("select * from productdetails");
			int flag = 0;
			while (res.next()) {
				String pname = res.getString("productname");
				String pdesc = res.getString("productdesc");
				String price = res.getString("productprice");
				System.out.println(pname + " " + pdesc + " " + price);
		%>
		<tr>
			<td><%=pname%></td>
			<td><%=pdesc%></td>
			<td><%=price%></td>
			<td><a
				href="editProduct.jsp?proname=<%=pname%>&prodesc=<%=pdesc%> &proprice=<%=price%>">Edit</a></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>