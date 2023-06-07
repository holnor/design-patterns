package hu.holnor.designpatterns.decorator.cafeexample.beverages;


/*
* Első lépésként hozzuk létre az absztrakt ősosztályt, majd a leszármazott osztályokat
*
*
* */


public abstract class Beverage {
    public abstract int cost(); //Egy ital nem példányosítható és nincs is alapára, ezért a metódus is absztrakt lesz.
}
