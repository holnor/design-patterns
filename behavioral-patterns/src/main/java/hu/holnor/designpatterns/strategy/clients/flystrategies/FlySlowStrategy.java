package hu.holnor.designpatterns.strategy.clients.flystrategies;

public class FlySlowStrategy implements FlyBehaviorStrategy {
    public void fly(){
        System.out.println("Flying slowly");
    }
}
