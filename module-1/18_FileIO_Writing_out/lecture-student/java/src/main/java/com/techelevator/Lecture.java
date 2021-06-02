package com.techelevator;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Lecture {

	public static void main(String[] args) throws IOException {

		Scanner userInput = new Scanner(System.in);

		/*
		 * The java.io.File class is a representation of file and directory path names.  It provides methods to inspect and
		 * modify file system objects.
		 *
		 * One benefit is that it compensates for differences in Windows and Unix use of '/' and '\' as directory delimiters.
		 *
		 * A new instance of File can be created from a String that contains a file system path
		 */

		System.out.println("Enter the path of a file or directory:");
		String path = userInput.nextLine();
		File f = new File(path);

		if (f.exists()) {
			System.out.println("name: " + f.getName());
			System.out.println("absolutePath: " + f.getAbsolutePath());
			if(f.isFile()) {
				System.out.println("type: file");
			}
			if(f.isDirectory()){
				System.out.println("type: directory");
			}
		} else {
			System.out.println(f.getAbsolutePath() + " does not exist.");
		}

		// Create a directory
		System.out.println("Please enter a new directory name: ");
		path = userInput.nextLine();
		File newDirectory = new File(path);
		if(newDirectory.exists()) {
			System.out.println("whomp, it's already there");
		} else {
			if(newDirectory.mkdir()){
				System.out.println("great! We made the directory " + newDirectory.getAbsolutePath());
			} else {
				System.out.println("sorry, that didn't work, new directory not created");
			}
		}

		// Create a file

		System.out.println("enter file name: ");
		String fileName = userInput.nextLine();
		File newFile = new File(newDirectory, fileName);

		if(!newFile.exists()) {
			newFile.createNewFile();
		}
		newFile.createNewFile();

		System.out.println(newFile.getName());
		System.out.println(newFile.getAbsolutePath());
		System.out.println(newFile.length());


		System.out.println("Give me some text to put in my file");
		String message = userInput.nextLine();


		try(PrintWriter writer = new PrintWriter(newFile)) {
			for(int i = 0; i < 5; i++) {
				writer.println(message);
				writer.flush();
			}

		}

		System.out.println(newFile.getName());
		System.out.println(newFile.getAbsolutePath());
		System.out.println(newFile.length());


	}

}
