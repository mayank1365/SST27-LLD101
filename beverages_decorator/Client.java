package beverages_decorator;

public class Client {

	public static void main(String[] args) {
		Beverage coffee = new Cappuccino();
		System.out.println(coffee.getDescription() + " -> " + coffee.cost());

		Beverage fancy = new Cappuccino();
		fancy = new Milk(fancy);
		fancy = new Chocolate(fancy);
		fancy = new Sugar(fancy);
		System.out.println(fancy.getDescription() + " -> " + fancy.cost());

		Beverage milkLatte = new Latte();
		milkLatte = new Milk(milkLatte);
		System.out.println(milkLatte.getDescription() + " -> " + milkLatte.cost());
	}

}