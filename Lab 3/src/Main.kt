// Clase principal Food y una función abstracta cook()
abstract class Food(val name: String, val price: Double) {
    abstract fun cook(): String
}

// Subclase de Food, Burger
class Burger(name: String, price: Double) : Food(name, price) {
    override fun cook(): String {
        return "Asar a termino medio la hamburguesa: $name"
    }
}

// Subclase de Food, Pizza
class Pizza(name: String, price: Double) : Food(name, price) {
    override fun cook(): String {
        return "Bien horneada la pizza: $name"
    }
}

// Interfaz Dessert con la función eat()
interface Dessert {
    fun eat(): String
}

// Subclase de Food, IceCream e implementa Dessert
class IceCream(name: String, price: Double) : Food(name, price), Dessert {
    override fun cook(): String {
        return "Enfriando el helado: $name en la nevera"
    }

    override fun eat(): String {
        return "Comer frio el helado $name"
    }
}

// Clase abstracta Drink que extiende Food
abstract class Drink(name: String, price: Double) : Food(name, price) {
    abstract fun pour(): String
}

// Subclase de Drink, Juice
class Juice(name: String, price: Double) : Drink(name, price) {
    override fun cook(): String {
        return "Exprimir el jugo $name con las manos"
    }

    override fun pour(): String {
        return "Servir con cuidado el jugo $name"
    }
}

// Función de extensión para calcular el precio con descuento
fun Food.discountedPrice(discountPercentage: Double): Double {
    return price - (price * discountPercentage / 100)
}

// Función main para probar el sistema
fun main() {
    val burger = Burger("Tejana", 5.99)
    val pizza = Pizza("Pepperoni", 8.99)
    val iceCream = IceCream("Chocolate", 3.99)
    val juice = Juice("Limonada", 2.99)

    println(burger.cook())
    println(pizza.cook())
    println(iceCream.cook())
    println(juice.cook())
    println(juice.pour())
    println(iceCream.eat())

    println("Precio con descuento de la hamburguesa: \$${burger.discountedPrice(50.0)}")
}
