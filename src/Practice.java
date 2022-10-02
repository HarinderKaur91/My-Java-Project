import java.util.Scanner;

public class Practice {

	public static void main(String[] args)

	{
		int i;
		System.out.println("enter valid password");
		int counter = 1;
		for (i = 1; i <= 5; i++) {

			Scanner obj = new Scanner(System.in);
			String pass = obj.nextLine();

			if (pass.equals("abc")) {
				System.out.println("Phone is unlocked");
				break;
			} else {
				if (i <= 4) {
					System.out.println(counter + " enter password again");
					counter++;
				} else {
					System.out.println("Attempt after 5 minutes");
				}
			}
		}

	}
}
