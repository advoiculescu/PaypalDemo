package pages;

import org.openqa.selenium.WebElement;

import browser.Browser;
import browser.ObjectMap;

public class ClassicCheckout {
	private String url = "https://demo.paypal.com/us/navigation?merchant=bigbox&page=bmlClassicCheckout";
	private String title = "PayPal Demo";
	ObjectMap map;
	
	public ClassicCheckout() {
		map = new ObjectMap("data\\ClassicCheckout.properties");
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
		System.out.print("Cargamos la página ClassicCheckout...");
		Browser.open(url);
		System.out.println("\u001B[32m" + " LISTO" + "\u001B[0m");
	}

	public boolean isLoaded() {
		System.out.print("Verificamos que la página ClassicCheckout ha cargado correctamente...");
		if (Browser.driver().getCurrentUrl().trim().equals(url)){
			System.out.println("\u001B[32m" + " LISTO" + "\u001B[0m");
			return true;
		} else {
			System.out.println("\u001B[31m" + " ERROR" + "\u001B[0m");
			System.out.println("KO: "+Browser.driver().getCurrentUrl()+" != "+url);
			return false;
		}
	}
	
	public void clickLogIn(){
		System.out.print("Hacemos click en 'Log In'...");
		WebElement logIn = null;
		try {
			logIn = Browser.driver().findElement(map.getLocator("logIn"));
			logIn.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("\u001B[32m" + " LISTO" + "\u001B[0m");
	}
}