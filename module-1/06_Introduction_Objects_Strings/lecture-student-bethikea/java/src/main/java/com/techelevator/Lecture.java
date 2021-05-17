package com.techelevator;

public class Lecture {

	public static void main(String[] args) {

		System.out.println("************************************");
		System.out.println("****** MAKING A STRING OBJECT ******");
		System.out.println("************************************");

		/* The String class gets special treatment in the Java language.  One
		 * example of this is that there is a literal representation of a
		 * String (i.e. characters appearing between two double quotes.  This
		 * is not the case for most classes */

		/* create an new instance of String using a literal */
		String myString = "Hi, I'm a little, happy string";
		String anotherString;

		
		System.out.println();
		System.out.println("******************************");
		System.out.println("****** MEMBER METHODS ******");
		System.out.println("******************************");
		System.out.println();

		String ikea = "Swedish Furniture";
		System.out.println(ikea.charAt(3));

		System.out.println("contains examples");
		boolean isItThere = ikea.contains("Dish");
		System.out.println("ikea contains 'dish': " + isItThere);
		System.out.println("Ends with: " + ikea.endsWith("ture"));
		System.out.println("indexOf: char " + ikea.indexOf('e'));
		System.out.println("indexOf: str " + ikea.indexOf("ed"));
		System.out.println("indexOf: char " + ikea.lastIndexOf("e") + " length of string: " + ikea.length() );
		System.out.println("indexOf: char " + ikea.lastIndexOf("ed") + " length of string: " + ikea.length() );

		String stringPart = ikea.substring(5);
		String stringPartWithEnd = ikea.substring(5, ikea.length()-1);
		System.out.println(stringPart + " " + stringPartWithEnd);

		String upper = ikea.toUpperCase();
		ikea = ikea.toUpperCase();

		/* Other commonly used methods:
		 *
		 * endsWith
		 * startsWith
		 * indexOf
		 * lastIndexOf
		 * length
		 * substring
		 * toLowerCase
		 * toUpperCase
		 * trim
		 */

		System.out.println();
		System.out.println("**********************");
		System.out.println("****** EQUALITY ******");
		System.out.println("**********************");
		System.out.println();



		/* Double equals will compare to see if the two variables, hello1 and
		 * hello2 point to the same object in memory. Are they the same object? */
		String hello1 = "hello";
		String hello2 = "hello";
		if (hello1 == hello2) {
			System.out.println("They are equal!");
		} else {
			System.out.println(hello1 + " is not equal to " + hello2);
		}

		String hello3 = hello1;
		if (hello1 == hello3) {
			System.out.println("hello1 is the same reference as hello3");
		}

		/* So, to compare the values of two objects, we need to use the equals method.
		 * Every object type has an equals method */
		if (hello1.equals(hello2)) {
			System.out.println("They are equal!");
		} else {
			System.out.println(hello1 + " is not equal to " + hello2);
		}

		int[] scores = new int[10];
		int[] scores1 = {1, 2, 3};

	}
}
