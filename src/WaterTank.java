/* There is a water tank of capacity 100 litres.
 * Water is filled into it using bucket which have capacity of 10 litres.
 * Write a program which fills the tank to its capacity using these buckets.
 * Also include a mechanism in your program to stop the tank from over flowing.
 */
public class WaterTank {

	public static void main(String[] args) {

		int waterTankCapacity = 100;

		for (int waterFilled = 9; waterFilled < waterTankCapacity; waterFilled += 10) {

			System.out.println("Water added " + waterFilled + " litres");

			if (waterFilled +10 >= waterTankCapacity) {
				System.out.println("You have reached the maximum capacity of tank.You should Stop adding water now.");
				break;

			}
		}
	}

}
