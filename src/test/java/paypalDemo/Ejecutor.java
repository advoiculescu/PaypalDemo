package paypalDemo;


import browser.Browser;
import pages.Apply;
import pages.BigboxMerchant;
import pages.ClassicCheckout;
import pages.ClassicCheckoutReview;
import pages.Home;
import pages.MerchantCreditCard;
import pages.MerchantHome;
import pages.MerchantLogin;
import pages.PayPalCheckout;
import pages.PayPalCheckoutReview;
import pages.PayPalConfirm;
import pages.PlaceOrder;
import pages.Product;
import pages.Shipping;
import pages.ShoppingCart;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.*;

public class Ejecutor {

	/*----------------------------------------------------------INICIO SCENARIO: scenarios.feature --------------------------------------------------*/
	
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
	
	@When("^hacemos click en Skip tour")
	public void hacemos_click_en_popUp() throws Throwable {
		MerchantHome merchantHome = new MerchantHome();
		Thread.sleep(2000);
		assertTrue(merchantHome.isLoaded());
		merchantHome.clickPopUp();
	}
	
	@When("^seleccionamos el objeto que queremos comprar$")
	public void seleccionamos_el_objeto_que_queremos_comprar() throws Throwable {
		MerchantHome merchantHome = new MerchantHome();
		Thread.sleep(2000);
		merchantHome.isLoaded();
		merchantHome.clickBlackCamera();
	}

	@When("hacemos click en ADD TO CART desde el listado de productos")
	public void hacemos_click_en_ADD_TO_CART() throws Throwable {
		BigboxMerchant bigboxMerchant = new BigboxMerchant();
		Thread.sleep(2000);
		bigboxMerchant.isLoaded();
		bigboxMerchant.clickAddToCart();
	}

	@When("^hacemos click en PROCEED TO CHECKOUT")
	public void hacemos_click_en_el_boton() throws Throwable {
		ShoppingCart shoppingCart = new ShoppingCart();
		Thread.sleep(2000);
		shoppingCart.isLoaded();
		shoppingCart.clickProceedToCheckout();
	}
	

	@When("^hacemos click en Checkout as guest")
	public void hacemos_click_en() throws Throwable {
		MerchantLogin merchantLogin = new MerchantLogin();
		Thread.sleep(2000);
		merchantLogin.isLoaded();
		merchantLogin.clickCheckoutAsGuest();
	}
	


	@When("^hacemos click en Continue")
	public void hacemos_click_en_boton() throws Throwable {
		Shipping shipping = new Shipping();
		Thread.sleep(2000);
		shipping.isLoaded();
		shipping.clickContinue();
	}
	
	@When("^pulsar Continue")
	public void pulsar() throws Throwable {
		MerchantCreditCard merchantCreditCard = new MerchantCreditCard();
		Thread.sleep(2000);
		merchantCreditCard.isLoaded();
		merchantCreditCard.clickContinue();
	}


	@When("^hacemos click en Log in to PayPal")
	public void hacer_click_en() throws Throwable {
		PayPalCheckout paypalCheckout = new PayPalCheckout();
		Thread.sleep(2000);
		paypalCheckout.isLoaded();
		paypalCheckout.clickLogInToPayPal();
	}

