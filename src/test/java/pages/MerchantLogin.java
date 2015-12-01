package pages;

import org.openqa.selenium.WebElement;

import browser.*;

public class MerchantLogin {
	private String url = "https://demo.paypal.com/us/navigation?merchant=bigbox&page=merchantLogin";
	private String title = "PayPal Demo";
	ObjectMap map;
	
	public MerchantLogin() {
		map = new ObjectMap("data\\MerchantLogin.properties");
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
		System.out.print("Cargamos la p�gina MerchantLogin...");
		Browser.open(url);
		System.out.println("\u001B[32m" + " LISTO" + "\u001B[0m");
	}

	public boolean isLoaded() {
		System.out.print("Verificamos que la p�gina MerchantLogin ha cargado correctamente...");
		if (Browser.driver().getCurrentUrl().trim().equals(url)){
			System.out.println("\u001B[32m" + " LISTO" + "\u001B[0m");
			return true;
		} else {
			System.out.println("\u001B[31m" + " ERROR" + "\u001B[0m");
			System.out.println("KO: "+Browser.driver().getCurrentUrl()+" != "+url);
			return false;
		}
	}
	
	public void clickCheckoutAsGuest(){
		System.out.print("Hacemos click en 'Checkout as guest'...");
		WebElement checkoutAsGuest = null;
		try {
			checkoutAsGuest = Browser.driver().findElement(map.getLocator("checkoutAsGuest"));
			checkoutAsGuest.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("\u001B[32m" + " LISTO" + "\u001B[0m");
	}
}
