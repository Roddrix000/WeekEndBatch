package Assignment;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.netty.util.internal.SystemPropertyUtil;
public class DataDriver_Excel {

	public static void main(String[] args) throws IOException {

		WebDriver d = new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String url = fetchData(1, 0);
		String userName = fetchData(1, 1);
		String password = fetchData(1, 2);
		d.get(url);
		WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(5));
		WebElement UN = d.findElement(By.id("username"));
		wait.until(ExpectedConditions.visibilityOf(UN));
		UN.sendKeys(userName);
		WebElement pwd = d.findElement(By.name("pwd"));
		wait.until(ExpectedConditions.visibilityOf(pwd));
		pwd.sendKeys(password);
		d.findElement(By.id("loginButton")).click();
		WebElement logout = d.findElement(By.id("logoutLink"));
		wait.until(ExpectedConditions.visibilityOf(logout));
		if (logout.isDisplayed() == true) {
			System.out.println("Passed");
		} else {
			System.out.println("Faild");
		}
		d.quit();
	}

	public static String fetchData(int row, int cell) throws IOException {

		FileInputStream fis = new FileInputStream("./Data/ActiTime.xlsx");
		Workbook Wb = WorkbookFactory.create(fis);
		String data = Wb.getSheet("Config").getRow(row).getCell(cell).getStringCellValue();
		return data;

	}

}