	@When("^hacemos click en Pay Now")
	public void click() throws Throwable {
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
		assertEquals(arg1,paypalConfirm.getConfirmationText());
		System.out.println("\u001B[32m" + "Mensaje validado de forma correcta" + "\u001B[0m");
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
	
	/*----------------------------------------------------------FIN SCENARIO: scenarios.feature --------------------------------------------------*/
	

	/*----------------------------------------------------------INICIO SCENARIO: PayPalCard.feature --------------------------------------------------*/
	
	
	@When("^hacemos click en Check out with PayPal")
	public void click_check_out_with_PayPal() throws Throwable {
		ShoppingCart shoppingCart = new ShoppingCart();
		Thread.sleep(2000);
		shoppingCart.isLoaded();
		shoppingCart.clickCheckoutWithPaypal();
	}
	
	@When("^confirmamos compra con PayPal pulsando Continue")
	public void click_Continue_para_confirmar_el_pago() throws Throwable {
		PayPalCheckoutReview paypalCheckoutReview = new PayPalCheckoutReview();
		paypalCheckoutReview.setUrl("https://demo.paypal.com/us/navigation?merchant=bigbox&page=classicCheckoutReview");
		Thread.sleep(2000);
		paypalCheckoutReview.isLoaded();
		paypalCheckoutReview.clickPayNow();
	}
	
	@When("^hacemos click en Place Order")
	public void click_Place_Order() throws Throwable {
		PlaceOrder placeOrder = new PlaceOrder();
		Thread.sleep(2000);
		placeOrder.isLoaded();
		placeOrder.clickPlaceOrder();	
	}
	
	/*----------------------------------------------------------FIN SCENARIO: PayPalCard.feature --------------------------------------------------*/
	
	/*---------------------------------------------------------- INICIO SCENARIO: paypalCredit.feature --------------------------------------------*/
		
	@When("^hacemos click en PayPal CREDIT")
	public void click_paypal_CREDIT() throws Throwable {
		ShoppingCart shoppingCart = new ShoppingCart();
		Thread.sleep(2000);
		shoppingCart.isLoaded();
		shoppingCart.clickPaypalCredit();
	}
	
	@When("^hacemos click en Log In")
	public void click_log_in() throws Throwable {
		ClassicCheckout classicCheckout = new ClassicCheckout();
		Thread.sleep(2000);
		classicCheckout.isLoaded();
		classicCheckout.clickLogIn();
	}
	
	@When("^hacemos click en Agree and Continue")
	public void click_agree_and_continue() throws Throwable {
		Apply apply = new Apply();
		Thread.sleep(2000);
		apply.isLoaded();
		apply.clickAgreeAndContinue();
	}
	
	@When("^hacemos click en el boton de Continue")
	public void click_boton_continue() throws Throwable {
		ClassicCheckoutReview classicCheckoutReview = new ClassicCheckoutReview();
		Thread.sleep(2000);
		classicCheckoutReview.isLoaded();
		classicCheckoutReview.clickContinue();
	}
	
	/*---------------------------------------------------------- FIN SCENARIO: paypalCredit.feature -----------------------------------------------------*/
	
	
	/*---------------------------------------------------------- INICIO SCENARIO: elegirVisaNoPaypal.feature --------------------------------------------*/
	
	@When("^pulsar radiobutton de Visa")
	public void click_button_Visa() throws Throwable {
		MerchantCreditCard merchantCreditCard = new MerchantCreditCard();
		Thread.sleep(2000);
		merchantCreditCard.isLoaded();
		merchantCreditCard.clickCCRadioButton();
	}
	@When("^pulsamos Continue tras pulsar en radio")
	public void pulsar_Continue_tras_pulsa_en_radio() throws Throwable {
		MerchantCreditCard merchantCreditCard = new MerchantCreditCard();
		Thread.sleep(2000);
		merchantCreditCard.isLoaded();
		merchantCreditCard.clickContinueAfterClickingRadio();
	}
	
	
	/*---------------------------------------------------------- FIN SCENARIO: elegirVisaNoPaypal.feature --------------------------------------------*/
	
	
	/*---------------------------------------------------------- INICIO SCENARIO: pinchandoFotoProducto.feature --------------------------------------------*/
	
	@When("^hacemos click en la foto del objeto elegido$")
	public void click_imagen_objeto() throws Throwable {
		BigboxMerchant bigboxMerchant = new BigboxMerchant();
		Thread.sleep(2000);
		bigboxMerchant.isLoaded();
		bigboxMerchant.clickImage();
	}
	
	
	@When("hacemos click en ADD TO CART estando en la pagina del producto")
	public void hacemos_click_en_ADD_TO_CART_estando_en_la_pagina_del_producto() throws Throwable {
		Product product = new Product();
		Thread.sleep(2000);
		product.isLoaded();
		product.clickAddToCart();
	}
	
	
	/*---------------------------------------------------------- FIN SCENARIO: pinchandoFotoProducto.feature --------------------------------------------*/
	
	
}
