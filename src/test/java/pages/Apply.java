package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import browser.Browser;
import browser.ObjectMap;

public class Apply {
	private String url = "https://demo.paypal.com/us/navigation?merchant=bigbox&page=bmlApply";
	private String title = "PayPal Demo";
	ObjectMap map;
	
	public Apply() {
		map = new ObjectMap("data\\Apply.properties");
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
		System.out.print("Cargamos la página Apply...");
		Browser.open(url);
		System.out.println("\u001B[32m" + " LISTO" + "\u001B[0m");
	}

	public boolean isLoaded() {
		System.out.print("Verificamos que la página Apply ha cargado correctamente...");
		if (Browser.driver().getCurrentUrl().trim().equals(url)){
			System.out.println("\u001B[32m" + " LISTO" + "\u001B[0m");
			return true;
		} else {
			System.out.println("\u001B[31m" + " ERROR" + "\u001B[0m");
			System.out.println("KO: "+Browser.driver().getCurrentUrl()+" != "+url);
			return false;
		}
	}
	
	public void clickAgreeAndContinue(){
		System.out.print("Hacemos click en 'AgreeAndContinue'...");
		WebElement agreeAndContinue = null;
		try {
			agreeAndContinue = Browser.driver().findElement(map.getLocator("agreeAndContinue"));
			((JavascriptExecutor) Browser.driver()).executeScript("arguments[0].scrollIntoView(true);", agreeAndContinue);
			Thread.sleep(500);
			agreeAndContinue.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("\u001B[32m" + " LISTO" + "\u001B[0m");
	}
}