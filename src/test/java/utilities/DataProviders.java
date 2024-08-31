package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name = "Logindata")
	public String[][] getData() throws IOException {

		String path = ".\\testData\\Opencart_LoginData.xlsx";// taking xl file from testdata
		ExcelUtility xlutil = new ExcelUtility(path);// creating an object for xl utility

		int totalrows = xlutil.getRowCount("sheet1");
		int totalcols = xlutil.getCellCount("sheet1", 1);

		String logindata[][] = new String[totalrows][totalcols];// created two dimensional array which can store xl data

		for (int i = 1; i <= totalrows; i++) {// 1 read the data for xl stored in 2 dimensional array
			for (int j = 0; j < totalcols; j++) {
				logindata[i - 1][j] = xlutil.getCellData("sheet1", i, j);
			}
		}
		return logindata;// returning 2 dimension array

	}
}
