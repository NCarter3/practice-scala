package org.scalalabs.basic.lab01
import scala.language.implicitConversions
/**
 * The goal of this exercise is to get familiar basic OO constructs in scala
 *
 * Fix the code so that the unit test 'CurrencyExerciseTest' passes.
 *
 * In order for the tests to pass you need to do the following:
 * 
 * Exercise 1:
 * - Create a class Euro
 * - Provide it with two constructor parameters: euro:Int, cents:Int
 * - Provide the cents field with default value: 0
 * - Provide an immutable field named: inCents that converts euro + cents into cents.
 * - Create an object Euro with a factory method named: fromCents that creates an Euro based on cents.
 * - Create a method named: + to the Euro class that adds another Euro
 * - Create a method named: * to the Euro class that multiplies an Euro by an integer
 * 
 * Exercise 2:
 * - Create an abstract class Currency
 * - Provide it with one constructor parameter: symbol:String
 * - Extend the previously created Euro class from Currency
 * - Override the toString method of Euro to represent the following String:
 *   -> symbol + ': ' + euro + ',' + cents.  E.g: EUR 200,05
 * - In case the cents are 0 use this representation:
 *   -> symbol + ': ' + euro + ',--. E.g.: EUR 200,--
 *   
 * OPTIONAL: Exercise 3:
 * - Mix the Ordered trait in Euro
 * - Implement the compare method  
 * 
 * OPTIONAL: Exercise 4:
 * - Provide an implicit class that adds a *(euro:Euro) method to Int
 * - Create a new currency Dollar
 * - Provide a implicit conversion method that converts from Euro to Dollar using the 
 *   [[org.scalalabs.basic.lab01.DefaultCurrencyConverter]]
 * 
 * OPTIONAL: Exercise 5:
 * - Extend the conversion method from Euro to Dollar with an implicit parameter 
 *   of type [[org.scalalabs.basic.lab01.CurrencyConverter]]
 * - Use the implicit CurrencyConverter to do the conversion. 
 */
class Euro extends Currency("EUR") {
  	private var privateCents:Int = 0
  	private var privateEuros:Int = 0
	
	def cents:Int = privateCents
	def euro:Int = privateEuros
	// TODO: This is an awful, terrible thing that makes life sad (see next line with no space in cents_=)
	def cents_= (newCents:Int) {
	  this.privateEuros = newCents / 100 + this.euro
	  this.privateCents = newCents % 100
	}
  	def euro_= (newEuros:Int) {
  	  this.privateEuros = newEuros
  	}
  
	def inCents = euro*100 + cents
	def +(rhs:Euro) = new Euro(this.euro + rhs.euro, this.cents + rhs.cents) 
	def *(rhs:Int) = new Euro(this.euro * rhs, this.cents * rhs)
	
	def this(euro:Int, cents:Int = 0) {
		this()
		this.euro = euro + this.euro
		this.cents = cents + this.cents
	}
	
	override def toString(): String = {
	  if (cents == 0) { 
	    symbol + ": " + euro + ",--"
	  }
	  else if (cents < 10) {
	    symbol + ": " + euro + ",0" + cents 
	  }
	  else {
	    symbol + ": " + euro + ',' + cents 
	  }
	}

}

object Euro {
   def fromCents(cents:Int) = { new Euro (0, cents) }
}

abstract class Currency (val symbol:String) {
}



