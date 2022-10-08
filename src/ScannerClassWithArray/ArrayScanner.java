/*Check how many times a name is present in the array*/
package ScannerClassWithArray;
import java.util.Scanner;
public class ArrayScanner {

	public static void main(String[] args) {
		int counter = 0;
		Scanner sc = new Scanner(System.in); 		// sc is Scanner class variable
		
		System.out.println("enter number of elements in the array");
		int arraySize = sc.nextInt();				// Taking input for Size of Array
		
		String[] nameList = new String[arraySize];   // Declaring an Array of String type

		// Taking user input to store array elements in the array
		for (int i = 0; i < arraySize; i++) {
			System.out.println("enter array element at index " + i + " : ");
			nameList[i] = sc.next();
		}
		// Printing array elements
		System.out.println("\nArray elements are : ");
		for (int i = 0; i < arraySize; i++) {
			System.out.println(nameList[i]);
		}
		// Checking for number of occurrences of the name in the array
		System.out.println("\nenter the name you want to search");
		String name = sc.next();
		for (int i = 0; i < arraySize; i++) {
			if (nameList[i].equals(name)) {
				counter++;
			}
		}
		if (counter == 0) {
			System.out.println("\n" + name + " is not present in the list");
		} else {
			System.out.println("\n" + name + " is present " + counter + " times in the list");
		}
	}
}
