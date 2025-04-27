import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import java.net.URI;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Pages.Dictionary;
import Pages.Home;
import Pages.Join;
import Pages.Meetup;
import Pages.RAG;
import Pages.TextToGloss;
import io.github.bonigarcia.wdm.WebDriverManager;


// Test Cases Details:							Test Cases Status:
// Page: Home Total Tests: 7 Details:
// 1. Dark Mode 								Status: ✔️
// 2. Get Started Button						Status: ✔️
// 3. Dictionary Button							Status: ✔️
// 4. Text to Gloss Button						Status: ✔️
// 5. Ask ISL Button							Status: ✔️
// 6. Join Us Button							Status: ✔️
// 7. Meetup Button								Status: ✔️
// Page: Dictionary Total Tests: 4 Details:
// 8. Dark Mode									Status: ✔️
// 9. Video Link								Status: ✔️
// 10. Search Bar								Status: ✔️
// 11. Search Word Click						Status: ✔️
// Page: Text to Gloss Total Tests: 2 Details:
// 12. Dark Mode								Status: ✔️
// 13. Translation								Status: ✔️
// Page: Ask ISL Total Tests: 3 Details:
// 14. Dark Mode								Status: ✔️
// 15. Text Input								Status: ✔️
// 16. Send Button								Status: ✔️
// Page: Join Us Total Tests: 2 Details:
// 17. Dark Mode								Status: ✔️
// 18. Form Submission							Status: ✔️
// Page: Meetup Total Tests: 2 Details:
// 19. Dark Mode								Status: ✔️
// 20. Submit Meetup Request					Status: ✔️




public class Testlauncher {
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static ThreadLocal<JavascriptExecutor> js = new ThreadLocal<>();

    public WebDriver getDriver() {
        return driver.get();
    }

    public JavascriptExecutor getJS() {
        return js.get();
    }

	@Parameters("browser")
	@BeforeTest
	public void setup(String browser) {
		WebDriver localDriver = null;

		if (browser.equalsIgnoreCase("chrome")) {

			WebDriverManager.chromedriver().setup();
			localDriver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			localDriver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			localDriver = new EdgeDriver();
		} else {
			System.out.println("Invalid browser name");
		}

		driver.set(localDriver);

		js.set((JavascriptExecutor) localDriver);
		localDriver.manage().window().maximize();
		localDriver.get("https://8000-01jg1zayg54zcq6p1wpjyjq745.cloudspaces.litng.ai/");
		System.out.println("Browser launched successfully");

	}

	//Test: 1 ;; Page: Home ;; Test: Dark Mode
	@Test(priority = 1, description = "Test case to check the dark mode")
	public void testDarkMode() {
		String currentTheme = (String) getJS().executeScript("return localStorage.getItem('theme')");
		currentTheme = currentTheme == null ? "light" : currentTheme.toLowerCase();

		System.out.println("Current theme: " + currentTheme);
		String afterClickTheme = Home.HomeDarkMode(getDriver(), getJS()).toLowerCase();

		assertNotEquals(currentTheme, afterClickTheme, "Theme Changed Successfully");

	}

	//Test: 2 ;; Page: Home ;; Test: Get Started Button
	@Test(priority = 2, description = "Test case to check the get started button")
	public void testGetStartedBtn() {
		String title = Home.GetStartedBtn(getDriver(), getJS());
		System.out.println("Title of the new page: " + title);
		assertEquals(title, "Dictionary - ISL Buddy", "Get Started button clicked successfully");
		getDriver().navigate().back();
	}

	//Test: 3 ;; Page: Home ;; Test: Dictionary Button
	@Test(priority = 3, description = "Test case to check the dictionary button")
	public void testDictionaryBtn() {
		String title = Home.DictionaryBtn(getDriver(), getJS());
		System.out.println("Title of the new page: " + title);
		assertEquals(title, "Dictionary - ISL Buddy", "Dictionary button clicked successfully");
		getDriver().findElement(By.xpath("/html/body/div/div[1]/div[1]/a")).click();
	}

	//Test: 4 ;; Page: Home ;; Test: Text to Gloss Button
	@Test(priority = 4, description = "Test case to check the text to gloss button")
	public void testTextToGlossBtn() {
		String title = Home.TextToGlossBtn(getDriver(), getJS());
		System.out.println("Title of the new page: " + title);
		assertEquals(title, "Text to Sign - ISL Buddy", "Text to Gloss button clicked successfully");
		getDriver().findElement(By.xpath("/html/body/div/div[1]/div/a")).click();
	}

