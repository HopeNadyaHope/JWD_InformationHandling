package by.epam.lab02.service;

import by.epam.lab02.bean.Text;
import by.epam.lab02.service.exception.ServiceException;

public interface TextCreatorService {	
	
	Text create() throws ServiceException;	
}