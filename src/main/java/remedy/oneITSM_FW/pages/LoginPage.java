package remedy.oneITSM_FW.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import remedy.oneITSM_FW.base.TestBase;



public class LoginPage extends TestBase{

	private WebDriver driver;
	private By username = By.name("loginfmt");
	private By nextBtn = By.id("idSIButton9");
	private By password = By.id("i0118");
	private By loginBtn = By.id("idSIButton9");
	private By stayLogged = By.id("idBtn_Back");
	
		public LoginPage(WebDriver driver) {
			this.driver = driver;
		}
	
		public void setUsername(String email) throws InterruptedException {
			Thread.sleep(10000);
			driver.findElement(username).sendKeys(email);
		}
		
		public void clickNext() {
			driver.findElement(nextBtn).click();
		}
		public void setPassword(String pass) {
			driver.findElement(password).sendKeys(pass);
		}
		public void clickLogin() throws InterruptedException {
			Thread.sleep(5000);
			driver.findElement(loginBtn).click();
		}
		public LandingPage clickNo() {
			driver.findElement(stayLogged).click();
			return new LandingPage(driver);
		}
		
}