	//Test: 5 ;; Page: Home ;; Test: Ask ISL Button
	@Test(priority = 5, description = "Test case to check the ask isl button")
	public void testAskISLBtn() {
		String title = Home.AskISLBtn(getDriver(), getJS());
		System.out.println("Title of the new page: " + title);
		assertEquals(title, "ISL Chatbot", "Ask ISL button clicked successfully");
		getDriver().findElement(By.xpath("/html/body/div/div[1]/div/a")).click();
	}

	//Test: 6 ;; Page: Home ;; Test: Join Us Button
	@Test(priority = 6, description = "Test case to check the join button")
	public void testJoinBtn() {
		String title = Home.JoinBtn(getDriver(), getJS());
		System.out.println("Title of the new page: " + title);
		assertEquals(title, "ISL Join Page", "Join button clicked successfully");
		getDriver().findElement(By.xpath("/html/body/div[1]/a[1]")).click();
	}

	//Test: 7 ;; Page: Home ;; Test: Meetup Button
	@Test(priority = 7, description = "Test case to check the meetup button")
	public void testMeetUpBtn() {
		String title = Home.MeetUpBtn(getDriver(), getJS());
		System.out.println("Title of the new page: " + title);
		assertEquals(title, "ISL Meetup", "Meetup button clicked successfully");
		getDriver().findElement(By.xpath("//html/body/div[1]/a")).click();
		System.out.println("HomePage testing Done successfully");
	}

	//Test: 8 ;; Page: Dictionary ;; Test: Dark Mode
	@Test(priority = 8, description = "Test case to check the Dictionary Dark Mode")
	public void testDictTheme() {
		//go to Dictionary Page
		String title = Home.DictionaryBtn(getDriver(), getJS());
		System.out.println("Moving to: " + title+" For Dictionary Testing");
		String currentTheme = (String) getJS().executeScript("return localStorage.getItem('theme')");
		currentTheme = currentTheme == null ? "light" : currentTheme.toLowerCase();
		System.out.println("Current theme: " + currentTheme);
		String afterClickTheme = Home.HomeDarkMode(getDriver(), getJS()).toLowerCase();
		assertNotEquals(currentTheme, afterClickTheme, "Theme Changed Successfully In Dictionary Page");
	}

	//Test: 9 ;; Page: Dictionary ;; Test: Video Link
	@Test(priority = 9, description = "Test case to check the video link")
	public void testVideoLink() {
		String[] videoIds = Dictionary.clickWordAndSeeVidLink(getDriver(), getJS());
		System.out.println("Expected Video ID: " + videoIds[0]);
	    System.out.println("Actual Video ID: " + videoIds[1]);
		assertEquals(videoIds[0], videoIds[1], "Video ID matched successfully");
		System.out.println("Video ID matched successfully");
	}

	//Test: 10 ;; Page: Dictionary ;; Test: Search Bar
	@Test(priority = 10, description = "Test case to check the search word and clear Button")
	public void testClearSearchBar() {
        Dictionary.enterSearchWord(getDriver());

        WebElement clearButton = getDriver().findElement(By.id("clearSearchButton"));
        clearButton.click();

        String value = getDriver().findElement(By.id("searchInput")).getDomAttribute("value");
        if (value == null) {
			value = "";
		}
        System.out.println("Search input value after clear: " + value);
        Assert.assertEquals(value, "", "Search input should be cleared.");
    }

	//Test: 11 ;; Page: Dictionary ;; Test: Search Word Click
	@Test(priority = 11, description = "Test case to check the dictionary search Word Click")
	public void testSearchWord() {
		Dictionary.enterSearchWord(getDriver());
		String[] videoIds = Dictionary.clickWordAndSeeVidLink(getDriver(), getJS());
		System.out.println("Expected Video ID: " + videoIds[0]);
	    System.out.println("Actual Video ID: " + videoIds[1]);
		assertEquals(videoIds[0], videoIds[1], "Video ID matched successfully");
		System.out.println("Video ID matched successfully");

		getDriver().findElement(By.xpath("/html/body/div/div[1]/div[1]/a")).click();

		System.out.println("Dictionary testing Done successfully");
	}

	//Test: 12 ;; Page: Text to Gloss ;; Test: Dark Mode
	@Test(priority = 12, description = "Test case to check the Text to Gloss Dark Mode")
	public void testTextToGlossTheme() {
		//go to Text to Gloss Page
		String title = Home.TextToGlossBtn(getDriver(), getJS());
		System.out.println("Moving to: " + title+" For Text to Gloss Testing");
		String currentTheme = (String) getJS().executeScript("return localStorage.getItem('theme')");
		currentTheme = currentTheme == null ? "light" : currentTheme.toLowerCase();
		System.out.println("Current theme: " + currentTheme);
		String afterClickTheme = TextToGloss.TextToGlossDarkMode(getDriver(), getJS());

		assertNotEquals(currentTheme, afterClickTheme, "Theme Changed Successfully In Text to Gloss Page");
	}

