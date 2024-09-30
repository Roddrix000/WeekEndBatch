package POC;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadFloatingValuesFromExcel {
	public static void main(String[] args) {
		// Path to the Excel file
		String excelFilePath = "C:\\Users\\Ronald\\Downloads\\Equity_56226498_01-08-2024 (1).xls";

		try (FileInputStream fis = new FileInputStream(new File(excelFilePath));
				Workbook workbook = WorkbookFactory.create(fis)) {

			// Get the first sheet
			Sheet sheet = workbook.getSheetAt(0);
			String fetchedValue = null;
			String searchValue = "Unrealized Gain/Loss";

			boolean flag=false;
			// Iterate through rows
			for (Row row : sheet) {
				for (Cell cell : row) {
					if (cell.getCellType() == CellType.STRING) {
						String cellValue = cell.getStringCellValue().trim();
						
						// Search for "Buy Value"
						if (searchValue.equalsIgnoreCase(cellValue)) {	
							
							Cell nextCell = row.getCell(cell.getColumnIndex() + 1);
							if (nextCell != null) {
								fetchedValue = nextCell.toString();
                               flag=true;
								break;
							}
						}
					}
				}
				if (flag) {
					break;
				}
			}
			// Output the extracted values
			System.out.println(searchValue +" "+fetchedValue);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
