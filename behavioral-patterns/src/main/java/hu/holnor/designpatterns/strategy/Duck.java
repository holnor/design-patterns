package hu.holnor.designpatterns.strategy;

import hu.holnor.designpatterns.strategy.clients.flystrategies.FlyBehaviorStrategy;
import hu.holnor.designpatterns.strategy.clients.quackstrategies.QuackBehaviorStrategy;

public class Duck {
    private String size;
    private String color;
    private FlyBehaviorStrategy flyBehaviorStrategy;
    private QuackBehaviorStrategy quackBehaviorStrategy;

    public Duck(String size, String color, FlyBehaviorStrategy flyBehaviorStrategy, QuackBehaviorStrategy quackBehaviorStrategy) {
        this.size = size;
        this.color = color;
        this.flyBehaviorStrategy = flyBehaviorStrategy;
        this.quackBehaviorStrategy = quackBehaviorStrategy;
    }

    public void fly(){
        this.flyBehaviorStrategy.fly();
    }

    public void quack(){
        this.quackBehaviorStrategy.quack();
    }
}
