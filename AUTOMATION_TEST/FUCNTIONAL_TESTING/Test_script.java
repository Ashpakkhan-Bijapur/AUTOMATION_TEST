package fucntional_testing;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test_script {
	public static void main(String[] args) throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./software/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.dealsdray.com/");
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("prexo.mis@dealsdray.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("prexo.mis@dealsdray.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='MuiButtonBase-root has-submenu compactNavItem css-46up3a']"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[.='Orders']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[.='Add Bulk Orders']")).click();
		Thread.sleep(2000);
		WebElement btn = driver.findElement(By.xpath("//input[@id='mui-7']"));
		btn.sendKeys("D:\\Selenium_files\\demo-data.xlsx");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[.='Import']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[.='Validate Data']")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.alertIsPresent());
		Alert a = driver.switchTo().alert();
		a.accept();

		// To Take Screenshot
		TakesScreenshot s = (TakesScreenshot) driver;
		File src = s.getScreenshotAs(OutputType.FILE);
		File dst = new File("D:\\Automation_Test\\FUNCTIONAL_TESTING\\FINAL SCREENSHOT\\d1.jpeg");
		FileHandler.copy(src, dst);
		Thread.sleep(2000);
		System.out.println("file is uploded and screenshot is captured");
		driver.quit();
	}
}
