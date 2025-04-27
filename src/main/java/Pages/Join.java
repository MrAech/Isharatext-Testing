package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Join {

	public static String JoinDarkMode(WebDriver driver, JavascriptExecutor js) {
		WebElement DarkModeBtn = driver.findElement(By.xpath("/html/body/div[1]/a[2]"));
		DarkModeBtn.click();
		String newTheme = (String) js.executeScript("return localStorage.getItem('theme')");
		System.out.println("Mode is: " + newTheme);
		return newTheme;
	}

	public static void fillJoinUsForm(WebDriver driver) {
	    // Fill the Organization Name input
	    WebElement orgNameInput = driver.findElement(By.id("orgName"));
	    orgNameInput.sendKeys("Test Organization");

	    // Fill the Contact Person input
	    WebElement contactPersonInput = driver.findElement(By.id("contactPerson"));
	    contactPersonInput.sendKeys("John Doe");

	    // Fill the Email input
	    WebElement emailInput = driver.findElement(By.id("email"));
	    emailInput.sendKeys("johndoe@example.com");

	    // Fill the Message input (optional)
	    WebElement messageInput = driver.findElement(By.id("message"));
	    messageInput.sendKeys("We are interested in joining your platform!");

	    // Submit the form
	    WebElement submitButton = driver.findElement(By.xpath("/html/body/div[2]/form/button"));
	    submitButton.click();
	}

}
