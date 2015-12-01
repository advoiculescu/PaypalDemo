package paypalDemo;


import browser.Browser;
import pages.BigboxMerchant;
import pages.Home;
import pages.MerchantCreditCard;
import pages.MerchantHome;
import pages.MerchantLogin;
import pages.PayPalCheckout;
import pages.PayPalCheckoutReview;
import pages.PayPalConfirm;
import pages.Shipping;
import pages.ShoppingCart;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.*;

public class Ejecutor {

	@Before
	public void setUp(){
		System.out.println("\t\t--------------------------------------------INICIO DEL TEST--------------------------------------------");
	}
	
	@Given("^instanciar navegador Chrome$")
	public void instanciar_navegador_Chrome() throws Throwable {
		Browser.startDriver("Chrome");
	}

	@Given("^instanciar navegador Mozilla Firefox$")
	public void instanciar_navegador_Mozilla_Firefox() throws Throwable {
		Browser.startDriver("Mozilla Firefox");
	}

	@Given("^instanciar navegador Internet Explorer$")
	public void instanciar_navegador_Internet_Explorer() throws Throwable {
		Browser.startDriver("Internet Explorer");
	}
	
	@When("^ir a la pagina del home de paypal y pulsar el boton \"([^\"]*)\"$")
	public void ir_a_la_pagina_del_home_de_paypal_y_pulsar_el_boton(String arg1) throws Throwable {
		Home home = new Home();
		home.load();
		home.isLoaded();
		home.clickSeeTheDemo();
	}
	
	@When("^hacemos click en popUp \"([^\"]*)\"$")
	public void hacemos_click_en_popUp(String arg1) throws Throwable {
		MerchantHome merchantHome = new MerchantHome();
		Thread.sleep(3000);
		assertTrue(merchantHome.isLoaded());
		merchantHome.clickPopUp(arg1);
	}
	
	@When("^seleccionamos el objeto que queremos comprar$")
	public void seleccionamos_el_objeto_que_queremos_comprar() throws Throwable {
		MerchantHome merchantHome = new MerchantHome();
		Thread.sleep(2000);
		merchantHome.isLoaded();
		merchantHome.clickBlackCamera();
	}

	@When("^hacemos click en el boton de \"([^\"]*)\"")
	public void hacemos_click_en_el_boton_de_Mozilla_Firefox(String arg1) throws Throwable {
		BigboxMerchant bigboxMerchant = new BigboxMerchant();
		Thread.sleep(2000);
		bigboxMerchant.isLoaded();
		bigboxMerchant.clickAddToCart();
		Thread.sleep(5000);
	}

	@When("^hacemos click en el boton \"([^\"]*)\"$")
	public void hacemos_click_en_el_boton(String arg1) throws Throwable {
		ShoppingCart shoppingCart = new ShoppingCart();
		Thread.sleep(2000);
		shoppingCart.isLoaded();
		shoppingCart.clickProceedToCheckout();
	}
	

	@When("^hacemos click en \"([^\"]*)\"$")
	public void hacemos_click_en(String arg1) throws Throwable {
		MerchantLogin merchantLogin = new MerchantLogin();
		Thread.sleep(2000);
		merchantLogin.isLoaded();
		merchantLogin.clickCheckoutAsGuest();
	}
	

	@When("^hacemos click en boton \"([^\"]*)\"$")
	public void hacemos_click_en_boton(String arg1) throws Throwable {
		Shipping shipping = new Shipping();
		Thread.sleep(2000);
		shipping.isLoaded();
		shipping.clickContinue();
	}
	
	@When("^pulsar  \"([^\"]*)\"$")
	public void pulsar(String arg1) throws Throwable {
		MerchantCreditCard merchantCreditCard = new MerchantCreditCard();
		Thread.sleep(2000);
		merchantCreditCard.isLoaded();
		merchantCreditCard.clickContinue();
	}


	@When("^hacer click en \"([^\"]*)\"$")
	public void hacer_click_en(String arg1) throws Throwable {
		PayPalCheckout paypalCheckout = new PayPalCheckout();
		Thread.sleep(2000);
		paypalCheckout.isLoaded();
		paypalCheckout.clickLogInToPayPal();
	}

	@When("^click \"([^\"]*)\"$")
	public void click(String arg1) throws Throwable {
		PayPalCheckoutReview paypalCheckoutReview = new PayPalCheckoutReview();
		Thread.sleep(2000);
		paypalCheckoutReview.isLoaded();
		paypalCheckoutReview.clickPayNow();
	}

	@Then("^el mensaje obtenido es \"([^\"]*)\"$")
	public void el_mensaje_obtenido_es(String arg1) throws Throwable {
		PayPalConfirm paypalConfirm = new PayPalConfirm();
		Thread.sleep(2000);
		paypalConfirm.isLoaded();
		assertEquals(paypalConfirm.getConfirmationText(),arg1);
		System.out.println("Mensaje validado de forma correcta");
	}
	
	@Then("^cerramos instancia de Chrome$")
	public void cerramos_instancia_de_Chrome() throws Throwable {
		Browser.close();
	}

	@Then("^cerramos instancia de Mozilla Firefox$")
	public void cerramos_instancia_de_Mozilla_Firefox() throws Throwable {
		Browser.close();
	}

	@Then("^cerramos instancia de Internet Explorer$")
	public void cerramos_instancia_de_Internet_Explorer() throws Throwable {
		Browser.close();
	}
	
	@After
	public void tearDown(){
		System.out.println("\t\t--------------------------------------------FIN DEL TEST--------------------------------------------");
	}
	
}
