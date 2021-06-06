package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FindAndReplace {

    public static void main(String[] args)  {

        Scanner userInput = new Scanner(System.in);
        System.out.println("What is the search word?");
        String searchWord = userInput.nextLine();

        System.out.println("What is the replacement word?");
        String newWord = userInput.nextLine();

        System.out.println("WHat is the source file?");
        String filePath = userInput.nextLine();
        File userFile = new File(filePath);

        //check for existence of file
        // if no existence, end program
        try (Scanner sourceFile = new Scanner(userFile)){
            if (!userFile.exists()) {
                System.out.println(filePath + " does not exist!");
                System.exit(1);
            } else if (!userFile.isFile()) {
                System.out.println(filePath + " is not a file!");
                System.exit(1);

        }
        } catch (FileNotFoundException ex) {
            System.out.println("No such file");
        }

        System.out.println("What is the destination file?");
        String destinationPath = userInput.nextLine();

        try (Scanner sourceFile = new Scanner(userFile);
            PrintWriter finalPath = new PrintWriter(destinationPath))
        {
            while (sourceFile.hasNext()) {
                String inputLine = sourceFile.nextLine();
                finalPath.println(inputLine.replace(searchWord, newWord));
            }

        } catch (FileNotFoundException exception) {

        }
    }
}
