package AssignmentWeek6;

import java.util.Scanner;

public class CrsCalculation {

	Scanner sc = new Scanner(System.in);

	int calculateEducationScore(int education) {// method returning points of education based on qualification
		int pointsOfEducation = 0;
		switch (education) {
		case 1:
			pointsOfEducation = 25;
			break;
		case 2:
			pointsOfEducation = 23;
			break;
		case 3:
			pointsOfEducation = 22;
			break;
		case 4:
			pointsOfEducation = 21;
			break;
		default:
			pointsOfEducation = 0;
			break;
		}
		return pointsOfEducation;
	}

	int calculateExperienceScore(int numberOfYears) {// method returning points of experience based on number of years
		int pointsOfExperience = 0;
		if (numberOfYears == 4 || numberOfYears == 5) {
			pointsOfExperience = 13;
		} else if (numberOfYears >= 6) {
			pointsOfExperience = 15;
		} else {
			pointsOfExperience = 0;
		}
		return pointsOfExperience;
	}

	int calculateAgeScore(int age) {
		int pointsOfAge = 0;
		if (age >= 18 && age <= 35) {
			pointsOfAge = 12;
		} else {
			switch (age) {
			case 36:
				pointsOfAge = 11;
				break;
			case 37:
				pointsOfAge = 10;
				break;
			case 38:
				pointsOfAge = 9;
				break;
			case 39:
				pointsOfAge = 8;
				break;
			case 40:
				pointsOfAge = 7;
				break;
			case 41:
				pointsOfAge = 6;
				break;
			case 42:
				pointsOfAge = 5;
				break;
			case 43:
				pointsOfAge = 4;
				break;
			case 44:
				pointsOfAge = 3;
				break;
			case 45:
				pointsOfAge = 2;
				break;
			case 46:
				pointsOfAge = 1;
				break;
			}
		}
		return pointsOfAge;
	}

	int calcualteIeltsScore(double listeningScore, double speakingScore, double readingScore, double writingScore) {
		int pointsOfIelts = 0;
		int pointsOfListening = 0;
		int pointsOfSpeaking = 0;
		int pointsOfReading = 0;
		int pointsOfWriting = 0;
		
		if (listeningScore == 7.5) {
			pointsOfListening = 5;
		} else if (listeningScore >= 8) {
			pointsOfListening = 6;
		}
		if (speakingScore == 6.5) {
			pointsOfSpeaking = 5;
		} else if (speakingScore >= 7) {
			pointsOfSpeaking = 6;
		}
		if (readingScore == 6.5) {
			pointsOfReading = 5;
		} else if (readingScore >= 7) {
			pointsOfReading = 6;
		}
		if (writingScore == 6.5) {
			pointsOfWriting = 5;
		} else if (writingScore >= 7) {
			pointsOfWriting = 6;
		}
		System.out.println("Points of Listening 	= " + pointsOfListening);
		System.out.println("Points of Speaking 	= " + pointsOfSpeaking);
		System.out.println("Points of Reading 	= " + pointsOfReading);
		System.out.println("Points of Writing 	= " + pointsOfWriting);

		pointsOfIelts = pointsOfListening + pointsOfSpeaking + pointsOfReading + pointsOfWriting;
		return pointsOfIelts;
	}

	int calculateAdaptabilityScore(String RelativesPresentInCanada, String studyInCanada, String workInCanada) {
		int pointsOfAdaptability = 0;
		int pointsOfRelatives = 0;
		int pointsOfStudy = 0;
		int pointsOfWork = 0;
		if (RelativesPresentInCanada.equalsIgnoreCase("Y")) {
			pointsOfRelatives = 5;
		}
		if (studyInCanada.equalsIgnoreCase("Y")) {
			pointsOfStudy = 5;
		}
		if (workInCanada.equalsIgnoreCase("Y")) {
			pointsOfWork = 10;
		}
		System.out.println("\n");
		System.out.println("Points of Relatives in Canada 	= " + pointsOfRelatives);
		System.out.println(("Points of Study in Canada 	= " + pointsOfStudy));
		System.out.println("Points of Work in Canada 	= " + pointsOfWork);
		pointsOfAdaptability = pointsOfRelatives + pointsOfStudy + pointsOfWork;
		return pointsOfAdaptability;
	}
}
