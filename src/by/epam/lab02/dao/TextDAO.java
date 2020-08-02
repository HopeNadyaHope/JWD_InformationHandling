package by.epam.lab02.dao;

import by.epam.lab02.bean.Text;
import by.epam.lab02.dao.exception.DAOException;

public interface TextDAO {	

	public Text createText() throws DAOException;
}