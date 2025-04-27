package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Home {
	public static String HomeDarkMode(WebDriver driver, JavascriptExecutor js) {
		WebElement DarkModeBtn = driver.findElement(By.className("theme-toggle"));
		DarkModeBtn.click();
		String newTheme = (String) js.executeScript("return localStorage.getItem('theme')");
		return newTheme;
	}

	public static String GetStartedBtn(WebDriver driver, JavascriptExecutor js) {
		WebElement GetstartedBtn = driver.findElement(By.id("getStartedBtn"));
		GetstartedBtn.click();
		//Get title of the Dictionary page
		String newPageTitle = driver.getTitle();
		return newPageTitle;
	}

	public static String DictionaryBtn(WebDriver driver, JavascriptExecutor js) {
		WebElement DictionaryBtn = driver.findElement(By.xpath("/html/body/section[2]/a[1]"));
		DictionaryBtn.click();
		//Get title of the Dictionary page
		String newPageTitle = driver.getTitle();
		return newPageTitle;
	}

	public static String TextToGlossBtn(WebDriver driver, JavascriptExecutor js) {
		WebElement TextToGlossBtn = driver.findElement(By.xpath("/html/body/section[2]/a[2]"));
		TextToGlossBtn.click();
		//Get title of the Text To Gloss page
		String newPageTitle = driver.getTitle();
		return newPageTitle;
	}

	public static String AskISLBtn(WebDriver driver, JavascriptExecutor js) {
		WebElement AskISLBtn = driver.findElement(By.xpath("/html/body/section[2]/a[3]"));
		AskISLBtn.click();
		//Get title of the RAG (Ask ISL) page
		String newPageTitle = driver.getTitle();
		return newPageTitle;
	}

	public static String JoinBtn(WebDriver driver, JavascriptExecutor js) {
		WebElement JoinBtn = driver.findElement(By.xpath("/html/body/section[2]/a[4]"));
		JoinBtn.click();
		//Get title of the Join up page
		String newPageTitle = driver.getTitle();
		return newPageTitle;
	}

	public static String MeetUpBtn(WebDriver driver, JavascriptExecutor js) {
		WebElement MeetUpBtn = driver.findElement(By.xpath("/html/body/section[2]/a[5]"));
		MeetUpBtn.click();
		//Get title of the Meetup page
		String newPageTitle = driver.getTitle();
		return newPageTitle;
	}
}
