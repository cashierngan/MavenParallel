package ngan.xd.pages;

import ngan.xd.utils.WebUI;
import org.openqa.selenium.By;

public class CommonPage {
    
    // Khai báo đối tượng cho Class chung
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private ProjectPage projectPage;

    // Object chung
    public By buttonDangXuat = By.xpath("//a[@class='btn btn-smb btn-outline-primary rounded-pill']");

    // Hàm chung để get Khởi tạo của các trang khai báo ở trên và các hàm xử lý chung
    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }

    // Khởi tạo giá trị cho tất cả các đối tượng trên
    public DashboardPage getDashboardPage() {
        if (dashboardPage == null) {
            dashboardPage = new DashboardPage();
        }
        return dashboardPage;
    }

    public ProjectPage getProjectPage() {
        if (projectPage == null) {
            projectPage = new ProjectPage();
        }
        return projectPage;
    }

    public void dangxuat() {
        WebUI.clickElement(buttonDangXuat);
    }

}
