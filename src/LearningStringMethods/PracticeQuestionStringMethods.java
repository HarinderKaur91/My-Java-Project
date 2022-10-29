package LearningStringMethods;

public class PracticeQuestionStringMethods {

	public static void main(String[] args) {

		String name = "Harinder Kaur";

		// replacing last name with '*'
		String firstName = name.substring(0, name.indexOf(" "));
		String lastName = name.substring(name.indexOf(" ") + 1);

		System.out.println("Name after replacing last name with * :" + firstName + " " + lastName.replaceAll("\\w", "*"));

		// print first name
		System.out.println("First name is :" + name.substring(0, name.indexOf(" ")));

		// find length of name
		System.out.println("Length of name is :" + name.length());

		// replace all 'a' with another character in name
		System.out.println("Name after replacing 'a' with '*' :" + name.replace('a', '*'));

	}

}
