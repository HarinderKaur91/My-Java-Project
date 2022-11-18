package assignmentWeek11;

public class R2 extends Rocket {

	R2() {
		super(120, 11000);
	}

	@Override
	public boolean launch() {
		chanceOfLaunchExplosion = 0.04 * (cargoCarried / cargoLimit);
		if (chanceOfLaunchExplosion <= ((Math.random()) / 10)) { //dividing by 10 to get value closer to the calculated one
			return true;
		}
		return false;
	}

	@Override
	public boolean land() {
		chanceOfLandingCrash = 0.08 * (cargoCarried / cargoLimit);
		if (chanceOfLandingCrash <= ((Math.random()) / 10)) {
			return true;
		}
		return false;
	}
}
