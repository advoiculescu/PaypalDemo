package paypalDemo;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Ejecutor {

	@BeforeClass
	public void instanciar ()
	{
		paypal pay = new paypal ();
	}
	
	
	@Given("^Probar navegadores Chrome$")
	public void probar_navegadores_Chrome() throws Throwable {
	    // TODO
	}

	@Given("^Probar navegadores Mozilla$")
	public void probar_navegadores_Mozilla() throws Throwable {
		// TODO
	}

	@Given("^Probar navegadores Explorer$")
	public void probar_navegadores_Explorer() throws Throwable {
		// TODO
	}
	
	@Given("^abro el navegador correspondiente(\\d+)$")
	public void abro_el_navegador_correspondiente(int arg1) throws Throwable {
		// TODO
	}
	
	@When("^pulsar  \"([^\"]*)\"$")
	public void pulsar(String arg1) throws Throwable {
		// TODO
	}

	@When("^ir a la p?gina del home de paypal y pulsar el boton \"([^\"]*)\"$")
	public void ir_a_la_p_gina_del_home_de_paypal_y_pulsar_el_boton(String arg1) throws Throwable {
		// TODO
	}

	@When("^seleccionamos el objeto que queremos comprar$")
	public void seleccionamos_el_objeto_que_queremos_comprar() throws Throwable {
		// TODO
	}

	@When("^hacemos click en el boton de \"([^\"]*)\"$")
	public void hacemos_click_en_el_boton_de(String arg1) throws Throwable {
		// TODO
	}

	@When("^hacemos click en el boton \"([^\"]*)\"$")
	public void hacemos_click_en_el_boton(String arg1) throws Throwable {
		// TODO
	}

	@When("^hacemos click en \"([^\"]*)\"$")
	public void hacemos_click_en(String arg1) throws Throwable {
		// TODO
	}

	@When("^click en \"([^\"]*)\"$")
	public void click_en(String arg1) throws Throwable {
		// TODO
	}


	@When("^hacer click en \"([^\"]*)\"$")
	public void hacer_click_en(String arg1) throws Throwable {
		// TODO
	}

	@When("^click \"([^\"]*)\"$")
	public void click(String arg1) throws Throwable {
		// TODO
	}

	@Then("^el mensaje obtenido es \"([^\"]*)\"$")
	public void el_mensaje_obtenido_es(String arg1) throws Throwable {
		// TODO
	}

	@When("^ir a la pagina del home de paypal y pulsar el boton \"([^\"]*)\"$")
	public void ir_a_la_pagina_del_home_de_paypal_y_pulsar_el_boton(String arg1) throws Throwable {
		// TODO	
	}

	@When("^hacemos click en boton \"([^\"]*)\"$")
	public void hacemos_click_en_boton(String arg1) throws Throwable {
		// TODO
	}

	
	
}
