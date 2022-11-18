package learnAbstraction;

public abstract class BOC {
	//concrete method
	public void bankAccount() {
	}

	public void validateUserWithSIN() {
		System.out.println("User validated with SIN");
	}

	public abstract void provideCreditCard(int CreditLimit);

	public abstract void interestRate();
}
