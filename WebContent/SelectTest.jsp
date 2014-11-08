<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="actions.NiitTest"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="dao.DBCon"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>NIIT TEST CENTER</title>
</head>
<body>
<br/>

<% out.println("<font color='blue'><h1>Welcome To NIIT</h1></font>");

out.println("<font color='green'><h2>Select From The Following Tests</h2></font>");

%>
<% 
ArrayList <String> testList= NiitTest.showTest();

Iterator <String>  itr=testList.iterator();
String nt="";
while(itr.hasNext()){
	nt=itr.next();
	%>

	<a href="StartTest?testtype=<%=nt%>" ><% out.println("<font color='red'><h2>Click the Link Below For</h2></font>"+nt);%></a>

<%} %>
</body>
</html>