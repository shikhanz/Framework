package dataprovider2;

import java.io.File;
import java.sql.SQLException;
import java.util.List;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

import database.Database;
import excel.ExcelHandler;

public class Data1 {
	@DataProvider
	public static Object[][] mydata(ITestContext context ){
		String b=context.getCurrentXmlTest().getParameter("value1");
		String s = "str";
		int a= 12;
		//System.out.println(b);
		return new Object[][] {{s,a,b}};
	}

	@DataProvider
	public static Object[][] databaseData() throws ClassNotFoundException, SQLException{
		Database db =new Database();
		String query="Select email,password, ph from regis where 1=1";
		List<String> email = db.executeQuery(query, "email");
		List<String> pass = db.executeQuery(query, "password");
		List<String> ph = db.executeQuery(query, "ph");
		return new Object[][] {{ email.get(0), pass.get(0),ph.get(0)}};
	}
	
	@DataProvider
	public static Object[][] excelData(ITestContext context) throws Exception{
		String excelLocation=context.getCurrentXmlTest().getParameter("excelLoc");
		String sheet=context.getCurrentXmlTest().getParameter("sheetName");
		ExcelHandler excel1=new ExcelHandler(new File(excelLocation));
		excel1.selectSheet(sheet);
		String x=excel1.getCellData(1,3).getContents();
		String y= excel1.getCellData(2,3).getContents();
		return new Object[][] {{x,y}};
		
	}
     
}
