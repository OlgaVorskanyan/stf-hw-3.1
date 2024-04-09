import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class JoomagTest {
    @Test
    public void jmgTest() {
        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize(); // Maximize browser window

        // Navigate to Joomag website
        driver.get("https://www.joomag.com/");

        // Perform browser navigation actions
        driver.navigate().refresh();
        driver.navigate().back();
        driver.navigate().forward();

        // Click on "Customer Support" link
        WebElement customerSupport = driver.findElement(By.linkText("Customer Support"));
        customerSupport.click();

        // Click on "Get Demo" button
        WebElement getDemo = driver.findElement(By.cssSelector(".primary-button.nav-btn.w-button"));
        getDemo.click();

        // Navigate back
        driver.navigate().back();

        // Click on "Sign In" button
        WebElement signIn = driver.findElement(By.cssSelector(".nav-link-wp.mob-hide.w-inline-block"));
        signIn.click();

        // Click on "Accept Cookies" button
        WebElement acceptCookies = driver.findElement(By.id("CybotCookiebotDialogBodyButtonAccept"));
        acceptCookies.click();

        // Click on "Single Sign In" link
        WebElement singleSignIn = driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[2]/div/div[1]/p/a"));
        singleSignIn.click();

        // Enter email and click on "Log In" button
        driver.findElement(By.id("j-sso-email")).sendKeys("olya.vorskanyan@gmail.com");
        WebElement logIn = driver.findElement(By.cssSelector(".btn.btn-primary.btn-block"));
        logIn.click();

        // Wait for error message and assert its text
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("j-form-error-message")));
        String text = errorMsg.getText();
        assertEquals("SSO may be unavailable or is not configured for this account.", text);
        System.out.println(text);

        // Navigate back
        driver.navigate().back();
        driver.navigate().back();

        // Print text of "Get Demo" button
        WebElement demoText = driver.findElement(By.className("primary-button"));
        System.out.println(demoText.getText());

        // Find all elements with the same class name and print their text
        List<WebElement> similarElements = driver.findElements(By.className("footer-block"));
        for (WebElement element : similarElements) {
            System.out.println(element.getText());
        }

        // Quit WebDriver
        driver.quit();
    }
}
