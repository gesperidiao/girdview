package com.example.contentproviders;

public class Populator {
	
	
	/*
	 * Dado um nome de arquivo, adicionar nova entrada de Pictograma no banco
	 */
	public void addPictogram(String fileName){
		/*
		 * Extracting word - everything before '_'
		 */
		String word;
		int underscorePosition = fileName.indexOf('-');
		if(underscorePosition == -1){
			word = fileName;
		}else{
			word = (String) fileName.subSequence(0, underscorePosition);
		}
		
	}
}
