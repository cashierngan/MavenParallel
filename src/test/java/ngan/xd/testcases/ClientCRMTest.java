package ngan.xd.testcases;

import ngan.xd.Common.BaseTest;
import ngan.xd.pages.ClientCRMPage;
import org.testng.annotations.Test;

public class ClientCRMTest extends BaseTest {
    @Test
    public void checkDataClientPage(){
        ClientCRMPage clientCRMPage = new ClientCRMPage();
        clientCRMPage.signIn();
        clientCRMPage.openClientPage();
        clientCRMPage.selectClientGroup("Vip");
        clientCRMPage.checkSearchTableByColumn(4, "Vip");
    }
}
