package by.epam.lab02.dao.parser;

import by.epam.lab02.dao.ParserDAO;
import by.epam.lab02.dao.exception.DAOException;

public class ParserFactory {

	private static final ParserFactory instance = new  ParserFactory();
	private TextElementParser textElementParser = new TextElementParser();
	private SentenceParser sentenceParser = new SentenceParser();
	private SentenceElementParser sentenceElementParser = new SentenceElementParser();

	private ParserFactory() {}
	
	public TextElementParser getTextElementParser() {
		return textElementParser;
	}

	public SentenceParser getSentenceParser() {
		return sentenceParser;
	}

	public SentenceElementParser getSentenceElementParser() {
		return sentenceElementParser;
	}
	
	public static ParserFactory getInstance() {
		return instance;
	}
}