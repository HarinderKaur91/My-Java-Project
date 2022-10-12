package ClassAndObjects;

public class MainClass {

	public static void main(String[] args) {

		SimpleMethod sm = new SimpleMethod(); // instantiating SimpleMethod class

		sm.addNumbers(); 				// calling method from SimpleMethod class in the Main class
		sm.subtractNumbers();
		sm.multiplyNumbers();

	}
}
