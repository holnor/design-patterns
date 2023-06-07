package hu.holnor.designpatterns.decorator.cafeexample.decoratorclasses;

import hu.holnor.designpatterns.decorator.cafeexample.beverages.Beverage;

/*
* Létrehozzuk az ős dekorátor osztályt, ami szintén leszármazottja a Beverage osztálynak,
* és továbbadjuk az ő leszármazottainak is a cost() metódus implementálását
* */

public abstract class AddonDecorator extends Beverage {
    public abstract int cost();
}
