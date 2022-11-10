package practiceInheritance;

public class Samsung extends Mobile {

	private String cameraPixels = "";

	public Samsung(String cameraPixels) {

		super("wifi123", "abc", "6''");
		this.cameraPixels = cameraPixels;

	}

	public void displayCameraPixels() {
		System.out.println("Your phone has " + cameraPixels + " camera");
	}
}
