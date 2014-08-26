package com.example.models;

import java.util.UUID;

public class Symbol {

	
	private static final long serialVersionUID = 1L;
    
    private UUID id;
    private Term term;
    private Pictogram pictogram;
    
    private Integer tempID;
    
    public Symbol(Integer tempId, Term term, Pictogram pictogram){
    	this.tempID = tempId;
    	this.term = term;
    	this.pictogram = pictogram;
    }
    
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public UUID getId() {
		return id;
	}


	public void setId(UUID id) {
		this.id = id;
	}


	public Pictogram getPictogram() {
		return pictogram;
	}


	public void setPictogram(Pictogram pictogram) {
		this.pictogram = pictogram;
	}


	public Term getTerm() {
		return term;
	}


	public void setTerm(Term term) {
		this.term = term;
	}
    
    
    
    
}
