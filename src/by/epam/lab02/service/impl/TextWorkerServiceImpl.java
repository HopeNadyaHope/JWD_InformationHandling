package by.epam.lab02.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import by.epam.lab02.bean.Sentence;
import by.epam.lab02.bean.SentenceElement;
import by.epam.lab02.bean.Text;
import by.epam.lab02.bean.TextElement;
import by.epam.lab02.bean.Word;
import by.epam.lab02.service.TextWorkerService;
import by.epam.lab02.service.exception.ServiceException;
import by.epam.lab02.service.validator.Validator;

public class TextWorkerServiceImpl implements TextWorkerService{

	@Override
	public void changeFirstAndLastWords(Text text) throws ServiceException{
		if(!Validator.validateText(text)) {
			throw new ServiceException("Text is uncorrect");
		}
		String firstWord;
		String lastWord;
		int firstInd;
		int lastInd;
		
		for(TextElement textElement: text.getElements()) {
			if(textElement.getClass() ==  Sentence.class) {
				Sentence sentence = ((Sentence)textElement);				
				List<SentenceElement> sentenceElements = sentence.getElements();
				
				firstInd = 0;				
				while((sentenceElements.get(firstInd).getClass() != Word.class)
						&&(firstInd <= sentenceElements.size() - 1)){
					firstInd++;
				}		
				
				lastInd = sentenceElements.size() - 1;
				while((sentenceElements.get(lastInd).getClass() != Word.class)
						&&(lastInd >=0)){
					lastInd--;
				}
				
				if(firstInd == lastInd) {
					continue;
				}
				
				firstWord = ((Word)sentenceElements.get(firstInd)).getWord();
				lastWord = ((Word)sentenceElements.get(lastInd)).getWord();
				((Word)sentenceElements.get(firstInd)).setWord(lastWord);
				((Word)sentenceElements.get(lastInd)).setWord(firstWord);
			}
		}
	}

	@Override
	public Set<Word> getWordsFromQuestions(Text text, int length) throws ServiceException {
		if(!Validator.validateTextAndWordLength(text, length)) {
			throw new ServiceException("Uncorrect command");
		}
		Set<Word> words = new LinkedHashSet<Word>();
		List<Word> wordsFromSentence;
		for(TextElement textElement: text.getElements()) {
			if(textElement.getClass() == Sentence.class) {
				Sentence sentence = ((Sentence)textElement);				
				if(sentence.getSign().contains("?")) {
					wordsFromSentence = getWordsFromSentence(sentence);
					for(Word wordFromSentence : wordsFromSentence) {
						if(wordFromSentence.getInfo().length() == length) {
							words.add(wordFromSentence);
						}
					}
				}
			}
		}
		if(words.isEmpty()) {
			words.add(new Word("Nothing"));
		}
		return words;
	}

	@Override
	public Word findOriginalWordFromFirstSentence(Text text) throws ServiceException {
		if(!Validator.validateText(text)) {
			throw new ServiceException("Text is uncorrect");
		}
		Word word;
		List<TextElement> textElements = text.getElements();
		
		int firstSentenceInd;
		firstSentenceInd = 0;
		for(TextElement textElement: text.getElements()) {
			if(textElement.getClass() ==  Sentence.class) {
				break;
			}
			firstSentenceInd++;
		}
		
		if(firstSentenceInd == textElements.size()) {
			word = new Word("no_Sentences");
			return word;
		}		
		
		Set <Word> allWordsFromOtherSentences = new HashSet<Word>();
		List<Word> wordsFromSentence;
		Sentence sentence;
		for(int sentenceInd = (firstSentenceInd + 1); sentenceInd < textElements.size(); sentenceInd++) {
			if(textElements.get(sentenceInd).getClass() == Sentence.class) {
				sentence = (Sentence)(textElements.get(sentenceInd));
				wordsFromSentence = getWordsFromSentence(sentence);
				for(Word wordFromSentence : wordsFromSentence) {
					allWordsFromOtherSentences.add(wordFromSentence);
				}
			}
		}
		
		Sentence firstSentence;
		firstSentence = (Sentence)(textElements.get(firstSentenceInd));
		for(Word wordFromFirstSenence : getWordsFromSentence(firstSentence)){
			if(! (allWordsFromOtherSentences.contains(wordFromFirstSenence))) {
				return wordFromFirstSenence;
			}
		}
		
		word = new Word("Nothing");
		return word;
	}
	
	private List<Word> getWordsFromSentence(Sentence sentence){
		List<Word> words = new ArrayList<Word>();
		for(SentenceElement sentenceElement : sentence.getElements()) {
			if((sentenceElement.getClass() == Word.class)) {
				Word word = (Word)sentenceElement;
				words.add(word);
			}
		}
		return words;		
	}
}
