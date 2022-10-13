package AssignmentWeek6;

import java.util.Scanner;

public class CrsScoreCalculation {

	Scanner sc = new Scanner(System.in);

	int educationScore(int education) {
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

	int experienceScore(int numberOfYears) {
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

	int ageScore1(int age) {
		int pointsOfAge = 0;
		pointsOfAge = 12;
		return pointsOfAge;
	}

	int ageScore2(int age) {
		int pointsOfAge = 12;
		for (int i = 36; i < 48; i++) {
			pointsOfAge--;
			if(age == i) {
				break;
			}
		}
		return pointsOfAge;
	}

//		} else if (age == 36) {
//			pointsOfAge = 11;
//		} else if (age == 37) {
//			pointsOfAge = 10;
//		} else if (age == 38) {
//			pointsOfAge = 9;
//		} else if (age == 39) {
//			pointsOfAge = 8;
//		} else if (age == 40) {
//			pointsOfAge = 7;
//		} else if (age == 41) {
//			pointsOfAge = 6;
//		} else if (age == 42) {
//			pointsOfAge = 5;
//		} else if (age == 43) {
//			pointsOfAge = 4;
//		} else if (age == 44) {
//			pointsOfAge = 3;
//		} else if (age == 45) {
//			pointsOfAge = 2;
//		} else if (age == 46) {
//			pointsOfAge = 1;
//		} else if (age == 47) {
//			pointsOfAge = 0;
//		} else {
//			pointsOfAge = 0;
//		}
	//return pointsOfAge;}

	int ieltsScore(double listeningScore, double speakingScore, double readingScore, double writingScore) {
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

	int adaptabilityScore(String RelativesPresentInCanada, String studyInCanada, String workInCanada) {
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
		System.out.println("Points of Relatives in Canada = " + pointsOfRelatives);
		System.out.println(("Points of Study in Canada = " + pointsOfStudy));
		System.out.println("Points of Work in Canada = " + pointsOfWork);
		pointsOfAdaptability = pointsOfRelatives + pointsOfStudy + pointsOfWork;
		return pointsOfAdaptability;
	}
}
