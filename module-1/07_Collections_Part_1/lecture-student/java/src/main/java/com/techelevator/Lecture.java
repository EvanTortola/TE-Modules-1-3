package com.techelevator;

import java.util.*;

public class Lecture {

	public static void main(String[] args) {
		System.out.println("####################");
		System.out.println("       LISTS");
		System.out.println("####################");

		List <String> foods = new ArrayList<String>();
		foods.add("tacos");
		foods.add("bacon");
		foods.add("Steak");
		foods.add("artichokes");
		foods.add("ravioli");
		foods.add("cheese");
		foods.add("ice cream");

		System.out.println("####################");
		System.out.println("Lists are ordered");
		System.out.println("####################");

		for (int i = 0; i < foods.size(); i++) {
			System.out.println( foods.get(i) );
		}


		System.out.println("####################");
		System.out.println("Lists allow duplicates");
		System.out.println("####################");

		foods.add("ice cream");
		for (int i = 0; i < foods.size(); i++) {
			System.out.println( foods.get(i) );
		}


		System.out.println("####################");
		System.out.println("Lists allow elements to be inserted in the middle");
		System.out.println("####################");

		foods.add(3, "ice cream");
		for ( int i = 0; i < foods.size(); i++){
			System.out.println( foods.get (i));
		}

		System.out.println("####################");
		System.out.println("Lists allow elements to be removed by index");
		System.out.println("####################");

		foods.remove( 3 );


		System.out.println("####################");
		System.out.println("Find out if something is already in the List");
		System.out.println("####################");

		boolean hasRavioli = foods.contains( "ravioli");
		boolean hasPizza = foods.contains("pizza");

		System.out.println("ravioli?" + hasRavioli + "i can haz pizza?" + hasPizza);


		System.out.println("####################");
		System.out.println("Find index of item in List");
		System.out.println("####################");

		if (foods.contains("ravioli")) {


			int ixRavioli = foods.indexOf("ravioli");
			System.out.println("Ravioli lives at index: " + ixRavioli);
		}
		else {
			System.out.println(":(");
		}

		System.out.println("####################");
		System.out.println("Lists can be turned into an array");
		System.out.println("####################");

		String[] arrFood;
		arrFood = foods.toArray(new String[0]);


		System.out.println("####################");
		System.out.println("Lists can be sorted");
		System.out.println("####################");

		Collections.sort(foods);


		System.out.println("####################");
		System.out.println("Lists can be reversed too");
		System.out.println("####################");

		Collections.reverse(foods);


		System.out.println("####################");
		System.out.println("       FOREACH");
		System.out.println("####################");
		System.out.println();

		for ( String food : foods ) {
			System.out.println(food);

		}

		System.out.println("####################");
		System.out.println("       QUEUES");
		System.out.println("####################");
		System.out.println();

		Queue<String> priorities = new LinkedList<String>();
		priorities.offer( "Clean the dishes");
		priorities.offer(" Vacuum something");
		priorities.offer("Go to the store");

		while ( priorities.size() > 0) {
			String nextPriority = priorities.poll();
			System.out.println(nextPriority);
		}

		/////////////////////
		// PROCESSING ITEMS IN A QUEUE
		/////////////////////

		System.out.println("####################");
		System.out.println("       STACKS");
		System.out.println("####################");
		System.out.println();

		Stack<String> browserStack = new Stack<String>();
		browserStack.push("http://www.google.com");
		browserStack.push("http://facebook.com");
		browserStack.push("http://www.techelevator.com");

		for ( String url : browserStack ) {
			System.out.println(url);
		}
		while (browserStack.size() > 0)
		String urlToNav = browserStack.pop();
		System.out.println(urlToNav);
		////////////////////
		// PUSHING ITEMS TO THE STACK
		////////////////////

		////////////////////
		// POPPING THE STACK
		////////////////////


	}
}
