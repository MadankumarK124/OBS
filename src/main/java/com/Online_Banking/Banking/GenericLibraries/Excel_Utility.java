package com.Online_Banking.Banking.GenericLibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;

public class Excel_Utility {
	/**
	 * These methods are used to read and write data using excel
	 * @author kalam
	 * @param SheetName
	 * @param Rowno
	 * @param ColumnNo
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	
	public String readDataFromExcel( String SheetName,int Rowno,int ColumnNo) throws EncryptedDocumentException, IOException {
		FileInputStream fi=new FileInputStream(IPathConstant.ExcelPath);
        Workbook wb = WorkbookFactory.create(fi);
        Sheet sh=wb.getSheet(SheetName);
        Row ro=sh.getRow(Rowno);
        Cell cell=ro.getCell(ColumnNo);
        String value=cell.getStringCellValue();
        return value;
	}
	public String writeDataIntoExcel( String SheetName,int Rowno,int ColumnNo,String data) throws Throwable {
		FileInputStream fi=new FileInputStream(IPathConstant.ExcelPath);
        Workbook wb = WorkbookFactory.create(fi);
        Sheet sh=wb.getSheet(SheetName);
        Row ro=sh.createRow(Rowno);
        Cell cell=ro.createCell(ColumnNo);
        cell.setCellValue(data);
        FileOutputStream fos=new FileOutputStream(IPathConstant.ExcelPath);
        wb.write(fos);
		return data;
       
       
	}
	
	/**This is used to get last row count
	 * @author kalam
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
        public int getLastRowNum(String sheetName) throws EncryptedDocumentException, IOException {
        	FileInputStream fi=new FileInputStream(IPathConstant.ExcelPath);
            Workbook wb = WorkbookFactory.create(fi);
            Sheet sh=wb.getSheet(sheetName);
            int count=sh.getLastRowNum();
            return count;
        }
        
        public Object[][] readMultipleData(String sheetName) throws Throwable {
			
			FileInputStream fi=new FileInputStream(IPathConstant.ExcelPath);
			 Workbook wb = WorkbookFactory.create(fi);
		    	Sheet sh = wb.getSheet(sheetName);
		    	int lastRow = sh.getLastRowNum()+1;
		    	int lastCell = sh.getRow(0).getLastCellNum();
		    	
		    	Object[][] obj = new Object[lastRow][lastCell];
		    	for(int i=0;i<lastRow;i++)
		    	{
		    		for(int j=0;j<lastCell;j++)
		    		{
		    			obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
		    		}
		    	}
		    	return obj;
		}
        
    public void getlist (String sheetName,WebDriver driver) throws EncryptedDocumentException, IOException {
    	FileInputStream fi=new FileInputStream(IPathConstant.ExcelPath);
        Workbook wb = WorkbookFactory.create(fi);
    	Sheet sh = wb.getSheet(sheetName);
    	int count=sh.getLastRowNum();
    	for(int i=0;i<=count;i++) {
    		String key = sh.getRow(i).getCell(0).getStringCellValue();
    		String value = sh.getRow(i).getCell(1).getStringCellValue();
    	
    		if(key.equals(sh.getRow(0))){
    			char ch='A';
    			if(ch>='A' && ch<='Z') {
    			value=value+ch++;}
    			else {
    				ch='A';
    			}
    					
    					
    		}
    		
    	}
    }
}
    		
    		
    		
    	
    
    
        
        





	


