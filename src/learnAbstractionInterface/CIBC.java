package learnAbstractionInterface;

public class CIBC implements BOC{

	@Override
	public void provideInterestRate() {
		// TODO Auto-generated method stub
		System.out.println("RBC interest Rate is 5%");
	}

	@Override
	public void provideBankAccount() {
		// TODO Auto-generated method stub
		
		System.out.println("CIBC Provides Personal Accounts");
		
	}

	@Override
	public void provideCC() {
		// TODO Auto-generated method stub
		System.out.println("Provide CC of 20.99% Interest Rate");
		
	}

	@Override
	public void provideAccessToOnlineBanking() {
		// TODO Auto-generated method stub
		
		System.out.println("Has website access");
		
	}


}
