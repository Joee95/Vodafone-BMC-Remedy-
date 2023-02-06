package remedy.oneITSM_FW.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class NewReleaseIDPage {

	private WebDriver driver;

	public NewReleaseIDPage(WebDriver driver) {
		this.driver= driver;
	}

	//private By ServiceField = By.cssSelector("#arid_WIN_3_303497300");
	private By SummaryField = By.id ("arid_WIN_3_1000000000");
	private By SaveBtn = By.id  ("WIN_3_1001");
	private By ServiceArrow = By.xpath("//*[@id=\"WIN_3_303497300\"]/a");


	public void ChooseServiceFromMenu () throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(ServiceArrow).click();
		Thread.sleep(2000);
		driver.findElement(ServiceArrow)
		.sendKeys(Keys.ARROW_DOWN , Keys.ARROW_RIGHT ,Keys.ARROW_RIGHT , Keys.ARROW_RIGHT ,Keys.ARROW_RIGHT , Keys.ENTER );
		Thread.sleep(2000);
	}

	public void SetSummaryField() throws InterruptedException { 
		Thread.sleep(500);
		driver.findElement(SummaryField).sendKeys("Testing Automation" , Keys.ENTER);
	}

	public void ClickOnSaveBtn() throws InterruptedException { 
		driver.findElement(SaveBtn).click();
	}
}
