package desafio.twitterNovo;

import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PostsPageTest {
	
	private static WebDriver driver;
	private static LoginPage loginPage;
	private static PostsPage postsPage;
	private static TweetPage tweetPage;
	
		
	@BeforeClass
	public static void testSetup() throws InterruptedException{
		driver = new FirefoxDriver();
		loginPage = new LoginPage(driver);
		postsPage = new PostsPage(driver);
		tweetPage = new TweetPage(driver);
		driver.get("http://twitter.com/");
		driver.manage().window().maximize();
		//Informar dados do usuário para começar os testes. (login, senha)
		loginPage.logar("", "");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
	}
		
	@Test
	public void aValidarNovoTweetComSucesso() {
		String mensagem = "teste";
		postsPage.twittar(mensagem);	
		postsPage.assertTweetPublicadoSucesso(mensagem);
	}
	
	@Test
	public void bValidarRemoverTweetTimeline() {
		String mensagem = "novo teste";
		postsPage.twittar(mensagem);
		postsPage.deletarTweetTimeline();
		postsPage.assertTweetDeletadoSucesso(mensagem);
	}
	
	@Test
	public void cValidarRemoverTweetTimelineUsuario() {
		postsPage.getProfilePage();
		postsPage.deletarTweetTimeline();
		postsPage.getHome();
	}
	
	@Test
	public void dValidarTweetTextoIgual(){
		String mensagem = "novo teste";
		postsPage.twittar(mensagem);
		postsPage.twittar(mensagem);
		postsPage.assertMensagemErroTweetMesmoTexto();		
	}	
	
	@AfterClass
	public static void testTearDown(){
		driver.close();
	}
	
	

}
