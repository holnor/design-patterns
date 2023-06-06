package hu.holnor.designpatterns.strategy.clients.flystrategies;

public class FlyFastStrategy implements FlyBehaviorStrategy {
    public void fly(){
        System.out.println("Flying fast... and furious");
    }
}
