package core;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Booking1case {
    @Test
	public void testBooking() {
		String exePath = "C:\\Users\\sama\\SeleniumDrivers\\chromedriver_win32\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.booking.com");
		
		WebElement searchField = driver.findElement(By.xpath("//*[@id='ss']"));
		searchField.sendKeys(new String[]{"Москва"});
		searchField.submit();

		
		WebElement date = driver.findElement(By.xpath("(//*[@id='frm']/div[3]/div/div[1]/div[1]/div/div/div[2]/div[2]/div[3]/div/div/div[1]/table/tbody/tr[5]/td[6]/span)"));
		date.click();
		
		WebElement search = driver.findElement(By.xpath("//span[@class='sb-submit-helper']"));
		search.submit();
		
		List<WebElement> hotels = driver.findElements(By.xpath(".//img[@class='hotel_image']"));
		Assert.assertFalse(hotels.isEmpty());
		
		driver.close();
		
		
		
		
		}
	}