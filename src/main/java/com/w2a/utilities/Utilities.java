package com.w2a.utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Hashtable;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;

import com.w2a.base.Page;


public class Utilities extends Page {
	public static String screenshotName;

	public static void captureScreenshot() throws IOException {

		Date d = new Date();
		screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile,
				new File(System.getProperty("user.dir") + "\\target\\surefire-reports\\html\\" + screenshotName));

	}

	@DataProvider(name = "dp")
	public Object[][] getData(Method m) {
		String sheetName = m.getName();
		log.debug("sheet name = " + sheetName);
		int rows = excel.getRowCount(sheetName);
		log.debug("no. of rows = " + rows);
		int columns = excel.getColumnCount(sheetName);
		log.debug("no. of columns = " + columns);
		Object[][] data = new Object[rows - 1][1];
		Hashtable<String, String> table;
		for (int rowNum = 2; rowNum <= rows; rowNum++) {
			log.debug("rownumber " + rowNum);
			table = new Hashtable<String, String>();
			for (int colNum = 0; colNum < columns; colNum++) {
				log.debug("column number " + colNum);

				table.put(excel.getCellData(sheetName, colNum, 1), excel.getCellData(sheetName, colNum, rowNum));
				log.debug(table);
				data[rowNum - 2][0] = table;
			}

		}
		return data;
	}

	public static boolean isTestRunnable(String testName, ExcelReader excel) {
		String sheetName = "Test_Suite";
		int rows = excel.getRowCount(sheetName);
		for (int rNum = 2; rNum <= rows; rNum++) {
			String testCase = excel.getCellData(sheetName, "TCID", rNum);
			if (testCase.equalsIgnoreCase(testName)) {
				String runMode = excel.getCellData(sheetName, "Runmode", rNum);
				if (runMode.equalsIgnoreCase("Y"))
					return true;
				else
					return false;
			}

		}
		return false;
	}

}
