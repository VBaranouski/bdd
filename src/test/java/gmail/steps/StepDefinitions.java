package gmail.steps;

import static org.junit.Assert.assertEquals;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import gmail.utils.Browser;


public class StepDefinitions extends Browser {

	private String firstUserEmail = "Vlad.autotest3@gmail.com";
	private String secondUserEmail = "Vlad.autotest4@gmail.com";
	private String password = "barvadya18";
	private String emailSubject = "Hey Hey Hey";
	
	private static final Logger LOGGER = Logger.getLogger(StepDefinitions.class);
		
	
	@Before
	public static void openChrome(){
        Browser.initChromeBrowser();
    }
	
	@After
	public static void closeChrome(){
        Browser.closeDriver();
        LOGGER.info("Browser closed");
    }
	
	
	@Given("^I logged in with the first user$")
	public void iLoggedInWithTheFirstUser() throws Throwable {
		driver.get("https://mail.google.com");
		LOGGER.info("page opens");
		driver.findElement(By.id("Email")).sendKeys(firstUserEmail);
		driver.findElement(By.xpath("//*[@id='next']")).click();
		driver.findElement(By.xpath("//*[@id='Passwd']")).sendKeys(password);
		driver.findElement(By.id("signIn")).click();
		LOGGER.info("Login with first user was successful");
	}

	@Then("^I click Compose button$")
	public void iClickComposeButton() throws Throwable {
		driver.findElement(By.xpath("//*[.='COMPOSE']")).click();
	}	
	
	@Then("^I fill in To field with \"([^\"]*)\"$")
	public void iFillInToFieldWith(String email) throws Throwable {
		driver.findElement(By.name("to")).sendKeys(email);
	}

	@And("^I fill in subject field with \"([^\"]*)\"$")
	public void iFillInSubjectFieldWith(String subj) throws Throwable {
		driver.findElement(By.name("subjectbox")).sendKeys(subj);
	}
	
	@Then("^I click Send button$")
	public void iClickSendButton() throws Throwable {
		driver.findElement(By.xpath("//*[.='Send']")).click();	
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		LOGGER.info("Email has been sent");
	}

	@Given("^I logged in with the second user$")
	public void iLoggedInWithTheSecondUser() throws Throwable {
		driver.get("https://mail.google.com");
		driver.findElement(By.id("Email")).sendKeys(secondUserEmail);
		driver.findElement(By.xpath("//*[@id='next']")).click();
		driver.findElement(By.xpath("//*[@id='Passwd']")).sendKeys(password);
		driver.findElement(By.id("signIn")).click();
		LOGGER.info("Login with second user was successful");
	}

	@Then("^I check the recieved mail$")
	public void iCheckTheRecievedMail() throws Throwable {
		String actualSubject = driver.findElement(By.xpath("//*[@class = 'F cf zt']//tr[1]//td[6]")).getText();
		assertEquals(emailSubject, actualSubject);
		LOGGER.info("Email was found");
	}

	@Then("^I mark letter as spam$")
	public void iMarkLetterAsSpam() throws Throwable {
		driver.findElement(By.xpath("//*[@class = 'F cf zt']//tr[1]//td[4]")).click();
		driver.findElement(By.xpath("//*[@id=':5']/div[2]/div[1]/div/div[2]/div[2]")).click();
		LOGGER.info("Email marked as spam");
	}

	@Then("^I check spam folder$")
	public void iCheckSpamFolder() throws Throwable {
		driver.findElement(By.xpath("//*[@class='CJ']")).click();
		driver.findElement(By.xpath("//a[contains(@href,'/#spam')]")).click();
		LOGGER.info("Email was found in Spam folder");
			
	}
	

}
