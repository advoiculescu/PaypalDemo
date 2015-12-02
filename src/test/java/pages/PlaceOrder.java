package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import browser.*;

public class PlaceOrder {
	private String url = "https://demo.paypal.com/us/navigation?merchant=bigbox&page=placeOrder";
	private String title = "PayPal Demo";
	ObjectMap map;
	
	public PlaceOrder() {
		map = new ObjectMap("data\\PlaceOrder.properties");
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
		System.out.print("Cargamos la página PlaceOrder...");
		Browser.open(url);
		System.out.println("\u001B[32m" + " LISTO" + "\u001B[0m");
	}

	public boolean isLoaded() {
		System.out.print("Verificamos que la página PlaceOrder ha cargado correctamente...");
		if (Browser.driver().getCurrentUrl().trim().equals(url)){
			System.out.println("\u001B[32m" + " LISTO" + "\u001B[0m");
			return true;
		} else {
			System.out.println("\u001B[31m" + " ERROR" + "\u001B[0m");
			System.out.println("KO: "+Browser.driver().getCurrentUrl()+" != "+url);
			return false;
		}
	}
	
	public void clickPlaceOrder(){
		System.out.print("Hacemos click en 'Place Order'...");
		WebElement placeOrder = null;
		try {
			placeOrder = Browser.driver().findElement(map.getLocator("placeOrder"));
			((JavascriptExecutor) Browser.driver()).executeScript("arguments[0].scrollIntoView(true);", placeOrder);
			((JavascriptExecutor) Browser.driver()).executeScript("arguments[0].click();", placeOrder);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("\u001B[32m" + " LISTO" + "\u001B[0m");
	}
}