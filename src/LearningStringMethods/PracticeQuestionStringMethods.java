package LearningStringMethods;

public class PracticeQuestionStringMethods {

	public static void main(String[] args) {

		String name = "Harinder Kaur";

		// replacing last name with '*'
		System.out.println("1.Name after replacing last name with * :" + name.replaceAll("\\bKaur\\b", "*"));
		// \b specifies regex for word boundary and it will replace only the exact word

		// Other way to replace last name with '*'
		System.out.println("2.Name after replacing last name with * :" + name.replace(name.substring(name.indexOf(" ") + 1), "*"));

		// print first name
		System.out.println("First name is :" + name.substring(0, name.indexOf(" ")));

		// find length of name
		System.out.println("Length of name is :" + name.length());

		// replace all 'a' with another character in name
		System.out.println("Name after replacing 'a' with '*' :" + name.replace('a', '*'));

	}

}
