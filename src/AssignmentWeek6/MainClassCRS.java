package AssignmentWeek6;

import java.util.Scanner;

public class MainClassCRS {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		CrsScore cs = new CrsScore();

		System.out.println("Enter your Education Level:\n");
		System.out.println("Press 1 - PhD\n" + "Press 2 - Master’s Degree\n"
				+ "Press 3 - Two or more university degrees/diplomas at the bachelor’s level one of which is a three year or longer duration \n"
				+ "Press 4 - 12th+ Three Years or longer Degree /Diploma");
		int education = sc.nextInt();
		int pointsOfEducation = cs.educationScore(education);

		System.out.println("Enter your Experience in years: " + "4,5,6 or more than 6");
		int numberOfYears = sc.nextInt();
		int pointsOfExperience = cs.experienceScore(numberOfYears);

		System.out.println("Enter your age in years from 18 to 47:");
		int age = sc.nextInt();
		int pointsOfAge = cs.ageScore(age);
		
		System.out.println("Enter your IELTS Score for Listening:");
		double listeningScore = sc.nextInt();
		System.out.println("Enter your IELTS Score for Speaking:");
		double speakingScore = sc.nextInt();
		System.out.println("Enter your IELTS Score for Reading: ");
		double readingScore = sc.nextInt();
		System.out.println("Enter your IELTS Score for Writing:");
		double writingScore = sc.nextInt();
		int pointsOfIelts = cs.ieltsScore( listeningScore,speakingScore,readingScore,writingScore);
		
		System.out.println("If you have a relative  in Canada(Parents, Grand Parents, Brother, Sister, Aunt, Uncle, Nephew or Niece)"
				+ " who is a Canadian Citizen or PR holder (Y/N)");
		String RelativesPresentInCanada = sc.next();
		System.out.println("Have you studied in Canada for atleast 2 years (Y/N)");
		String studyInCanada = sc.next();
		System.out.println("Have you worked in Canada for atleast 2 years at NOC 0, A, B (Y/N)");
		String workInCanada = sc.next();
		int pointsOfAdaptability = cs.adaptabilityScore(RelativesPresentInCanada,studyInCanada,workInCanada);
		
		System.out.println("Points of Education 	= "+ pointsOfEducation);
		System.out.println("Points of Experience 	= "+ pointsOfExperience);
		System.out.println("Points of Age 		= "+ pointsOfAge);
		System.out.println("Points of Ielts 	= "+ pointsOfIelts);
		System.out.println("Points of Adaptability 	= "+ pointsOfAdaptability);
		
		int totalCrsScore = pointsOfEducation + pointsOfExperience + pointsOfAge + pointsOfIelts + pointsOfAdaptability;

		
		System.out.println("\nTotal Points you have scored: " + totalCrsScore + " Points");
		
		if(totalCrsScore>=67) {
			System.out.println("\nYou qualify to submit an Expression of Interest (EOI) to Immigration Canada");
		}else {
			System.out.println("You DO NOT qualify to submit an Expression of Interest (EOI) to Immigration Canada");
		}
		
	}

}
