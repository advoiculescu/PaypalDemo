package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import browser.*;

public class Home {
	private String url = "https://demo.paypal.com/us/home";
	private String title = "PayPal Demo";
	private int hola;
	ObjectMap map;
	
	public Home() {
		map = new ObjectMap("data\\Home.properties");
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
		System.out.print("Cargamos la página Home...");
		Browser.open(url);
		System.out.println("\u001B[32m" + " LISTO" + "\u001B[0m");
	}

	public boolean isLoaded() {
		System.out.print("Verificamos que la página Home ha cargado correctamente...");
		if (Browser.driver().getCurrentUrl().trim().equals(url)){
			System.out.println("\u001B[32m" + " LISTO" + "\u001B[0m");
			return true;
		} else {
			System.out.println("\u001B[31m" + " ERROR" + "\u001B[0m");
			System.out.println("KO: "+Browser.driver().getCurrentUrl()+" != "+url);
			return false;
		}
	}
	
	public void clickSeeTheDemo(){
		System.out.print("Hacemos click en 'See The Demo'...");
		WebElement button = null;
		try {
			button = Browser.driver().findElement(map.getLocator("button"));
			button.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("\u001B[32m" + " LISTO" + "\u001B[0m");
	}
}