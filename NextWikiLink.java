
//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           NextWikiLink
// Files:           None.
// Course:          Comp Sci 300, LEC-005, Spring 2019
//
// Author:          Shihan Cheng
// Email:           scheng93@wisc.edu
// Lecturer's Name: Mouna Kacem
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    NA
// Partner Email:   NA
// Partner Lecturer's Name: NA
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   ___ Write-up states that pair programming is allowed for this assignment.
//   ___ We have both read and understand the course Pair Programming Policy.
//   ___ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully 
// acknowledge and credit those sources of help here.  Instructors and TAs do 
// not need to be credited here, but tutors, friends, relatives, room mates, 
// strangers, and others do.  If you received no outside help from either type
//  of source, then please explicitly indicate NONE.
//
// Persons:         (identify each person and describe their help in detail)
// Online Sources:  (identify each URL and describe their assistance in detail)
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

import java.io.IOException;
import java.util.Scanner;
import java.util.function.Function;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * This class is the process of following the first link in one Wikipedia page
 * to the next, could be modeled as a kind of Iterator that is created by our
 * Generator class
 * 
 * @author Shihan.Cheng
 */
public class NextWikiLink implements Function<String, String> {

	/**
	 * This function uses user's input as the key word to find the first link in
	 * one Wikipedia page to the next.
	 * 
	 * @return Name of the first link in the wiki page
	 */
	@Override
	public String apply(String t) {
		try {
			// Download a Wikipedia page, using t in their internal link format:
			// /wiki/Some_Subject
			Document doc = Jsoup.connect("https://en.wikipedia.org" + t).get();
			// Use .css selector to retrieve a collection of links from this
			// page's description
			// "p a" selects links within paragraphs
			// ":not([title^='Help'])" skips pronunciations
			// ":not(sup a)" skips citations
			Elements links = doc.select("p a:not([title^='Help']):not(sup a)");
			// return the link attribute from the first element of this list
			return links.get(0).attr("href");
			// Otherwise return an appropriate error message:
		} catch (IOException | IllegalArgumentException e) {
			return "FAILED to find wikipedia page: " + t;
		} catch (IndexOutOfBoundsException e) {
			return "FAILED to find a link in wikipedia page: " + t;
		}
	}

	/**
	 * The main method implements our own Wikipedia crawling application.
	 * 
	 * @param args (input arguments if any)
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); // Create a new scanner
		String input; // Declare a string to store user's input
		int step = 0; // Declare an integer to store the user's number of
						// iterations
		// Prompt the user to enter a topic name
		System.out.println("Enter a wikipedia page topic: ");
		input = sc.nextLine(); // Store the name
		// Prompt the user to enter a number of iterations to follow
		System.out.println(
				"Enter the number of pages you'd like to step through: ");
		// Now check if user's input is a valid integer with a while loop
		while (sc.hasNext()) {
			try { // Try to check if it is an integer first;
				step = Integer.parseInt(sc.next());
				// Once user's input is an integer, check if it is valid
				if (step <= 0) {
					throw new IllegalArgumentException();
				}
				break; // If user's input is a positive integer, end the loop
			} catch (IllegalArgumentException e) {
				// Display a message to prompt user to re-enter an positive
				// integer
				System.out.println("Please enter an valid integer: ");
			}
		}
		// Prepend "/wiki/" to the user's input, and replace spaces with
		// underscores
		input = "/wiki/" + input.trim().replace(' ', '_');
		// Create a Generator to iterate
		Generator<String> it = new Generator<>(input, new NextWikiLink(), step);
		// Use a for-each loop to iterate through the number of links requested
		for (String output : it) {
			System.out.println(output);
			// If next link is failed to find, then stop iterating
			if (output.contains("FAILED to find")) {
				break;
			}
		}
		sc.close(); // Close the scanner;
	}
}