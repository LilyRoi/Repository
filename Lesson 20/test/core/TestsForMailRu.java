package core;

import org.testng.annotations.Test;

import pages2.MailsPage;
import pages2.LoginPage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class TestsForMailRu {

	private WebDriver driver;
	private pages2.MailsPage mailsPage;
	private LoginPage loginPage;
	private static final String Url = "https://mail.ru/";
	private static final String email = "antonyourkevich09";
	private static final String password = "antonigorevichanton";	

	@BeforeClass
	public void beforeClass() {
		//String exePath = "c:\\Home\\QA\\chromedriver_win32\\chromedriver.exe";
		//System.setProperty("webdriver.chrome.driver", exePath);

		System.out.println("Test class TestsForMailRu is started.");		
	}

	@AfterClass
	public void afterClass() {
		System.out.println("Test class TestsForMailRu is ended.");

	}

	@BeforeMethod
	public void beforeMethod() {
		driver = new ChromeDriver();
		loginPage = new LoginPage(driver);
		mailsPage = new pages2.MailsPage(driver);
		loginPage.setPropertyWindow();
	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
	}
	
	@Test(priority = 4)
	public void testMoveToSpamFolder() {
		loginPage.login(Url, email, password);
		mailsPage.moveMailToSpam();
		Assert.assertTrue(mailsPage.isAddedToSpamAlertPresent());
	}
	
	@Test(priority = 5)
	public void testReturnFromSpamFolder() {
		loginPage.login(Url, email, password);
		mailsPage.goToSpam();		
		mailsPage.returnMailFromSpam();
		Assert.assertTrue(mailsPage.isMoveFromSpamAlertPresent());
	}
	
	@Test(priority = 1)
	public void testSendMessages() {
		loginPage.login(Url, email, password);
		String[] sendToEmails = { "test1@test.com;", "test2@test.com;", "test3@test.com" };
		String topic = "Topic";
		String text = "Test text for email.";
		mailsPage.sendMails(Arrays.asList(sendToEmails), topic, text);
		String expectedMessage = "Ваше письмо отправлено. Перейти во Входящие";
		Assert.assertEquals(expectedMessage, mailsPage.getMessageSentTitle());
	}
	
	@Test(priority = 2)
	public void testFlagging3Mails() {
		loginPage.login(Url, email, password);
		Assert.assertTrue(mailsPage.checkboxList.size() > 3, "Not enough mails to flag!");
		int numberMarked = 3;
		mailsPage.markFlagOfFirst(numberMarked);
		Assert.assertEquals(mailsPage.flagsList.size(), numberMarked);
	}
	
	@Test(priority = 3)
	public void testDeselectAllFlags() {
		loginPage.login(Url, email, password);
		mailsPage.removeAllFlag();
		Assert.assertFalse(mailsPage.flagsList.size() > 0);
	}

}
