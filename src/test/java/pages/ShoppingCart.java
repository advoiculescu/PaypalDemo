package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import browser.*;

public class ShoppingCart {
	private String url = "https://demo.paypal.com/us/navigation?merchant=bigbox&page=shoppingCart";
	private String title = "PayPal Demo";
	ObjectMap map;
	
	public ShoppingCart() {
		map = new ObjectMap("data\\ShoppingCart.properties");
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
		System.out.print("Cargamos la página ShoppingCart...");
		Browser.open(url);
		System.out.println("\u001B[32m" + " LISTO" + "\u001B[0m");
	}

	public boolean isLoaded() {
		System.out.print("Verificamos que la página ShoppingCart ha cargado correctamente...");
		if (Browser.driver().getCurrentUrl().trim().equals(url)){
			System.out.println("\u001B[32m" + " LISTO" + "\u001B[0m");
			return true;
		} else {
			System.out.println("\u001B[31m" + " ERROR" + "\u001B[0m");
			System.out.println("KO: "+Browser.driver().getCurrentUrl()+" != "+url);
			return false;
		}
	}
	
	public void clickProceedToCheckout(){
		System.out.print("Hacemos click en 'Proceed to Checkout'...");
		WebElement proceedToCheckout = null;
		try {
			proceedToCheckout = Browser.driver().findElement(map.getLocator("proceedToCheckout"));
			((JavascriptExecutor) Browser.driver()).executeScript("arguments[0].scrollIntoView(true);", proceedToCheckout);
			Thread.sleep(5000);
			((JavascriptExecutor) Browser.driver()).executeScript("arguments[0].click();", proceedToCheckout);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("\u001B[32m" + " LISTO" + "\u001B[0m");
	}
	
	public void clickCheckoutWithPaypal(){
		System.out.print("Hacemos click en 'Checkout with Paypal'...");
		WebElement checkoutWithPaypal = null;
		try {
			checkoutWithPaypal = Browser.driver().findElement(map.getLocator("checkoutWithPaypal"));
			((JavascriptExecutor) Browser.driver()).executeScript("arguments[0].scrollIntoView(true);", checkoutWithPaypal);
			Thread.sleep(5000);
			((JavascriptExecutor) Browser.driver()).executeScript("arguments[0].click();", checkoutWithPaypal);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("\u001B[32m" + " LISTO" + "\u001B[0m");
	}
}