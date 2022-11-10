package practiceInheritance;

public class MainMobile {

	public static void main(String[] args) {

		ModelS22 modelS22 = new ModelS22(true);
		
		modelS22.checkWifiPassword("wifi123");
		modelS22.displayScreenSize();
		modelS22.displayCameraPixels();
		modelS22.displayWaterprooffeature(true);
		modelS22.phoneCoverPrice(false);

	}

}