	//Test: 13 ;; Page: Text to Gloss ;; Test: Translation
	@Test(priority = 13, description = "Test case to check The Translation Works")
	public void TestTranslation() throws InterruptedException {
	    // Enter text using TextToGloss class
	    TextToGloss.EnterText(getDriver());

	    getDriver().findElement(By.xpath("/html/body/div/div[2]/button")).click();

	    // Wait for the output section to become visible
	    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
	    WebElement outputSection = wait.until(
	        ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='outputSection']"))
	    );

	    System.out.println("Waiting for the output section to change...");

	    // Wait until the text changes from "Translating to Gloss..." \
	    wait.until(driver -> {
	        String text = outputSection.getText();
	        return !text.trim().equalsIgnoreCase("Translating to Gloss...");
	    });

	    // Sleep 2 seconds to let final content fully load
	    Thread.sleep(2000);

	    // Get final output and verify if it contains "GLOSS"
	    String finalOutput = outputSection.getText();
	    System.out.println("Final Output: " + finalOutput);

	    Assert.assertTrue(
	        finalOutput.toUpperCase().contains("GLOSS"),
	        "Translation did not contain 'GLOSS'. Actual output: " + finalOutput
	    );

	    getDriver().findElement(By.xpath("/html/body/div/div[1]/div/a")).click();

