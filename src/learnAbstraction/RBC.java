package learnAbstraction;

public class RBC extends BOC{

	@Override
	public void provideCreditCard(int creditLimit) {
		//if("User".equals("Citizen")||"User".equals("PR")) {
		System.out.println("CC of RBC Provided with "+creditLimit+" limit");
		//}
		
	}

	@Override
	public void interestRate() {
		System.out.println("RBC provides Interest rate of 17% for CC");
		
	}

}