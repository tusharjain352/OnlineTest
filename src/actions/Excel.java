package actions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.*;

import dao.DBCon;
/**
 * Servlet implementation class Excel
 */
@WebServlet("/Excel")
public class Excel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Excel() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	try{
	
		 Connection conn = DBCon.getDBCon();
         Statement stmt = conn.createStatement();
         
         /* Create Workbook and Worksheet objects */
         
         HSSFWorkbook new_workbook = new HSSFWorkbook(); //create a blank workbook object
         
         HSSFSheet sheet = new_workbook.createSheet("Dept_Details");  //create a worksheet with caption score_details
         /* Define the SQL query */
         
         ResultSet query_set = stmt.executeQuery("select name,score from resulttable");
         /* Create Map for Excel Data */
         
         Map<String, Object[]> excel_data = new HashMap<String, Object[]>(); //create a map and define data
         
         int row_counter=0;
         /* Populate data into the Map */
         
         while (query_set.next()) {
                         row_counter=row_counter+1;
                         String un = query_set.getString("name");
                         String up=query_set.getString("score");
                         excel_data.put(Integer.toString(row_counter), new Object[] {un, up});
                         }
         /* Close all DB related objects */
         query_set.close();
         stmt.close(); 
         conn.close();
         
         /* Load data into logical worksheet */           
         Set<String> keyset = excel_data.keySet();
         int rownum = 0;
         for (String key : keyset) { //loop through the data and add them to the cell
                 Row row = sheet.createRow(rownum++);
                 Object [] objArr = excel_data.get(key);
                 int cellnum = 0;
                 for (Object obj : objArr) {
                         Cell cell = row.createCell(cellnum++);
                         if(obj instanceof Double)
                                 cell.setCellValue((Double)obj);
                         else
                                 cell.setCellValue((String)obj);
                         }
         }

         FileOutputStream output_file = new FileOutputStream(new File("POI_XLS_JDBC.xls")); //create XLS file
         new_workbook.write(output_file);//write excel document to output stream
         output_file.close(); //close the file
	
	}
	catch(Exception e){
		e.printStackTrace();
	}
	
         /*response.setContentType("text/html");  
         PrintWriter out = response.getWriter();  
         String filename = "home.jsp";   
         String filepath = "e:\\";   
         response.setContentType("APPLICATION/OCTET-STREAM");   
         response.setHeader("Content-Disposition","attachment; filename=\"" + filename + "\"");   
           
         FileInputStream fileInputStream = new FileInputStream(filepath + filename);  
                     
         int i;   
         while ((i=fileInputStream.read()) != -1) {  
         out.write(i);   
         }   
         fileInputStream.close();   
         out.close();   
         */
         
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	doGet(request, response);
	
	}

}
