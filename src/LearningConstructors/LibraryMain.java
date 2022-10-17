package LearningConstructors;

import java.util.Scanner;

public class LibraryMain {

	public static void main(String[] args) {
		String requiredBookName;
		BookDetails romeoAndJuliet = new BookDetails("Romeo and Juliet", "Shakespere");
		BookDetails peaceOfMind = new BookDetails("Peace of Mind", "Allen");
		BookDetails homeBody = new BookDetails("Home Body", "Rupi Kaur");
		BookDetails twoStates = new BookDetails("Two States", "Two States");
		BookDetails halfGirlfriend = new BookDetails("Half Girlfriend", "Chetan Bhagat");
		BookDetails oliverTwist = new BookDetails("Oliver Twist", "Charles Dickens");
		BookDetails macbeth = new BookDetails("Macbeth", "Shakespere");
		BookDetails harrypotter1 = new BookDetails("Harry Potter and the Sorcere's Stone", "J K Rowling");
		BookDetails malgudyDays = new BookDetails("Malgudy Days", "R K Narayan");
		BookDetails alchemist = new BookDetails("Alchemist", "Paulo Coehlo");

		// Array of Objects
		BookDetails[] bookDetails = { romeoAndJuliet, peaceOfMind, homeBody, twoStates, halfGirlfriend, oliverTwist,
				macbeth, harrypotter1, malgudyDays, alchemist };
		Scanner sc = new Scanner(System.in);
		int bookCount = 0;
		int i;
		do {
			System.out.println("Which book you want to be issued");
			requiredBookName = sc.nextLine();
			System.out.println("Who is the author");
			String bookAuthor = sc.nextLine();

			for (i = 0; i < bookDetails.length; i++) {
				if ((requiredBookName.equals(bookDetails[i].bookName))
						&& (bookAuthor.equals(bookDetails[i].authorName))) {
					if (!bookDetails[i].isBookIssued) {

						bookDetails[i].isBookIssued = true;
						bookCount++;
						System.out.println("\nBook " + bookCount + ": " + bookDetails[i].bookName + " is issued"
								+ " and present at index " + i + "\n");
						break;

					} else {
						System.out.println(
								"\n" + requiredBookName + " is already issued. This cannot be issued twice.\n");
						break;
					}
				}
			}
			if (i == bookDetails.length) {
				System.out.println("\n" + requiredBookName + " is not available in the library\n");
			}

		} while (bookCount < 3);
		System.out.println("\nYou have been issued 3 books.You cannot borrrow more books.");

	}
}
