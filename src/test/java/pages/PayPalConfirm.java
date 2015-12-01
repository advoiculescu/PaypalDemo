package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import browser.Browser;
import browser.ObjectMap;

public class PayPalConfirm {
	private String url = "https://demo.paypal.com/us/navigation?merchant=bigbox&page=paypalConfirm";
	private String title = "PayPal Demo";
	ObjectMap map;

	public PayPalConfirm() {
		map = new ObjectMap("data\\PayPalConfirm.properties");
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
		System.out.print("Cargamos la página PayPalConfirm...");
		Browser.open(url);
		System.out.println("\u001B[32m" + " LISTO" + "\u001B[0m");
	}

	public boolean isLoaded() {
		System.out.print("Verificamos que la página PayPalConfirm ha cargado correctamente...");
		if (Browser.driver().getCurrentUrl().trim().equals(url)) {
			System.out.println("\u001B[32m" + " LISTO" + "\u001B[0m");
			return true;
		} else {
			System.out.println("\u001B[31m" + " ERROR" + "\u001B[0m");
			System.out.println("KO: " + Browser.driver().getCurrentUrl() + " != " + url);
			return false;
		}
	}

	public String getConfirmationText() {
		WebElement payNow = null;
		String texto = null;
		try {
			payNow = Browser.driver().findElement(map.getLocator("confirmationText"));
			texto = payNow.getText();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return texto;
	}
}