package remedy.oneITSM_FW.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SearchReleaseIDPage {

	private WebDriver driver;

	public SearchReleaseIDPage(WebDriver driver) {
		this.driver = driver;
	}

	private By SearchReleaseField = By.xpath("//textarea[@id='arid_WIN_3_303489800']");
	private By SearchBtn = By.id("WIN_3_1002");
	private By Status = By.xpath ("//*[@id='arid_WIN_3_303502600']");
	private By SaveBtn = By.xpath("//a[@id='WIN_3_1002'  and @class='btn btn3d arfid1002 ardbnQuery btnd']");

	public void ClickOnSearchField (String ReleaseID) throws InterruptedException {
		Thread.sleep(10000);
		driver.findElement(SearchReleaseField).sendKeys(ReleaseID);
	}

	public void ClickOnSearchBtn () throws InterruptedException {
		Thread.sleep(500);
		driver.findElement(SearchBtn).click();
	}
	
	public void ClickOnStatusField () throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(Status).click();
		Thread.sleep(2000);
		driver.findElement(Status).sendKeys(Keys.ARROW_DOWN , Keys.ARROW_DOWN , Keys.ENTER);
	}
	
	public void scrolltoSaveBtn () throws InterruptedException {
		Thread.sleep(1000);
		WebElement savebtn = driver.findElement(SaveBtn);
		String JS_Syntax = "arguments[0].scrollIntoView();";
		((JavascriptExecutor)driver).executeScript(JS_Syntax, savebtn);
		Thread.sleep(1000);
	}

	public void ClickOnSaveBtn () throws InterruptedException {
		Thread.sleep(500);
		Actions action = new Actions(driver);
		action.doubleClick(driver.findElement(SaveBtn));
	}
	
	
}
