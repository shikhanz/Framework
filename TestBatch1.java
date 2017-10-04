package test2;

import org.testng.annotations.Test;

import pageObj2.Page1;
import core2.BrowserFunctions;

public class TestBatch1 extends  BrowserFunctions{
  @Test(priority=0,dataProviderClass=dataprovider2.Data1.class, dataProvider="mydata")
  public void f(String x, int y, String b) {
	  System.out.println("hii");
	  System.out.println(x);
	  System.out.println(y);
	  System.out.println(b);
  }
  
  @Test(priority=1, description= "1. Click reg button, 2. Type Email,Password,Ph 3. Click Signup button")
  public void invalidreg1(){
	  Page1 ob= new Page1(driver);
	  ob.clickRegBtn();
	  ob.typeEmail("xyz");
	  ob.typePass("12345");
	  ob.typePh("9999999");
	  ob.clickSignup();
	  assert ob.fetchTitle().equalsIgnoreCase("Shine.com - Free  with Linkedin Connect"):"Should be on same reg page";
  }
  
/*  @Test(priority=2, description= "1. Click reg button, 2. Type Email,Password,Ph 3. Click Signup button",dataProviderClass=dataprovider2.Data1.class, dataProvider="databaseData")
  public void invalidreg2(String x, String y, String z){
	  Page1 ob= new Page1(driver);
	 // ob.clickRegBtn();
	  ob.typeEmail(x);
	  ob.typePass(y);
	  ob.typePh(z);
	  ob.clickSignup();
	  assert ob.fetchTitle().equalsIgnoreCase("Shine.com - Free Register with Linkedin Connect"):"Should be on same reg page";
  }
  */
  @Test(priority=3, description= "1. Click reg button, 2. Type Email,Password,Ph 3. Click Sihnup button",dataProviderClass=dataprovider2.Data1.class, dataProvider="excelData")
  public void invalidreg2(String x, String y){
	  Page1 ob= new Page1(driver);
	  ob.typeEmail(x);
	  ob.typePass(y);
	  ob.clickSignup();
	  assert ob.fetchTitle().equalsIgnoreCase("Shine.com - Free Register with Linkedin Connect"):"Should be on same reg page";
  }
  
}
