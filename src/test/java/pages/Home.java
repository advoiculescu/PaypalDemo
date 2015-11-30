package pages;

import org.openqa.selenium.WebElement;
import static org.junit.Assert.*;

import browser.*;

public class Home {
	private String url = "https://demo.paypal.com/us/home";
	private String title = "PayPal Demo";
	private ObjectMap map;

	public Home() {
		map = new ObjectMap("data\\PageObjects\\front\\Home.properties");
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void load() {
		Browser.startDriver("");
		Browser.open(url);
	}

	public void isLoaded() {
		assertTrue(Browser.driver().getCurrentUrl().equals(url));
	}

	public void close() {
		Browser.close();
	}
}