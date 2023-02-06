package remedy.oneITSM_FW.tests;

import org.testng.annotations.Test;
import remedy.oneITSM_FW.base.TestBase;
import remedy.oneITSM_FW.loadProperties.LoadPropertiesFile;


public class TestTicketCreation extends TestBase {

	// private WebDriver driver;
	String email = LoadPropertiesFile.userdata.getProperty("email");
	String password = LoadPropertiesFile.userdata.getProperty("password");

	@Test
	public void testCreateTicket() throws Exception {
		loginPage.setUsername(email);
		loginPage.clickNext();
		loginPage.setPassword(password);
		loginPage.clickLogin();
		landingPage = loginPage.clickNo();
		landingPage.clickApplicationMenu();
		landingPage.clickIncidentManagement();
		newIncidentPage = landingPage.clickNewIncident();
		newIncidentPage.CreateNewIncident();
	}
}
