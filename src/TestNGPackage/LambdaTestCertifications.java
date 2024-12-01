package TestNGPackage;

import java.util.HashMap;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LambdaTestCertifications {
    WebDriver driver;
    WebDriverWait wait;

    @Parameters({"browser", "url"})
    @BeforeMethod
    public void setUp(String browser, String url) {
    	ChromeOptions browserOptions = new ChromeOptions();
    	browserOptions.setPlatformName("Windows 11");
    	browserOptions.setBrowserVersion("130");
    	HashMap<String, Object> ltOptions = new HashMap<String, Object>();
    	ltOptions.put("username", "pandhari.0305");
    	ltOptions.put("accessKey", "wALu2mEt2CueZQBRMNMHCdND0kh9ebZuIcmfWS2LcIgYcyP027");
    	ltOptions.put("project", "Untitled");
    	ltOptions.put("selenium_version", "4.0.0");
    	ltOptions.put("w3c", true);
    	browserOptions.setCapability("LT:Options", ltOptions);
    	
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("ie")) {
            driver = new InternetExplorerDriver();
        }
        driver.get(url);
        wait = new WebDriverWait(driver,null);
    }

    @Test(timeOut = 20000)
    public void testScenario1() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.tagName("body")));
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.getTitle(), "LambdaTest");
        softAssert.assertAll();
    }

    @Test
    public void testScenario2() {
        driver.findElement(By.linkText("Checkbox Demo")).click();
        WebElement singleCheckbox = driver.findElement(By.id("isAgeSelected"));
        singleCheckbox.click();
        Assert.assertTrue(singleCheckbox.isSelected());
        singleCheckbox.click();
        Assert.assertFalse(singleCheckbox.isSelected());
    }

    @Test
    public void testScenario3() {
        driver.findElement(By.linkText("Javascript Alerts")).click();
        driver.findElement(By.xpath("//button[text()='Click Me']")).click();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "I am an alert box!");
        alert.accept();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
