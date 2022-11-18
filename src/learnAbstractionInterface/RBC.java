package learnAbstractionInterface;

//A class can inherit multiple Interfaces
public class RBC implements BOC, Fintrac{

	@Override
	public void provideInterestRate() {
		// TODO Auto-generated method stub
		
		System.out.println("RBC interest Rate is 4.5%");
		
	}

	@Override
	public void provideBankAccount() {
		// TODO Auto-generated method stub
		
		System.out.println("RBC Provides Personal and Business Accounts");
		
	}

	@Override
	public void provideCC() {
		// TODO Auto-generated method stub
		System.out.println("Provide CC of 19.99% Interest Rate");
		
	}

	@Override
	public void provideAccessToOnlineBanking() {
		// TODO Auto-generated method stub
		
		System.out.println("Has both mobile app and website");
		
	}

	@Override
	public void completeKYC() {
		// TODO Auto-generated method stub
		System.out.println("KYC needs to be completed");
		
	}

}
