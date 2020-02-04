
//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           FiniteIterator
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

/**
 * This class implements Iterator, build a iterator with finite elements
 * 
 * @author Shihan.Cheng
 */
public class FiniteIterator<T> implements Iterator<T> {
	// Instance fields
	private InfiniteIterator<T> infinite; // Create a new InfiniteIterator
	private int length; // The length of the finite iterator
	private int size; // Current size of the finite iterator

	/**
	 * Constructor, create a FiniteIterator with a InfiniteIterator and length
	 * 
	 * @param infinite an instance field
	 * @param length   the length of the infinite iterator
	 */
	public FiniteIterator(InfiniteIterator<T> infinite, int length) {
		this.infinite = infinite; // An instance infinite iterator
		this.length = length; // The length of the finite iterator
		this.size = 0; // Current size of the finite iterator
	}

	/**
	 * Check if iterator has next element
	 * 
	 * @return true if current size is less than the expected length, then the
	 *         current element still has next. Otherwise return false
	 */
	@Override
	public boolean hasNext() {
		return this.size < length;
	}

	/**
	 * Find the current element's next by applying the function
	 * 
	 * @return the current element's next returned by the function
	 */
	@Override
	public T next() {
		this.size += 1; // Increase the size with 1
		return this.infinite.next();
	}

}
