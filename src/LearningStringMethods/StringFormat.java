package LearningStringMethods;

public class StringFormat {

	public static void main(String[] args) {

		String name = "navjot";
		String upperCaseName = name.toUpperCase();
		System.out.println("Upper case Name: " + upperCaseName);
		
		String nameKuldeep = "KulDeep";
		String lowerCaseName = nameKuldeep.toLowerCase();
		System.out.println("Lower case Name: " + lowerCaseName);
		
		//Find length of String
		
		String username = "qwertyjskasl";
		System.out.println("Length of the username: "+username.length());
		
		//calculate characters in name without including spaces
		String manvirName = "   Manvir Singh Parmar";
		manvirName = manvirName.replace(" ", "");
		System.out.println("Length of Manvir name is "+ manvirName.length());
		
		//or print it directly
		
		System.out.println("Length of Manvir name is " + manvirName.replace(" ", "").length());
		
		//We may use multiple string methods together
		System.out.println("Length of Manvir name is " + manvirName.replace(" ", "").toUpperCase(). length());

		//Trim leading and trailing white spaces
		String manvirName1 = "   Manvir Singh Parmar";

		System.out.println("Without leading and trailing before name: " + manvirName1.trim());
		System.out.println("Length of Manvir Name with spaces in between: " + manvirName.trim().length());
	
		//replace everything in the string
		String rajbirName = "Rajbir";
		System.out.println("Name of Rajbir after masking with '*' is :" + rajbirName.replaceAll("\\w", "*"));
		// \w is a regex which replaces word character: [a-zA-Z_0-9]
		
		String rajbirAge = "Just Rajbir age is 28 years";
		System.out.println(rajbirAge.replaceAll("\\d", "*"));
		
		//substring method
		//Get a sequence of a string after the index
		String rajbirUpdatedAge = rajbirAge.substring(5);
		System.out.println("Age without just word: " + rajbirUpdatedAge);
		
		//or
		int indexOfRajbirAge = rajbirAge.indexOf("R");
		
		System.out.println("Index of Rajbir is " + indexOfRajbirAge);
		System.out.println("Age without just word: " + rajbirUpdatedAge);
		
		
	}

}
