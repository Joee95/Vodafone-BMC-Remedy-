package remedy.oneITSM_FW.tests;


import org.testng.annotations.Test;
import remedy.oneITSM_FW.base.TestBase;
import remedy.oneITSM_FW.loadProperties.LoadPropertiesFile;


public class TestTicketCancellation extends TestBase{

	// private WebDriver driver;
	String email = LoadPropertiesFile.userdata.getProperty("email");
	String password = LoadPropertiesFile.userdata.getProperty("password");
	String ticketID = LoadPropertiesFile.userdata.getProperty("TicketId");

	@Test
	public void testCancelTicket() throws Exception {

		loginPage.setUsername("yousef.kenawy@vodafone.com");
		loginPage.clickNext();
		loginPage.setPassword("New.pass.word-2");
		loginPage.clickLogin();
		landingPage = loginPage.clickNo();
		landingPage.clickApplicationMenu();
		landingPage.clickIncidentManagement();
		searchPage = landingPage.clickSearchIncident();
		searchPage.SearchForIncident(ticketID);
		searchPage.cancelTicket();

	}
}
