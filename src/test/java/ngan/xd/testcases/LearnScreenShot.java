package ngan.xd.testcases;

import ngan.xd.Common.BaseTest;
import ngan.xd.dataprovider.DataProviderManager;
import ngan.xd.helpers.CaptureHelpers;
import ngan.xd.utils.WebUI;
import org.testng.annotations.Test;

public class LearnScreenShot extends BaseTest {


    @Test(dataProvider = "data_provider_login", dataProviderClass = DataProviderManager.class)
    public void testLoginFromDataProvider(String username, String password) throws Exception {

        getLoginPage().login(username, password);
        dangxuat();
        WebUI.sleep(3);
        CaptureHelpers.stopRecord();
    }

}

