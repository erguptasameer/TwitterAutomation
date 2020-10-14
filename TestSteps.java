package stepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import junit.framework.Assert;


public class Login_TestSteps {

	public static WebDriver driver;
	@Given("^User is on Home page$")
	public void user_is_on_home_page()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("https://twitter.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	
	@When("^User navigate to Login page$")
	public void user_navigate_to_login_page()
	{
		//click on login button
		driver.findElement(By .xpath("//span[text()='Log in']")).click();
	}
	
	@When("^User enters Username and Password$")
	public void user_enters_username_and_password()
	{
		//Enter user credentials
		driver.findElement(By .xpath("//*[@name='session[username_or_email]']")).sendKeys("gupta.sameer2@gmail.com");
		driver.findElement(By .xpath("//*[@name='session[password]']")).sendKeys("bonjour7");
		driver.findElement(By .xpath("//*[text()='Log in']")).click();
	}
	
	@Then("^User is able to login successfully$")
	public void user_is_able_to_login_successfully()
	{
		String actualTitle = driver.getTitle();
		String expTitle = "Twitter";
        if (actualTitle.contains(expTitle)) {
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed");
        }
	}
    
    @Given("^User is logged in$")
    public void user_is_logged_in()
    {
   	driver.findElement(By .xpath("//*[text()='Home']")).click();
   	String actualTitle = driver.getTitle();
		String expTitle = "Twitter";
       if (actualTitle.contains(expTitle)) {
           System.out.println("Test Passed!");
       } else {
           System.out.println("Test Failed");
     }
    }


	@When("User goes to Edit profile")
	public void user_goes_to_edit_profile()
	{
		driver.findElement(By .xpath("//*[text()='Profile']")).click();
		driver.findElement(By .xpath("//*[text()='Edit profile']")).click();
	}	
        
	@Then("User can update profile details")
	public void user_can_update_profile_details()
	{
		driver.findElement(By .xpath("//*[@placeholder='Add your bio']")).clear();
		driver.findElement(By .xpath("//*[@placeholder='Add your bio']")).sendKeys("Selenium automation user");
		driver.findElement(By .xpath("//*[@placeholder='Add your location']")).clear();
		driver.findElement(By .xpath("//*[@placeholder='Add your location']")).sendKeys("Pune");
		driver.findElement(By .xpath("//*[@placeholder='Add your website']")).clear();
		driver.findElement(By .xpath("//*[@placeholder='Add your website']")).sendKeys("twitter.com");
		driver.findElement(By .xpath("//*[@data-testid='Profile_Save_Button']")).click();
		
		String expBio = "Selenium automation user";
		String actualBio = driver.findElement(By .xpath("//*[@data-testid='UserDescription']/span")).getText();
		Assert.assertEquals(expBio, actualBio);

		String expLoc = "Pune";
		String actualLoc = driver.findElement(By .xpath("//div[@data-testid='UserProfileHeader_Items']/span/span/span")).getText();
		Assert.assertEquals(expLoc, actualLoc);
		
		String expWebsite = "twitter.com";
		String actualWebsite = driver.findElement(By .xpath("//div[@data-testid='UserProfileHeader_Items']/a")).getText();
		Assert.assertEquals(expWebsite, actualWebsite);
		
		
    	}
 
        
}
