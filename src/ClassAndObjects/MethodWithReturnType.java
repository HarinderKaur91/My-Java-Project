package ClassAndObjects;

public class MethodWithReturnType {

	String licenseType (String currentLicense) {

		String licenseToBeIssued;
		if (currentLicense.equals("No License")) {
			licenseToBeIssued = "G1";
		} else if (currentLicense.equals("G1")) {
			licenseToBeIssued = "G2";
		} else if (currentLicense.equals("G2")) {
			licenseToBeIssued = "G";
		} else {
			licenseToBeIssued = "You already have a license";
		}
		return licenseToBeIssued;
		
	}
}
