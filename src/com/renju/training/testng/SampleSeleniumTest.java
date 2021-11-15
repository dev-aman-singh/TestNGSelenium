package com.renju.training.testng;

import static org.openqa.selenium.Platform.WINDOWS;
import static org.openqa.selenium.remote.http.HttpMethod.POST;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SampleSeleniumTest {
	
	WebDriver driver;
	
	@BeforeClass
	public void startBrowser() {
		//System.setProperty("webdriver.chrome.driver", "F:\\Downloads\\chromedriver_win32\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--start-maximized");
		driver = new ChromeDriver(chromeOptions);
	}
	
	@Test
	public void validateGoogleId() throws Exception {
		System.out.println("Opening Browser");
		driver.get("http://www.google.com");
		//driver.findElement(By.xpath("//*[@id=\"gbw\"]/div/div/div[1]/div[1]/a")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Gmail')]")).click();
		//a[contains(text(),'Gmail')]
		System.out.println("Clicking Gmail Link");
		System.out.println("Clicking Sign In link");
		//driver.findElement(By.xpath("/html/body/nav/div/a[2]")).click();
		//a[contains(text(),'Sign in')]
		driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();
		System.out.println("Entering username");
		driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys("amansingh1031997");
		System.out.println("Clicking Next button");
		driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
		Thread.sleep(5000);
		boolean textFound = driver.getPageSource().contains("Forgot");
		System.out.println(textFound);
		AssertJUnit.assertTrue(textFound);
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
}