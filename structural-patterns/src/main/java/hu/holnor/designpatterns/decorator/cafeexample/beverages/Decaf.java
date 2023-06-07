package hu.holnor.designpatterns.decorator.cafeexample.beverages;

public class Decaf extends Beverage {

    @Override
    public int cost() {
        return 120;
    }
}
