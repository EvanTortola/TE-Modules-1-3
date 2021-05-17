package com.techelevator;

import java.util.Scanner;

public class LinearConvert {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the length");
		String length = scanner.nextLine();
		System.out.println("Is the measurement in (m)eter or (f)eet? ");
		String whichMeasurement = scanner.nextLine();
		if ( whichMeasurement.equals("f") ){
			double feetLength = Double.parseDouble(length);
			double feetToMeters = feetLength * .3048;
			System.out.println(feetToMeters);
		} else if (whichMeasurement.equals("m")){
			double meterLength = Double.parseDouble(length);
			double metersToFeet = meterLength * 3.2808399;
			System.out.println(metersToFeet);



		}




	}

}
