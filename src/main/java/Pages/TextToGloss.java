package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextToGloss {

	public static String TextToGlossDarkMode(WebDriver driver, JavascriptExecutor js) {
		WebElement DarkModeBtn = driver.findElement(By.xpath("/html/body/div/div[1]/div/button[2]"));
		DarkModeBtn.click();
		String newTheme = (String) js.executeScript("return localStorage.getItem('theme')");
		System.out.println("Mode is: " + newTheme);
		return newTheme;
	}

	public static void EnterText(WebDriver driver) {
		WebElement textInput = driver.findElement(By.xpath("//*[@id=\"textInput\"]"));
		String text = "How are you Today";
		textInput.sendKeys(text);
	}

}
