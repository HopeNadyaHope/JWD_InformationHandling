package by.epam.lab02.main;

import java.util.Set;

import by.epam.lab02.bean.Text;
import by.epam.lab02.bean.Word;
import by.epam.lab02.service.ServiceFactory;
import by.epam.lab02.service.TextCreatorService;
import by.epam.lab02.service.TextWorkerService;
import by.epam.lab02.service.exception.ServiceException;
import by.epam.lab02.view.Printer;

public class Main {

	public static void main(String[] args) {
		Text text;
		
		ServiceFactory factory = ServiceFactory.getInstance();
		TextCreatorService textCreatorService = factory.getTextCreatorService();
		TextWorkerService textWorkerService = factory.getTextWorkerService();
		
		Printer printer = Printer.getInstance();
		
		try {
			text = textCreatorService.create();
			System.out.println("/////////// ALL TEXT /////////////////");
			printer.print(text);
			
			/////3 task
			System.out.println("\n/////////// FIND ORIGINAL WORD /////////////////");
			Word word = textWorkerService.findOriginalWordFromFirstSentence(text);
			printer.print(word);
			
			/////4 task
			System.out.println("\n/////////// WORDS FROM QUSTIONS LENTH 2 /////////////////");
			Set<Word> words = textWorkerService.getWordsFromQuestions(text, 2);
			printer.print(words);

			/////5 task
			System.out.println("\n///////////CHANGE FIRST AND LAST/////////////////");
			textWorkerService.changeFirstAndLastWords(text);////////////////////////////5
			printer.print(text);
			
		} catch (ServiceException e) {
			System.out.println(e);
		}
	}
}