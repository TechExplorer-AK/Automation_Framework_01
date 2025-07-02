package genericutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
public String getStringDatafromExcel(String sheetName, int rowIndex,int columnIndex) throws EncryptedDocumentException, IOException {
	FileInputStream fis=new FileInputStream("./src/test/resources/TestData/TestScriptData.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	
	return wb.getSheet(sheetName).getRow(rowIndex).getCell(columnIndex).getStringCellValue();
}

public Number getNumberDataFromExcel(String sheetName, int rowIndex,int columnIndex) throws EncryptedDocumentException, IOException {
	FileInputStream fis=new FileInputStream("./src/test/resources/TestData/TestScriptData.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	return wb.getSheet(sheetName).getRow(rowIndex).getCell(columnIndex).getNumericCellValue();
}
public boolean getBooleanDataFromExcel(String sheetName,int rowIndex,int colIndex) throws IOException {
	FileInputStream fis=new FileInputStream("./src/test/rsources/TestData/TestScriptData.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	return wb.getSheet(sheetName).getRow(rowIndex).getCell(colIndex).getBooleanCellValue();
	
}
public LocalDateTime getDateAndTimeFromExcel(String sheetName,int rowIndex,int colIndex) throws EncryptedDocumentException, IOException {
	FileInputStream fis=new FileInputStream("./src/test/resources/TestData/TestScriptData.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	return wb.getSheet(sheetName).getRow(rowIndex).getCell(colIndex).getLocalDateTimeCellValue();
}
}