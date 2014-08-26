package com.example.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DataHardCode {

	private List<Pictogram> pictogramList = new ArrayList<Pictogram>();
	private List<Term> termList = new ArrayList<Term>();
	private List<Symbol> symbolList = new ArrayList<Symbol>();

	public DataHardCode() {
		generatePictogramList();
		generateTermList();
		generateSymbolList();
	}

	public void generatePictogramList() {
		this.pictogramList.clear();

		this.pictogramList.add(new Pictogram(new Integer(1), "aabril"));
		this.pictogramList.add(new Pictogram(new Integer(2), "abecedario"));
		this.pictogramList.add(new Pictogram(new Integer(3), "abelha"));
		this.pictogramList.add(new Pictogram(new Integer(4), "aberto"));
		this.pictogramList.add(new Pictogram(new Integer(5), "abobora"));
		this.pictogramList.add(new Pictogram(new Integer(6), "abobrinha"));
		this.pictogramList.add(new Pictogram(new Integer(7), "aborrecer"));
		this.pictogramList.add(new Pictogram(new Integer(8), "abotoar"));
		this.pictogramList.add(new Pictogram(new Integer(9), "abracar"));
		this.pictogramList.add(new Pictogram(new Integer(10), "absorver"));
		this.pictogramList.add(new Pictogram(new Integer(11), "acampar"));
		this.pictogramList.add(new Pictogram(new Integer(12), "acessivel"));
		this.pictogramList.add(new Pictogram(new Integer(13), "acesso"));
		this.pictogramList.add(new Pictogram(new Integer(14), "acido"));
		this.pictogramList.add(new Pictogram(new Integer(15), "acougue"));
		this.pictogramList.add(new Pictogram(new Integer(16), "adesivo"));
		this.pictogramList.add(new Pictogram(new Integer(17), "adeus"));
		this.pictogramList.add(new Pictogram(new Integer(18), "adulto"));
		this.pictogramList.add(new Pictogram(new Integer(19), "advertencia"));
		this.pictogramList.add(new Pictogram(new Integer(20), "advertir"));
		this.pictogramList.add(new Pictogram(new Integer(21), "aeroplano"));
		this.pictogramList.add(new Pictogram(new Integer(22), "afiar"));

		this.pictogramList.add(new Pictogram(new Integer(23), "andar"));
		this.pictogramList.add(new Pictogram(new Integer(24), "beber"));
		this.pictogramList.add(new Pictogram(new Integer(25), "brincar"));
		this.pictogramList.add(new Pictogram(new Integer(26), "cachorro"));
		this.pictogramList.add(new Pictogram(new Integer(27), "cadeira"));
		this.pictogramList.add(new Pictogram(new Integer(28), "carne"));
		this.pictogramList.add(new Pictogram(new Integer(29), "cavalo"));
		this.pictogramList.add(new Pictogram(new Integer(30), "laptop"));
		this.pictogramList.add(new Pictogram(new Integer(31), "correr"));
		this.pictogramList.add(new Pictogram(new Integer(32), "dormir"));
		this.pictogramList.add(new Pictogram(new Integer(33), "ela"));
		this.pictogramList.add(new Pictogram(new Integer(33), "eles"));
		this.pictogramList.add(new Pictogram(new Integer(34), "entrar"));
		this.pictogramList.add(new Pictogram(new Integer(35), "eu"));
		this.pictogramList.add(new Pictogram(new Integer(36), "feliz"));
		this.pictogramList.add(new Pictogram(new Integer(37), "frango"));
		this.pictogramList.add(new Pictogram(new Integer(38), "frio"));
		this.pictogramList.add(new Pictogram(new Integer(39), "fruta"));
		this.pictogramList.add(new Pictogram(new Integer(40), "macarrao"));
		this.pictogramList.add(new Pictogram(new Integer(41), "observar"));
		this.pictogramList.add(new Pictogram(new Integer(42), "porta"));
		this.pictogramList.add(new Pictogram(new Integer(43), "quente"));
		this.pictogramList.add(new Pictogram(new Integer(44), "quero"));
		this.pictogramList.add(new Pictogram(new Integer(45), "repousar"));
		this.pictogramList.add(new Pictogram(new Integer(46), "sentar"));
		this.pictogramList.add(new Pictogram(new Integer(47), "triste"));
		this.pictogramList.add(new Pictogram(new Integer(48), "voce"));

	}

	public void generateTermList() {
		this.termList.clear();

		this.termList.add(new Term(new Integer(1), "Abril", Category.NOUN));
		this.termList
				.add(new Term(new Integer(2), "abecedário", Category.NOUN));
		this.termList.add(new Term(new Integer(3), "abelha", Category.NOUN));
		this.termList
				.add(new Term(new Integer(4), "aberto", Category.ADJECTIVE));
		this.termList.add(new Term(new Integer(5), "abóbora", Category.NOUN));
		this.termList.add(new Term(new Integer(6), "abobrinha", Category.NOUN));
		this.termList.add(new Term(new Integer(7), "aborrecer", Category.VERB));
		this.termList.add(new Term(new Integer(8), "abotoar", Category.VERB));
		this.termList.add(new Term(new Integer(9), "abraçar", Category.VERB));
		this.termList.add(new Term(new Integer(10), "absorver", Category.VERB));
		this.termList.add(new Term(new Integer(11), "acampar", Category.VERB));
		this.termList.add(new Term(new Integer(12), "acessível",
				Category.ADJECTIVE));
		this.termList.add(new Term(new Integer(13), "acesso", Category.NOUN));
		this.termList
				.add(new Term(new Integer(14), "ácido", Category.ADJECTIVE));
		this.termList.add(new Term(new Integer(15), "açougue", Category.NOUN));
		this.termList.add(new Term(new Integer(16), "adesivo", Category.NOUN));
		this.termList.add(new Term(new Integer(17), "adeus", Category.NOUN));
		this.termList.add(new Term(new Integer(18), "adulto", Category.NOUN));
		this.termList.add(new Term(new Integer(19), "advertência",
				Category.NOUN));
		this.termList.add(new Term(new Integer(20), "advertir", Category.VERB));
		this.termList.add(new Term(new Integer(21), "avião", Category.NOUN));
		this.termList.add(new Term(new Integer(22), "afiar", Category.VERB));

		this.termList.add(new Term(new Integer(23), "andar", Category.VERB));
		this.termList.add(new Term(new Integer(24), "beber", Category.VERB));
		this.termList.add(new Term(new Integer(25), "brincar", Category.VERB));
		this.termList.add(new Term(new Integer(26), "cachorro", Category.NOUN));
		this.termList.add(new Term(new Integer(27), "cadeira", Category.NOUN));
		this.termList.add(new Term(new Integer(28), "carne", Category.NOUN));
		this.termList.add(new Term(new Integer(29), "cavalo", Category.NOUN));
		this.termList.add(new Term(new Integer(30), "laptop", Category.NOUN));
		this.termList.add(new Term(new Integer(31), "correr", Category.VERB));
		this.termList.add(new Term(new Integer(32), "dormir", Category.VERB));
		this.termList.add(new Term(new Integer(33), "ela", Category.PRONOUN));
		this.termList.add(new Term(new Integer(33), "eles", Category.PRONOUN));
		this.termList.add(new Term(new Integer(34), "entrar", Category.VERB));
		this.termList.add(new Term(new Integer(35), "eu", Category.PRONOUN));
		this.termList
				.add(new Term(new Integer(36), "feliz", Category.ADJECTIVE));
		this.termList.add(new Term(new Integer(37), "frango", Category.NOUN));
		this.termList
				.add(new Term(new Integer(38), "frio", Category.ADJECTIVE));
		this.termList.add(new Term(new Integer(39), "fruta", Category.NOUN));
		this.termList.add(new Term(new Integer(40), "macarrão", Category.NOUN));
		this.termList.add(new Term(new Integer(41), "observar", Category.VERB));
		this.termList.add(new Term(new Integer(42), "porta", Category.NOUN));
		this.termList.add(new Term(new Integer(43), "quente",
				Category.ADJECTIVE));
		this.termList.add(new Term(new Integer(44), "quero", Category.VERB));
		this.termList.add(new Term(new Integer(45), "repousar", Category.VERB));
		this.termList.add(new Term(new Integer(46), "sentar", Category.VERB));
		this.termList.add(new Term(new Integer(47), "triste",
				Category.ADJECTIVE));
		this.termList.add(new Term(new Integer(48), "você", Category.PRONOUN));

	}

	public void generateSymbolList() {
		this.symbolList.clear();

		for (int i = 0; i < this.pictogramList.size(); i++) {
			this.symbolList.add(new Symbol(new Integer(i + 1), this.termList
					.get(i), this.pictogramList.get(i)));
		}
	}

	public List<Pictogram> getPictogramList() {
		return pictogramList;
	}

	public void setPictogramList(List<Pictogram> pictogramList) {
		this.pictogramList = pictogramList;
	}

	public List<Term> getTermList() {
		return termList;
	}

	public void setTermList(List<Term> termList) {
		this.termList = termList;
	}

	public List<Symbol> getSymbolList() {
		return symbolList;
	}

	public void setSymbolList(List<Symbol> symbolList) {
		this.symbolList = symbolList;
	}

	public List<Symbol> getCategoryList(Category c) {
		List<Symbol> list = new ArrayList<Symbol>();
		for (int i = 0; i < this.symbolList.size(); i++) {
			if (this.symbolList.get(i).getTerm().getCategory().compareTo(c) == 0)
				list.add(this.symbolList.get(i));
		}
		return list;
	}

}
