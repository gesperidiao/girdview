package com.example.models;

import java.io.Serializable;
import java.util.UUID;

public class Pictogram implements Serializable {


	private static final long serialVersionUID = 1L;
    
    private UUID id;
    private Byte[] image;
    private String fileName;
    private Integer contextId;
    
    private Integer tempId; //TODO: change to UUID
    
	public Pictogram(){};
	
	public Pictogram(Integer tempId, String fileName){
		super();
		this.setTempId(tempId);
		this.setFileName(fileName);
	}
	
    public Pictogram(UUID id, Byte[] image) {
		super();
		this.id = id;
		this.image = image;

	}	
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public Byte[] getImage() {
		return image;
	}
	public void setImage(Byte[] image) {
		this.image = image;
	}
	public Integer getContextId() {
		return contextId;
	}
	public void setContextId(Integer contextId) {
		this.contextId = contextId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Integer getTempId() {
		return tempId;
	}

	public void setTempId(Integer tempId) {
		this.tempId = tempId;
	}
    
    
}
