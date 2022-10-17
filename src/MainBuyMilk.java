import java.util.Scanner;

public class MainBuyMilk {

	public static void main(String[] args) {

		MilkDetails mD = new MilkDetails();  //mD is reference variable of MilkDetails class

		boolean isMilkAvailable;
		
		Scanner sc = new Scanner(System.in);

		System.out.println("Is milk avaialble in the store? (true/false)");
		isMilkAvailable = sc.nextBoolean();

		System.out.println(mD.isMilkAvailable(isMilkAvailable));
		
	}

}
