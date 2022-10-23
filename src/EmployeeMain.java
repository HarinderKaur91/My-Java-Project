
public class EmployeeMain {

	public static void main(String[] args) {

		EmployeeDetails employee1 = new EmployeeDetails("John","Senior Developer", 8000.00, 800.00,"Robert");

		boolean isAdminAuthentic = employee1.checkAdminAuthenticity("Thomas");
		
		employee1.setEmployeeDesignation(isAdminAuthentic,"Project Manager");
		
		employee1.setSalaryAfterIncentives(isAdminAuthentic,500.00);
		

	}

}
