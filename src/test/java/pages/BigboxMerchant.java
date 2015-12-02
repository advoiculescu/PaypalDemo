package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import browser.Browser;
import browser.ObjectMap;

public class BigboxMerchant {
	private String url = "https://demo.paypal.com/us/navigation?merchant=bigbox&page=category";
	private String title = "PayPal Demo";
	ObjectMap map;

	public BigboxMerchant() {
		map = new ObjectMap("data\\BigboxMerchant.properties");
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
		System.out.print("Cargamos la página BigboxMerchant...");
		Browser.open(url);
		System.out.println("\u001B[32m" + " LISTO" + "\u001B[0m");
	}

	public boolean isLoaded() {
		System.out.print("Verificamos que la página BigboxMerchant ha cargado correctamente...");
		if (Browser.driver().getCurrentUrl().trim().equals(url)) {
			System.out.println("\u001B[32m" + " LISTO" + "\u001B[0m");
			return true;
		} else {
			System.out.println("\u001B[31m" + " ERROR" + "\u001B[0m");
			System.out.println("KO: " + Browser.driver().getCurrentUrl() + " != " + url);
			return false;
		}
	}

	public void clickAddToCart() {
		System.out.print("Hacemos click en 'Add to Cart'...");
		WebElement addToCart = null;
		try {
			addToCart = Browser.driver().findElement(map.getLocator("addToCart"));
			((JavascriptExecutor) Browser.driver()).executeScript("arguments[0].scrollIntoView(true);", addToCart);
			Thread.sleep(500);
			((JavascriptExecutor) Browser.driver()).executeScript("arguments[0].click();", addToCart);
		} catch (StaleElementReferenceException e) {
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("\u001B[32m" + " LISTO" + "\u001B[0m");
	}

	public void clickImage() {
		System.out.print("Hacemos click en la imagen del producto...");
		WebElement image = null;
		try {
			image = Browser.driver().findElement(map.getLocator("image"));
			((JavascriptExecutor) Browser.driver()).executeScript("arguments[0].scrollIntoView(true);", image);
			Thread.sleep(500);
			((JavascriptExecutor) Browser.driver()).executeScript("arguments[0].click();", image);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("\u001B[32m" + " LISTO" + "\u001B[0m");
	}
}
