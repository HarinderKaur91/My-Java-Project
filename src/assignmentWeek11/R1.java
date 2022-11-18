package assignmentWeek11;

public class R1 extends Rocket {

	R1() {
		super(100, 8000);
	}

	@Override
	public boolean launch() {
		chanceOfLaunchExplosion = (0.05 * (cargoCarried / cargoLimit));
		if (chanceOfLaunchExplosion <= ((Math.random())/10)) {	//dividing by 10 to get value closer to the calculated one
			return true;
		}
		return false;
	}

	@Override
	public boolean land() {
		chanceOfLandingCrash = (0.01 * (cargoCarried / cargoLimit));
		if (chanceOfLandingCrash <= ((Math.random())/10)) {
			return true;
		}
		return false;
	}
}
