// This code is handling invalid inputs also
package AssignmentWeek6;

import java.util.Scanner;

public class MainClassCrSCalculation {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		CrsCalculation cC = new CrsCalculation();
		int numberOfEducationAttempts = 0;
		int numberOfYearsAttempts = 0;
		int numberOfAgeAttempts = 0;
		int numberOfRelativesCheckAttempts = 0;
		int numberOfStudyInCanadaAttempts = 0;
		int numberOfWorkInCanadaAttempts = 0;
		int numberOfListeningScoreAttempts = 0;
		int numberOfSpeakingScoreAttempts = 0;
		int numberOfReadingingScoreAttempts = 0;
		int numberOfWritingScoreAttempts = 0;

		System.out.println("Enter your Education Level:\n");
		System.out.println("Press 1 - PhD\n" + "Press 2 - Master’s Degree\n"
				+ "Press 3 - Two or more university degrees/diplomas at the bachelor’s level one of which is a three year or longer duration \n"
				+ "Press 4 - 12th+ Three Years or longer Degree /Diploma");

		int education = sc.nextInt();
		while (!(education == 1 || education == 2 || education == 3 || education == 4)) {// loop to handle invalid input
			numberOfEducationAttempts++;
			if (numberOfEducationAttempts > 2) {
				System.out.println("Attempts exceeded! Start again...");
				System.exit(0);
			}
			System.out.println("You have entered INVALID option for education. Please choose from 1,2,3 or 4");
			education = sc.nextInt();
		}

		int pointsOfEducation = cC.calculateEducationScore(education);

		System.out.println("Enter your Experience in years: " + "4,5,6 or more than 6");
		int numberOfYears = sc.nextInt();

		while (numberOfYears < 4) { // loop to handle invalid input
			numberOfYearsAttempts++;
			if (numberOfYearsAttempts > 2) {
				System.out.println("Attempts exceeded! Start again...");
				System.exit(0);
			}
			System.out.println(
					"INVALID input.You must have 4 or more than 4 years of experience to enter into the application pool.");
			System.out.println("Please enter your experience again.");
			numberOfYears = sc.nextInt();
		}

		int pointsOfExperience = cC.calculateExperienceScore(numberOfYears);

		System.out.println("Enter your age in years from 18 to 46:");
		int age = sc.nextInt();

		while (age < 18 || age > 46) { // loop to handle invalid input
			numberOfAgeAttempts++;
			if (numberOfAgeAttempts > 2) {
				System.out.println("Attempts exceeded! Start again...");
				System.exit(0);
			}
			System.out.println(
					"INVALID input. You age should be 18 years or more and less than 47 years to enter into the application pool.");
			System.out.println("Please enter your age again.");
			age = sc.nextInt();
		}

		int pointsOfAge = cC.calculateAgeScore(age);

		System.out.println("Enter your IELTS Score for Listening:");
		double listeningScore = sc.nextDouble();
		while (listeningScore > 9) { // loop to handle invalid input
			numberOfListeningScoreAttempts++;
			if (numberOfListeningScoreAttempts > 1) {
				System.out.println("Attempts exceeded! Start again...");
				System.exit(0);
			}
			System.out.println("INVALID input. You cannot have more than 9 bands.");
			System.out.println("Please enter your score again.");
			listeningScore = sc.nextDouble();
		}
		System.out.println("Enter your IELTS Score for Speaking:");
		double speakingScore = sc.nextDouble();
		while (speakingScore > 9) { // loop to handle invalid input
			numberOfSpeakingScoreAttempts++;
			if (numberOfSpeakingScoreAttempts > 1) {
				System.out.println("Attempts exceeded! Start again...");
				System.exit(0);
			}
			System.out.println("INVALID input. You cannot have more than 9 bands.");
			System.out.println("Please enter your score again.");
			speakingScore = sc.nextDouble();
		}
		System.out.println("Enter your IELTS Score for Reading: ");
		double readingScore = sc.nextDouble();
		while (readingScore > 9) { // loop to handle invalid input
			numberOfReadingingScoreAttempts++;
			if (numberOfReadingingScoreAttempts > 1) {
				System.out.println("Attempts exceeded! Start again...");
				System.exit(0);
			}
			System.out.println("INVALID input. You cannot have more than 9 bands.");
			System.out.println("Please enter your score again.");
			readingScore = sc.nextDouble();
		}
		System.out.println("Enter your IELTS Score for Writing:");
		double writingScore = sc.nextDouble();
		while (writingScore > 9) { // loop to handle invalid input
			numberOfWritingScoreAttempts++;
			if (numberOfWritingScoreAttempts > 1) {
				System.out.println("Attempts exceeded! Start again...");
				System.exit(0);
			}
			System.out.println("INVALID input. You cannot have more than 9 bands.");
			System.out.println("Please enter your score again.");
			writingScore = sc.nextDouble();
		}
		int pointsOfIelts = cC.calcualteIeltsScore(listeningScore, speakingScore, readingScore, writingScore);

		System.out.println(
				"If you have a relative  in Canada(Parents, Grand Parents, Brother, Sister, Aunt, Uncle, Nephew or Niece)"
						+ " who is a Canadian Citizen or PR holder (Y/N)");
		String RelativesPresentInCanada = sc.next();
		while (!(RelativesPresentInCanada.equalsIgnoreCase("Y") || RelativesPresentInCanada.equalsIgnoreCase("N"))) {
			numberOfRelativesCheckAttempts++;
			if (numberOfRelativesCheckAttempts > 2) {
				System.out.println("Attempts exceeded! Start again...");
				System.exit(0);
			}
			System.out.println("INVALID input. Enter 'Y' for Yes and 'N' for No");
			RelativesPresentInCanada = sc.next();
		}

		System.out.println("Have you studied in Canada for atleast 2 years (Y/N)");
		String studyInCanada = sc.next();
		while (!(studyInCanada.equalsIgnoreCase("Y") || studyInCanada.equalsIgnoreCase("N"))) {
			numberOfStudyInCanadaAttempts++;
			if (numberOfStudyInCanadaAttempts > 2) {
				System.out.println("Attempts exceeded! Start again...");
				System.exit(0);
			}
			System.out.println("INVALID input. Enter 'Y' for Yes and 'N' for No");
			studyInCanada = sc.next();
		}

		System.out.println("Have you worked in Canada for atleast 2 years at NOC 0, A, B (Y/N)");
		String workInCanada = sc.next();
		while (!(workInCanada.equalsIgnoreCase("Y") || workInCanada.equalsIgnoreCase("N"))) {
			numberOfWorkInCanadaAttempts++;
			if (numberOfWorkInCanadaAttempts > 2) {
				System.out.println("Attempts exceeded! Start again...");
				System.exit(0);
			}
			System.out.println("INVALID input. Enter 'Y' for Yes and 'N' for No");
			workInCanada = sc.next();
		}

		int pointsOfAdaptability = cC.calculateAdaptabilityScore(RelativesPresentInCanada, studyInCanada, workInCanada);

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
