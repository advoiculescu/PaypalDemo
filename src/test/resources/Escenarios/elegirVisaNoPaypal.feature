@Run
Feature: Pagar con Visa

Scenario Outline: pagar con Visa
	Given instanciar navegador <navegador>
	When ir a la pagina del home de paypal y pulsar el boton "See the demo"
	And hacemos click en Skip tour
	And seleccionamos el objeto que queremos comprar
	And hacemos click en ADD TO CART
	And hacemos click en PROCEED TO CHECKOUT
	And hacemos click en Checkout as guest
	And hacemos click en Continue
	And pulsar radiobutton de Visa
	And pulsar Continue
	And hacemos click en Place Order
    Then el mensaje obtenido es "Thank you! Your order is complete."
    And cerramos instancia de <navegador>
    
Examples:
	| navegador |
	| Chrome |
	| Mozilla Firefox   |