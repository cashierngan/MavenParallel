package ngan.xd.pages;

import ngan.xd.driver.DriverManager;
import ngan.xd.utils.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage extends CommonPage {

    private WebDriverWait wait;


    //Hàm xây dựng
    public LoginPage() {
    }

    //Login
    private String pageText = "Welcome to HRM System";
    private By inputUsername = By.xpath("//input[@id='iusername']");
    private By inputPassword = By.xpath("//input[@id='ipassword']");
    private By buttonSignin = By.xpath("//button[@type='submit']");

    //ForgotPassword
    private By linkForgotPassword = By.xpath("//a[normalize-space()='Forgot password?']");
    private By pageTextForgotPassword = By.xpath("//h4[normalize-space()='Reset your password']");
    private By inputEmaiForgotPassword = By.xpath("//input[@placeholder='Email address']");
    private By buttonReset = By.xpath("//button[@type='submit']");
    private By linkClickHere = By.xpath("//a[normalize-space()='Click here']");


    private By alertMessage = By.xpath("//div[@class = 'toast-message']");

    public DashboardPage login(String email, String password) {
        WebUI.openURL("https://app.hrsale.com/");
        WebUI.setText(inputUsername, email);
        WebUI.setText(inputPassword, password);
        WebUI.clickElement(buttonSignin);

        // wait for pageload
//        wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardPage.menuTrangchu))
        boolean checkMenu = WebUI.checkElementExist(getDashboardPage().menuTrangchu);
        Assert.assertTrue(checkMenu, "Login fail. Không tìm thấy menu trang chủ");
        return new DashboardPage(); // khởi tạo trang Dashboard
    }

    public void loginWithUsernameInValid(String email, String password) {
        WebUI.openURL("https://hrm.anhtester.com/");
        WebUI.setText(inputUsername, email);
        WebUI.setText(inputPassword, password);
        WebUI.clickElement(buttonSignin);
        boolean checkAlertMessage = WebUI.checkElementExist(alertMessage);
        Assert.assertTrue(checkAlertMessage, "Fail message");
        Assert.assertTrue(DriverManager.getDriver().findElement(alertMessage).getText().trim().equals("Invalid Login Credentials."), "Fail. Text NOT match");

    }

    public void loginWithPasswordInValid(String email, String password) {
        WebUI.openURL("https://hrm.anhtester.com/");
        WebUI.setText(inputUsername, email);
        WebUI.setText(inputPassword, password);
        WebUI.clickElement(buttonSignin);
        boolean checkAlertMessage = WebUI.checkElementExist(alertMessage);
        Assert.assertTrue(checkAlertMessage, "Fail message");
        Assert.assertTrue(DriverManager.getDriver().findElement(alertMessage).getText().trim().equals("Invalid Login Credentials.."), "Fail. Text NOT match");
    }

    public void resetPassword(String emailForgot) {
        WebUI.openURL("https://hrm.anhtester.com/");
        WebUI.clickElement(linkForgotPassword);
        Assert.assertTrue(WebUI.getElementText(pageTextForgotPassword).equals("Reset your password"));
        WebUI.setText(inputEmaiForgotPassword, emailForgot);
        WebUI.clickElement(buttonReset);
        WebUI.clickElement(linkClickHere);
        Assert.assertTrue(DriverManager.getDriver().findElement(alertMessage).getText().trim().equals("Invalid Login Credentials.."), "Fail. Text NOT match");


    }
}
