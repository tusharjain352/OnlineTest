package actions;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DBCon;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public login() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	
	response.setContentType("text/html");
	PrintWriter out=response.getWriter();
	
	String un=request.getParameter("name");
	String up=request.getParameter("pwd");
	
	
	
	HttpSession ses=request.getSession();
	ses.setAttribute("uname",un);
	try{
	Connection con=DBCon.getDBCon();
	
	
	
	PreparedStatement ps=con.prepareStatement("select * from mylogin5 where name=? and password=?");
	ps.setString(1,un);
	ps.setString(2,up);
	ResultSet rs=ps.executeQuery();
	
	if(rs.next())
	{
		
		RequestDispatcher rd1=request.getRequestDispatcher("SelectTest.jsp");
		rd1.forward(request, response);
		
	}
	else
	{
		out.print("<font color='red'><h3>Sorry username or password is wrong<br>Please Try Again</h3></font>");
		RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
		rd.include(request, response);
		
	}
	
	
	
	
	}
	catch(Exception e){
		e.printStackTrace();
	}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
