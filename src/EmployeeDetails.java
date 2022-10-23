
public class EmployeeDetails {

	public String employeeName; // class level variables
	private String employeeDesignation;
	private double employeeSalary; // private access modifier will not let it use outside the class.
	private double annualIncrement; // Suppose 10% of increment on salary is given to every employee.
	public String hRAdminName;

	public EmployeeDetails(String employeeName, String employeeDesignation, double employeeSalary,
			double annualIncrement, String hRAdminName) {
		this.employeeName = employeeName;
		this.employeeDesignation = employeeDesignation;
		this.employeeSalary = employeeSalary;
		this.annualIncrement = annualIncrement;
		this.hRAdminName = hRAdminName;
	}

	boolean isAdminAuthentic = false;

	boolean checkAdminAuthenticity(String hRAdminName) {
		if (this.hRAdminName.equalsIgnoreCase(hRAdminName)) {
			isAdminAuthentic = true;
		}
		return isAdminAuthentic;
	}

	void setEmployeeDesignation(boolean isAdminAuthentic, String newDesignation) {
		if (isAdminAuthentic) {
			employeeDesignation = newDesignation;
			getEmployeeDesignation();
		} else {
			System.out.println("\nOnly admin can update the designation of employee.");
		}
	}

	void getEmployeeDesignation() {
		System.out.println("\nDesignation updated to " + employeeDesignation);
	}

	void setSalaryAfterIncentives(boolean isAdminAuthentic, double employeeIncentive) {
		if (isAdminAuthentic) {
			employeeSalary = employeeSalary + annualIncrement + employeeIncentive;
			getSalaryAfterIncentives();
		} else {
			System.out.println("\nOnly admin can update the salary of employee.");
		}
	}

	void getSalaryAfterIncentives() {
		System.out.println("\nSalary updated to $" + employeeSalary);
	}

}
