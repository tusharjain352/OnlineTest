<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome TO NIIT TEST CENTER</title>
</head>
<body>

<font color='blue'><h1>Welcome to NIIT Test Center</h1></font>

<form action="login">

<fieldset>
<legend><h2>Student Login</h2></legend>
<table border="1">
<tr><td>Name:</td><td><input type="text" name="name"></td></tr><br>
<tr><td>Password</td><td><input type="password" name="pwd"></td></tr><br>
<tr><td><input type="submit" value="Login"></td></tr>
</table>

</fieldset>

</form>

<h2>New User!!!Sign Up Here</h2>
<h1><a href="signup.jsp">New User</a></h1>

<br>

<h2>Click Below To Generate Your report in Excel Format</h2>

<a href="Excel.java">Excel report</a>

</body>
</html>