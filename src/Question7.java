
public class Question7 {

	public static void main(String[] args) {

		int waterTankCapacity = 100;

		for (int waterFilled = 10; waterFilled <= waterTankCapacity; waterFilled += 10) {

			System.out.println("Water added " + waterFilled + " litres");

			if (waterFilled >= waterTankCapacity) {
				System.out.println("You have reached the maximum capacity of tank.You should Stop adding water now.");
				break;

			}
		}
	}

}
