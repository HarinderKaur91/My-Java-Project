package PersonAccessModifiers;

public class PersonDetails {

	public String personLastName;
	double personWeight;	//
	private int sinNumber;
	public String serviceCanadaAdminName;

	public PersonDetails(String personLastName, double personWeight, int sinNumber, String serviceCanadaadminName) {
		this.personLastName = personLastName;
		this.personWeight = personWeight;
		this.sinNumber = sinNumber;
		this.serviceCanadaAdminName = serviceCanadaadminName;
	}

	boolean isAdminAuthentic = false;

	boolean checkAdminAuthenticity(String serviceCanadaadminName) {
		if (this.serviceCanadaAdminName.equalsIgnoreCase(serviceCanadaadminName)) {
			isAdminAuthentic = true;
		}
		return isAdminAuthentic;
	}

	public String getPersonLastName() {
		return personLastName;
	}

	public void setPersonWeight(double personWeight) {
		this.personWeight = personWeight;
	}

	public double getPersonWeight() {
		return personWeight;
	}

	public void setSinNumber(boolean isAdminAuthentic, int sinNumber) {
		if (isAdminAuthentic) {
			this.sinNumber = sinNumber;
		} else {
			System.out.println("\nOnly Service Canada can update the SIN number of a person.");
		}
	}

}
