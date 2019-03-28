
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
 * Class creates Finite and Infinite iterators and implements the interface
 *
 * @param <T>
 *          Generic type object
 */
public class Generator<T> implements Iterable<T> {

  private T firstValue1;
  private T firstValue2;
  private Function<T, T> newFunc1;
  private Function<T, T> newFunc2;
  private int length;
  private int genPicked;

  /**
   * Constructor class creates Generator of an inital T value and a Function
   * 
   * @param firstValue
   *          generic T type object first item in sequence
   * @param generateNextFromLast
   *          Function<T, T> that executes different actions depending on type
   *          object
   */
  public Generator(T firstValue, Function<T, T> generateNextFromLast) {
    genPicked = 1;
    this.firstValue1 = firstValue;
    this.newFunc1 = generateNextFromLast;
  }

  /**
   * Overloaded constructor creates object with initial value of sequence,
   * function and length
   * 
   * @param firstValue
   *          initial value of sequence
   * @param generateNextFromLast
   *          function to determine type of action
   * @param length
   *          of the finite sequence
   */
  public Generator(T firstValue, Function<T, T> generateNextFromLast, int length) {
    genPicked = 2;
    this.firstValue2 = firstValue;
    this.newFunc2 = generateNextFromLast;
    this.length = length;
  }

  /**
   * Method from Iterator acts depending on type of Generator created.
   */
  @Override
  public Iterator<T> iterator() {
    InfiniteIterator<T> infIt;
    // If first generator, an InfiniteIterator is created and returned
    if (genPicked == 1) {
      infIt = new InfiniteIterator<>(firstValue1, newFunc1);
      return (Iterator<T>) infIt;
    } else {
      // If second generator picked, create an Infinite iterator and use to create a
      // finite iterator of
      // specified length
      infIt = new InfiniteIterator<>(firstValue2, newFunc2);
      FiniteIterator<T> finiteIt = new FiniteIterator<>(infIt, length);
      return (Iterator<T>) finiteIt;
    }

  }

}
