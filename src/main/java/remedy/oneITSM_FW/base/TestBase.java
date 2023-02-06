package remedy.oneITSM_FW.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

import remedy.oneITSM_FW.pages.ExitPage;
import remedy.oneITSM_FW.pages.LandingPage;
import remedy.oneITSM_FW.pages.LoginPage;
import remedy.oneITSM_FW.pages.NewChangeIDPage;
import remedy.oneITSM_FW.pages.NewIncidentPage;
import remedy.oneITSM_FW.pages.NewReleaseIDPage;
import remedy.oneITSM_FW.pages.SearchChangeIDPage;
import remedy.oneITSM_FW.pages.SearchIncidentPage;
import remedy.oneITSM_FW.pages.SearchReleaseIDPage;


public class TestBase {


	private static WebDriver driver;
	protected LandingPage landingPage;
	protected LoginPage loginPage;
	protected SearchIncidentPage searchPage;
	protected NewIncidentPage newIncident;
	protected ExitPage exitPage;
	protected NewIncidentPage newIncidentPage;
	protected NewChangeIDPage newchangeidpage ;
	protected SearchChangeIDPage searchchangeidpage ;
	protected SearchReleaseIDPage searchreleaseidpage ;
	protected NewReleaseIDPage newreleaseidpage ;


	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\KenawyY\\OneDrive - Vodafone Group\\Desktop\\Automation\\Drivers\\chromedriver.exe");
		//WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		//		ChromeOptions chromeOptions = new ChromeOptions();
		//		WebDriverManager.chromedriver().setup();
		//		WebDriver driver = new ChromeDriver(chromeOptions);
		driver.get("https://oneitsm-qa.onbmc.com/");
		driver.manage().window().maximize();
		loginPage = new LoginPage(driver);

	}


}
