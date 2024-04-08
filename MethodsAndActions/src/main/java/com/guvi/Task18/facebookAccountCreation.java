package com.guvi.Task18;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class facebookAccountCreation {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://www.facebook.com/");
		
		String expectedTitle = "Facebook – log in or sign up";
		
		String actualTitle = driver.getTitle();
		
		if(actualTitle.equalsIgnoreCase(expectedTitle))
		{
			System.out.println("Correct FaceBook page is Launched");
		}else
		{
			System.out.println("Wrong FaceBook page is Launched");
		}

		WebElement creatButton = driver.findElement(By.xpath("//a[text() = 'Create new account']"));
		creatButton.click();
		
		WebElement firstName = driver.findElement(By.xpath("//input[@type = 'text' and @name = 'firstname']"));
		firstName.sendKeys("Test");
		
		WebElement lastName = driver.findElement(By.xpath("//input[@type = 'text' and @name = 'lastname']"));
		lastName.sendKeys("User");
		
		WebElement emailField = driver.findElement(By.xpath("//input[@type = 'text' and @name = 'reg_email__']"));
		emailField.sendKeys("Test@test.com");
		
		WebElement re_EmailField = driver.findElement(By.xpath("//input[@type = 'text' and @name = 'reg_email_confirmation__']"));
		re_EmailField.sendKeys("Test@test.com");
		
		WebElement password = driver.findElement(By.xpath("//input[@type = 'password' and @name = 'reg_passwd__']"));
		password.sendKeys("Testing@12394");
		
		WebElement dobDate = driver.findElement(By.xpath("//select[@name = 'birthday_day' and @id = 'day']"));
		Select select1 = new Select(dobDate);
		select1.selectByIndex(10);
		
		WebElement dobMonth = driver.findElement(By.xpath("//select[@name = 'birthday_month' and @id = 'month']"));
		Select select2 = new Select(dobMonth);
		select2.selectByValue("5");
		
		WebElement dobYear = driver.findElement(By.xpath("//select[@name = 'birthday_year' and @id = 'year']"));
		Select select3 = new Select(dobYear);
		select3.selectByVisibleText("1985");
		
		WebElement gender = driver.findElement(By.xpath("//label[text() = 'Male']"));
		gender.click();
		
		WebElement signupButton = driver.findElement(By.xpath("//button[text() = 'Sign Up']"));
		signupButton.click();
		
		String expectedLoginTitle = "Facebook";
		String actualLoginTitle = driver.getTitle();
		if(actualLoginTitle.contentEquals(expectedLoginTitle))
		{
			System.out.println("Login Sucessful");
		}else
		{
			System.out.println("Login Unsuccessful");
		}
		
		driver.quit();
	}

}
