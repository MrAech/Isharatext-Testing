package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RAG {

	public static String AskISLDarkMode(WebDriver driver, JavascriptExecutor js) {
		WebElement DarkModeBtn = driver.findElement(By.xpath("/html/body/div/div[1]/div/button"));
		DarkModeBtn.click();
		String newTheme = (String) js.executeScript("return localStorage.getItem('theme')");
		return newTheme;
	}

	public static void EnterText(WebDriver driver) {
		WebElement textInput = driver.findElement(By.xpath("/html/body/div/div[3]/input"));
		String text = "Tell Me about ISL and its history";
		textInput.sendKeys(text);
	}

	public static void clickSendBtn(WebDriver driver) {
		WebElement sendBtn = driver.findElement(By.xpath("/html/body/div/div[3]/button[2]"));
		sendBtn.click();
	}

}
