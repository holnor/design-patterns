package hu.holnor.designpatterns.decorator.cafeexample.beverages;

/*
* A leszármazott osztályokban implementáljuk az ősosztály absztrakt metódusát
* */

public class Espresso extends Beverage {
    private static final int PRICE = 100;
    @Override
    public int cost() {
        return PRICE;
    }
}
