package by.epam.lab02.view;

import java.util.Iterator;
import java.util.Set;

import by.epam.lab02.bean.TextElement;

public class Printer {
	private static final Printer instance = new Printer();	
	
	public Printer() {}
	
	public static Printer getInstance() {
		return instance;
	}	
	
	public void print(TextElement text) {
		System.out.print(text.getInfo());
	}
	
	public void print(Set<? extends TextElement> elements) {
		Iterator<? extends TextElement> iterator = elements.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next().getInfo());
		}
	}
}
