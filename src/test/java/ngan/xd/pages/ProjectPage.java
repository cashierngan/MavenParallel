package ngan.xd.pages;

import ngan.xd.utils.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProjectPage {
    WebDriver driver;

    public ProjectPage() {
    }

    private By headerPage = By.xpath("");

    private By buttonThemMoi = By.xpath("//a[normalize-space()='Thêm mới']");
    private By inputTitle = By.xpath("//input[@placeholder='Tiêu đề']");

    public void clickButtonThemMoi() {
        WebUI.clickElement(buttonThemMoi);
    }

    public void enterData() {
        WebUI.clickElement(buttonThemMoi);
    }

    public void AddProject() {
        clickButtonThemMoi();
        enterData();
    }
}
