package actions;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import dao.DBCon;;

public class NiitTest {
	
	private static ArrayList<String> testList;
	static{
		testList=new ArrayList<String>(5);
	}

public static ArrayList<String> getTestestListist() {
		return testList;
	}


	public static void setTestestListist(ArrayList<String> testestListist) {
		NiitTest.testList = testestListist;
	}


public static ArrayList<String> showTest() throws SQLException{
Connection con=DBCon.getDBCon();	
	Statement st=con.createStatement();
	ResultSet testestLististResultSet=st.executeQuery("select * from niittest");
	if(testList.size()==0){
	while(testestLististResultSet.next()){
		String s=testestLististResultSet.getString(2);
	testList.add(s);
		
		}}
	
	return testList;
	}



}
