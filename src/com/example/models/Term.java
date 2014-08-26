package com.example.models;

import java.util.UUID;

public class Term {

	private static final long serialVersionUID = 1L;
    
    private UUID id;
    private String word;
    private Category category;
    
    private Integer tempId; //TODO
    
    public Term(Integer tempId, String word, Category c){
    	this.tempId = tempId;
    	this.word = word;
    	this.category = c;
    }
    
    
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
    
    
	
}
