package core;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

import core.Credentials;
import core.JDBC;
import page_objects.LoginPage2;
import page_objects.MailsPage;

public class GroupMessageTestMailRu {

	private WebDriver driver;
	private page_objects.MailsPage mailsPage;
	private LoginPage2 loginPage2;
	private static final String Url = "https://mail.ru/";

	@BeforeClass
	public void beforeClass() {
		System.out.println("Test class TestsForMailRu is started.");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("Test class TestsForMailRu is ended.");

	}

	@BeforeMethod
	public void beforeMethod() {
		driver = new ChromeDriver();
		loginPage2 = new LoginPage2(driver);
		mailsPage = new MailsPage(driver);
		loginPage2.setPropertyWindow();
	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
	}

	@Test
	public void testSendMessages() throws Exception {
		Credentials credentials = JDBC.getCredentials();
		String login = credentials.getLogin();
		String password = credentials.getPassword();
		loginPage2.login(Url, login, password);
		String[] sendToEmails = { "test1@test.com;", "test2@test.com;",
				"test3@test.com" };
		String topic = "Topic";
		String text = "Test text for email.";
		mailsPage.sendMails(Arrays.asList(sendToEmails), topic, text);
		String expectedMessage = "Ваше письмо отправлено. Перейти во Входящие";
		Assert.assertEquals(expectedMessage, mailsPage.getMessageSentTitle());
	}
}
