package beverages_decorator;

public class Chocolate extends BeverageDecorator {
    public Chocolate(Beverage beverage) {
        super(beverage);
    }

    @Override
    public int cost() {
        return beverage.cost() + 7;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Chocolate";
    }
}