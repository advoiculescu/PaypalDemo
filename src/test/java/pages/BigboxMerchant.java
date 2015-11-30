package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

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
		if (Browser.driver().getCurrentUrl().trim().equals(url)){
			System.out.println("\u001B[32m" + " LISTO" + "\u001B[0m");
			return true;
		} else {
			System.out.println("\u001B[31m" + " ERROR" + "\u001B[0m");
			System.out.println("KO: "+Browser.driver().getCurrentUrl()+" != "+url);
			return false;
		}
	}
	
	public void clickAddToCart(){
		//category-add-to-cart-btn
		System.out.print("Hacemos click en 'Add to Cart'...");
		WebElement addToCart = null;
		try {
			addToCart = Browser.driver().findElement(map.getLocator("addToCart"));
			Actions actions = new Actions(Browser.driver());
			actions.moveToElement(addToCart);
			actions.perform();
			addToCart.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("\u001B[32m" + " LISTO" + "\u001B[0m");
	}
}
