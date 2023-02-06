package remedy.oneITSM_FW.tests;

import org.testng.annotations.Test;

import remedy.oneITSM_FW.base.TestBase;
import remedy.oneITSM_FW.loadProperties.LoadPropertiesFile;

public class TestReleaseManagement_NewID extends TestBase{

	//private WebDriver driver;
	String email = LoadPropertiesFile.userdata.getProperty("email");
	String password = LoadPropertiesFile.userdata.getProperty("password");
	String ticketID = LoadPropertiesFile.userdata.getProperty("TicketId");
	String ChangeID = LoadPropertiesFile.userdata.getProperty("ChangeID");
	String Service = LoadPropertiesFile.userdata.getProperty("Service");


	@Test
	public void Testreleasemanagement_NewID() throws Exception {

		loginPage.setUsername(email);
		loginPage.clickNext();
		loginPage.setPassword(password);
		loginPage.clickLogin();
		landingPage = loginPage.clickNo();
		landingPage.clickApplicationMenu();
		landingPage.ClickOnReleaseManagement();
		newreleaseidpage = landingPage.ClickOnNewRelease();
		newreleaseidpage.ChooseServiceFromMenu();
		newreleaseidpage.SetSummaryField();
		newreleaseidpage.ClickOnSaveBtn();
	}

}
