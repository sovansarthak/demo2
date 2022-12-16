package dummyframework1.tests;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class dummyclass {
	
	   static DataFormatter formatter= new DataFormatter();


	public static void main(String[] args) throws IOException {
		
		 FileInputStream file= new FileInputStream("/users/sovansarthak/Downloads/testdata3.xlsx");
		   XSSFWorkbook workbook= new XSSFWorkbook(file);
		   XSSFSheet sheet=workbook.getSheetAt(0);
		   int rowcount=sheet.getPhysicalNumberOfRows();
		   System.out.println(rowcount);
		   Row firstrow=sheet.getRow(0);
		   int columncount=firstrow.getLastCellNum();
		   System.out.println(columncount);

		   Object [][] data=new Object [rowcount-1][columncount];

		   
		    for(int i=0; i<rowcount-1; i++) {
		    	 
		    	 Row row=sheet.getRow(i+1);   
		    	
		    	for(int j=0; j<columncount; j++) {
		    		
		    		data [i][j]=formatter.formatCellValue(row.getCell(j));
		    		System.out.println(data[i][j]);
		    		
		    		
		    		
		    	}
		    	
		    	
		    }	
		    
	//	    System.out.println(data);
		    workbook.close();
		 		 
	  }
	}


