package browser;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.WrapsDriver;

public class WebElementExtender {
	// Método para cambiar un atributo de un webelement en tiempo de ejecución
	public static void setAttribute(WebElement element, String attributeName, String value) {
		WrapsDriver wrappedElement = (WrapsDriver) element;
		JavascriptExecutor driver = (JavascriptExecutor) wrappedElement.getWrappedDriver();
		driver.executeScript("arguments[0].setAttribute(arguments[1],arguments[2])", element, attributeName, value);
	}
	// Método para destacar un webelement durante la ejecución (ralentiza el script)
	public static void highlightElement(WebElement element) {
		for (int i = 0; i < 5; i++) {
			WrapsDriver wrappedElement = (WrapsDriver) element;
			JavascriptExecutor driver = (JavascriptExecutor) wrappedElement.getWrappedDriver();
			driver.executeScript("arguments[0].setAttribute('style',arguments[1]);", element,
					"color: green; border: 2px solid yellow;");
			driver.executeScript("arguments[0].setAttribute('style',arguments[1]);", element, "");
		}
	}
	// Método para hacer captura (screenshot) solo del elemento WebElement enviado
	public static File captureElementBitmap(WebElement element) throws Exception {

	// Obtenemos el WrapsDriver del elemento
	WrapsDriver wrapsDriver = (WrapsDriver) element;
	
	// Obtenemos una captura solo del elemento WrapsDriver
	File screen = ((TakesScreenshot) wrapsDriver.getWrappedDriver()).
	getScreenshotAs(OutputType.FILE);
	
	// Crea una instancia de BufferedImage a partir de la captura
	BufferedImage img = ImageIO.read(screen);
	
	// Obtiene la altura y la anchura del elemento
	int width = element.getSize().getWidth();
	int height = element.getSize().getHeight();
	
	// Crea un rectángulo en base a su altura y anchura
	Rectangle rect = new Rectangle(width, height);
	
	// Obtiene las coordenadas del webelement
	Point p = element.getLocation();
	
	//Crear una imagen del elemento usando sus coordenadas y tamaño
	BufferedImage dest = img.getSubimage(p.getX(), p.getY(), rect.width,rect.height);
	
	// Volvemos a introducir la imagen en el objeto File
	ImageIO.write(dest, "png", screen);
	
	// Devolvemos el objeto file que contiene la imagen 
	return screen;
	}
}
