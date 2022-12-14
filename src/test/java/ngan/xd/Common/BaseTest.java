package ngan.xd.Common;

import io.github.bonigarcia.wdm.WebDriverManager;
import ngan.xd.driver.DriverManager;
import ngan.xd.helpers.CaptureHelpers;
import ngan.xd.helpers.PropertiesHelper;
import ngan.xd.pages.CommonPage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;

public class BaseTest extends CommonPage {

    //    public static WebDriver driver;
    public BaseTest() {
        PropertiesHelper.loadAllFiles();
    }

    @BeforeMethod
    @Parameters({"browser"})
    public static void createDriver(@Optional("chrome") String browser, ITestResult result) throws Exception {
        WebDriver driver = setupDriver(browser);
        DriverManager.setDriver(driver);
        CaptureHelpers.startRecord(result.getName());

    }

    public static WebDriver setupDriver(String browserName) {
        WebDriver driver;
        System.out.println(browserName.trim().toLowerCase());
        switch (browserName.trim().toLowerCase()) {
            case "chrome":
                driver = initChromeDriver();
                break;
            case "firefox":
                driver = initFirefoxDriver();
                break;
            case "edge":
                driver = initEdgeDriver();
                break;
            default:
                System.out.println("Browser: " + browserName + " is invalid, Launching Chrome as browser of choice...");
                driver = initChromeDriver();
        }
        return driver;
    }

    private static WebDriver initChromeDriver() {
        WebDriver driver;
        System.out.println("Launching Chrome browser...");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    private static WebDriver initEdgeDriver() {
        WebDriver driver;
        System.out.println("Launching Edge browser...");
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    private static WebDriver initFirefoxDriver() {
        WebDriver driver;
        System.out.println("Launching Firefox browser...");
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        return driver;
    }

    @AfterMethod
    public static void closeDriver(ITestResult result) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (DriverManager.getDriver() != null) {
            DriverManager.quit();
        }
        try {
            CaptureHelpers.stopRecord();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //Ch???p m??n h??nh
        if (result.getStatus() == ITestResult.FAILURE) {

            // T???o tham chi???u c???a TakesScreenshot v???i driver hi???n t???i
            TakesScreenshot ts = (TakesScreenshot) DriverManager.getDriver();
// G???i h??m capture screenshot - getScreenshotAs
            File source = ts.getScreenshotAs(OutputType.FILE);
//Ki???m tra folder t???n t???i. N??u kh??ng th?? t???o m???i folder
            File theDir = new File("./Screenshots/");
            if (!theDir.exists()) {
                theDir.mkdirs();
            }
// result.getName() l???y t??n c???a test case xong g??n cho t??n File ch???p m??n h??nh lu??n
            try {
                FileHandler.copy(source, new File("./Screenshots/" + result.getName() + ".png"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Screenshot taken: " + result.getName());
        }
    }
}