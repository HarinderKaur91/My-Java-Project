
public class C1 {

	public static void main(String[] args) {

		int actualdrinkCapacity = 3;

		for (int drinksTaken = 2; drinksTaken <= actualdrinkCapacity ; drinksTaken++) {

			System.out.println("Drink " + drinksTaken + " times");
			if (drinksTaken == actualdrinkCapacity) {
				System.out.println("You have reached the maximum limit. You should Stop drinking now");
				break;

			} else {
				System.out.println("You can drink more");
			}

		}

	}
}
