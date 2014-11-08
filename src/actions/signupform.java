package actions;

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

import dao.DBCon;

/**
 * Servlet implementation class signupform
 */
@WebServlet("/signupform")
public class signupform extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public signupform() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	PrintWriter out=response.getWriter();
	response.setContentType("text/html");
	
	String un=request.getParameter("name");
	String uid=request.getParameter("userid");
	String up=request.getParameter("password");
	String um=request.getParameter("mobile");
	
	HttpSession ses=request.getSession();
	ses.setAttribute("uid", uid);
	
	RequestDispatcher rd=null;
	
	if((un==null)||(uid==null)||(up==null)||(um==null)||un.equals("")||uid.equals("")||up.equals("")||um.equals(""))
	{
		out.print("Please fill all the deatils");
		rd=request.getRequestDispatcher("signup.jsp");
		rd.include(request, response);
	}
	
	else{
	try{
		Connection conn=DBCon.getDBCon();
		PreparedStatement ps=conn.prepareStatement("insert into mylogin5 values(?,?,?,?)");
		ps.setString(1,un);
		ps.setString(2,uid);
		ps.setString(3,up);
		ps.setString(4,um);
	
		ps.executeUpdate();
	
		rd=request.getRequestDispatcher("SelectTest.jsp");
		rd.forward(request, response);
			
	}
	catch(Exception e){
		e.printStackTrace();
	}
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
