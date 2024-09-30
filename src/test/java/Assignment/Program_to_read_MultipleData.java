package Assignment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Program_to_read_MultipleData {

	public static void main(String[] args) throws IOException {

		FileInputStream fis = new FileInputStream("./Data/ActiTime.xlsx");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost/login.do");
		// Adding Implicite Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheetName = wb.getSheet("TestData");
		int lastRow = sheetName.getLastRowNum();
		for (int i = 1; i <= lastRow; i++) {
			try {
				// Adding Explicit Wait
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
				WebElement userName_textBox = driver.findElement(By.name("username"));
				wait.until(ExpectedConditions.visibilityOf(userName_textBox));
				String username = GetValueFromExcel(fis, sheetName, i, 0);
				userName_textBox.sendKeys(username);
				String pass = GetValueFromExcel(fis, sheetName, i, 1);
				driver.findElement(By.name("pwd")).sendKeys(pass);
				driver.findElement(By.id("loginButton")).click();
				WebElement logoutLink = driver.findElement(By.id("logoutLink"));
				wait.until(ExpectedConditions.visibilityOf(logoutLink));
				logoutLink.click();
				writeBackStatus(fis, sheetName, i, 2, "Pass");

			} catch (Exception e) {
				// TODO: handle exception
				writeBackStatus(fis, sheetName, i, 2, "Fail");
			}
		}
		FileOutputStream fot = new FileOutputStream("./Data/ActiTime.xlsx");
		wb.write(fot);
		fot.close();
		driver.quit();
		System.out.println("Automation Done!!!!");
	}

	public static String GetValueFromExcel(FileInputStream fis, Sheet sheetName, int rowId, int columnId)
			throws EncryptedDocumentException, IOException {

		return sheetName.getRow(rowId).getCell(columnId).getStringCellValue();

	}

	public static void writeBackStatus(FileInputStream fis, Sheet sheetName, int rowId, int columnId, String status)
			throws IOException {

		sheetName.getRow(rowId).getCell(columnId).setCellValue(status);

	}
}
