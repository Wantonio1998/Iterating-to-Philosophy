
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
import java.util.function.Function;

/**
 * Generates an infinite sequence of values Generic class that can be used with
 * Integers and Strings
 * 
 * @author wilib implements Iterator <Integer>
 * 
 */
public class InfiniteIterator<T> implements Iterator<T> {
  private T act;
  private boolean firstTime = true;
  Function<T, T> newFunc;

  /**
   * Constructor class creates T with an initial generic value and a generic
   * Function type T Depending on type i.e. String, Integer Function will have
   * different execution
   * 
   * @param act
   *          generic starting T
   * @param newFunc
   *          generic function to be applied
   */
  public InfiniteIterator(T act, Function<T, T> newFunc) {
    this.act = act;
    this.newFunc = newFunc;
  }

  /**
   * Method generates next object in the series of its type If first time called,
   * returns first item
   */
  public T next() {
    if (this.firstTime) {
      this.firstTime = false;
    } else {
      act = this.newFunc.apply(act);
    }

    return act;
  }

  /**
   * Method always true
   */
  public boolean hasNext() {
    boolean isTrue = true;

    return isTrue;
  }

}