	    System.out.println("Text To Gloss Testing Done successfully");
	}

	//Test: 14 ;; Page: Ask ISL ;; Test: Dark Mode
	@Test(priority = 14, description = "Test case to check the Ask ISL Dark Mode")
	public void testAskISLDarkMode() {
		//go to Ask ISL Page
		String title = Home.AskISLBtn(getDriver(), getJS());
		System.out.println("Moving to: " + title+" For Ask ISL Testing");
		String currentTheme = (String) getJS().executeScript("return localStorage.getItem('theme')");
		currentTheme = currentTheme == null ? "light" : currentTheme.toLowerCase();
		System.out.println("Current theme: " + currentTheme);
		String afterClickTheme = RAG.AskISLDarkMode(getDriver(), getJS()).toLowerCase();

		assertNotEquals(currentTheme, afterClickTheme, "Theme Changed Successfully In Ask ISL Page");
	}

	//Test: 15 ;; Page: Ask ISL ;; Test: Text Input
	@Test(priority = 15, description = "Test case to check the Ask ISL Chat Input works or not")
	public void testTextInput() {
		RAG.EnterText(getDriver());
		// get the text input value
		WebElement textInput = getDriver().findElement(By.xpath("/html/body/div/div[3]/input"));
		String text = textInput.getDomProperty("value");
		System.out.println("Text input value: " + text);
		// wait for the text input to be filled
		new WebDriverWait(getDriver(), Duration.ofSeconds(5));

		// check if the text input value is not null
		Assert.assertNotNull(text, "Text input should not be null.");

		// check if the text input value is not empty
		Assert.assertFalse(text.isEmpty(), "Text input should not be empty.");

	}

	//Test: 16 ;; Page: Ask ISL ;; Test: Send Button
	@Test(priority = 16, description = "Test case to check the Ask ISL Send Button works or not")
	public void testSendBtn() {
		RAG.EnterText(getDriver());
		RAG.clickSendBtn(getDriver());
		// wait for the response to be visible
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
		WebElement response = wait.until(
			ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[2]/div[3]"))
		);

		System.out.println("Waiting for the response to change...");

		// check if the response is not null
		Assert.assertNotNull(response, "Response should not be null.");

		getDriver().findElement(By.xpath("/html/body/div/div[1]/div/a")).click();
	}

	//Test: 17 ;; Page: Join Us ;; Test: Dark Mode
	@Test(priority = 17, description = "Test case to check Join us Dark Mode" )
	public void testJoinUsDarkMode() {
		//go to Join Us Page
		String title = Home.JoinBtn(getDriver(), getJS());
		System.out.println("Moving to: " + title+" For Join Us Testing");
		String currentTheme = (String) getJS().executeScript("return localStorage.getItem('theme')");
		currentTheme = currentTheme == null ? "light" : currentTheme.toLowerCase();
		System.out.println("Current theme: " + currentTheme);
		String afterClickTheme = Join.JoinDarkMode(getDriver(), getJS()).toLowerCase();

		assertNotEquals(currentTheme, afterClickTheme, "Theme Changed Successfully In Join Us Page");
	}

	//Test: 18 ;; Page: Join Us ;; Test: Form Submission
	@Test(priority = 18, description = "Test case to check the Join Us Form")
	public void testJoinUsFormSubmission() {
	    // Fill the Join Us form
	    Join.fillJoinUsForm(getDriver());

	    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

	    // Wait for at least one row in the table with <td> cells
	    wait.until(ExpectedConditions.presenceOfElementLocated(
	        By.xpath("//div[contains(@class, 'table-section')]//table//tbody/tr[td]")));

	    WebElement table = getDriver().findElement(
	        By.xpath("//div[contains(@class, 'table-section')]//table"));

	    List<WebElement> rows = table.findElements(By.xpath(".//tbody/tr[td]"));
	    System.out.println("Row count: " + rows.size());

	    boolean found = false;

	    for (WebElement row : rows) {
	        List<WebElement> cells = row.findElements(By.tagName("td"));
	        if (cells.size() < 3)
			 {
				continue; // Skip incomplete rows
			}

	        String orgName = cells.get(0).getText().trim();
	        String contactPerson = cells.get(1).getText().trim();
	        String email = cells.get(2).getText().trim();

	        if (orgName.equals("Test Organization") &&
	            contactPerson.equals("John Doe") &&
	            email.equals("johndoe@example.com")) {
	            found = true;
	            break;
	        }
	    }

	    Assert.assertTrue(found, "The submitted data should appear in the table.");

	    System.out.println("Join Us form submitted successfully and data verified in the table.");
	    System.out.println("Join Us Testing Done successfully");

	    getDriver().findElement(By.xpath("//html/body/div[1]/a")).click();

	}

	//Test: 19 ;; Page: Meetup ;; Test: Dark Mode
	@Test(priority = 19, description = "Test case to check the Meetup Dark Mode")
	public void testMeetupDarkMode() {
		//go to Meetup Page

		String title = Home.MeetUpBtn(getDriver(), getJS());
		System.out.println("Moving to: " + title+" For Meetup Testing");
		String currentTheme = (String) getJS().executeScript("return localStorage.getItem('theme')");
		currentTheme = currentTheme == null ? "light" : currentTheme.toLowerCase();
		System.out.println("Current theme: " + currentTheme);
		String afterClickTheme = Meetup.MeetupDarkMode(getDriver(), getJS()).toLowerCase();

		assertNotEquals(currentTheme, afterClickTheme, "Theme Changed Successfully In Meetup Page");

	}

	//Test: 20 ;; Page: Meetup ;; Test: Submit Meetup Request
	@Test(priority = 20, description = "Test case to submit a meetup request and verify table update and join link")
	public void testSubmitMeetupRequest() throws InterruptedException {

	    //  Submit a meetup request
	    String name = "John Doe";
	    String email = "johndoe@example.com";
	    String gender = "Male";
	    String message = "Looking forward to the meetup!";
	    String time = "2025-04-15T10:30";
	    Meetup.submitMeetupRequest(getDriver(), name, email, gender, message, time);

	    // Verify the table is updated with the new meetup request

	    getDriver().navigate().refresh();

	    // Wait for table to load
	    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("table")));


	    Thread.sleep(2000); // Wait for 2 seconds to ensure the table is updated -- FORCED
	    WebElement table = getDriver().findElement(By.tagName("table"));
	    List<WebElement> rows = table.findElements(By.tagName("tr"));

	    boolean isUpdated = false;
	    for (WebElement row : rows) {
	        List<WebElement> columns = row.findElements(By.tagName("td"));
	        if (columns.size() > 0 && columns.get(0).getText().equals(name)) {
	            isUpdated = true;
	            break;
	        }
	    }

	    assertTrue(isUpdated, "Meetup request is successfully added to the table.");

	    // Verify the join link is valid
	    WebElement joinLinkElement = getDriver().findElement(By.xpath("//td/a[@class='meeting-link']"));
	    String joinLink = joinLinkElement.getDomAttribute("href");

	    assertTrue(isValidURL(joinLink), "Join link is a valid URL.");


	    System.out.println("Meetup request submitted successfully and verified in the table.");

	    System.out.println("All tests completed successfully.");
	}

	// Helper method to check if a URL is valid
	public boolean isValidURL(String url) {
	    try {
	        URI uri = new URI(url);
	        uri.toURL();
	        return true;
	    } catch (Exception e) {
	        return false;
	    }
	}



	@AfterTest
	public void teardown() {
		getDriver().quit();
		System.out.println("Browser closed successfully");
	}

}
