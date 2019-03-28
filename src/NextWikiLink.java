
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
import java.io.IOException;
import java.util.Scanner;
import java.util.function.Function;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * Class follows one wikipedia link to the next within an object that implements
 * the function interface
 *
 */
public class NextWikiLink implements Function<String, String> {

  /**
   * Apply method uses jsoup library to access a wikipedia page If failed to find,
   * an exception is thrown
   */
  @Override
  public String apply(String t) {
    try {
      // Download a Wikipedia page, using t in their internal link format:
      // /wiki/Some_Subject
      Document doc = Jsoup.connect("https://en.wikipedia.org" + t).get();
      // Use .css selector to retrieve a collection of links from this page's
      // description
      // "p a" selects links within paragraphs
      // ":not([title^='Help'])" skips pronunciations
      // ":not(sup a)" skips citations
      Elements links = doc.select("p a:not([title^='Help']):not(sup a)");
      // return the link attribute from the first element of this list
      return links.get(0).attr("href");
      // Otherwise return an appropriate error message:
    } catch (IOException | IllegalArgumentException e) {
      return "FAILED to find wikipedia page: " + t;
    } catch (IndexOutOfBoundsException e) {
      return "FAILED to find a link in wikipedia page: " + t;
    }
  }

  /**
   * Prompt user to enter topic and number of iterations create generator and
   * implement for loop to iterate through
   * 
   * @param args
   */
  public static void main(String[] args) {
    // Implement your own Wikipedia crawling application here.

    // 1. prompt the user to enter a topic name and number of iterations to follow
    System.out.println("Enter topic to crawl: ");
    Scanner scnr = new Scanner(System.in);
    String topic = scnr.nextLine();
    System.out.println("Enter number of iterations: ");
    String numIt = scnr.nextLine();
    int pageIt = Integer.parseInt(numIt);

    // 2. prepend "/wiki/" to the user's input, and replace spaces with underscores
    topic = "/wiki/" + topic;
    topic = topic.replace(" ", "_");
    // Generator newGen = new Generator()

    // 3. use a for-each loop to iterate through the number of links requested
    Generator<String> newGen = new Generator<>(topic, new NextWikiLink(), pageIt);
    String str = "";
    int lim = 0;

    // enhance for loop that iterates through wikipedia pages starting at the
    // initial topic page
    for (String finalIt : newGen) {
      // if exception FAILED is thrown break out of loop
      if (str.contains("FAILED")) {
        break;
      } // iterate thorugh until number of iterations are completed
      else if (lim <= pageIt) {
        str = " " + finalIt;
        System.out.println(str);
        lim++;
      }
    }
    scnr.close();
  }
}