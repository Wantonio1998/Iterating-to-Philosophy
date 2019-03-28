
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
 * Generates a sequence of even numbers started a specified starting point
 * implements Iterator <Integer>
 * 
 * @author wilib
 */
public class EvenNumbers implements Iterator<Integer> {
  private Integer num;
  private boolean firstTime = true;

  /**
   * Constructor class creates object using parameter as starting number of series
   * 
   * @param num
   *          starting number
   */
  public EvenNumbers(Integer num) {
    this.num = num;

  }

  /**
   * Method returns the starting number if called for the first time, following
   * times it generates the next lower even number
   */
  public Integer next() {
    if (firstTime) {
      firstTime = false;
    } // if number is even add 2
    else if (num % 2 == 0) {
      this.num = num + 2;
    } else {
      // if number is odd add one to find next even
      num++;
    }

    return num;
  }

  /**
   * Always true in an infinite series
   */
  public boolean hasNext() {
    boolean isTrue = true;

    return isTrue;
  }

}
