package com.test.utility;

import java.util.ArrayList;

import com.excel.utility.Xls_Reader;

public class TestNGTestUtil {
	
	static Xls_Reader reader;
	
	public static ArrayList<Object[]> getDataFromExcel() {
		
		
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		
		
		// we have included the below try catch block bcoz if in future if we delete the excel sheet then this block will give exception
		try {
			reader = new Xls_Reader("F:\\Vishal_Offc Work\\Workspace\\SeleniumBasics\\src\\com\\testdata\\NewToursRegTestData.xlsx");
		} catch(Exception e) {
			e.printStackTrace();
		}
		for(int rowNum = 2 ; rowNum<=reader.getRowCount("RegTestData") ; rowNum++ ) {
			
			String firstName = reader.getCellData("RegTestData", "FirstName", rowNum);
			String LastName = reader.getCellData("RegTestData", "LastName", rowNum);
			String Phone = reader.getCellData("RegTestData", "Phone", rowNum);
			String Email = reader.getCellData("RegTestData", "Email", rowNum);
			String Address1 = reader.getCellData("RegTestData", "Address1", rowNum);
			String Address2 = reader.getCellData("RegTestData", "Address2", rowNum);
			String City = reader.getCellData("RegTestData", "City", rowNum);
			String State = reader.getCellData("RegTestData", "State", rowNum);
			String PostalCode = reader.getCellData("RegTestData", "PostalCode", rowNum);
			String Country = reader.getCellData("RegTestData", "Country", rowNum);
			
			reader.setCellData("RegTestData", "Status", rowNum, "Pass");
			Object ob[] = {firstName,LastName,Phone,Email,Address1,Address2,City,State,
					PostalCode,Country};
			myData.add(ob);
			
		}
		return myData;
		
	}

}
