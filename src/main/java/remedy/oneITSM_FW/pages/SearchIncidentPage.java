package remedy.oneITSM_FW.pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;



public class SearchIncidentPage {

	private WebDriver driver;

	//	private By CustomerEmail = By.id("arid_WIN_3_303530000");
	//	private By Summary=By.xpath("//div[3][@id='WIN_3_1000000000']/textarea[1][@id='arid_WIN_3_1000000000']");
	//	private By Service =By.id("arid_WIN_3_303497300");
	//	private By IncidenTypeMenu=By.id("arid_WIN_3_1000000099"); 
	//	private By IncidentOption=By.xpath("//td[1][text()='Incident']"); 
	//	private By AssignedGroup= By.id("arid_WIN_3_1000000217");
	//	private By VendorID=By.id("arid_WIN_3_1000000652");
	private By SaveButton= By.id("WIN_3_301614800");//Save
	private By SearchButton= By.xpath("//a[2][@id='WIN_3_1002']/div[1][@class='btntextdiv']/div[1][@class='f1' and text()='Search']"); 
	private By Incident_ID=By.id("arid_WIN_3_1000000161");
	WebElement InprogressCheckStatus = null;
	private By Status=By.xpath("//*[@id='T1020']/tbody/tr[2]/td[9]/nobr/span");
	String IncID = null;
	String VendID = null;

	public SearchIncidentPage(WebDriver driver) {
		this.driver = driver;
	}

	//	public boolean isreadOnly(WebElement element) {        
	//	    Boolean readOnly = false;       
	//	    readOnly = ((element.getAttribute("disabled") != null) || (element.getAttribute("readonly") != null));  
	//	    return readOnly;        
	//	}

	public void SearchForIncident(String ticketID) throws Exception
	{
		try
		{

			Thread.sleep(10000);
			WebElement IncidentIdField = driver.findElement(Incident_ID);
			IncidentIdField.click();
			IncidentIdField.sendKeys(ticketID);

			WebElement SearchBtn = driver.findElement(SearchButton);
			SearchBtn.click();

			//			VendID = driver.findElement(VendorID).getAttribute("value");
			//			if(VendID == null)
			//			{
			//				Assert.fail("No Vendor ID ");
			//			}
			//			else 
			//			{
			//				System.out.println(" Vendor ID : " + VendID);
			//			}        	    
			//			            
			//			String SupportGroupName = driver.findElement(AssignedGroup).getAttribute("value");        	    
			//			
			//			WebElement AssignedGroupField = driver.findElement(AssignedGroup);
			//			boolean F = isreadOnly(AssignedGroupField);
			//			System.out.println("Disable : " + F);
			//			String pagestatus="";
			//			if (F==true)
			//			{
			//				pagestatus ="Ticket is dimmed ";
			//			}
			//			else 
			//			{
			//				pagestatus ="Ticket is editable :( " ;
			//			}
			//
			//			System.out.println("Vendor ID: "+VendID+"////"+"  With Support group: "+SupportGroupName+"////"+pagestatus+"////" );
		}
		catch (Exception e)
		{
			Assert.fail("Search Incident was failed with Exception" + e);
		}
	}


