package desafio.twitterNovo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	private WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void logar(String user, String password){
		WebElement usuario = driver.findElement(By.xpath("//div[@id='front-container']/div[2]/div[2]/form/div/input"));
		WebElement senha = driver.findElement(By.xpath("//div[@id='front-container']/div[2]/div[2]/form/table/tbody/tr/td/div/input"));
		usuario.click();
		usuario.sendKeys(user);
		senha.click();
		senha.sendKeys(password);
		driver.findElement(By.xpath("//div[@id='front-container']/div[2]/div[2]/form/table/tbody/tr/td[2]/button")).click();	
	}

}
