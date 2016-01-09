package desafio.twitterNovo;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TweetPage {

	private WebDriver driver;
	private WebDriverWait wait;
	
	public TweetPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 10);
	}
	
	public void deletarTweet(){
		WebElement profileLink = driver.findElement(By.xpath("//a[contains(@class, 'DashboardProfileCard-screennameLink')]"));
		profileLink.click();
		WebElement tweetPagina = driver.findElement(By.xpath("//div//small//a[1]"));
		WebElement menuRemover = driver.findElement(By.xpath("(//div[contains(@class, 'ProfileTweet-action--more')])[1]//li[contains(@class, 'js-actionDelete')][1]//button"));
		WebElement botaoRemover = driver.findElement(By.xpath("//li[@class='js-actionDelete']//button"));
		WebElement botaoFinalRemover = driver.findElement(By.className("delete-action"));
		tweetPagina.click();
		menuRemover.click();	
		botaoRemover.click();		
		botaoFinalRemover.click();		
	}
	
	public void assertTweetDeletadoSucesso(String message){
		String tweet = driver.findElement(By.xpath("(//div[contains(@class, 'original-tweet')])[1]//p")).getText();
		Assert.assertNotEquals(message, tweet);
	}
	
	private void waitForSeconds(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
