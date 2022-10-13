// This code is handling invalid inputs also
package AssignmentWeek6;

import java.util.Scanner;

public class MainClassCrSCalculation {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		CrsCalculation cC = new CrsCalculation();

		System.out.println("Enter your Education Level:\n");
		System.out.println("Press 1 - PhD\n" + "Press 2 - Master’s Degree\n"
				+ "Press 3 - Two or more university degrees/diplomas at the bachelor’s level one of which is a three year or longer duration \n"
				+ "Press 4 - 12th+ Three Years or longer Degree /Diploma");

		int education = sc.nextInt();
		while (!(education == 1 || education == 2 || education == 3 || education == 4)) {// loop to handle invalid input
			System.out.println("You have entered INVALID option for education. Please choose from 1,2,3 or 4");
			education = sc.nextInt();
		}

		int pointsOfEducation = cC.educationScore(education);

		System.out.println("Enter your Experience in years: " + "4,5,6 or more than 6");
		int numberOfYears = sc.nextInt();
		while (numberOfYears < 4) { // loop to handle invalid input
			System.out.println(
					"INVALID input.You must have 4 or more than 4 years of experience to enter into the application pool.");
			System.out.println("Please enter your experience again.");
			numberOfYears = sc.nextInt();
		}

		int pointsOfExperience = cC.experienceScore(numberOfYears);

		System.out.println("Enter your age in years from 18 to 47:");
		int age = sc.nextInt();
		while (age < 18) { // loop to handle invalid input
			System.out.println(
					"INVALID age input. You should be 18 years old or more to enter into the application pool.");
			System.out.println("Please enter your age again.");
			age = sc.nextInt();
		}
		int pointsOfAge = 0;
		if (age >= 18 && age <= 35) {
			pointsOfAge = cC.ageScore1(age);
		} else if (age > 35 && age <= 47) {
			pointsOfAge = cC.ageScore2(age);
		}
		//System.out.println("Points of age = " + pointsOfAge);

		System.out.println("Enter your IELTS Score for Listening:");
		double listeningScore = sc.nextDouble();
		System.out.println("Enter your IELTS Score for Speaking:");
		double speakingScore = sc.nextDouble();
		System.out.println("Enter your IELTS Score for Reading: ");
		double readingScore = sc.nextDouble();
		System.out.println("Enter your IELTS Score for Writing:");
		double writingScore = sc.nextDouble();

		int pointsOfIelts = cC.ieltsScore(listeningScore, speakingScore, readingScore, writingScore);

		System.out.println(
				"If you have a relative  in Canada(Parents, Grand Parents, Brother, Sister, Aunt, Uncle, Nephew or Niece)"
						+ " who is a Canadian Citizen or PR holder (Y/N)");
		String RelativesPresentInCanada = sc.next();
		while (!(RelativesPresentInCanada.equalsIgnoreCase("Y") || RelativesPresentInCanada.equalsIgnoreCase("N"))) {
			System.out.println("INVALID input. Enter 'Y' for Yes and 'N' for No");
			RelativesPresentInCanada = sc.next();
		}

		System.out.println("Have you studied in Canada for atleast 2 years (Y/N)");
		String studyInCanada = sc.next();
		while (!(studyInCanada.equalsIgnoreCase("Y") || studyInCanada.equalsIgnoreCase("N"))) {
			System.out.println("INVALID input. Enter 'Y' for Yes and 'N' for No");
			studyInCanada = sc.next();
		}

		System.out.println("Have you worked in Canada for atleast 2 years at NOC 0, A, B (Y/N)");
		String workInCanada = sc.next();
		while (!(workInCanada.equalsIgnoreCase("Y") || workInCanada.equalsIgnoreCase("N"))) {
			System.out.println("INVALID input. Enter 'Y' for Yes and 'N' for No");
			workInCanada = sc.next();
		}

		int pointsOfAdaptability = cC.adaptabilityScore(RelativesPresentInCanada, studyInCanada, workInCanada);

		System.out.println("\n");
		System.out.println("Points of Education 		= " + pointsOfEducation);
		System.out.println("Points of Experience 		= " + pointsOfExperience);
		System.out.println("Points of Age 			= " + pointsOfAge);
		System.out.println("Points of Ielts 		= " + pointsOfIelts);
		System.out.println("Points of Adaptability 		= " + pointsOfAdaptability);

		int totalCrsScore = pointsOfEducation + pointsOfExperience + pointsOfAge + pointsOfIelts + pointsOfAdaptability;

		System.out.println("\nTotal Points you have scored: " + totalCrsScore + " Points");

		if (totalCrsScore >= 67) {
			System.out.println("\nYou QUALIFY to submit an Expression of Interest (EOI) to Immigration Canada");
		} else {
			System.out.println("You DO NOT qualify to submit an Expression of Interest (EOI) to Immigration Canada");
		}

	}

}
