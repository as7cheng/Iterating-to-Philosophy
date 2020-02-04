
//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           EvenNumbers
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
 * This class is an iterator with infinite even numbers
 * 
 * @author Shihan.Cheng
 */
public class EvenNumbers implements Iterator<Integer> {
	// Instance fields
	private Integer currNum; // Integer field to store the current number
	private Integer counter; // For recording how many times the EvenNumbers
								// object's next() method has been called.

	/**
	 * Constructor, created by a staring integer
	 * 
	 * @param input any integer
	 */
	public EvenNumbers(Integer input) {
		this.currNum = input; // Assign current number
		this.counter = 0; // Counter as 0 that next() has never been called
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
	 * @return the current number's next smallest even number
	 */
	@Override
	public Integer next() {
		// When counter is 0 means the next() has never been called before
		// Then the first call should return the current number itself
		if (counter == 0) {
			this.counter++; // Counter increases with 1
			return this.currNum;
		}
		// When the current number is odd, its next smallest even number should
		// be current number+1
		if (!(this.currNum % 2 == 0)) {
			this.counter++; // Counter increases with 1
			this.currNum += 1; // The smallest even number
			return this.currNum;
		}
		// If the call is not the very first time and current number is even
		// Then current number+2 is the smallest even number to return
		this.counter++; // Counter increases with 1
		this.currNum += 2; // The smallest even number
		return this.currNum;
	}

}
