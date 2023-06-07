package hu.holnor.designpatterns.decorator.cafeexample.decoratorclasses;

import hu.holnor.designpatterns.decorator.cafeexample.beverages.Beverage;

public class Chocolate extends AddonDecorator{
        private final int PRICE = 70;
        private Beverage beverage;

    public Chocolate(Beverage beverage) {
        this.beverage = beverage;
    }

    public int cost() {
        return this.beverage.cost() + PRICE;
    }
}
