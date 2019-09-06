package com.lemon.api.auto;

import java.io.File;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class ExcelUtil {

	public static Object[][] datas() {

		String excelPath = System.getProperty("user.dir") + "/src/test/resources/Case1.xlsx";
		// 获取Workbook对象
		try {
			Workbook workbook = WorkbookFactory.create(new File(excelPath));
			// 获取sheet对象
			Sheet sheet = workbook.getSheet("用例");
			// 获取行
			for (int i = 1; i <= 5; i++) {
				Row row = sheet.getRow(i);
				for (int j = 5; j <= 6; j++) {
					Cell cell = row.getCell(j);
					cell.setCellType(CellType.STRING);
					String value = cell.getStringCellValue();
					System.out.println(value);
				}

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 获取列

		return null;
	}

	@Test
	public void printPath() {
		String path = System.getProperty("user.dir");
		System.out.println(path);
	}

	public static void main(String[] args) {
		ExcelUtil.datas();
		// test();
	}
}
