
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
 * Class tests functionality of project classes implemented
 * 
 * @author wilib
 *
 */
public class TestDriver {

  /**
   * Method tests functionality of even numbers class
   * 
   * @return true when all tests are passed successfully
   */
  public static boolean testEvenNumbers() {
    EvenNumbers it = new EvenNumbers(44);
    boolean testPassed = true;
    // when method next called first time returns initial value sequence
    if (it.next() != 44) {
      System.out
          .println("The first call of EvenNumbers.next() " + "did not return the value passed into its constructor.");
      testPassed = false;
    }
    // next even number is 46
    if (it.next() != 46) {
      System.out.println("The second call of EvenNumbers.next() " + "did not return the smallest even number, "
          + "that is larger than the previously returned number.");
      testPassed = false;
    }
    // hasNext method is always true
    if (it.hasNext() != true) {
      System.out.println("EvenNumbers.next() returned false, " + "but should always return true.");
      testPassed = false;
    }
    return testPassed;
  }

  /**
   * Method tests correct functionality of PowersOfTwo function
   * 
   * @return true when all tests are passed correctly
   */
  public static boolean testPowersOfTwo() {
    Iterator<Integer> it = new InfiniteIterator<>(8, new NextPowerOfTwo());
    boolean testPassed = true;
    // first next call should return intial value of sequence
    if (it.next() != 8) {
      System.out.println(
          "The first call of InfiniteIterator.next() " + "did not return the number passed into its constructor.");
      testPassed = false;
    } // next value is 8*2 = 16
    if (it.next() != 16) {
      System.out
          .println("The second call of InfiniteIterator.next() " + "did not return the smallest power of two number, "
              + "that is larger than the previously returned number.");
      testPassed = false;
    } // hasNext is always true
    if (it.hasNext() != true) {
      System.out.println("InfiniteIterator.next() returned false, " + "but should always return true.");
      testPassed = false;
    }
    return testPassed;
  }

  /**
   * Method tests that AddExtraSmile function correctly adds a string " :)" to the
   * end of a string
   * 
   * @return true if all tests are passed correctly
   */
  public static boolean testAddExtraSmile() {
    InfiniteIterator<String> it = new InfiniteIterator<>("Hello", new AddExtraSmile());
    // First call of next should return initial value of sequence
    if (!it.next().equals("Hello")) {
      System.out.println(
          "The first call of InfiniteIterator.next() " + "did not return the string passed into its constructor.");
      return false;
    }
    // next value of sequnce should contain smiley face at the end
    if (!it.next().contains(" :)")) {
      System.out.println("The second call of InfiniteIterator.next() "
          + "did not return the a string with one more :), " + "than the previously returned string.");
      return false;
    }
    // hasNext method should always be true
    if (it.hasNext() != true) {
      System.out.println("InfiniteIterator.next() returned false, " + "but should always return true.");
      return false;
    }
    return true;
  }

  /**
   * Method tests correct functionality of a FiniteIterator by crating an infnite
   * itearator and limiting the sequence to a length of n
   * 
   * @return true if all tests are passed correctly
   */
  public static boolean testFiniteIterator() {
    InfiniteIterator<Integer> infinite = new InfiniteIterator<>(2, new NextPowerOfTwo());
    FiniteIterator<Integer> it = new FiniteIterator<>(infinite, 8);
    String s = "";
    // while loop should itearate until 8 values of sequences are created
    while (it.hasNext())
      s += " " + it.next();
    if (!s.equals(" 2 4 8 16 32 64 128 256")) {
      System.out.println(
          "Repeatedly called the next() method of a FiniteIterator," + "and the incorrect valuese were returned:" + s);
      return false;
    }
    return true;
  }

  /**
   * Method tests functionality by creating a Geberator object of type string and
   * adding three more smiley faces at the end
   * 
   * @return true if all tests are passed correctly
   */
  public static boolean testGenerator() {
    // test generator 1
    boolean testPassed = false;
    Generator<String> firstGen = new Generator<>("Testing", new AddExtraSmile(), 4);
    // firstGen.next();
    String s = "";
    for (String newStr : firstGen) {
      s = "" + newStr;

    }
    if (s.equals("Testing :) :) :)")) {
      testPassed = true;
    }
    System.out.println(s);


    return testPassed;
  }

  /**
   * Run method tests and print true or false depening on correctness of methods
   * @param args
   */
  public static void main(String[] args) {
    System.out.println("testEvenNumbers(): " + testEvenNumbers());
    System.out.println("testPowersOfTwo: " + testPowersOfTwo());
    System.out.println("testAddExtraSmile(): " + testAddExtraSmile());
    System.out.println("testFiniteIterator(): " + testFiniteIterator());
    System.out.println("testGenerator(): " + testGenerator());
  }

}

class NextPowerOfTwo implements Function<Integer, Integer> {
  @Override
  public Integer apply(Integer previous) {
    return 2 * previous;
  }
}

class AddExtraSmile implements Function<String, String> {
  @Override
  public String apply(String t) {
    return t + " :)";
  }
}
