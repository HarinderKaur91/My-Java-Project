package learnAbstraction;

public class CIBC extends BOC {
	@Override
	public void provideCreditCard(int creditLimit) {
		if ("User".equals("Citizen")) {
			System.out.println("CC of CIBC Provided with " + creditLimit + " limit");
		}
	}

	@Override
	public void interestRate() {

		System.out.println("CIBC provides Interest rate of 19% for CC");

	}
}
