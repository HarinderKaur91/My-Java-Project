package AssignmentWeek9;

//Java program to illustrate reading data from file
//using nio.File
import java.util.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.io.*;

public class ReadFile {
	public List<String> readingFileIntoList(String fileName) {
		List<String> lines = Collections.emptyList();
		try {
			lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lines;
	}

	// Function selecting an element based on index and returning an element
	public String getRandomName(List<String> list) {
		Random rand = new Random();
		return list.get(rand.nextInt(list.size()));
	}
}
