// Clase base Food con propiedades name y price y una función abstracta cook()
abstract class Food(val name: String, val price: Double) {
    abstract fun cook(): String
}

// Subclase de Food para hamburguesas
class Burger(name: String, price: Double) : Food(name, price) {
    override fun cook(): String {
        return "Asando la hamburguesa $name"
    }
}

// Subclase de Food para pizzas
class Pizza(name: String, price: Double) : Food(name, price) {
    override fun cook(): String {
        return "Horneando la pizza $name"
    }
}

// Interfaz Dessert con la función eat()
interface Dessert {
    fun eat(): String
}

// Clase IceCream que es una subclase de Food e implementa Dessert
class IceCream(name: String, price: Double) : Food(name, price), Dessert {
    override fun cook(): String {
        return "Enfriando el helado $name"
    }

    override fun eat(): String {
        return "Comiendo el helado $name"
    }
}

// Clase abstracta Drink que extiende Food
abstract class Drink(name: String, price: Double) : Food(name, price) {
    abstract fun pour(): String
}

// Subclase de Drink llamada Juice
class Juice(name: String, price: Double) : Drink(name, price) {
    override fun cook(): String {
        return "Exprimiendo el jugo $name"
    }

    override fun pour(): String {
        return "Sirviendo el jugo $name"
    }
}

// Función de extensión para calcular el precio con descuento
fun Food.discountedPrice(discountPercentage: Double): Double {
    return price - (price * discountPercentage / 100)
}

// Función main para probar el sistema
fun main() {
    val burger = Burger("Cheeseburger", 5.99)
    val pizza = Pizza("Pepperoni", 8.99)
    val iceCream = IceCream("Vanilla", 3.49)
    val juice = Juice("Orange", 2.99)

    println(burger.cook())
    println(pizza.cook())
    println(iceCream.cook())
    println(juice.cook())
    println(juice.pour())

    println(iceCream.eat())

    println("Precio con descuento de la hamburguesa: \$${burger.discountedPrice(10.0)}")
}
