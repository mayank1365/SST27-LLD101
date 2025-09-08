package beverages_decorator;

public abstract class BeverageDecorator extends Beverage {
    protected Beverage beverage;

    protected BeverageDecorator(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public abstract String getDescription();
}