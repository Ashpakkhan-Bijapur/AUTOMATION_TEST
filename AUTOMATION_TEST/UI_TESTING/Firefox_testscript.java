package ui_testing;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

public class Firefox_testscript {
	public static void main(String[] args) {

		System.setProperty("webdriver.gecko.driver", "./software/geckodriver.exe");

		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		try {
			driver.get("https://www.getcalley.com/see-a-demo");

			// Define different dimensions
			Dimension[] dimensions = { new Dimension(1920, 1080), new Dimension(1366, 768), new Dimension(1536, 864),

					new Dimension(360, 640), new Dimension(414, 896), new Dimension(375, 667)

			};

			// Loop through the dimensions, resize the browser, and capture screenshots
			for (Dimension dimension : dimensions) {
				// To Resize the browser window
				driver.manage().window().setSize(dimension);

				// To Capture the screenshot
				File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

				// To Get the current date and time
				String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

				// To Create a unique file name with dimensions and timestamp
				String fileName = "screenshot_" + dimension.width + "x" + dimension.height + "_" + timestamp + ".png";
				File destinationFile = new File("D:\\Automation_Test\\UI_TESTING\\SCREENSHOTS OF FIREFOX BROWSER\\" + fileName);

				// To Copy the file to the destination using FileHandler
				FileHandler.copy(screenshot, destinationFile);

				System.out.println("Screenshot captured: " + fileName);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// To Close the browser
			driver.quit();
		}
	}


}
