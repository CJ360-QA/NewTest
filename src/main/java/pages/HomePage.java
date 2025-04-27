package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import baseClass.BaseClass;

public class HomePage extends BaseClass{
	
	
	public HomePage() {
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy (xpath="//div[@Type='text']") WebElement txtuser;
	@FindBy (xpath="//input[contains(@class,'name']") WebElement txtpass;
	@FindBy (xpath="//div//span[contains(text()='name']") WebElement sub;
	@FindBy (xpath="//input[starts-with(@class='name')]") WebElement dropdown ;
	@FindBy (xpath="//div[text()='name']") WebElement radio;
	@FindBy (xpath="//span[@type='name' and @class='mana']") List<WebElement>  dd;
	//@FindBy (xpath="") WebElement ;

	
	public void signup(String name, String pass) {
		
		txtuser.sendKeys(name);
		txtpass.sendKeys(pass);
		sub.click();
		
		Select slt=new Select(dropdown);
		slt.selectByVisibleText("indian");
		List<WebElement> opt=slt.getOptions();
		
		for(int i=0; i<opt.size(); i++) {
			String txt=opt.get(i).getText();
			
			if(txt.contains("indina") && opt.get(i).isEnabled() && !opt.get(i).isSelected()) {
				slt.selectByVisibleText(("indian"));
				
			}
		}
		radio.click();
		driver.switchTo().frame(radio);
		for(int i=0; i<dd.size(); i=i+2) {
			dd.get(i).click();
		}
	}
	
	public void verifyTitle() {
	Assert.assertEquals(driver.getTitle(), "chinmaya");
	Assert.assertTrue(sub.getText().contains(prop.getProperty("username")));

	}
}
