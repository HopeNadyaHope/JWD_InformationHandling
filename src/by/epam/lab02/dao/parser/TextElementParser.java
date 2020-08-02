package by.epam.lab02.dao.parser;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.epam.lab02.bean.Code;
import by.epam.lab02.bean.Sentence;
import by.epam.lab02.bean.Text;
import by.epam.lab02.dao.ParserDAO;
import by.epam.lab02.dao.exception.DAOException;

public class TextElementParser {

	private final String TEXT_ELEMENT_REGEX;
	private final Pattern TEXT_ELEMENT_PATTERN;

	public TextElementParser(){
		this.TEXT_ELEMENT_REGEX = "(?<Paragraf>[^{}]+\\n)" + "|" + "(?<Code>.*\\{\\n*(.*\\n)+?\\n*}\\n)";
		this.TEXT_ELEMENT_PATTERN = Pattern.compile(TEXT_ELEMENT_REGEX);
	}
	
	public Text getText(String allText) {
		Text text = new Text();
		Matcher matcher = TEXT_ELEMENT_PATTERN.matcher(allText);
		String code;		
		String paragraf;
	
		while(matcher.find()) {
			
			if((code = matcher.group("Code")) != null) {
				text.add(new Code(code));
			}
			if((paragraf = matcher.group("Paragraf")) != null) {
				ParserFactory parserFactory = ParserFactory.getInstance();
				SentenceParser sentenceParser = parserFactory.getSentenceParser();
				List<Sentence> readySentences = sentenceParser.getSentences(paragraf);
				for(Sentence sentence: readySentences) {
					text.add(sentence);
				}
			}
		}		
		return text;
	}
}