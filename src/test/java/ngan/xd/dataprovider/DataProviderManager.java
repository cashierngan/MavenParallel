package ngan.xd.dataprovider;

import ngan.xd.helpers.ExcelHelpers;
import ngan.xd.helpers.Helpers;
import org.testng.annotations.DataProvider;

public class DataProviderManager {
    @DataProvider(name = "data_provider_login", parallel = true)
    public Object[][] dataLoginHRM() {
        return new Object[][]{{"frances.burns", "frances.burns"}, {"frances.burns", "frances.burns"}};
    }

    @DataProvider(name = "data_provider_login_from_excel", parallel = true)
    public Object[][] dataLoginHRMFromExcel() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getExcelData(Helpers.getCurrentDir() + "dataTest/Login.xlsx", "sheet1");
        return data;
    }

//    @DataProvider(name = "data_provider_login_from_excel_multy_excel", parallel = true)
//    public Object[][] dataLoginHRMFromExcelMultyRow() {
//        ExcelHelpers excelHelpers = new ExcelHelpers();
//        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + "dataTest/Login.xlsx", "sheet1", 1, 3);
//        return data;
//    }
}
