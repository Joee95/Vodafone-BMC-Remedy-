package remedy.oneITSM_FW.tests;


import remedy.oneITSM_FW.base.TestBase;
import remedy.oneITSM_FW.loadProperties.LoadPropertiesFile;

public class TestKnowledgeSearch extends TestBase{

	//private WebDriver driver;
	String email = LoadPropertiesFile.userdata.getProperty("email");
	String password = LoadPropertiesFile.userdata.getProperty("password");
	String knowledgeID = LoadPropertiesFile.userdata.getProperty("knowledgeId");
}
