package remedy.oneITSM_FW.tests;


import org.testng.annotations.Test;

import remedy.oneITSM_FW.base.TestBase;
import remedy.oneITSM_FW.loadProperties.LoadPropertiesFile;

public class TestChangeManagement_NewID extends TestBase {

	//private WebDriver driver;
	String email = LoadPropertiesFile.userdata.getProperty("email");
	String password = LoadPropertiesFile.userdata.getProperty("password");
	String ticketID = LoadPropertiesFile.userdata.getProperty("TicketId");
	String ChangeID = LoadPropertiesFile.userdata.getProperty("ChangeID");
	String Service = LoadPropertiesFile.userdata.getProperty("Service");


	@Test
	public void testchangemanagement_NewID() throws Exception {

		loginPage.setUsername(email);
		loginPage.clickNext();
		loginPage.setPassword(password);
		loginPage.clickLogin();
		landingPage = loginPage.clickNo();
		landingPage.clickApplicationMenu();
		landingPage.ClickOnChangeManagementModule();
		newchangeidpage = landingPage.ClickOnNewSearch();
		newchangeidpage.setService(Service);
		newchangeidpage.selectService();
		newchangeidpage.SetSummaryField();
		newchangeidpage.ClickOnUrgencyField();
		newchangeidpage.SetManagerGroupField();
		newchangeidpage.ClickOnCategorizationTab();
		newchangeidpage.SetOP_cat_tier1();
		newchangeidpage.SetChangeManagerField();
		newchangeidpage.ClickOnSaveBtn();
	}

}
