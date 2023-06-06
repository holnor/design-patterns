package hu.holnor.designpatterns.strategy.clients.quackstrategies;

public class SimpleQuackStrategy implements QuackBehaviorStrategy {
    public void quack(){
        System.out.println("Quack-quack SIMPLE quack");
    }
}
