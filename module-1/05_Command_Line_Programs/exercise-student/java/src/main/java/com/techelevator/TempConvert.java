package com.techelevator;

import java.util.Scanner;

public class TempConvert {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter the temperature");
		String enterTemp = scanner.nextLine();
		System.out.println("Is the temperature in (C)elsius or (F)ahrenheit? ");
		String whichTemp = scanner.nextLine();
		if (whichTemp.equals("F")) {
			double fTemp = Double.parseDouble(enterTemp);
			double fahrenheitToCelsius = (fTemp - 32) / 1.8;
			System.out.println(fahrenheitToCelsius + "c");
		} else if (whichTemp.equals("C")) {
			double cTemp = Double.parseDouble(enterTemp);
			double celsiusToFahrenheit = cTemp * 1.8 + 32;
			System.out.println(celsiusToFahrenheit + "f");


		}

	}

}
