package core;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import core.Credentials;
import core.JDBC;
import page_objects.LoginPage;

public class LoginTestMailRu {

	private WebDriver driver;
	private LoginPage loginPage;

	@Before
	public void before() {
		driver = new ChromeDriver();
		loginPage = new LoginPage(driver);

	}

	@Test
	public void test() throws Exception {
		driver.get("https://www.mail.ru");
		Credentials credentials = JDBC.getCredentials();
		loginPage.enterLoginAndPassword(credentials.getLogin(),
				credentials.getPassword());
		loginPage.clickEnterButton();
		Assert.assertTrue(loginPage.isExitLinkPresent());

	}

	@After
	public void tearDown() {
		driver.quit();
	}
}
