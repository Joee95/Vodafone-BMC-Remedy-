package remedy.oneITSM_FW.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SearchChangeIDPage {



	private WebDriver driver;
	private By SearchIDField = By.xpath("//div[1][@class='PageBody pbChrome']/div[1][@id='WIN_3_303683700']/fieldset[1][@class=' pnl ']/div[1][@id='WIN_3_1000000182']/textarea[1][@id='arid_WIN_3_1000000182']");
	private By SearchButton = By.xpath("//fieldset[1][@class='PageBodyHorizontal']/div[1][@class='PageBody pbChrome']/a[2][@id='WIN_3_1002' and contains(normalize-space(),'Search')]/div[1][@class='btntextdiv']/div[1][@class='f1' and text()='Search']");
	private By logoutBtn = By.id("WIN_0_302145300");
	private By Status = By.xpath ("//*[@id='arid_WIN_3_303502600']");
	private By SaveBtn = By.xpath("//a[@id='WIN_3_1002'  and @class='btn btn3d arfid1002 ardbnQuery btnd']");


	public SearchChangeIDPage(WebDriver driver) {
		this.driver = driver;
	}

	public void ClickOnSearchIDField (String ChangeID) throws InterruptedException 
	{
		Thread.sleep(10000);
		WebElement searchidfield = driver.findElement(SearchIDField);
		searchidfield.click();
		searchidfield.sendKeys(ChangeID);

	}

	public void ClickOnSearchButton() throws InterruptedException {
		Thread.sleep(3000);
		WebElement searchbtn = driver.findElement(SearchButton);
		searchbtn.click();
	}

	public void ClickOnLogoutButton() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(logoutBtn).click();
		Thread.sleep(3000);
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
