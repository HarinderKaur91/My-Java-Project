package AssignmentWeek9;

import java.util.Scanner;

public class Game {
	String maskedName = "";
	int counterForWrongGuess = 0;
	String nonMatchedLetters = "";
	String matchedLetters = "";

	Scanner sc = new Scanner(System.in);

	void GuessTheName(String randomName) {
		System.out.println("WELCOME TO GUESS THE STUDENT GAME");
		maskedName = randomName.replaceAll("\\w", "_"); // mask random element to '_'
		while (counterForWrongGuess < 5 && maskedName.contains("_")) {
			System.out.println("You are guessing :" + maskedName);
			System.out.println("Guess a letter:");
			String guessedLetter = sc.nextLine();
			GameLogic(guessedLetter, randomName);
		}
		sc.close();
	}

	public void GameLogic(String guessedLetter, String randomName) {
		String guessedName = "";
		int matchCount = 0;
		String guessedLetterInLowerCase = guessedLetter.toLowerCase();
		String guessedLetterInUpperCase = guessedLetter.toUpperCase();
		for (int i = 0; i < randomName.length(); i++) {
			boolean isLetterAlreadyMatched = false;
			if (randomName.charAt(i) == guessedLetterInLowerCase.charAt(0)
					|| randomName.charAt(i) == guessedLetterInUpperCase.charAt(0)) {
				matchCount++;
				guessedName += randomName.charAt(i);
				matchedLetters += guessedLetter.charAt(0);
				char[] matchedLettersToCharArray = matchedLetters.toCharArray();
				int counterForAlreadyMatchedLetters = 0;

				for (int j = 0; j < matchedLettersToCharArray.length; j++) {
					if (matchedLettersToCharArray[j] == guessedLetter.charAt(0)) {
						counterForAlreadyMatchedLetters++;
					}
				}
				if (counterForAlreadyMatchedLetters > 1) {
					isLetterAlreadyMatched = true;
				}

				if (matchCount == 1 && !isLetterAlreadyMatched) {
					System.out.println("You have guesssed (0) wrong letters:");
				}
			} else if (maskedName.charAt(i) != '_') {
				guessedName += randomName.charAt(i);
			} else {
				guessedName += "_";
			}
		}

		if (maskedName.equals(guessedName)) {
			counterForWrongGuess++;
			nonMatchedLetters += " " + guessedLetter;
			System.out.println("You have guesssed (" + counterForWrongGuess + ") wrong letters:" + nonMatchedLetters);
			if (counterForWrongGuess == 5) {
				System.out.println("Attempts exceeded!GAME OVER!");
				System.out.println("The name was " + randomName);
			}
		} else {
			maskedName = guessedName;
		}
		if (maskedName.equals(randomName)) {
			System.out.println("Hurray! You WIN!");
			System.out.println("You have guessed '" + maskedName + "' correctly");
		}
	}
}
