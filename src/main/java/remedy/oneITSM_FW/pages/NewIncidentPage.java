package remedy.oneITSM_FW.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class NewIncidentPage {

	private WebDriver driver;
	private By CustomerEmail = By.id("arid_WIN_3_303530000");
	private By Summary = By.xpath("//div[3][@id='WIN_3_1000000000']/textarea[1][@id='arid_WIN_3_1000000000']");
	private By Service = By.id("arid_WIN_3_303497300");
	private By IncidenTypeMenu = By.id("arid_WIN_3_1000000099"); 
	private By IncidentOption = By.xpath("//td[1][text()='Incident']"); 
	private By AssignedGroup = By.id("arid_WIN_3_1000000217");
	private By VendorID = By.id("arid_WIN_3_1000000652");
	private By SaveButton = By.id("WIN_3_301614800");//Save
	private By SearchButton = By.xpath("//a[2][@id='WIN_3_1002']/div[1][@class='btntextdiv']/div[1][@class='f1' and text()='Search']"); 
	private By Incident_ID = By.id("arid_WIN_3_1000000161");
	WebElement InprogressCheckStatus = null;
	String incidentID = null;
	String vendorID = null;

	public NewIncidentPage(WebDriver driver) {
		this.driver = driver;
	}

	public String CreateNewIncident()
	{
		try {
			// 1- Wait till loading of the page 
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			//            --------------------------------------------------------------------
			// 2- Wait till Customer Email be clickable
			//   Waiting element display
			//WebDriverWait wait = new WebDriverWait(driver, 70);
			//wait.until(ExpectedConditions.elementToBeClickable(CustomerEmail)); 
			//driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			//            --------------------------------------------------------------------		
			//3- Choose the Customer mail in" Customer " drop-down list
			// Use " Actions " due to drop-down list 
			Thread.sleep(10000); 
			WebElement emailField =driver.findElement(CustomerEmail);
			emailField = driver.findElement(CustomerEmail);
			emailField.click();
			Actions builder = new Actions(driver); 
			builder.sendKeys("ahmed.elramady@vodafone.com").sendKeys(Keys.ENTER).build().perform();
			Thread.sleep(10000); 
			//          ------------------------------------------------------------------------		  
			// 4- Type the Summary in " Summary " field 
			WebElement summaryField = driver.findElement(Summary);  

			// Test TTWOS - CZ - Amadox integration
			summaryField.sendKeys("Create New Incident using our automation selenium code");
			//         ---------------------------------------------------------------------------	
			// 5- Choose the service from ( Service ) drop-down list
			// Use " Actions " due to drop-down list 
			WebElement serviceCIField = driver.findElement(Service);  	
			serviceCIField.click();
			Actions builder1 = new Actions(driver);

			// TTWOS ->> ROAMING-VHE PROD , CZ ->> VF-INFRA REPORTING-SLS PROD , Amadox ->> 
			builder1.sendKeys("VF-ITSM-PROD").sendKeys(Keys.ENTER).build().perform();
			//     ---------------------------------------------------------------------------------
			// 6- Choose the incident Type 
			WebElement incidentMenuType = driver.findElement(IncidenTypeMenu);
			incidentMenuType.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			WebElement incidentOpt = driver.findElement(IncidentOption);
			incidentOpt.click();
			//	   ---------------------------------------------------------------------------------
			// 7- Select the Assigned Group 
			WebElement assignedGroupField = driver.findElement(AssignedGroup);

			// TTWOS ->> VF-DE OPS-DE , CZ ->> VF OPS-CZ , Amadox ->> 
			assignedGroupField.sendKeys("VF-DE OPS-DE");//we will face auto complete issue
			assignedGroupField.sendKeys(Keys.ENTER);
			//	   ---------------------------------------------------------------------------------
			// 8- Click " Save " Button 
			WebElement saveIncidentBtn = driver.findElement(SaveButton);
			saveIncidentBtn.click();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			Thread.sleep(10000); //this for waiting creation done

			//    ------------------------------------------------------------------------------------	
			//  Doaa Code for integrations 
			// *******************************    
			// 11 - Check if the Ticket is created or not 
			// If the Field of " Incident ID " is Null and empty then the ticket is not Created 
			// It will throw exception ( In Catch ) 		    	 
			incidentID = driver.findElement(Incident_ID).getAttribute("value");
			if(incidentID == null)
			{
				Assert.fail("No Incident was created , please check Exception:  \n ");
			}
			// If the Field of " Incident ID " is not Null then it's Created Successfuly
			else 
			{
				//System.err.println("Incident was created by Selenium with ID : "+IncID);
				System.out.println("Incident was created by Selenium with ID : "+incidentID);
			}
			//ExcelUtil.WriteInExcel("Incident ID: "+ IncID ); 		  
			//		 -----------------------------------------------------------------------------------	
			//11- Write in the Excel sheet the Ticket ID  which is Created 

			//java.util.Date date = new java.util.Date();
		}
		// When Creation of the Ticket is Failed 
		catch (Exception e)
		{
			System.err.println("Your Test case was failed for details check The Exception");
			e.printStackTrace();
		}
		return incidentID;		
	}

	public boolean isreadOnly(WebElement element) {        
		Boolean readOnly = false;       
		readOnly = ((element.getAttribute("disabled") != null) || (element.getAttribute("readonly") != null));  
		return readOnly;        
	}

	public void SearchCreatedIncident(String inc_id) throws Exception
	{
		try
		{
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
			// WebDriverWait wait1 = new WebDriverWait(driver, 5);
			//wait1.until(ExpectedConditions.elementToBeClickable(Incident_ID));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			WebElement IncId_textbox=driver.findElement(Incident_ID);
			IncId_textbox.click();
			IncId_textbox.sendKeys(inc_id);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			WebElement Search_butt= driver.findElement(SearchButton);
			Search_butt.click();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
			//  Thread.sleep(5000);

			vendorID = driver.findElement(VendorID).getAttribute("value");
			if(vendorID == null)
			{
				Assert.fail("No Vendor ID ");
			}
			else 
			{
				System.out.println(" Vendor ID : " + vendorID);
			}        	    
			//              ***************************************************************************************************************	
			String SP=driver.findElement(AssignedGroup).getAttribute("value");        	    
			//  ------------------------------------------------------------------------------------
			WebElement AssGroup = driver.findElement(AssignedGroup);
			boolean F = isreadOnly(AssGroup);
			System.out.println("Disable : "+F);
			String pagestatus="";
			if (F==true)
			{
				pagestatus ="Ticket is dimmed ";
			}
			else 
			{
				pagestatus ="Ticket is editable :( " ;
			}

			System.out.println("Vendor ID: "+ vendorID +"////"+"  With Support group: "+SP+"////"+pagestatus+"////" );
		}
		catch (Exception e)
		{
			Assert.fail("Search Incident was failed with Exception"+e);
		}
	}


}
