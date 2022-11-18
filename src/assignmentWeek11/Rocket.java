package assignmentWeek11;

public class Rocket implements SpaceShip {

	protected int rocketCost;
	private int rocketWeight;
	protected int cargoCarried;
	int cargoLimit;

	double chanceOfLaunchExplosion;
	double chanceOfLandingCrash;

	public Rocket(int cost, int cargoLimit) {
		this.rocketCost = cost;
		this.cargoLimit = cargoLimit;
	}

	@Override
	public boolean launch() {
		return true;
	}

	@Override
	public boolean land() {
		return true;
	}

	@Override
	public boolean canCarry(Item item) {
		if ((rocketWeight + (Integer.parseInt(item.itemWeight))) <= cargoLimit) {
			return true;
		} else {
			cargoCarried = rocketWeight;
			System.out.println("CARGO CARRIED 	= " + cargoCarried + " kgs");
		}
		return false;
	}

	@Override
	public void carry(Item item) {
		rocketWeight += Integer.parseInt(item.itemWeight);
		System.out.println(item.itemName + "  = " + item.itemWeight);
		if (item.itemName.equals("water material")) {
			System.out.println("CARGO CARRIED 	= " + rocketWeight + " kgs");
		}
	}
}
