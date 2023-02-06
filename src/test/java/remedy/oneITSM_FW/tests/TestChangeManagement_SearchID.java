package remedy.oneITSM_FW.tests;


import org.testng.annotations.Test;

import remedy.oneITSM_FW.base.TestBase;
import remedy.oneITSM_FW.loadProperties.LoadPropertiesFile;


public class TestChangeManagement_SearchID extends TestBase {

	// private WebDriver driver;
	String email = LoadPropertiesFile.userdata.getProperty("email");
	String password = LoadPropertiesFile.userdata.getProperty("password");
	String ticketID = LoadPropertiesFile.userdata.getProperty("TicketId");
	String ChangeID = LoadPropertiesFile.userdata.getProperty("ChangeID");


	@Test
	public void Testchangemanagement_searchid () throws Exception {

		loginPage.setUsername(email);
		loginPage.clickNext();
		loginPage.setPassword(password);
		loginPage.clickLogin();
		landingPage = loginPage.clickNo();
		landingPage.clickApplicationMenu();
		landingPage.ClickOnChangeManagementModule();
		searchchangeidpage = landingPage.ClickOnSearchChange();
		searchchangeidpage.ClickOnSearchIDField(ChangeID);
		searchchangeidpage.ClickOnSearchButton();
		//searchchangeidpage.ClickOnLogoutButton();

	}

}
