package remedy.oneITSM_FW.pages;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TaskPage {

	private WebDriver driver;

	//	private By TaskManagement= By.xpath("//a[1][@class='btn' and contains(.,'Task Manag')]");
	//	private By TaskConsole =By.xpath("//a[1][@class='btn' and contains(.,'Task Manag')]/span[1][text()='Task Management Console']");
	private By SearchTask =By.xpath("//fieldset[1][@class='PageBodyVertical']/div[1][@class='PageBody pbChrome']/div[1][@class='VNavBar arfid301626400 ardbnz2NF_SecondaryNavigation']/div[2][@id='sub-301650500']/div[2][@class and contains(.,' Search Ta')]");
	private By TaskID =By.xpath("//div[1][@id='WIN_4_303611000']/fieldset[1][@class='PageBodyVertical']/div[1][@class='PageBody pbChrome']/div[1][@id='WIN_4_1']/textarea[1][@id='arid_WIN_4_1']");
	private By SearchTaskBtn =By.xpath("//fieldset[1][@class='PageBodyVertical']/div[1][@class='PageBody pbChrome']/a[6][@id='WIN_4_1002' and contains(normalize-space(),'Search')]/div[1][@class='btntextdiv']/div[1][@class='f1' and text()='Search']");
	String Task_ID="TAS000030000502";
	private By TaskTab = By.xpath("//div[1]/dl[1][@class='OuterOuterTab']/dd[3][@class='OuterTab']/span[2][@class='Tab']/a[1][@class='btn f1' and text()='Tasks']");
	private By TaskList = By.id("arid_WIN_3_10003042");
	private By RelateTask= By.xpath("//fieldset[1][@class='PageBodyVertical']/div[1][@class='PageBody pbChrome']/a[3][@id='WIN_3_10003044']");
	//	private By RelateTaskGroupTem= By.id("WIN_0_10006772");
	//	private By RelateTaskTem= By.id("WIN_0_10006855");
	private By TaskName = By.xpath("//textarea[@id='arid_WIN_0_10007000']");
	private By TaskSummary = By.xpath("//textarea[@id='arid_WIN_0_8']");
	private By AssignmentTab = By.xpath("//a[@class='btn f1' and text()='Assignment/Dates']");
	private By AssigneeCompany=By.xpath("//textarea[@id='arid_WIN_0_1000000251']");
	private By AssigneeOrg=By.xpath("//textarea[@id='arid_WIN_0_1000000014']");
	private By AssigneeGroup=By.xpath("//textarea[@id='arid_WIN_0_10002506']");
	private By SaveTask=By.xpath("//a[@id='WIN_0_300000300']");
	private By TaskGroupID=By.xpath("//a[@class='btn' and contains(text(), 'TGR')]");
	private By TaskAdHocID=By.xpath("//a[@class='btn' and contains(text(), 'TAS')]");
	private By TaskTempID=By.xpath("//a[@class='btn' and contains(text(), 'TAS')]");
	//private By BkToCRQ=By.xpath("//a[@class='btn' and contains(text(), 'CRQ')]");
	private By BkToCRQ=By.xpath("//*[@id='WIN_0_304248710']/fieldset/div/dl/dd[5]/span[2]/a");
	private By ViewTask=By.id("WIN_3_10003040");
	private By TaskPhase=By.xpath("//*[@id='WIN_3_1000005950']/a");
	//private By SelectTask=By.xpath("//*[@id='T10006140']/tbody/tr[2]/td[1]/nobr");
	//*[@id="WIN_3_1000005950"]/a
	//	private By TaskChildID2=By.xpath("//div[@ class ='BaseTableInner']/table [@ id ='T10003029']/tbody[1]/tr[3][@arrow='1']");
	String PTaskGroupID;
	String TaskTempIDD;
	String CTaskGroupID1;
	String CTaskGroupID2;
	private By TaskStatus=By.xpath("//*[@id='WIN_6_7']/div/a");
	private By SaveTask2=By.xpath("//*[@id='WIN_6_300000300']");
	private By ViewChildern=By.id("WIN_3_10003080");
	//	private By InfrastructureChange =By.xpath("//a[@class='btn' and text()='Infrastructure Change (Search)']");
	//private By TaskChildID=By.id("arid_WIN_5_1");
	//	private By RefreshTask=By.xpath("//a[@id='WIN_0_304352241']//*[@id='reg_img_304352241']");
	private By TaskChildID1=By.xpath("//a[@class='btn' and contains(text(), 'TAS')]");
	private By Refresh=By.xpath("//fieldset[1][@class='PageBodyHorizontal']/div[1][@class='PageBody pbChrome']/a[2][@id='WIN_0_304352241']/div[1][@class='btnimgdiv']/img[1][@id='reg_img_304352241']");

	public TaskPage(WebDriver driver) {
		this.driver = driver;
	}

	public void SearchTask() {	

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		WebElement element3 = driver.findElement(SearchTask);
		//		WebDriverWait wait2 = new WebDriverWait(driver, 10);
		//		wait2.until(ExpectedConditions.elementToBeClickable(element3));
		element3.click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement element4 = driver.findElement(TaskID);
		element4.sendKeys(Task_ID);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement element5 = driver.findElement(SearchTaskBtn);
		element5.click();
	}

	public void CreateAdhocTaskFromChange() throws InterruptedException {

		Thread.sleep(10000);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		WebElement element11 = driver.findElement(TaskTab);
		//			WebDriverWait wait3 = new WebDriverWait(driver, 150);
		//			wait3.until(ExpectedConditions.elementToBeClickable(element11));
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		element11.click();


		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement element2 = driver.findElement(TaskList);
		element2.click();
		element2.sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ENTER);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement element3 = driver.findElement(RelateTask);
		element3.click();
	}

	public void RelateTaskGroupTemp() throws InterruptedException {

		Thread.sleep(500);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		WebElement element11 = driver.findElement(TaskTab);
		//			WebDriverWait wait3 = new WebDriverWait(driver, 80);
		//			wait3.until(ExpectedConditions.elementToBeClickable(element11));
		Thread.sleep(500);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		element11.click();


		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement element12 = driver.findElement(TaskList);
		element12.click();
		element12.sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ENTER);


		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement element1 = driver.findElement(RelateTask);
		element1.click();


		String parentHandle = driver.getWindowHandle();

		Set<String> PopHandle = driver.getWindowHandles();
		Iterator<String> it = PopHandle.iterator();
		String ChildHandle = "";
		while(it.hasNext())
		{   
			if (it.next() != parentHandle)
			{   
				ChildHandle = it.next().toString();
			}
		}
		Thread.sleep(600);
		driver.switchTo().window(ChildHandle);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		//WebDriverWait wait1 = new WebDriverWait(driver,200);
		Thread.sleep(500);

		//wait1.until(ExpectedConditions.visibilityOfElementLocated(RelateTaskGroupTem)).click();
		driver.switchTo().window(parentHandle);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


		//driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		//WebElement element13 = driver.findElement(RelateTaskGroupTem);
		//element13.click();


		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		WebElement element6 = driver.findElement(Refresh);
		//		WebDriverWait wait4 = new WebDriverWait(driver, 80);
		//		wait4.until(ExpectedConditions.elementToBeClickable(element6));
		Thread.sleep(500);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		element6.click();


		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		WebElement element2 = driver.findElement(ViewTask);
		//		WebDriverWait wait5 = new WebDriverWait(driver, 80);
		//		wait5.until(ExpectedConditions.elementToBeClickable(element2));
		Thread.sleep(500);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		element2.click();


		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		WebElement element3 = driver.findElement(TaskGroupID);
		PTaskGroupID=element3.getText();
		System.out.println("Task Group ID is "+ PTaskGroupID);

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		WebElement element7 = driver.findElement(BkToCRQ);
		element7.click();

		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			WebElement element4 = driver.findElement(ViewChildern);
			//			WebDriverWait wait6 = new WebDriverWait(driver, 80);
			//			wait6.until(ExpectedConditions.elementToBeClickable(element4));
			Thread.sleep(500);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
			element4.click();

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			WebElement element5 = driver.findElement(TaskChildID1);
			CTaskGroupID1=element5.getText();
			System.out.println("Child # 1"+CTaskGroupID1);

			/*driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		WebElement element15 = driver.findElement(TaskChildID2);
		element15.click();

		CTaskGroupID1=element15.getText();
		System.out.println("Child # 1"+CTaskGroupID2);
			 */
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
			element7 = driver.findElement(BkToCRQ);
			element7.click();


		}
		catch (Exception e) {
			System.out.println("");

		}




	}
	public void FillAdhocTask() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Thread.sleep(500);
		String parentHandle = driver.getWindowHandle();
		Set<String> PopHandle = driver.getWindowHandles();
		Iterator<String> it = PopHandle.iterator();
		String ChildHandle = "";
		while(it.hasNext())
		{   
			if (it.next() != parentHandle)
			{   
				ChildHandle = it.next().toString();
				// because the new window will be the last one opened
			}
		}
		Thread.sleep(500);
		driver.switchTo().window(ChildHandle);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(200));
		Thread.sleep(500);
		WebElement element1 = driver.findElement(TaskName);
		WebElement element2 = driver.findElement(TaskSummary);
		WebElement element3 = driver.findElement(AssignmentTab);

		WebElement element7 = driver.findElement(SaveTask);

		Thread.sleep(600);
		driver.switchTo().window(ChildHandle);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
		Thread.sleep(500);
		element1.sendKeys("TaskName1");
		element2.sendKeys("Test");
		element3.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
		Thread.sleep(500);
		WebElement element4 = driver.findElement(AssigneeCompany);
		WebElement element5 = driver.findElement(AssigneeOrg);
		WebElement element6 = driver.findElement(AssigneeGroup);
		element4.sendKeys("Partner Market IT Operation");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
		element5.sendKeys("A1 Slovenia");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
		element6.sendKeys("SiMobile Support A1-SI");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
		Thread.sleep(500);
		//		WebDriverWait wait1 = new WebDriverWait(driver,200);
		//		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='WIN_0_300000300']"))).click();
		element7.click();
		Thread.sleep(500);
		//wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='f1'and text()='Select']"))).click();
		driver.switchTo().window(parentHandle);

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		WebElement element8 = driver.findElement(Refresh);
		//		WebDriverWait wait4 = new WebDriverWait(driver, 80);
		//		wait4.until(ExpectedConditions.elementToBeClickable(element8));
		Thread.sleep(500);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		element8.click();


		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		WebElement element9 = driver.findElement(ViewTask);
		//		WebDriverWait wait5 = new WebDriverWait(driver, 80);
		//		wait5.until(ExpectedConditions.elementToBeClickable(element9));
		Thread.sleep(500);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		element9.click();


		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		WebElement element10 = driver.findElement(TaskAdHocID);
		PTaskGroupID=element10.getText();
		System.out.println("Task AdHoc ID is "+ PTaskGroupID);

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		WebElement element11 = driver.findElement(BkToCRQ);
		element11.click();


	}

	public void RelateTaskTemp() throws InterruptedException {

		Thread.sleep(500);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		WebElement element11 = driver.findElement(TaskTab);
		//		WebDriverWait wait3 = new WebDriverWait(driver, 80);
		//		wait3.until(ExpectedConditions.elementToBeClickable(element11));
		Thread.sleep(500);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		element11.click();


		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement element12 = driver.findElement(TaskList);
		element12.click();
		element12.sendKeys(Keys.ARROW_DOWN,Keys.ENTER);


		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement element1 = driver.findElement(RelateTask);
		element1.click();


		String parentHandle = driver.getWindowHandle();

		Set<String> PopHandle = driver.getWindowHandles();
		Iterator<String> it = PopHandle.iterator();
		String ChildHandle = "";
		while(it.hasNext())
		{   
			if (it.next() != parentHandle)
			{   
				ChildHandle = it.next().toString();
			}
		}






		Thread.sleep(600);
		driver.switchTo().window(ChildHandle);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(200));
		//WebDriverWait wait1 = new WebDriverWait(driver,200);
		Thread.sleep(500);

		//wait1.until(ExpectedConditions.visibilityOfElementLocated(RelateTaskTem)).click();
		driver.switchTo().window(parentHandle);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));


		//driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		//WebElement element13 = driver.findElement(RelateTaskGroupTem);
		//element13.click();


		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		WebElement element6 = driver.findElement(Refresh);
		//		WebDriverWait wait4 = new WebDriverWait(driver, 80);
		//		wait4.until(ExpectedConditions.elementToBeClickable(element6));
		Thread.sleep(500);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		element6.click();


		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		WebElement element2 = driver.findElement(ViewTask);
		//		WebDriverWait wait5 = new WebDriverWait(driver, 80);
		//		wait5.until(ExpectedConditions.elementToBeClickable(element2));
		Thread.sleep(500);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		element2.click();


		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		WebElement element3 = driver.findElement(TaskTempID);
		TaskTempIDD=element3.getText();
		System.out.println("Task Temp ID is "+ TaskTempIDD);

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		WebElement element7 = driver.findElement(BkToCRQ);
		element7.click();
	}

	public void UpdateAdhocTask() throws InterruptedException {

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));

		Thread.sleep(500);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		WebElement element11 = driver.findElement(TaskTab);
		//		WebDriverWait wait3 = new WebDriverWait(driver, 80);
		//		wait3.until(ExpectedConditions.elementToBeClickable(element11));
		Thread.sleep(500);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		element11.click();

		Thread.sleep(500);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		WebElement element12 = driver.findElement(TaskPhase);
		if(element12.isDisplayed()==false) {
			System.out.println("If Condition");
			//			WebDriverWait wait4 = new WebDriverWait(driver, 800);
			//			wait4.until(ExpectedConditions.elementToBeClickable(element12)).click();
			Thread.sleep(500);
			element12.click();
			element12.sendKeys(Keys.ARROW_DOWN,Keys.ENTER);

		}
		else {
			System.out.println("Else Condition");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
			element12.click();
			element12.sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
		}
		Thread.sleep(5000);
		//		WebElement element23=driver.findElement(SelectTask);
		//		WebDriverWait wait5 = new WebDriverWait(driver, 80);
		//		wait5.until(ExpectedConditions.elementToBeClickable(element23)).click();
		//element23.click();


		//		WebElement element2 = driver.findElement(ViewTask);
		//		WebDriverWait wait6 = new WebDriverWait(driver, 80);
		//		wait6.until(ExpectedConditions.elementToBeClickable(element2)).click();
		Thread.sleep(500);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		//element2.click();

		Thread.sleep(200);

		WebElement element1 = driver.findElement(TaskStatus);
		element1.sendKeys(Keys.ARROW_DOWN);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));

		WebElement element3 = driver.findElement(TaskTempID);
		TaskTempIDD=element3.getText();
		System.out.println("Task Temp ID is "+ TaskTempIDD);


		WebElement element4 = driver.findElement(SaveTask2);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		//element4.click();

		System.out.println("It's saved");

		//a[@id='WIN_0_304352241']//*[@id="reg_img_304352241"]



		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		element1.sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN);


		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		element4.click();

		//*WebElement element5 = driver.findElement(RefreshTask);
		//WebDriverWait wait7 = new WebDriverWait(driver, 80);
		//wait7.until(ExpectedConditions.elementToBeClickable(element5)).click();
		//element5.click();
		//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));*/


		Thread.sleep(1000);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		element1.sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN);


		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		element4.click();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		WebElement element7 = driver.findElement(BkToCRQ);
		element7.click();

	}
}
