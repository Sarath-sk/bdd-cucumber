package stepDeffinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class Steps {
	WebDriver driver;
	
	public Steps() {
		System.setProperty("WebDriver.edge.driver", "C://Users//Sarath//Downloads//edgedriver_win64 (1)//msedgedriver.exe");
		driver = new EdgeDriver();
		PageFactory.initElements(driver, this);
		}
	
	
//	@FindBy(how=How.ID, using="APjFqb")
//	public WebElement search_bar;
	
	WebElement search_bar = driver.findElement(By.id("APjFqb"));
	
	@Given("^Navigate to google$")
	public void Navigate_To_Google() {
		System.setProperty("WebDriver.edge.driver", "C://Users//Sarath//Downloads//edgedriver_win64 (1)//msedgedriver.exe");
		
		driver.navigate().to("https://www.google.com");
	}
	
	@When("Search Something")
	public void Search_Something() {
		
		search_bar.sendKeys("healenium");
	}
	
	@And("Click Enter")
	public void Click_Enter() {
		search_bar.sendKeys(Keys.ENTER);
	}
	
	@Then("Validate results")
	public void Validate_Results() {
		WebElement Validation = driver.findElement(By.linkText("Healenium"));
		Assert.assertTrue(Validation.getText()=="Healenium");
	}
	

}
