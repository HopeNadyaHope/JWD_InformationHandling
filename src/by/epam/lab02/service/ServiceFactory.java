package by.epam.lab02.service;

import by.epam.lab02.service.impl.TextCreatorServiceImpl;
import by.epam.lab02.service.impl.TextWorkerServiceImpl;

public class ServiceFactory {
	private static final ServiceFactory instance = new ServiceFactory();
	
	private final TextCreatorService textCreatorService = new TextCreatorServiceImpl();
	private final TextWorkerService textWorkerService = new TextWorkerServiceImpl();
	
	private ServiceFactory() {}

	public static ServiceFactory getInstance() {
		return instance;
	}

	public TextCreatorService getTextCreatorService() {
		return textCreatorService;
	}

	public TextWorkerService getTextWorkerService() {
		return textWorkerService;
	}
}
