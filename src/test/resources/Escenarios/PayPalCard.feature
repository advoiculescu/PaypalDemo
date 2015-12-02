#@Run
#Feature: Pagar con tarjeta de Paypal
#
#Scenario Outline: demo comprar con tarjeta paypal
#	Given instanciar navegador <navegador>
#	When ir a la pagina del home de paypal y pulsar el boton "See the demo"
#	And hacemos click en Skip tour
#	And seleccionamos el objeto que queremos comprar
#	And hacemos click en ADD TO CART desde el listado de productos
#	And hacemos click en Check out with PayPal
#	And hacemos click en Log in to PayPal
#	And confirmamos compra con PayPal pulsando Continue
#	And hacemos click en Place Order
#    Then el mensaje obtenido es "Thank you! Your order is complete."
#    And cerramos instancia de <navegador>
#    
#Examples:
#	| navegador |
#	| Chrome |
#	| Mozilla Firefox   |
	#| Internet Explorer  |