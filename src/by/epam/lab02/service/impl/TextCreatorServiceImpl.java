package by.epam.lab02.service.impl;

import by.epam.lab02.bean.Text;
import by.epam.lab02.dao.DAOFactory;
import by.epam.lab02.dao.TextDAO;
import by.epam.lab02.dao.exception.DAOException;
import by.epam.lab02.service.TextCreatorService;
import by.epam.lab02.service.exception.ServiceException;

public class TextCreatorServiceImpl implements TextCreatorService{

	public Text create() throws ServiceException {
		DAOFactory factory;
		TextDAO textDAO;
		Text text;
		
		try {
			factory = DAOFactory.getInstance();
			textDAO = factory.getTextDAO();
			text = textDAO.createText();
		}catch (DAOException e) {
			throw new ServiceException(e);		
		}
		return text;
	}
}