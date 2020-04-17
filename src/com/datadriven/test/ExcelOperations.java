package com.datadriven.test;

import com.excel.utility.Xls_Reader;

public class ExcelOperations {

	public static void main(String[] args) {
		
		Xls_Reader reader = new Xls_Reader("F:\\Vishal_Offc Work\\Workspace\\SeleniumBasics\\src\\com\\testdata\\NewToursRegTestData.xlsx");
		
		if(!reader.isSheetExist("RegTestData"))
		{
			reader.addSheet("HomePage");
		}
		
		int colCount = reader.getColumnCount("RegTestData");
		System.out.println("Total nubmer of columns present in RegTestData sheet is :"+colCount);
		int cellRowNum = reader.getCellRowNum("RegTestData", "Address1", "14,new street");
		System.out.println("cell row number for 14, new street is : "+cellRowNum);
		

	}

}
