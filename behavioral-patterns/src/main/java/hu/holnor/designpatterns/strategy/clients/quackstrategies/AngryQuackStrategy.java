package hu.holnor.designpatterns.strategy.clients.quackstrategies;

public class AngryQuackStrategy implements QuackBehaviorStrategy {
    public void quack(){
        System.out.println("QUAAAACK OFF!");
    }
}
