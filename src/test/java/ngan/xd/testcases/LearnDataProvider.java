package ngan.xd.testcases;

import ngan.xd.dataprovider.DataProviderFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LearnDataProvider {


    @Test(dataProvider = "data_login", priority = 1, dataProviderClass = DataProviderFactory.class)
    public void testLoginDataProvider(String username, String password, int position) {
        System.out.println(username + " - " + password + " - " + position);
    }


    @Test(dataProvider = "data-provider", dataProviderClass = DataProviderFactory.class)
    public void Sum(int a, int b, int result) {
        int sum = a + b;
        Assert.assertEquals(result, sum);
    }

    @Test(dataProvider = "data-provider", dataProviderClass = DataProviderFactory.class)
    public void Diff(int a, int b, int result) {
        int diff = a - b;
        Assert.assertEquals(result, diff);
    }

}
