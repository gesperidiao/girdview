package com.example.models;

public enum Category {
	NOUN(0), VERB(1), PRONOUN(2), ADJECTIVE(3), DEFAULT(4);
	private final int category;
	private final String color;
	
	Category(int c){
		this.category = c;
		switch(c){
		case 0: this.color = "#FFCC66";
				break;
		case 1: this.color = "#99FF99";
				break;
		case 2: this.color = "#FFFF99";
				break;
		case 3: this.color = "#0099FF";
				break;
		default: this.color = "#FFFFFF";		
		}
	}
	@Override
	public String toString() {
		switch(this.category){
		case 0: return "Noun";
		case 1: return "Verb";
		case 2: return "Pronoun";
		case 3: return "Adjective";
		default: return "Default";
		}
	}

	public int toInt() {
		return this.category;
	}

	public static Category fromInt(int x) {
		switch(x){
		case 0: return NOUN;
		case 1: return VERB;
		case 2: return PRONOUN;
		case 3: return ADJECTIVE;
		default: return DEFAULT;
		}
	}
	
	public String getColor(){
		return this.color;
	}
}
