package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class WordSearch {
	public static void main(String[] args) throws FileNotFoundException {

		File inputFile = getInputFileFromUser();

		try (Scanner fileScanner = new Scanner (inputFile)) {
			System.out.println("What is the word you are searching for?");
			Scanner wordInput = new Scanner(System.in);
			String word = wordInput.nextLine();
			int lineNumber = 1;
			while (fileScanner.hasNextLine()) {
				String nextLine = fileScanner.nextLine();
				lineNumber++;
				if (nextLine.contains(word)) {
					System.out.println(lineNumber + ") ");
					System.out.println(nextLine);
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("No such file found");
			e.printStackTrace();
		}



}

	private static File getInputFileFromUser() {
		Scanner userInput = new Scanner(System.in);
		System.out.println("Please enter the path to input file >>>");
		String path = userInput.nextLine();



		File inputFile = new File(path);
		if (inputFile.exists() == false){
			System.out.println(path + " does not exist");
		} else if (!inputFile.isFile() == false) {
			System.out.println(path + " is not a file");
		}
		return inputFile;
	}



	}
