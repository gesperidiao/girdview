package com.example.models;

import java.util.ArrayList;
import java.util.List;

public class Sentence {
	
	private List<Symbol> symbolList = new ArrayList<Symbol>();

	public List<Symbol> getSymbolList() {
		return symbolList;
	}

	public void setSymbolList(List<Symbol> symbolList) {
		this.symbolList = symbolList;
	}
	
	public void clearSentence(){
		this.symbolList.clear();
	}
	
	public boolean addSymbol(Symbol s){
		return this.symbolList.add(s);
	}
	
	public void read(){
		for(int i = 0; i < this.symbolList.size() ; i++){
			
		}
	}

}
