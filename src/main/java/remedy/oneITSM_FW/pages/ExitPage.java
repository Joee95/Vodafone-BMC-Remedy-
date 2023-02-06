package remedy.oneITSM_FW.pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ExitPage {

	private WebDriver driver;
	public String currentURL = "https://ams-rsso1-qa.onbmc.com/rsso/logout?agent-id=oneitsm-qa";
	
	public ExitPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void validateSuccessfullLogOut() {
		Assert.assertEquals(currentURL, driver.getCurrentUrl());
	}
}
