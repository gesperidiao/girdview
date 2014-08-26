package com.example.dataservice;

import java.util.UUID;




import com.example.models.Pictogram;

import android.content.ContentResolver;



public class DataService {

	public final PictogramDAO pictogramDAO;
	
	public DataService(ContentResolver contentResolver) {
        super();

        pictogramDAO = new PictogramDAO(contentResolver);
        
	}
	
	
	 //Store CRUD operations
    public UUID insertPictogram(Pictogram p){
    	return pictogramDAO.insert(p);
    }
    
    public void updatePictogram(Pictogram p){
    	pictogramDAO.update(p);
    }
    
    public void deletePictogram(Pictogram p){
    	pictogramDAO.delete(p.getId());
    }
    
    public Pictogram getPictogram(UUID id){
    	return pictogramDAO.get(id);
    }
    
    public LazyInitialization<Pictogram> getAllPictograms(){
    	return pictogramDAO.all();
    }
}
