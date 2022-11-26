package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class LoginTest extends Utility {
    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }


    public String getTextFromElement(By by){
        WebElement actualTextMessageElement = driver.findElement(by);
        return actualTextMessageElement.getText();
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully(){
        // Click on login button using By.xpath method
        clickOnElement(By.xpath("//a[@href='/users/sign_in']"));

        // Actual Requirements
        String expectedMessage = "Welcome Back!";
        // Storing value in string to compare actual message
        String actualMessage = getTextFromElement(By.xpath("//h1[contains(text(),'Welcome Back!')]"));

    }
    @Test
    public void verifyTheErrorMessage(){
        // Click on login button using By.xpath method
        clickOnElement(By.xpath("//a[@href='/users/sign_in']"));
        //  Send user email using By.id method
        sendTextToElement(By.id("user[email]"),"standard_user");
        // Send password using By.name method
        sendTextToElement(By.name("user[password]"),"secret_sauce");
        // click on login button using xpath
        clickOnElement(By.xpath("//input[@type='submit']"));

        // Actual Requirements
        String expectedMessage = "Invalid email or password.";
        // Storing value in string to compare actual message
        String actualMessage = getTextFromElement(By.xpath("//li[contains(text(),'Invalid email or password.')]"));

    }


    @After
    public void testDown(){
        //closeBrowser();
    }

}