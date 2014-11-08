package actions;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DBCon;

/**
 * Servlet implementation class result
 */
@WebServlet("/result")
public class result extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public result() {
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
		int count=0,score=0;
		HttpSession hp=request.getSession();
	String test=(String)hp.getAttribute("testtype");
	
	
	
	//out.print(test);
	int ans[]=(int [])hp.getAttribute("answers");
	ResultSet rs=null;
	
	
	String n=(String) hp.getAttribute("uname");
	String uid=(String)hp.getAttribute("uid");
	
	try{
		Connection con=DBCon.getDBCon();
		
		Statement st=con.createStatement();
		rs=st.executeQuery("select * from niittest where testtype='"+test+"'");
		rs.next();
		out.println("<br>");
		String answer=rs.getString(3);
		
		rs=st.executeQuery("select * from "+answer);
		while(rs.next())
		{
			if(rs.getInt(2)==ans[count++])
			{
				score++;
			}
			
			
		}
	
		
	PreparedStatement ps=con.prepareStatement("insert into resulttable values(?,?,?)");
	ps.setString(1, n);
	ps.setInt(2, score);
	ps.setString(3,uid);
	int i=ps.executeUpdate();
	
	}
	catch(Exception e){
		e.printStackTrace();
	}
	
	out.print("<h2><font color='red'>Congrats "+n+"!!! You have Successfully Completed Your Test</font></h2>");
	out.print("<h1>Your score is="+score+"</h1>");
	
	
	hp.invalidate();
	
	out.print("<a href='index.jsp'>click Here for LOGOUT</a>");
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	
	doGet(request, response);
	}

}
