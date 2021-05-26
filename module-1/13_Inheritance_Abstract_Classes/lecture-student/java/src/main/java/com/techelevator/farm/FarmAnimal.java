package com.techelevator.farm;

public abstract class FarmAnimal implements Singable {
	private String name;
	private String sound;
	private boolean isAsleep = false;

	public FarmAnimal(String name, String sound) {
		this.name = name;
		this.sound = sound;
	}

	public String getName( ) {
		return name;
	}
	public final String getSound( ) {
		if (isAsleep) {
			return "zzzZZZZZZZzzzz......";
		}
		 else return sound;
	}

	public void sleep(){
		this.isAsleep = true;

	}

}