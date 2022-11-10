package practiceInheritance;

public class ModelS22 extends Samsung {
	private boolean isWaterproof;

	public ModelS22(boolean isWaterproof) {
		super("50MP");
		this.isWaterproof = isWaterproof;

	}

	public void displayWaterprooffeature(boolean isWaterproof) {
		if (isWaterproof) {
			System.out.println("Your phone has waterproof feature");
		} else {
			System.out.println("Your phone do not has waterproof feature");
		}
	}

	public void phoneCoverPrice(boolean isCoverPricePaid) {
		if (isCoverPricePaid) {
			displayPhoneCover();
		} else {
			System.out.println("You need to pay $100 to take phone cover.");
		}
	}

	private void displayPhoneCover() {
		System.out.println("You can take your phone cover");

	}
}
