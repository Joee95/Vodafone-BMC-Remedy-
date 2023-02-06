package remedy.oneITSM_FW.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	private WebDriver driver;

	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	private By ApplicationMenu = By.xpath("//body/div[@id='FormApp']/div[@id='FormContainer']/div[@id='WIN_0_303610200']/div[1]/div[1]/div[3]/fieldset[1]/div[1]/div[1]/div[1]/div[1]/div[1]/fieldset[1]/div[1]/div[2]/fieldset[1]/a[1]/div[1]");
	private By IncidentManagment = By.xpath("//a[1][@class='btn' and contains(.,'Incident M')]/span[1][@class='navLabel root ' and text()='Incident Management']");
	private By SearchIncident = By.xpath("//a[1][@class='btn' and contains(.,'Search Inc')]");
	private By newIncident = By.xpath("//span[contains(text(),'New Incident')]");
	private By ChangeManagementModule = By.xpath("//a[1][@class='btn' and contains(.,'Change Man')]");
	private By SearchChange = By.xpath("//a[1][@class='btn' and contains(.,'Search Cha')]/span[1][text()='Search Change']");
	private By NewChange = By.xpath("//a[1][@class='btn' and contains(.,'New Change')]/span[1][text()='New Change']");
	private By ReleaseManagement = By.xpath("//a[1][@class='btn' and contains(.,'Release Manag')]");
	private By SearchRelease = By.xpath("//*[@id=\"FormContainer\"]/div[5]/div/div[15]/div/div[3]");
	private By NewRelease = By.xpath("//*[@id=\"FormContainer\"]/div[5]/div/div[15]/div/div[2]");
	//  private By NewIncident= By.linkText("New Incident");
	//	private By KnowledgeManagement = By.xpath("//span[text()='Knowledge Management']");
	//	private By NewArticle= By.linkText("New Article");
	//	private By SearchKnowledge= By.linkText("Search Knowledge");




	public void clickApplicationMenu() throws InterruptedException {
		Thread.sleep(10000);
		driver.findElement(ApplicationMenu).click();
	}

	public void clickIncidentManagement() {
		driver.findElement(IncidentManagment).click();
	}
	public SearchIncidentPage clickSearchIncident() {
		driver.findElement(SearchIncident).click();
		return new SearchIncidentPage(driver);
	}
	public NewIncidentPage clickNewIncident() {
		driver.findElement(newIncident).click();
		return new NewIncidentPage(driver);
	}

	public void ClickOnChangeManagementModule () throws InterruptedException {
		Thread.sleep(1000);
		WebElement changemanagementmodule = driver.findElement(ChangeManagementModule);
		changemanagementmodule.click();
	}

	public SearchChangeIDPage ClickOnSearchChange () throws InterruptedException {
		Thread.sleep(1000);
		WebElement searchchange = driver.findElement(SearchChange);
		searchchange.click();
		return new SearchChangeIDPage(driver);
	}

	public NewChangeIDPage ClickOnNewSearch () throws InterruptedException {
		Thread.sleep(1000);
		WebElement searchchange = driver.findElement(NewChange);
		searchchange.click();
		return new NewChangeIDPage(driver);
	}

	public void ClickOnReleaseManagement () throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(ReleaseManagement).click();;
	}

	public SearchReleaseIDPage ClickOnSearchRelease () throws InterruptedException {
		Thread.sleep(1000);
		WebElement searchRelease = driver.findElement(SearchRelease);
		searchRelease.click();
		return new SearchReleaseIDPage(driver);
	}

	public NewReleaseIDPage ClickOnNewRelease () throws InterruptedException {
		Thread.sleep(1000);
		WebElement searchchange = driver.findElement(NewRelease);
		searchchange.click();
		return new NewReleaseIDPage(driver);
	}
}
