
public class License {

	public static void main(String[] args) {

		int age = 16; 							// age should be>=16 to get license
		String province = "Alberta"; 			// either Ontario or Alberta
		String currentLevel = "NL";				//NL stands for no license 

		if (age < 16) {
			System.out.println("You must be of 16 years or more to get license ");
		} 
		else {
			if (province == "Ontario") {
				if (currentLevel == "NL") {
					System.out.println("G1 license will be issued");
				} else if (currentLevel == "G1") {
					System.out.println("G2 license will be issued");
				} else if (currentLevel == "G2") {
					System.out.println("G license will be issued");
				} else if (currentLevel == "G") {
					System.out.println("Already has the highest level of license for car");

				} else {
					System.out.println("enter valid current level of license for Ontario");
				}
			} else if (province == "Alberta") {
				if (currentLevel == "NL") {
					System.out.println("class 7 learner license will be issued");
				} else if (currentLevel == "class 7") {
					System.out.println("class 6 or class 5 GDL license will be issued");
				} else if (currentLevel == "class 6") {
					System.out.println("class 5 GDL license will be issued");
				} else if (currentLevel == "class 5 GDL") {
					System.out.println("class 5 Advanced (Full) license will be issued");
				} else if (currentLevel == "class 5 Full") {
					System.out.println("Already has the highest level of license for car");
					System.out.println("Now you may get class 4,3,2 or 1 license");
				} else if (currentLevel == "class 4") {
					System.out.println("You may get class 3,2 or 1 license");
				} else if (currentLevel == "class 3") {
					System.out.println("Yoy may get class 2 or 1 license");
				} else if (currentLevel == "class 2") {
					System.out.println("Yoy may get class 1 license");
				} else if (currentLevel == "class 1") {
					System.out.println("You already have the highest level of Alberta license");
				}
				else {
					System.out.println("enter valid current level of license for Alberta");
				}
			} else {
				System.out.println("enter valid province");
			}
		}

	}
}
