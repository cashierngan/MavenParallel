package ngan.xd.pages;

import ngan.xd.utils.WebUI;
import org.openqa.selenium.By;

public class DashboardPage extends CommonPage {

    ProjectPage projectPage;

    public DashboardPage() {

    }

    private By menuProject = By.xpath("//span[contains(text(),'Dự án')]");
    private By menuTasks = By.xpath("//a[@href='https://hrm.anhtester.com/erp/tasks-list']");
    public By menuTrangchu = By.xpath("//span[contains(text(),'Trang chủ')]");


    public void openProject() {
        System.out.println("Đã mở project");
        WebUI.clickElement(menuProject);
    }

}
