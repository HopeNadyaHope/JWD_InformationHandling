package by.epam.lab02.service;

import java.util.Set;

import by.epam.lab02.bean.Text;
import by.epam.lab02.bean.Word;
import by.epam.lab02.service.exception.ServiceException;

public interface TextWorkerService {
	
	public void changeFirstAndLastWords(Text text) throws ServiceException;
	public Set<Word> getWordsFromQuestions(Text text, int length) throws ServiceException;
	public Word findOriginalWordFromFirstSentence(Text text) throws ServiceException;
}
