package com.techelevator;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FizzWriter {

	public static void main(String[] args)  {

		Scanner userInput = new Scanner(System.in);

		System.out.println("Where is the destination file?");
		String filePath = userInput.nextLine();

		String number = "0";

		try (PrintWriter fileLocation = new PrintWriter(filePath)) {
			for (int i = 1; i <= 300; i++) {
				String inputString = Integer.toString(i);
				if(i % 5 == 0 && i % 3 == 0) {
					number = "FizzBuzz";
					fileLocation.println(number);
				} else if (i % 3 == 0 || inputString.contains("3")){
					number = "Fizz";
					fileLocation.println(number);

				} else if (i % 5 == 0 || inputString.contains("5")) {
					number = "Buzz";
					fileLocation.println(number);

				} else {
					number = Integer.toString(i);
					fileLocation.println(number);
				}
			}
		} catch (FileNotFoundException e) {
			System.err.println("Not possible");
		}

	}

}
