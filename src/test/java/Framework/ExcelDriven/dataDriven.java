package Framework.ExcelDriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class dataDriven {
	
	@SuppressWarnings("deprecation")
	public ArrayList<String> getData(String TestCaseName) throws IOException {
		
		ArrayList<String> array = new ArrayList<String>();
		
		FileInputStream fis = new FileInputStream("H:\\DSandALGO\\ExcelDriven\\TestData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		int sheets = workbook.getNumberOfSheets();
		for(int i = 0; i<sheets; i++) {
			
			if(workbook.getSheetName(i).equalsIgnoreCase("TestData")) {
			XSSFSheet sheet = workbook.getSheetAt(i);
			Iterator<Row> rows = sheet.iterator();
			
			Row firstrow = rows.next();
			Iterator<Cell> cell = firstrow.cellIterator();
			int k=0;
			int coloumn = 0;
			while(cell.hasNext()) {
				Cell value = cell.next();
				if(value.getStringCellValue().equalsIgnoreCase("TestCases")) {
					
					coloumn = k;
					
				}
				k++;
			}
			
			System.out.println(coloumn);
			
			while(rows.hasNext()) {
				Row r = rows.next();
				if(r.getCell(coloumn).getStringCellValue().equalsIgnoreCase(TestCaseName)){
					
					Iterator<Cell> cellvalue = r.cellIterator();
					
					while(cellvalue.hasNext()) {
						
						Cell c = cellvalue.next();
						if(c.getCellTypeEnum()==CellType.STRING) {
						array.add(c.getStringCellValue());
						}
						else {
							array.add(NumberToTextConverter.toText(c.getNumericCellValue()));
							
						}
					}
				}
				
			}
			
			}
			
		}
		return array;
	
		
		
		
	}
	
	
}
