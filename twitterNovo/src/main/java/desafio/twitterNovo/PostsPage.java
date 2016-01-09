package desafio.twitterNovo;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.*;

public class PostsPage {

	private WebDriver driver;
		
	public PostsPage(WebDriver driver) {
		this.driver = driver;
	}

	public void twittar(String message){
		WebElement campoNovoTweet = driver.findElement(By.xpath("//div[@id='tweet-box-home-timeline']"));
		WebElement botaoTweet = driver.findElement(By.xpath("(//div[contains(@class, 'tweet-button')])[1]//button"));
		campoNovoTweet.click();		
		campoNovoTweet.sendKeys(message);
		waitForSeconds(2);
		botaoTweet.click();
		waitForSeconds(2);
		
	}
	
	public void assertTweetPublicadoSucesso(String message){
		String tweet = driver.findElement(By.xpath("(//div[contains(@class, 'original-tweet')])[1]//p")).getText();
		assertEquals(message, tweet);
		waitForSeconds(2);
	}
	
	public void deletarTweetTimeline() {
		WebElement botaoDeletePrincipal = driver.findElement(By.xpath("(//div[contains(@class, 'ProfileTweet-action--more')])[1]"));
		botaoDeletePrincipal.click();
		WebElement botaoDeleteMenor = driver.findElement(By.xpath("(//div[contains(@class, 'ProfileTweet-action--more')])[1]//li[contains(@class, 'js-actionDelete')][1]//button"));
		botaoDeleteMenor.click();
		waitForSeconds(2);
		WebElement botaoRemoverFinal = driver.findElement(By.className("delete-action"));
		botaoRemoverFinal.click();
		waitForSeconds(3);
		//driver.findElement(By.linkText("Home")).click();
		waitForSeconds(2);
	}
	
	public void assertTweetDeletadoSucesso(String message){
		String tweet = driver.findElement(By.xpath("(//div[contains(@class, 'original-tweet')])[1]//p")).getText();
		Assert.assertNotEquals(message, tweet);
	}
	
	public void assertMensagemErroTweetMesmoTexto(){
		String mensagemNotificacao = driver.findElement(By.className("message-text")).getText();
		Assert.assertEquals("You have already sent this Tweet.", mensagemNotificacao);
	}
	
	public void getProfilePage() {
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		WebElement profileLink = driver.findElement(By.xpath("//a[contains(@class, 'DashboardProfileCard-screennameLink')]"));
		profileLink.click();
	}
	
	public void getHome(){
		WebElement home = driver.findElement(By.linkText("Home"));
		home.click();
	}
	
	private void waitForSeconds(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
