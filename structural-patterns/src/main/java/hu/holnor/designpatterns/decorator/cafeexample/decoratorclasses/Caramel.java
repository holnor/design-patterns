package hu.holnor.designpatterns.decorator.cafeexample.decoratorclasses;

import hu.holnor.designpatterns.decorator.cafeexample.beverages.Beverage;

/*
* Egy konkrét dekorátor az ősdekorátor leszármazottja, de egyben a Beverage leszármazottja is.
* Azzal pedig, hogy van egy Beverage típusú váltózója kompozíciót alakít ki.
* Végeredményül hozzáférése van a Beverage osztályból leszármazó "testvér" cost() metódusához.
* */

public class Caramel extends AddonDecorator{
        private static final int PRICE = 50;
        private Beverage beverage;

    public Caramel(Beverage beverage) {
        this.beverage = beverage;
    }

    public int cost() {
        return this.beverage.cost() + PRICE;
    }
}
