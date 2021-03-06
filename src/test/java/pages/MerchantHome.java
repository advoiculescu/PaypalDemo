package pages;

import org.openqa.selenium.WebElement;

import browser.*;

public class MerchantHome {
	private String url = "https://demo.paypal.com/us/navigation?device=desktop&page=merchantHome";
	private String title = "PayPal Demo";
	ObjectMap map;
	
	public MerchantHome() {
		map = new ObjectMap("data\\MerchantHome.properties");
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
		System.out.print("Cargamos la p�gina MerchantHome...");
		Browser.open(url);
		System.out.println("\u001B[32m" + " LISTO" + "\u001B[0m");
	}

	public boolean isLoaded() {
		System.out.print("Verificamos que la p�gina MerchantHome ha cargado correctamente...");
		if (Browser.driver().getCurrentUrl().trim().equals(url)){
			System.out.println("\u001B[32m" + " LISTO" + "\u001B[0m");
			return true;
		} else {
			System.out.println("\u001B[31m" + " ERROR" + "\u001B[0m");
			System.out.println("KO: "+Browser.driver().getCurrentUrl()+" != "+url);
			return false;
		}
	}
	
	public void clickBlackCamera(){
		System.out.print("Hacemos click en 'Black Camera'...");
		WebElement blackCamera = null;
		try {
			blackCamera = Browser.driver().findElement(map.getLocator("blackCamera"));
			blackCamera.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("\u001B[32m" + " LISTO" + "\u001B[0m");
	}
	
	public void clickPopUp (){
		System.out.print("Hacemos click en 'Skip Tour'...");
		WebElement popUpButton = null;
		try {
			Thread.sleep(3000);
			popUpButton = Browser.driver().findElement(map.getLocator("popUpButton"));
			popUpButton.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("\u001B[32m" + " LISTO" + "\u001B[0m");
	}
}
