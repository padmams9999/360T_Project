
// author padmashri

package Generic_Component;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRW {
	
	 	FileInputStream fis;
	    XSSFWorkbook wb ;
	    
	    public ExcelRW(String filePath) throws IOException
	     {
		        fis = new FileInputStream(filePath);
		        wb = new XSSFWorkbook(fis);		        
	     }
	    
	    public int getRow( String sheetName)
	    {
	    	XSSFSheet sheet = wb.getSheet(sheetName);
	    	 return  sheet.getLastRowNum();
	    	
	     }
	    
	    public int getCol(String sheetName)
	    {
	    	XSSFSheet sheet = wb.getSheet(sheetName);
	    	int col_count = sheet.getRow(0).getLastCellNum();	    	
	    	return 	col_count;
	    }
	    
	    public String readCell(String sheetName,int Row, int Col )
	    {
	        String cellText="";
			//reading age column
			XSSFSheet sheet = wb.getSheet(sheetName);
			XSSFCell cell = sheet.getRow(Row).getCell(Col);
			
			if(cell.getCellType()==CellType.STRING)
			{
				cellText = cell.getStringCellValue();
			}
			if(cell.getCellType()==CellType.NUMERIC)
			{
			 cellText = String.valueOf(cell.getNumericCellValue());
			}
			if(cell.getCellType()==CellType.BLANK)
			{
				cellText="";
			}
			     return cellText;
	        }
	    
	    public void writeCell(String sheetName , int Row ,int Col , String value )
	    {
	    	XSSFSheet sheet = wb.getSheet(sheetName);
	    	sheet.getRow(Row).getCell(Col).setCellValue(value);
			sheet.getRow(Row).getCell(Col).setCellValue(value);
	    	
	    }
	    
	    public void saveAndClose(String fpath ) throws IOException
	    {
	    	FileOutputStream fos = new FileOutputStream(fpath);
			fis.close();
			wb.write(fos); 
			fos.close();
	    }
	    

}
