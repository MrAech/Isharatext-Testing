package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Dictionary {
	public String changetheme(WebDriver driver, JavascriptExecutor js) {
		WebElement DarkModeBtn = driver.findElement(By.className("theme-toggle"));
		DarkModeBtn.click();
		String newTheme = (String) js.executeScript("return localStorage.getItem('theme')");
		return newTheme;
	}

	public static String[] clickWordAndSeeVidLink(WebDriver driver, JavascriptExecutor js) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	    By videoLinkLocator = By.cssSelector(".video-link");

	    WebElement firstLink = null;
	    String expectedVideoId = "";

	    // Retry loop to handle Edge's StaleElementReferenceException
	    for (int attempt = 0; attempt < 3; attempt++) {
	        try {
	            wait.until(ExpectedConditions.presenceOfElementLocated(videoLinkLocator));
	            firstLink = driver.findElement(videoLinkLocator);
	            expectedVideoId = firstLink.getDomAttribute("data-video-id");
	            firstLink.click();
	            break; // success, exit loop
	        } catch (StaleElementReferenceException e) {
	            if (attempt == 2)
				 {
					throw e; // Re-throw after 3 attempts
				}
	            // wait briefly before retrying
	            try {
	                Thread.sleep(500);
	            } catch (InterruptedException ignored) {}
	        }
	    }

	    // Wait for JS state to confirm video is loaded
	    wait.until(d -> {
	        Object result = js.executeScript(
	            "return (typeof player !== 'undefined' && window.currentVideoId !== '');"
	        );
	        return result instanceof Boolean && (Boolean) result;
	    });

	    String actualVideoId = (String) js.executeScript("return window.currentVideoId;");

	    return new String[]{expectedVideoId, actualVideoId};
	}

	public static void enterSearchWord(WebDriver driver) {
        WebElement searchInput = driver.findElement(By.id("searchInput"));
        String word = "Happy";
        searchInput.clear();
        searchInput.sendKeys(word);

        // Trigger input event via JS
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].dispatchEvent(new Event('input'))", searchInput);
    }



}
