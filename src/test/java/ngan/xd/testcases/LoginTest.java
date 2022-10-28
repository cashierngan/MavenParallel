package ngan.xd.testcases;

import ngan.xd.Common.BaseTest;
import ngan.xd.dataprovider.DataProviderManager;
import ngan.xd.helpers.PropertiesHelper;
import ngan.xd.utils.WebUI;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class LoginTest extends BaseTest {
//    public ngan.xd.pages.LoginPage loginPage;

    @BeforeMethod
//    public void LoginTest() {
//        //Truyền driver từ BaseTest sang các class Page
//        loginPage = new LoginPage();
////        PropertiesHelper.setValue("username", "client01");
////        PropertiesHelper.setValue("pin", "123");
//    }

    @Test(dataProvider = "data_provider_login", dataProviderClass = DataProviderManager.class)
    public void testLoginFromDataProvider(String username, String password) {
        getLoginPage().login(username, password);
        getLoginPage().dangxuat();
        WebUI.sleep(3);
    }

    @Test(dataProvider = "data_provider_login_from_excel", dataProviderClass = DataProviderManager.class)
    public void testLoginFromDataProviderFromExcel(String username, String password, String result) {
        getLoginPage().login(username, password);
        getLoginPage().dangxuat();
        WebUI.sleep(3);
    }

    @Test(dataProvider = "data_provider_login_from_excel_multy_excel", dataProviderClass = DataProviderManager.class)
    public void testLoginFromDataProviderFromExcel1(Hashtable<String, String> data) {
        getLoginPage().login(data.get("username"), data.get("password"));
        getLoginPage().dangxuat();
        WebUI.sleep(3);
    }

    @Test
    public void testLoginSuccess() {
        getLoginPage().login(PropertiesHelper.getValue("username"), PropertiesHelper.getValue("password"));
        for (int i = 1; i <= 3; i++) {

        }
        getLoginPage().dangxuat();
        WebUI.sleep(3);
    }

    @Test
    public void loginWithUsernameInValid() {

        getLoginPage().loginWithUsernameInValid("client0431", "123456");
    }

    // get last row number -> lấy số lượng tất cả các row value
//    public int getRowsNumber() {
//        int lastRowNum = sheet.getLastRowNum();
//        return lastRowNum;
//    }


}

