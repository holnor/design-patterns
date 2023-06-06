package hu.holnor.designpatterns.strategy;

import hu.holnor.designpatterns.strategy.clients.flystrategies.FlyFastStrategy;
import hu.holnor.designpatterns.strategy.clients.flystrategies.FlySlowStrategy;
import hu.holnor.designpatterns.strategy.clients.quackstrategies.AngryQuackStrategy;
import hu.holnor.designpatterns.strategy.clients.quackstrategies.SimpleQuackStrategy;

public class App {

    public static void main(String[] args) {

        Duck wildDuck = new Duck("medium", "brown", new FlySlowStrategy(), new SimpleQuackStrategy());
        wildDuck.quack();
        wildDuck.fly();

        Duck angryBigRedDuck = new Duck("big", "red", new FlyFastStrategy(), new AngryQuackStrategy());
        angryBigRedDuck.quack();
        angryBigRedDuck.fly();
    }
}
