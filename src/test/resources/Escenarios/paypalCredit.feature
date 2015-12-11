#@Run
#Feature: Pagar con credito de PayPal
#
#Scenario Outline: demo comprar con credito de PayPal
#	Given instanciar navegador <navegador>
#	When ir a la pagina del home de paypal y pulsar el boton "See the demo"
#	And hacemos click en Skip tour
#	And seleccionamos el objeto que queremos comprar
#	And hacemos click en ADD TO CART desde el listado de productos
#	And hacemos click en PayPal CREDIT
#	And hacemos click en Log In
#	And hacemos click en Agree and Continue
#	And hacemos click en el boton de Continue
#	And hacemos click en Place Order
#    Then el mensaje obtenido es "Thank you! Your order is complete."
#    And cerramos instancia de <navegador>
#    
#Examples:
#	| navegador |
#	| Chrome |
#	| Mozilla Firefox   |