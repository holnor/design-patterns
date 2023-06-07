package hu.holnor.designpatterns.decorator.cafeexample;

import hu.holnor.designpatterns.decorator.cafeexample.beverages.Espresso;
import hu.holnor.designpatterns.decorator.cafeexample.decoratorclasses.Caramel;
import hu.holnor.designpatterns.decorator.cafeexample.decoratorclasses.Chocolate;

/*
* Végül a main metódusban egymásbaágyazott konstruktorhívásokkal hozhatjuk elő az eredményt.
* Valamilyen szinten ez egyfajta rekurzió, ahol a külső rétegek felől haladunk befelé.
* Akárhány réteget felhúzhatunk így egy objektumra.
* Minden réteg csak annyit tud a becsomagolt objektumról, hogy egy objektum, de arról fogalma sincs, hogy az
* dekorátor vagy sem.
* A tervezési minta egyik legnagyobb előnye a felxibilitás: akár futásidőben is modósítható a program.
* */

public class App {
    public static void main(String[] args) {
        Chocolate espressoWithCaramelChocolate = new Chocolate(new Caramel(new Espresso()));
        System.out.println(espressoWithCaramelChocolate.cost()); //Chocolate: 70, Caramel: 50, Espresso: 100, sum = 220
    }
}