	public String cancelTicket() throws InterruptedException
	{
		Thread.sleep(7000);

		String cancellationResult="";
		// 1- Boolean to check if the Ticket exist in oneITSM or needs approval first ;) 
		Boolean isPresent = driver.findElements(By.xpath("//*[@id='T1020']/tbody/tr[2]/td[9]/nobr/span")).size() > 0;

		// 2- If Ticket Exists
		if (isPresent.equals(true))
		{
			// A- Get status value from Status drop-down list
			Thread.sleep(5000);
			WebElement Ticket_Status = driver.findElement(Status);
			String ticketCurrentStatus = Ticket_Status.getText();
			System.out.println("try :"+ ticketCurrentStatus);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));  
			// B- Cancellation depends on status 
			WebElement saveBtn = driver.findElement(SaveButton);
			if (ticketCurrentStatus.equals("Cancelled"))
			{
				cancellationResult=" The ticket is already Cancelled !!! ";
			}
			if (ticketCurrentStatus.equals("Assigned"))
			{    	
				String StatusXpath="//table[@class='MenuTable']//tbody//tr[2]//td[1]";
				updateStatus(StatusXpath);
				cancellationResult="The ticket was Assigned and cancelled Successfully... ";
				saveBtn.click();
			}
			if (ticketCurrentStatus.equals("In Progress"))
			{
				String StatusXpath="/html/body/div[4]/div[2]/table/tbody/tr[1]/td[1]";
				updateStatus(StatusXpath);   
				cancellationResult="The ticket was In-Progress and cancelled Successfully... ";
				saveBtn.click();
			}
			if (ticketCurrentStatus.equals("Resolved"))
			{
				System.out.println("The ticket is Resolved ... ");
				String StatusXpath_Inprogress="/html/body/div[4]/div[2]/table/tbody/tr[2]/td[1]";
				updateStatus(StatusXpath_Inprogress);
				saveBtn.click();

				System.out.println("The ticket status changed to in-progress  ... ");	 
				ticketCurrentStatus = Ticket_Status.getText();
				System.out.println("try :"+ ticketCurrentStatus);
				String StatusXpath_Cancelled="/html/body/div[4]/div[2]/table/tbody/tr[2]/td[1]"; 
				updateStatus(StatusXpath_Cancelled);
				cancellationResult="The ticket Resolved and cancelled Successfully... ";
				saveBtn.click();
			}

		}
		//    -------------------------------------------------------------------------------------------------------------------------------------
		//       2- If Ticket Not Exist 
		else 
		{       	
			// A- switch to iframe ( The window appears not a popup window or alert :( ... it's just window with new Iframe )
			driver.switchTo().frame(2);
			Thread.sleep(7000);
			WebElement OK = driver.findElement(By.xpath("/html/body/div[2]/a"));
			Actions actions = new Actions(driver);
			actions.moveToElement(OK).click().perform();
			// C- Return to Default Iframe
			driver.switchTo().defaultContent();	
			cancellationResult =" The ticket not exist in oneITSM , please try to approve it !!!";
		}

		//  5) NewSearch  //

		Thread.sleep(7000);
		//    2- Click on NewSearch Button at the top left of the page 
		WebElement x=driver.findElement(By.xpath("/html/body/div[1]/div[5]/div[2]/div/div/div[3]/fieldset/div/div/div/div/div[3]/fieldset/div/div/div/div[1]/table/tbody/tr/td[2]/a[1]/span"));
		Actions actions = new Actions(driver);
		actions.moveToElement(x).click().perform();

		return cancellationResult;
	}

	public void updateStatus(String StatusXpath) throws InterruptedException
	{

		//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		//
		//		 //1- Click on status drop-down list
		//		 WebElement x=driver.findElement(By.xpath("//input[@id='arid_WIN_3_7']"));
		//		 
		//		 ((JavascriptExecutor)driver).executeScript("window.scrollTo(0,"+x.getLocation().y+")");
		//     	// driver.findElement(By.xpath("//*[@id='WIN_3_2000000001']/a")).click();
		//		 x.click();
		//    	 //2-select cancelled from drop-down list
		//     	// wait.until(ExpectedConditions.elementToBeClickable(By.xpath(StatusXpath)));
		//		 Thread.sleep(5000);
		//	     driver.findElement(By.xpath(StatusXpath)).click();    


		//1- Click on status drop-down list
		WebElement statusMenu = driver.findElement(By.id("arid_WIN_3_900000325"));
		((JavascriptExecutor)driver).executeScript("window.scrollTo(0," + statusMenu.getLocation().y+")");

		wait.until(ExpectedConditions.elementToBeClickable(statusMenu));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));


		statusMenu.click();

		// wait.until(ExpectedConditions.elementToBeClickable(By.xpath(StatusXpath)));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath(StatusXpath)).click();    
	}
}
