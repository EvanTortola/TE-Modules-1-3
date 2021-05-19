package com.techelevator;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Lecture {

	public static void main(String[] args) {

		System.out.println("####################");
		System.out.println("        MAPS");
		System.out.println("####################");
		System.out.println();

		//Declare and instantiate a Map
		Map<String, String> nameToZip = new HashMap<String, String>();

		//Add Something to our map

		nameToZip.put("David", "44103");
		nameToZip.put("Ben", "44256");
		nameToZip.put("Beth", "15237");
		nameToZip.put("Frank", "Enigma");
		nameToZip.put("John", "00020");

		System.out.println("David lives in " + nameToZip.get("David"));
		System.out.println("Ben lives in " + nameToZip.get("Ben"));

		Set<String> keys = nameToZip.keySet();
		//Set <String> someOtherSet = new HashSet<String>();


		for ( String name : keys ) {
			System.out.println( name + " lives in " + nameToZip.get(name) );
		}


		nameToZip.put("Frank", "44109");
		System.out.println("Frank now lives in " + nameToZip.get("Frank"));

		nameToZip.remove("Beth");

	}

}
