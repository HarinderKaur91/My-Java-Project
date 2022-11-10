package AssignmentWeek9;

// Java program select a random element from array

import java.util.List;

public class MainGuessTheStudent {
	
	public static void main(String[] args) {

		ReadFile file = new ReadFile();
		Game game = new Game();

		List<String> list = file.readingFileIntoList("C:\\Users\\Harry\\Desktop\\NameList.txt");

		String randomName = file.getRandomName(list);
		
		game.GuessTheName(randomName );
		
	}

}
