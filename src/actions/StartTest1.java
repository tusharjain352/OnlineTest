package actions;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
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
 * Servlet implementation class StartTest
 */
@WebServlet("/StartTest1")
public class StartTest1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StartTest1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con=DBCon.getDBCon();	
		try {
			Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet testQuestionResultSet=st.executeQuery("select * from "+request.getParameter("testtype")+"");
	       HttpSession hp=request.getSession();
	       hp.setAttribute("testQuestion",testQuestionResultSet);
	       hp.setAttribute("testtype", request.getParameter("testtype"));
	       
	       RequestDispatcher rd=request.getRequestDispatcher("StartTest.jsp");
	       
	       rd.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


	

}
