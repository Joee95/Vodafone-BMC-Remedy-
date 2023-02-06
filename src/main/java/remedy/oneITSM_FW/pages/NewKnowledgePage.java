package remedy.oneITSM_FW.pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class NewKnowledgePage {

	private WebDriver driver;
	private By ChooseFromKnowledgeDDLBy = By.xpath("(//a[@class='btn btn3d menu'])[1]");
	private By CreateArticleBy = By.xpath("//div[text()='Create']");
	private By Title = By.xpath("//div[@ardbn='ArticleTitle']/textarea[@class='text sr f1']");
	private By DetailTab = By.xpath("/html/body/div[1]/div[5]/div[2]/div/div/div[3]/fieldset/div/div/div/div/div[3]/fieldset/div/div/div/div[4]/div[3]/div/div/div[3]/fieldset/div/div/div/div/div[2]/fieldset/div/div/div/div/div[2]/fieldset/div/div/div[2]/div[2]/div/dl/dd[2]/span[2]/a");
	private By ArticleID = By.xpath("//dd/span/a[contains(text(),'KBA')]"); 
	private By SaveArticle = By.xpath("//a/div/div[text()='Save']");
	private By Visibility = By.xpath("//*[@id='sub-301648200']/div[1]/span");
	private By VisibilityGroup = By.xpath("//*[@id='WIN_0_302297851']/a/img");
	private By Save_Vs_group = By.xpath("//*[@id='WIN_0_302297801']/div/div");
	// private By Close_Vs_form = By.xpath("//*[@id='WIN_0_301614900']/div/div");
	private By VisibilityGroupType = By.xpath("/html/body/div[3]/div[2]/table/tbody/tr[1]/td[1]");
	private By Add = By.xpath("//*[@id='WIN_0_302301027']/div/div");
	private By Add_node = By.id("addButtonImg");
	private By shift_right = By.xpath("//*[@id='rightButtonImg']");
	private By shift_left = By.id("leftButtonImg"); 
	String status = null;
	String Textid = "";
	String textcontent = "";
	String Article_ID = "";

	public NewKnowledgePage(WebDriver driver) {
		this.driver = driver;
	}

	public String CreateNewArticle(String TypeOfArticle) throws InterruptedException
	{		
		// 1- save the Current Window  
		String winHandleBefore = driver.getWindowHandle(); 
		driver.manage().timeouts(). pageLoadTimeout(Duration.ofSeconds(20));	
		//   -----------------------------------------------------------------------------------------------------------		
		//2- Switch to new window opened (Which contains Article types )
		for(String winHandle : driver.getWindowHandles())
		{
			driver.switchTo().window(winHandle);
		}
		Thread.sleep(10000);
		driver.manage().timeouts(). pageLoadTimeout(Duration.ofSeconds(20));	
		// -----------------------------------------------------------------------------------------------------------------
		//3- Click on drop-down list
		WebElement ChooseFromKnowledgeDDL = driver.findElement(ChooseFromKnowledgeDDLBy);
		ChooseFromKnowledgeDDL.click();	
		Thread.sleep(10000);
		// -----------------------------------------------------------------------------------------------------------------
		//4- Choose the type of the article
		WebElement Article = driver.findElement(By.xpath("//table[@class='MenuTable']//td[text()='"+TypeOfArticle+"']"));
		Article.click();
		driver.manage().timeouts(). pageLoadTimeout(Duration.ofSeconds(20));
		// -------------------------------------------------------------------------------------------------------------------
		//5- Click on " Create " Button
		WebElement CreateArticle = driver.findElement(CreateArticleBy);
		CreateArticle.click();
		Thread.sleep(10000);
		//  -------------------------------------------------------------------------------------------------------------------	
		//6- Switch to main window to open Create Knowledge window 
		for(String winHandle : driver.getWindowHandles())
		{
			driver.switchTo().window(winHandle);
		}
		driver.switchTo().window(winHandleBefore);
		Thread.sleep(10000);
		//  --------------------------------------------------------------------------------------------------------------------
		//7- Fill  " Title " field   
		WebElement KnowledgeTitle = driver.findElement(Title);
		KnowledgeTitle.sendKeys("        Test Automation Article");	
		driver.manage().timeouts(). pageLoadTimeout(Duration.ofSeconds(20));
		//  ----------------------------------------------------------------------------------------------------------------------
		//8- Visibility 
		//-------------------------------------------
		//  1) save the Current Window  
		String winHandleBefore1 = driver.getWindowHandle(); 
		//driver.manage().timeouts(). pageLoadTimeout(15, TimeUnit.SECONDS);			
		//   2) press on Visibility button
		WebElement Visible=driver.findElement(Visibility);
		Visible.click();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

		//    3) Switch to new window opened (Which contains Visibility types )
		for(String winHandle : driver.getWindowHandles())
		{
			driver.switchTo().window(winHandle);
		}
		Thread.sleep(10000);		
		//    4)  Click on drop-down list
		//WebDriverWait wait = new WebDriverWait(driver, 20);
		//wait.until(ExpectedConditions.elementToBeClickable(VisibilityGroup)); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement ChooseVisibility = driver.findElement(VisibilityGroup);
		ChooseVisibility.click();	
		Thread.sleep(2000);
		//      5) Choose the type of the visibility group
		boolean staleElement = true; 
		while(staleElement){
			try{
				driver.findElement(VisibilityGroupType).click();
				staleElement = false;

			} catch(StaleElementReferenceException e){
				staleElement = true;
			}
		}
		//       6) click on add button 
		WebElement addgroup=driver.findElement(Add);
		addgroup.click();
		driver.manage().timeouts(). pageLoadTimeout(Duration.ofSeconds(20));		
		//       7) click on save button
		WebElement save =driver.findElement(Save_Vs_group);
		save.click();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));			
		//     8)  Return to the dafult page     
		for(String winHandle : driver.getWindowHandles())
		{
			driver.switchTo().window(winHandle);
		}
		driver.switchTo().window(winHandleBefore1);
		driver.manage().timeouts(). pageLoadTimeout(Duration.ofSeconds(20));
		Thread.sleep(30000); 
		//  ------------------------------------------------------------------------------------------------------------------------		
		//9- Fill Content field of each type of articles
		// 1) In case of Known Error 
		if (TypeOfArticle=="Known Error")
		{
			Textid="rtf_text_302311208";
			textcontent ="                                            ROOT CAUSE ";
			TypeInText( Textid,textcontent); 
			Thread.sleep(5000);	
			Textid="div_0_302311207";
			textcontent ="                                     ERROR ";
			TypeInText( Textid,textcontent);
			Thread.sleep(7000);		
			Textid="rtf_text_302311202";
			textcontent ="              Technical notes";
			TypeInText( Textid,textcontent);
			Thread.sleep(5000);
			Textid="rtf_text_302311209";
			textcontent ="                                             Work around ";
			TypeInText( Textid,textcontent);
			Thread.sleep(5000);	
		}	
		//---------------------------------------------------------------------------------------
		// 2) In case of Reference 
		if (TypeOfArticle=="Reference")
		{
			Textid="rtf_text_302311210";
			textcontent ="               Reference Bla Bla Bla ";
			TypeInText( Textid,textcontent);	
		}
		//---------------------------------------------------------------------------------------
		// 3) In case of How to 
		if (TypeOfArticle=="How To")
		{
			// Rich Text Editor, rtf_text_302311200 question
			Textid="rtf_text_302311200";
			textcontent ="             Question";
			TypeInText( Textid,textcontent);
			Thread.sleep(5000);	
			//Rich Text Editor, rtf_text_302311201 Answer
			Textid="rtf_text_302311201";
			textcontent ="              Answer";
			TypeInText( Textid,textcontent);
			Thread.sleep(7000);	
			// Rich Text Editor, rtf_text_302311202   Technical notes
			Textid="rtf_text_302311202";
			textcontent ="              Technical notes";
			TypeInText( Textid,textcontent);	
		} 
		//---------------------------------------------------------------------------------------
		// 4) In case of Decision tree 
		if (TypeOfArticle=="Decision Tree")
		{
			Create_DecisioN_Tree();

		}
		//---------------------------------------------------------------------------------------
		// 5) In case of Problem solution 
		if (TypeOfArticle=="Problem Solution")
		{
			//Rich Text Editor, rtf_text_302311205  problem
			Textid="rtf_text_302311205";
			textcontent ="              problem";
			TypeInText( Textid,textcontent);
			Thread.sleep(5000);	
			//Rich Text Editor, rtf_text_302311206   Solution 
			Textid="rtf_text_302311206";
			textcontent ="              Solution";
			TypeInText( Textid,textcontent);
			Thread.sleep(5000);	
			//Rich Text Editor, rtf_text_302311202  technical notes
			Textid="rtf_text_302311202";
			textcontent ="              Technical notes";
			TypeInText( Textid,textcontent);	
		}		
		//  ------------------------------------------------------------------------------------------------------------------------
		//10- Click on  " Details "    
		WebElement KnoweldegDetails = driver.findElement(DetailTab);
		KnoweldegDetails.click();
		driver.manage().timeouts(). pageLoadTimeout(Duration.ofSeconds(20));	
		//  ------------------------------------------------------------------------------------------------------------------------
		//11- Get ID of the element 
		WebElement KnowledgeID = driver.findElement(ArticleID);
		Article_ID =KnowledgeID.getText();
		String[] parts = Article_ID.split(" ");
		String id = parts[0];
		System.out.println("New Article is created with ID:"+id);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		//  --------------------------------------------------------------------------------------------------------------------------
		//12- Save the article 
		WebElement KnowledgeSave = driver.findElement(SaveArticle);
		KnowledgeSave.click();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		//  ---------------------------------------------------------------------------------------------------------------------------
		//13- Update status to be Draft  
		status = "Draft";
		Update (  status , KnowledgeSave ) ;
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		Thread.sleep(5000);
		//  -----------------------------------------------------------------------------------------------------------------------------
		//14- Update status to be 
		status="SME Review";
		Update (  status , KnowledgeSave ) ;
		Thread.sleep(5000);
		//  -----------------------------------------------------------------------------------------------------------------------------
		//15- Update status to be 
		status="Publish Approval";
		Update (  status , KnowledgeSave ) ;
		Thread.sleep(5000);
		//  -----------------------------------------------------------------------------------------------------------------------------
		//16- Refresh the article to be " published "
		WebElement RefreshArticle=driver.findElement(By.xpath("//*[@id='reg_img_304352241']"));
		RefreshArticle.click();
		//  ------------------------------------------------------------------------------------------------------------------------------
		//17- Return back to " Details " tab after refresh to close the article
		KnoweldegDetails.click();
		driver.manage().timeouts(). pageLoadTimeout(Duration.ofSeconds(20)); 
		//  -------------------------------------------------------------------------------------------------------------------------------
		//18- Update status to be " Retire Approval " ( close ) 
		/*	status="Retire Approval";
			Update (  status , KnowledgeSave ) ;
			Thread.sleep(5000);	 */

		return id;
	}

	///                                Update Status Function                                             ///
	///                          ---------------------------------------                                  ///
	//                              Update Status  Function                                        //
	//	                           **************************************                            //
	public void Update ( String status ,WebElement KnowledgeSave ) throws InterruptedException
	{
		// 1- Wait 20 seconds to make sure that the drop-down list of status is click able 
		//WebDriverWait wait = new WebDriverWait(driver, 20);
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'ArticleStatusDisplay')]/a")));   
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//div[contains(@class,'ArticleStatusDisplay')]/a")).click();	
		Thread.sleep(2000);
		// 2- Conditions to check which status , we want to update , and click on it 
		if (status == "Draft")
		{
			//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@class='MenuTable']//tr/td[text()='Draft']")));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.findElement(By.xpath("//table[@class='MenuTable']//tr/td[text()='Draft']")).click();
		}
		if (status == "SME Review")
		{
			//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@class='MenuTable']//tr/td[text()='SME Review']")));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.findElement(By.xpath("//table[@class='MenuTable']//tr/td[text()='SME Review']")).click();
		}
		if ( status == "Publish Approval")
		{
			//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@class='MenuTable']//tr/td[text()='Publish Approval']")));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.findElement(By.xpath("//table[@class='MenuTable']//tr/td[text()='Publish Approval']")).click();
		}
		if ( status == "Retire Approval")
		{
			//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@class='MenuTable']//tr/td[text()='Retire Approval']")));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.findElement(By.xpath("//table[@class='MenuTable']//tr/td[text()='Retire Approval']")).click();
		}
		// 3- Click on save button to save the status update
		KnowledgeSave.click();	
	}
	///                                Typing in text boxes function                                      ///
	///                          ---------------------------------------                                  ///
	//                                Typing in content ( text boxes ) Function                  //
	//	                            ***************************************                        //
	public void TypeInText(String Textid,String textcontent)
	{
		// 1- Switch to frame which contain the element ( text box )
		driver.switchTo().frame(1);
		// 2- Find the element ( text box ) and typing inside it by sendkeys built in function 
		WebElement element=driver.findElement(By.id(Textid));
		Actions actions = new Actions(driver);
		actions.click();
		actions.sendKeys(element, textcontent).build().perform();
		//3- Switch to default frame of the page and wait 15 sec
		driver.switchTo().defaultContent();	
		driver.manage().timeouts(). pageLoadTimeout(Duration.ofSeconds(20));
	}

	///                               Decision Tree Creation function                                     ///
	///                          ---------------------------------------                                  ///
	//                                 Decision Tree creation Function                         //
	//	                             ***************************************                     //
	public void Create_DecisioN_Tree() throws InterruptedException
	{
		// 1-Switch to the frame which is containing the nodes 
		driver.switchTo().frame(1);
		driver.switchTo().frame(1);
		//-----------------------------------------------------------------------------------------------------------------------------
		// 2- Type on the parent Node 
		WebElement element=driver.findElement(By.xpath("//*[@id='dt_desc_0']"));
		Actions actions = new Actions(driver);
		actions.click();
		actions.sendKeys(element, "  Age < 30 ?").build().perform();
		Thread.sleep(5000);
		//-------------------------------------------------------------------------------------------------------------------------------
		// 3- Click Add node 
		driver.findElement(Add_node).click();
		Thread.sleep(5000);
		//-----------------------------------------------------------------------------------------------------------------------------
		//4- First Choice  ( Yes ) (Eat's a lot of pizza ? )
		driver.findElement(By.xpath("//*[@id='dt_title_1']")).clear();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='dt_desc_1']")).sendKeys("    Eat's a lot of pizza ?");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='dt_title_1']")).sendKeys("     YES ?");
		Thread.sleep(5000);
		// Add 2 more choices inside it 
		// 1)- ( yes )
		driver.findElement(Add_node).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='dt_title_2']")).clear();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='dt_title_2']")).sendKeys("     YES ?");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='dt_desc_2']")).sendKeys("   UNFIT :( ");
		Thread.sleep(5000);
		driver.findElement(shift_right).click();
		Thread.sleep(5000);
		//--------------------------------------------------------------------------------------
		//  2)- (NO)
		driver.findElement(Add_node).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='dt_title_3']")).clear();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='dt_title_3']")).sendKeys("  NO ?"); 
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='dt_desc_3']")).sendKeys("    FIT ^_^ "); 
		Thread.sleep(5000);
		//-----------------------------------------------------------------------------------------------------------------------------   
		//4- First Choice  ( NO ) 
		driver.findElement(Add_node).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='dt_title_4']")).clear();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='dt_desc_4']")).sendKeys("    Exercises in the morning ?");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='dt_title_4']")).sendKeys("     NO ?");
		Thread.sleep(5000);
		driver.findElement(shift_left).click();
		// Add 2 more choices inside it 
		// 1)- ( yes )
		Thread.sleep(5000);
		driver.findElement(Add_node).click();
		driver.findElement(By.xpath("//*[@id='dt_title_5']")).clear();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='dt_title_5']")).sendKeys("     YES ?"); 
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='dt_desc_5']")).sendKeys("   FIT ^^ ");
		Thread.sleep(5000);
		driver.findElement(shift_right).click();
		Thread.sleep(5000);
		//--------------------------------------------------------------------------------------
		//  2)- (NO)
		driver.findElement(Add_node).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='dt_title_6']")).clear();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='dt_title_6']")).sendKeys("  NO ?"); 
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='dt_desc_6']")).sendKeys("    UNFIT :( "); 
		Thread.sleep(5000);
		// 3- Switch to default frame 
		driver.switchTo().defaultContent();	

	}

}
