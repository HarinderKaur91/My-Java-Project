package PersonAccessModifiers;

public class PersonMain {

	public static void main(String[] args) {

		PersonDetails harinder = new PersonDetails("Kaur", 58, 596845124,"Admin");

		boolean isAdminAuthentic = harinder.checkAdminAuthenticity("Admin");

		System.out.println(harinder.getPersonLastName());
		
		harinder.setPersonWeight(59); 
		System.out.println(harinder.getPersonWeight());
		
		//harinder.sinNumber = 123564258; //cannot access private variable outside the class directly
		harinder.setSinNumber(isAdminAuthentic, 542156954); // private variable could be indirectly accessed through public method of the
											// class

	}

}
