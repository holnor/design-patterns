package hu.holnor.designpatterns.strategy.clients.quackstrategies;

public class LongQuackStrategy implements QuackBehaviorStrategy {
    public void quack() {
        System.out.println("quuuuuuaaaaaaack... quaaaaaaaack");
    }
}
