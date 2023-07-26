package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.asm.Advice.Enter;

import org.openqa.selenium.By;
//Selenium Imports
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
///

import com.google.common.base.Verify;


public class LinkedInPost {
    ChromeDriver driver;
    public LinkedInPost()
    {
        System.out.println("Constructor: TestCases");
         WebDriverManager.chromedriver().timeout(30).setup();
         driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public  void LinkedInPost1(){
// Visit LinkedIn  https://in.linkedin.com/ 
driver.get("https://in.linkedin.com/");
// Enter User Name Using Locator "ID" By.id("session_key")
driver.findElement(By.xpath("//input[@name='session_key']")).sendKeys("7349266016");
// Enter Password Using Locator "ID" By.id("session_key")
driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Shubh@123");
// Click on login
driver.findElement(By.xpath("//button[@type='submit']")).click();
// Print the count of 'Who's viewed your profile' and 'Impressions of your post'  
WebElement profileViewsCount = driver.findElement(By.xpath("//a[@href=\"/me/profile-views/\"]/div/div[2]/span/strong"));
System.out.println("Who's viewed your profile count: " + profileViewsCount.getText());

WebElement impressionOfYourPost = driver.findElement(By.xpath("//a[@href=\"/in/sks2605/recent-activity/shares/\"]/div/div[2]/span/strong"));
System.out.println("Impressions of your post count: " + impressionOfYourPost.getText());

// Create a post, sharing with 'Connections only' Using Locator "XPath" //button[@data-control-name='create_post']
WebElement createPost = driver.findElement(By.xpath("//*[contains(@class,'tertiary ember-view share-box-feed-entry')]"));
createPost.click();

//WebElement connectionsOnly = driver.findElement(By.xpath("//button[@class='share-unified-settings-entry-button']"));
WebElement connectionsOnly = driver.findElement(By.xpath("//label[@for='sharing-shared-generic-list-radio-CONNECTIONS_ONLY']"));
connectionsOnly.click();

// Confirm if the post gets posted Using Locator "XPath" xpath("//div[text()='Your post was shared.']
WebElement messageToPost = driver.findElement(By.xpath("//div[contains(@data-placeholder,'What do you want to talk about')]"));
messageToPost.sendKeys("This is a sample post from a controlled Automation Software, please ignore!!");

WebElement postConfirmationMessage = driver.findElement(By.xpath("//div[text()='Your post was shared.']"));
        if (postConfirmationMessage.isDisplayed()) {
            System.out.println("Post successfully posted!");
        } else {
            System.out.println("Failed to post!");
        }

        // Step 6: Close the browser
        driver.quit();
    }
}
    

    //     public void endTest()
    // {
    //     System.out.println("End Test: TestCases");
    //     driver.close();
    //     driver.quit();

    // }


