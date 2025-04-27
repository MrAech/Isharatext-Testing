package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Meetup {

	public static String MeetupDarkMode(WebDriver driver, JavascriptExecutor js) {
		WebElement DarkModeBtn = driver.findElement(By.xpath("/html/body/div[1]/button"));
		DarkModeBtn.click();
		String newTheme = (String) js.executeScript("return localStorage.getItem('theme')");
		System.out.println("Mode is: " + newTheme);
		return newTheme;
	}

	public static void submitMeetupRequest(WebDriver driver, String name, String email, String gender, String message, String time) {
        driver.findElement(By.name("name")).sendKeys(name);
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("gender")).sendKeys(gender);
        driver.findElement(By.name("message")).sendKeys(message);
        driver.findElement(By.name("time")).sendKeys(time);
        driver.findElement(By.xpath("//button[text()='Request Meetup']")).click();
    }

}
