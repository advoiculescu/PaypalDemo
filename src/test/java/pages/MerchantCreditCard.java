package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import browser.Browser;
import browser.ObjectMap;

public class MerchantCreditCard {
	private String url = "https://demo.paypal.com/us/navigation?merchant=bigbox&page=merchantCreditCard";
	private String title = "PayPal Demo";
	ObjectMap map;
	
	public MerchantCreditCard() {
		map = new ObjectMap("data\\MerchantCreditCard.properties");
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
		System.out.print("Cargamos la página MerchantCreditCard...");
		Browser.open(url);
		System.out.println("\u001B[32m" + " LISTO" + "\u001B[0m");
	}

	public boolean isLoaded() {
		System.out.print("Verificamos que la página MerchantCreditCard ha cargado correctamente...");
		if (Browser.driver().getCurrentUrl().trim().equals(url)){
			System.out.println("\u001B[32m" + " LISTO" + "\u001B[0m");
			return true;
		} else {
			System.out.println("\u001B[31m" + " ERROR" + "\u001B[0m");
			System.out.println("KO: "+Browser.driver().getCurrentUrl()+" != "+url);
			return false;
		}
	}
	
	public void clickContinue(){
		System.out.print("Hacemos click en 'Continue'...");
		WebElement continueButton = null;
		try {
			continueButton = Browser.driver().findElement(map.getLocator("continueButton"));
			((JavascriptExecutor) Browser.driver()).executeScript("arguments[0].scrollIntoView(true);", continueButton);
			Thread.sleep(500);
			continueButton.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("\u001B[32m" + " LISTO" + "\u001B[0m");
	}
	
	public void clickContinueAfterClickingRadio(){
		System.out.print("Hacemos click en 'Continue' tras pulsar en el radio...");
		WebElement continueButton2 = null;
		try {
			continueButton2 = Browser.driver().findElement(map.getLocator("continueButton2"));
			((JavascriptExecutor) Browser.driver()).executeScript("arguments[0].scrollIntoView(true);", continueButton2);
			Thread.sleep(500);
			continueButton2.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("\u001B[32m" + " LISTO" + "\u001B[0m");
	}
	
	public void clickCCRadioButton(){
		System.out.print("Hacemos click en el radio button 'Tarjetas Crédito'...");
		WebElement radio = null;
		try {
			radio = Browser.driver().findElement(map.getLocator("radio"));
			((JavascriptExecutor) Browser.driver()).executeScript("arguments[0].scrollIntoView(true);", radio);
			Thread.sleep(500);
			((JavascriptExecutor) Browser.driver()).executeScript("arguments[0].click();", radio);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("\u001B[32m" + " LISTO" + "\u001B[0m");
	}
}
