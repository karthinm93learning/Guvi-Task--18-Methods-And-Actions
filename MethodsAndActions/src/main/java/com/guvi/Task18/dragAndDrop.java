package com.guvi.Task18;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;


public class dragAndDrop {

	public static void main(String[] args) {


		WebDriver driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://jqueryui.com/droppable/");
		
		driver.switchTo().frame(0);
		
		WebElement source = driver.findElement(By.xpath("//div[@id ='draggable']"));
		WebElement destination = driver.findElement(By.xpath("//div[@id ='droppable']"));
		Actions action = new Actions(driver);
		
		action.dragAndDrop(source, destination).build().perform();
		
		String expectedColour = "rgb(255, 250, 144) 50% 0%";
		String actualColour = destination.getCssValue("background");
		if(actualColour.contentEquals(expectedColour)) 
		{
		 System.out.println("Background Colour is changed"); 
		}else 
		{
		 System.out.println("Background Colour not changed"); 
		}
		 
		String expectedTargetText = "Dropped!";
		String actualTargetText = destination.getText();
		if(expectedTargetText.contentEquals(actualTargetText))
		{
			System.out.println("Target Text is Correct");
		}else
		{
			System.out.println("Target Text is Wrong");
		}
		
		driver.switchTo().defaultContent();
		driver.quit();	
	}

}
