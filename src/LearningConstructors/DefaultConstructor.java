package LearningConstructors;

public class DefaultConstructor {
	String firstName;
	String lastName;
	int age;

	public static void main(String[] args) {
		// Constructor has same name as that of the class but with method brackets
		// Always invoked when object is created
		// does not have any return type
		DefaultConstructor defaultConstructor = new DefaultConstructor();
		
		defaultConstructor.firstName = "Harinder";
		defaultConstructor.lastName = "Kaur";
		
		System.out.println(defaultConstructor.firstName +" "+ defaultConstructor.lastName );
	
	}

}
