package practiceInheritance;

public class Mobile {

	String defaultWifiPassword = "";
	private String phonePassword = "";
	public String screenSize = "";

	public Mobile(String defaultWifiPassword, String phonePassword, String screenSize) {
		this.defaultWifiPassword = defaultWifiPassword;
		this.phonePassword = phonePassword;
		this.screenSize = screenSize;

	}

	void checkWifiPassword(String wifiPassword) {
		if (wifiPassword.equals(this.defaultWifiPassword)) {
			System.out.println("Internet enabled");
			checkPhonePassword("abc");
		} else {
			System.out.println("Invalid wifi password");
		}

	}

	private void checkPhonePassword(String phonePassword) {
		if (phonePassword.equals(this.phonePassword)) {
			System.out.println("Phone is unlocked");
		}else {
			System.out.println("Invalid phone password");
		}
	}

	public void displayScreenSize() {
		System.out.println("Screen size is " + screenSize);
	}

	

}
