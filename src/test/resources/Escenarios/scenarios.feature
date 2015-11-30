@Run
Feature: Ejemplo compra paypal

Scenario Outline: demo compra correcta
	Given instanciar navegador <navegador>
	When ir a la pagina del home de paypal y pulsar el boton "See the demo"
	And seleccionamos el objeto que queremos comprar
	And hacemos click en el boton de "ADD TO CART"
	And hacemos click en el boton "PROCEED TO CHECKOUT"
	And hacemos click en "Checkout as guest"
	And hacemos click en boton "Continue"
	And pulsar  "Continue"
	And hacer click en "Log in to PayPal"
	And click "Pay Now"
    Then el mensaje obtenido es "Thank you! Your order is complete."
    And cerramos instancia de <navegador>
    
Examples:
	| navegador |
	| Chrome |
	| Mozilla Firefox   |
	| Internet Explorer  |