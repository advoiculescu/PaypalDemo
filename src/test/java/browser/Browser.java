package browser;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Browser {
	private static WebDriver driver;

	public static void startDriver(String driverType) {
		System.out.print("Arrancando "+driverType+"...");
		if (driverType.equals("") || driverType.equals("Mozilla Firefox")) {
			driver = new FirefoxDriver();
		} else if (driverType.equals("Chrome")){
			System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (driverType.equals("Internet Explorer")){
			System.setProperty("webdriver.ie.driver", "drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		System.out.println("\u001B[32m" + " LISTO" + "\u001B[0m");
	}

	public static WebDriver driver() {
		return driver;
	}

	public static void open(String url) {
		driver.get(url);
	}

	public static void close() {
		driver.close();
	}
}
