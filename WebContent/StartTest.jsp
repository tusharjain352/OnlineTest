<%@page import="java.sql.ResultSet"%>
<%@page import="dao.DBCon"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>NIIT TEST CENTER</title>
</head>
<%! int a=1; 
int []testans=new int[20];
 
%>
<body>


<% 



ResultSet rs=(ResultSet)session.getAttribute("testQuestion");

if(request.getParameter("buttonSelected")!=null && request.getParameter("optionSelected")!=null)
{
	
	
	testans[a]=Integer.parseInt(request.getParameter("optionSelected"));
	if(request.getParameter("buttonSelected").equals("Next")){
		a++;
	}

}

rs.absolute(a);

%>
<form action="StartTest.jsp" method="get">
Q-<%=a %> : <%=rs.getString(2) %> ?
<br/>
<input type="radio" name="optionSelected" value="1"  <%if(testans[a]==1){ %> checked="checked" <% }%>     ><%=rs.getString(3) %>
<br/>
<input type="radio" name="optionSelected" value="2"    <%if(testans[a]==2){ %> checked="checked" <% }%>    ><%=rs.getString(4) %>
<br/>
<input type="radio" name="optionSelected" value="3"    <%if(testans[a]==3){ %> checked="checked" <% }%>   ><%=rs.getString(5) %>
<br/>
<input type="radio" name="optionSelected" value="4"      <%if(testans[a]==4){ %> checked="checked" <% }%>   ><%=rs.getString(6) %>
<br/>
<%if(a<19){ %>
<input type="submit" name="buttonSelected" value="Next">
<%}%>


<% 

if(a==19){
%>
<input type="submit" name="buttonSelected" value="FINISH">
<%
if(request.getParameter("buttonSelected")!=null && request.getParameter("optionSelected")!=null)
{
	
	session.setAttribute("answers",testans);
	if(request.getParameter("buttonSelected").equals("FINISH"))
	{
	RequestDispatcher rd=request.getRequestDispatcher("result");
	rd.forward(request,response);
	
	
	
	}

}


} %>

</form>



</body>
</html>