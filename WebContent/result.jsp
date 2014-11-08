<%@page import="dao.DBCon"%>
<%@page import="java.sql.*;" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<h1>Helooooo</h1>

<%
String id=(String)session.getAttribute("uname");
if(id.equals("")||id==null)
{
out.print("Id Does not exist");
%>

<jsp:include page="index.jsp"/>
<%
	}

else
{
Connection con=DBCon.getDBCon();
Statement st=con.createStatement();
ResultSet rs=st.executeQuery("select * from resulttable where id='"+id+"'");

rs.next();

int result=rs.getInt(2);

out.print("<h1>Your previous score is"+result+"</h1>");
}

%>


</body>
</html>