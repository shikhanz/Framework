package pageObj2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import core2.ActionDriver;

public class Page1 extends ActionDriver{
	public Page1(WebDriver driver) {
		super(driver);
	}
	
	
	String reg="(//a[contains(text(),'Register')])[1]";
	String email="id_email";
	String pass="Password";
	String ph="id_cell_phone";
	String signup="//button[contains(text(),'Sign up')]";
	//String title="//title";

	

	public By getReg(){
		return By.xpath(reg);
	}
	
	public By getemail(){
		return By.id(email);
	}
	public By getPass(){
		return By.id(pass);
	}
	
	public By getPh(){
		return By.id(ph);
	}
	
	public By getSignup(){
		return By.xpath(signup);
    }
	
	/*************************/
	
	public void clickRegBtn(){
		click(getReg());
	}
	
	public void typePass(String value){
		type(getPass(),value);
	}
	
	public void typeEmail(String value){
		type(getemail(),value);
	}
	
	public void typePh(String value){
		type(getPh(),value);
	}
	
	public void clickSignup(){
	click(getSignup());
	
    }
	
	public String fetchTitle(){
		String pgTitle= title();
		return pgTitle;
	}
}
 