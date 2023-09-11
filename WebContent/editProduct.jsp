<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
		String productName = request.getParameter("proname");
		String productDesc = request.getParameter("prodesc");
		String productPrice = request.getParameter("proprice");
		System.out.println(productName + " " + productDesc + " " + productPrice);

		String value = (String) session.getAttribute("username");
	%>
	<form action="AddProduct" method="post" onsubmit="return myFunction()">
		<table align="center">

			<tr>
				<td></td>
				<td><input type="hidden" name="pname" id="pname"
					value="<%=value%>" readonly="readonly" /></td>
			</tr>
			<tr>
				<td>Product Name</td>
				<td><input type="text" name="pname" id="pname"
					value="<%=productName%>" readonly="readonly" /></td>
			</tr>

			<tr>
				<td>Product Desc</td>
				<td><input type="text" name="pdesc" id="pdesc"
					value="<%=productDesc%>" /></td>
			</tr>
			<tr>
				<td>Product Price</td>
				<td><input type="text" name="price" id="price"
					value="<%=productPrice%>" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Update" /></td>
			</tr>
		</table>
	</form>

</body>
</html>