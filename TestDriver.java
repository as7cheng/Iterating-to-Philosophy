
//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           TestDriver
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

import java.util.function.Function;

/**
 * This class tests EvenNumbers, InfiniteIterator, FiniteIterator and Generator
 * with their methods and functions. Check if they can be iterating well
 * 
 * @author Shihan.Cheng
 */
public class TestDriver {

	/**
	 * This method tests if the class EvenNumber() works well
	 * 
	 * @return true if its next() always returns the smallest even number bigger
	 *         than the previous one and hasNext() always return true. Otherwise
	 *         return false.
	 */
	public static boolean testEvenNumbers() {
		// Test starts with an even number 44
		EvenNumbers it = new EvenNumbers(44);
		// First call should return the number itself
		if (it.next() != 44) {
			System.out.println("The first call of EvenNumbers.next() "
					+ "did not return the value passed into its constructor.");
			return false;
		}
		// Then return the smallest even number bigger than the previous one
		if (it.next() != 46) {
			System.out.println("The second call of EvenNumbers.next() "
					+ "did not return the smallest even number, "
					+ "that is larger than the previously returned number.");
			return false;
		}
		// The hasNext() should always return true
		if (it.hasNext() != true) {
			System.out.println("EvenNumbers.next() returned false, "
					+ "but should always return true.");
			return false;
		}
		// If no bug return true
		return true;
	}

	/**
	 * This method tests if the class InfiniteIterator() implemented by function
	 * PowersOfTwo() works well
	 * 
	 * @return true if next() always returns value is double of the previous one
	 *         and hasNext() always returns true. Otherwise return false
	 */
	public static boolean testPowersOfTwo() {
		// Create a new InfiniteIterator with type integer
		InfiniteIterator<Integer> it = new InfiniteIterator<>(8,
				new NextPowerOfTwo());
		// First call should return the number itself
		if (it.next() != 8) {
			System.out.println("The first call of InfiniteIterator.next() "
					+ "did not return the number passed into its constructor.");
			return false;
		}
		// Then next() should return a value which is double of the previous one
		if (it.next() != 16) {
			System.out.println("The second call of InfiniteIterator.next() "
					+ "did not return the smallest power of two number, "
					+ "that is larger than the previously returned number.");
			return false;
		}
		// The hasNext() should always return true
		if (it.hasNext() != true) {
			System.out.println("InfiniteIterator.next() returned false, "
					+ "but should always return true.");
			return false;
		}
		// If no bug, return true
		return true;
	}

	/**
	 * This method tests if the class InfiniteIterator() implemented by function
	 * AddExtraSmile() works well
	 * 
	 * @return true if next() always return the data has one more smile than the
	 *         previous one and hasNext() always returns true. Otherwise return
	 *         false
	 */
	public static boolean testAddExtraSmile() {
		// Create a new InfiniteIterator with string type
		InfiniteIterator<String> it = new InfiniteIterator<>("Hello",
				new AddExtraSmile());
		// The first call should return the string itself
		if (!it.next().equals("Hello")) {
			System.out.println("The first call of InfiniteIterator.next() "
					+ "did not return the string passed into its constructor.");
			return false;
		}
		// Then next() should return the previous one with an extra smile
		if (!it.next().contains(" :)")) {
			System.out.println("The second call of InfiniteIterator.next() "
					+ "did not return the a string with one more :), "
					+ "than the previously returned string.");
			return false;
		}
		// hasNext() should always return true
		if (it.hasNext() != true) {
			System.out.println("InfiniteIterator.next() returned false, "
					+ "but should always return true.");
			return false;
		}
		// If no bug, return true
		return true;
	}

	/**
	 * This method tests if the class FiniteIterator() works well
	 * 
	 * @return true if it can be iterating by calling next() correctly.
	 *         Otherwise, return false
	 */
	public static boolean testFiniteIterator() {
		// Create a new InifiniteIterator with function NextPowerOfTwo()
		InfiniteIterator<Integer> infinite = new InfiniteIterator<>(2,
				new NextPowerOfTwo());
		// Create a new FiniteIterator with the InifiniteIterator
		FiniteIterator<Integer> it = new FiniteIterator<>(infinite, 8);
		String s = ""; // Declare a string to store the iterated result
		// If it has next, call next()
		while (it.hasNext())
			s += " " + it.next();
		// The string should contains all the values by iterating
		if (!s.equals(" 2 4 8 16 32 64 128 256")) {
			System.out.println(
					"Repeatedly called the next() method of a FiniteIterator,"
							+ "and the incorrect valuese were returned:" + s);
			return false;
		}
		// If no bug, return true
		return true;
	}

	/**
	 * This method tests if the class Generator() works well
	 * 
	 * @return true if it can be iterating by using for-each loop correctly.
	 *         Otherwise, return false
	 */
	public static boolean testGenerator() {
		// Create a new Generator with first value 0, function NexrNumber and
		// length 10
		Generator<Integer> it = new Generator<>(0, new NextNumber(), 10);
		String s = ""; // Declare a string to store the iterated result
		// Create a for-each loop to iterate
		for (Integer i : it) {
			s += " " + i; // Add the return value to the string
		}
		// The string should contains all the values by iterating
		if (!s.equals(" 0 1 2 3 4 5 6 7 8 9")) {
			System.out.println("For-each loop used by Genetator() failed,"
					+ "and the incorrect valuese were returned:" + s);
			return false;
		}
		// If no bug, return false
		return true;
	}

	/**
	 * The main method calls all the test methods above and print the messages
	 * for displaying the test outcomes
	 * 
	 * @param arg (input arguments if any)
	 */
	public static void main(String arg[]) {
		System.out.println("testEvenNumbers(): " + testEvenNumbers());
		System.out.println("testPowersOfTwo(): " + testPowersOfTwo());
		System.out.println("testAddExtraSmile(): " + testAddExtraSmile());
		System.out.println("testFiniteIterator(): " + testFiniteIterator());
		System.out.println("testGenerator(): " + testGenerator());
	}

}

/**
 * This class contains a function to be implemented
 * 
 * @author
 */
class NextPowerOfTwo implements Function<Integer, Integer> {

	/**
	 * This method is a function for doubling an integer
	 * 
	 * @return an integer that doubles the previous one
	 */
	@Override
	public Integer apply(Integer previous) {
		return 2 * previous;
	}
}

/**
 * This class contains a function to be implemented
 * 
 * @author
 */
class AddExtraSmile implements Function<String, String> {

	/**
	 * This method is a function for add an smile :) to the string argument
	 * 
	 * @return a string with an extra smile than the previous one
	 */
	@Override
	public String apply(String t) {
		return t + " :)";
	}
}

/**
 * This class was created by myself, contains a function to be implemented
 * 
 * @author Shihan.Cheng
 */
class NextNumber implements Function<Integer, Integer> {

	/**
	 * This method is a function for increasing an integer with 1
	 * 
	 * @return an integer that the previous one plus 1
	 */
	@Override
	public Integer apply(Integer previous) {
		return previous + 1;
	}
}
