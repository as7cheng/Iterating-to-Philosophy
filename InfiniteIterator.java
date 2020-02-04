
//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           InfiniteIterator
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
 * This class implements Iterator, build a iterator with infinite elements
 * 
 * @author Shihan.Cheng
 */
public class InfiniteIterator<T> implements Iterator<T> {
	// Instance fields
	private T input; // Integer field to store the current generic input
	private int counter; // For recording how many times the
							// InfiniteIterator object's next() method has
							// been called.
	private Function<T, T> function; // Function to access the input

	/**
	 * Constructor. Create a iterator with generic type
	 * 
	 * @param input    A generic type input
	 * @param function A generic type function
	 */
	public InfiniteIterator(T input, Function<T, T> function) {
		this.input = input; // The first value to start
		this.function = function; // The function to implement
		this.counter = 0; // The counter to check if the next() has been called
	}

	/**
	 * Check if iterator has next element
	 * 
	 * @return true forever
	 */
	@Override
	public boolean hasNext() {
		return true;
	}

	/**
	 * Find the current element's next
	 * 
	 * @return the current element's next returned by the function
	 */
	@Override
	public T next() {
		// When counter is 0 means the next() has never been called before
		// Then the first call should return the current element itself
		if (counter == 0) {
			this.counter++; // Counter increases with 1
			return this.input;
		}
		// If the call is not the very first time, then assign the value
		// returned by the function to the instance variable, then return the
		// value
		this.counter++; // Counter increases with 1
		this.input = this.function.apply(this.input); // Assignment
		return this.input;
	}

}
