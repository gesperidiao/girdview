package com.example.dataservice;

import java.util.UUID;

import com.example.models.Pictogram;

import android.content.ContentResolver;

public class PictogramDAO {
	ContentResolver contentResolver;
	
	public PictogramDAO(ContentResolver contentResolver) {
		this.contentResolver = contentResolver;
	}

	public UUID insert(Pictogram p) {
		// TODO Auto-generated method stub
		return null;
	}

	public void update(Pictogram p) {
		// TODO Auto-generated method stub
		
	}

	public Pictogram get(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	public LazyInitialization<Pictogram> all() {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(UUID id) {
		// TODO Auto-generated method stub
		
	}

	
	
}
