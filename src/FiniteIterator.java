
//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           Iterating to Philosophy 
// Files:           EvenNumbers.java, FiniteIterator.java, Generator.java, 
//          InfiniteIterator.java, NextWikiLink.java, TestDriver.java
//          
// Course:          (CS 300, Spring, 2019)
//
// Author:          William Antonio-Gutierrez
// Email:           antoniogutie@wisc.edu 
// Lecturer's Name: Mouna Kacem
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    NONE
// Partner Email:   NONE
// Partner Lecturer's Name: NONE
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   _X_ Write-up states that pair programming is allowed for this assignment.
//   _X_ We have both read and understand the course Pair Programming Policy.
//   _X_ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully 
// acknowledge and credit those sources of help here.  Instructors and TAs do 
// not need to be credited here, but tutors, friends, relatives, room mates, 
// strangers, and others do.  If you received no outside help from either type
//  of source, then please explicitly indicate NONE.
//
// Persons:         NONE
// Online Sources:  NONE
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////
import java.util.Iterator;

/**
 * Class uses a InfiniteIterator sequence to generate a sequence of n length
 * 
 * @author wilib
 *
 */
public class FiniteIterator<T> implements Iterator<T> {
  private InfiniteIterator<T> newObj;
  private int length;
  private int count;

  /**
   * Constructor uses InfiniteIterator and a length to create an finite series
   * 
   * @param newObj
   *          InfiniteIterator type object
   * @param length
   *          size of the series finiteIterator
   */
  public FiniteIterator(InfiniteIterator<T> newObj, int length) {
    this.newObj = newObj;
    this.length = length;
    count = 0;
  }

  /**
   * Returns true until length size has been reached
   */
  @Override
  public boolean hasNext() {

    if (count < length) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Generates the next value in the sequence of InfinteIterator
   */
  @Override
  public T next() {

    count++;
    return newObj.next();

  }

}
