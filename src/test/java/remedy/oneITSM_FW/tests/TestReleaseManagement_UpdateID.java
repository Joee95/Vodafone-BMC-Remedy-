package remedy.oneITSM_FW.tests;


import org.testng.annotations.Test;

import remedy.oneITSM_FW.base.TestBase;
import remedy.oneITSM_FW.loadProperties.LoadPropertiesFile;


public class TestReleaseManagement_UpdateID extends TestBase {

	// private WebDriver driver;
	String email = LoadPropertiesFile.userdata.getProperty("email");
	String password = LoadPropertiesFile.userdata.getProperty("password");
	String ticketID = LoadPropertiesFile.userdata.getProperty("TicketId");
	String ChangeID = LoadPropertiesFile.userdata.getProperty("ChangeID");
	String ReleaseID = LoadPropertiesFile.userdata.getProperty("ReleaseID");

	@Test
	public void TestReleasemanagement_Updateid () throws Exception {

		loginPage.setUsername(email);
		loginPage.clickNext();
		loginPage.setPassword(password);
		loginPage.clickLogin();
		landingPage = loginPage.clickNo();
		landingPage.clickApplicationMenu();
		landingPage.ClickOnReleaseManagement();
		searchreleaseidpage = landingPage.ClickOnSearchRelease();
		searchreleaseidpage.ClickOnSearchField(ReleaseID);
		searchreleaseidpage.ClickOnSearchBtn();
		searchreleaseidpage.ClickOnStatusField();
		searchreleaseidpage.scrolltoSaveBtn();
		searchreleaseidpage.ClickOnSaveBtn();

	}

}
