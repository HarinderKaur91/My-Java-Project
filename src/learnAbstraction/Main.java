package learnAbstraction;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		//Abstract Class cannot be instantiated
//		BOC boc = new BOC();
		
		Scanner sc = new Scanner(System.in);
		RBC rbc = new RBC();
		BOC bocRbc = new RBC();

		//rbc.bankAccount();
		
		rbc.provideCreditCard(1000);
		rbc.interestRate();
		
		
		//bocRbc.bankAccount();
		bocRbc.provideCreditCard(1500);
		bocRbc.interestRate();

		CIBC cibc = new CIBC();
		cibc.provideCreditCard(2000);
	}

}
