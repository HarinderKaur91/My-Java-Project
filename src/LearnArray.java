
public class LearnArray {

	public static void main(String[] args) {

		String[] nameList = { "Harinder", "Parul", "Parul","Shanti", "Rajbir" };
		// prints array
		System.out.println("Array elements are: \n");
		for (int i = 0; i < nameList.length; i++) {
			System.out.println(nameList[i]);
		}

		// reverse array
		System.out.println("\nReverse array elements are: \n");
		for (int i = (nameList.length - 1); i >= 0; i--) {
			System.out.println(nameList[i]);
		}
		
		//for-each loop
		String[] cars = { "Volvo", "BMW", "Ford", "Mazda" };
		for (String i : cars) {
			System.out.println(i);
		}
	}
}