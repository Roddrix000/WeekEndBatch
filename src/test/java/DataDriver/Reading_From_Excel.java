package DataDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Reading_From_Excel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		System.out.println("Reading Data from Excel");
		FileInputStream fis = new FileInputStream("./Data/Sample_read_Frm_Excel.xlsx");
		Workbook wb= WorkbookFactory.create(fis);
		String excelData = wb.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue();
		System.out.println(excelData);
		System.out.println("Writing Back to Excel");
		wb.getSheet("Sheet1").getRow(1).getCell(4).setCellValue("Hello There");
		
		//for Writing we need to use FileOutPutStrea,
		FileOutputStream fop= new FileOutputStream("./Data/Sample_read_Frm_Excel.xlsx");
		wb.write(fop);
		fop.close();
		String writtenvalue = wb.getSheet("Sheet1").getRow(1).getCell(4).getStringCellValue();
		System.out.println("Successfully Written " +writtenvalue);
		
		
	}
}
