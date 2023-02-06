package remedy.oneITSM_FW.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class NewChangeIDPage {

	private WebDriver driver ;
	public NewChangeIDPage(WebDriver driver) {
		this.driver = driver;
	}
	private By SummaryField = By.id ("arid_WIN_3_1000000000");
	private By ServiceField = By.cssSelector("#arid_WIN_3_303497300");
	private By CategorizationTab = By.xpath ("/html/body/div[1]/div[5]/div[2]/div/div/div[3]/fieldset/div/div/div/div/div[3]/fieldset/div/div/div/div[4]/div[15]/div/div/div[3]/fieldset/div/div/div/div/div[3]/fieldset/div/div/div[2]/div[2]/div/dl/dd[2]/span[2]/a");
	private By OP_Cat_Tier1 = By.xpath ("//div[1][@class='PageBody pbChrome']/div[1][@id='WIN_3_303868800']/fieldset[2][@id='WIN_3_304287650']//textarea[1][@id='arid_WIN_3_1000000063']");
	private By ChangeManagerField = By.xpath ("//div[1][@class='PageBody pbChrome']/div[4][@id='WIN_3_304196800']/fieldset[1][@class=' pnl ']/div[4][@id='WIN_3_1000000403']/textarea[1][@id='arid_WIN_3_1000000403']");
	private By SaveBtn = By.id  ("WIN_3_1001");
	private By ManagerGroupField = By.id ("arid_WIN_3_1000000015");
	private By UrgencyField = By.xpath("//input[@id='arid_WIN_3_1000000162']");

	public void setService(String service) throws InterruptedException {
		Thread.sleep(7000);
		driver.findElement(ServiceField).click();
		driver.findElement(ServiceField).sendKeys(service);
	}
	public void selectService() throws InterruptedException {
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ARROW_DOWN).perform();
		action.sendKeys(Keys.ENTER).perform();
	}
	public void SetSummaryField() throws InterruptedException { 
		Thread.sleep(500);
		driver.findElement(SummaryField).sendKeys("Testing Automation" , Keys.ENTER);;
	}
	public void ClickOnUrgencyField() throws InterruptedException {
		driver.findElement(UrgencyField).click();
		Thread.sleep(500);
		driver.findElement(UrgencyField)
		.sendKeys(Keys.ARROW_DOWN ,Keys.ARROW_DOWN,Keys.ENTER);
		Thread.sleep(500);
	}
	public void SetManagerGroupField() throws InterruptedException {
		Thread.sleep(500);
		driver.findElement(ManagerGroupField).click();
		Thread.sleep(500);
		driver.findElement(ManagerGroupField).sendKeys("VFI" , Keys.ARROW_DOWN,Keys.ENTER);
	}
	public void ClickOnCategorizationTab () throws InterruptedException {
		Thread.sleep(500);
		driver.findElement(CategorizationTab).click();
	}
	public void SetOP_cat_tier1() throws InterruptedException {
		Thread.sleep(500);
		driver.findElement(OP_Cat_Tier1).click();
		driver.findElement(OP_Cat_Tier1).sendKeys("Application Management");
	}
	public void SetChangeManagerField () throws InterruptedException {
		driver.findElement(ChangeManagerField).sendKeys("Ana Ion",Keys.ENTER);
		Thread.sleep(500);
	}
	public void ClickOnSaveBtn() throws InterruptedException { 
		driver.findElement(SaveBtn).click();
	}
}
