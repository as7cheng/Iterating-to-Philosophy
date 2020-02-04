
//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           Generator
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

import java.util.Iterator;
import java.util.function.Function;

/**
 * This class implements Iterable<> to create a iterator either finite or
 * infinite by class FiniteIterator and InfiniteIterator
 * 
 * @author Shihan.Cheng
 */
public class Generator<T> implements Iterable<T> {
	// Instance fields
	private T firstValue; // The very first element to start with
	private Function<T, T> generateNextFromLast; // Function to apply
	private int length; // Expected length for finite iterator
	private int mark; // Indicate the constructor's type, built in the
						// constructor

	/**
	 * Constructor, create an infinite iterator returned by method iterator()
	 * 
	 * @param firstValue he very first element to start with
	 * @param generateNextFromLast Function to apply for finding next element
	 */
	public Generator(T firstValue, Function<T, T> generateNextFromLast) {
		this.firstValue = firstValue; // The very first element to start with
		this.generateNextFromLast = generateNextFromLast; // The function to
															// apply finding the
															// next element
		this.mark = 1; // Type 1 means the infinite iterator
	}
	
	/**
	 * Constructor, create a finite iterator returned by method iterator()
	 * @param firstValue he very first element to start with
	 * @param generateNextFromLast Function to apply for finding next element
	 * @param length Expected length for finite iterator
	 */
	public Generator(T firstValue, Function<T, T> generateNextFromLast,
			int length) {
		this.firstValue = firstValue; // The very first element to start with
		this.generateNextFromLast = generateNextFromLast; // The function to
															// apply finding the
															// next element
		this.length = length; // Expected length for finite iterator
		this.mark = 2; // Type 2 means the finite iterator
	}

	/**
	 * This method create the generator based on the constructors's type, then
	 * return a iterator either infinite or finite
	 * 
	 * @return an infinite iterator with generic type arguments if the
	 *         constructor's mark is 1, or a finite iterator with generic type
	 *         arguments if the constructor's mark is 2
	 */
	@Override
	public Iterator<T> iterator() {
		// Create a infinite iterator first
		InfiniteIterator<T> infinite = new InfiniteIterator<T>(this.firstValue,
				this.generateNextFromLast);
		// Check the constructor's mark, if it is 1, then return the infinite
		// iterator
		if (this.mark == 1) {
			return infinite;
		}
		// Otherwise, create a finite iterator with the infinite iterator
		FiniteIterator<T> finite = new FiniteIterator<T>(infinite, this.length);
		// Return the finite iterator
		return finite;
	}

}
