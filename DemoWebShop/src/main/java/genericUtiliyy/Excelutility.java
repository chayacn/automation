package genericUtiliyy;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excelutility {
	public String getStringDataFromExcel(String sheetName,int rowIndex,int colIndex) throws EncryptedDocumentException, IOException {
	FileInputStream  fis=new FileInputStream("./src/test/resources/Testdata/testscriptdata.xlsx");
	Workbook wb=WorkbookFactory.create(fis);
	return wb.getSheet(sheetName).getRow(rowIndex).getCell(colIndex).getStringCellValue();

}
}