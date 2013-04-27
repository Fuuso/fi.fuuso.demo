package fi.fuuso.demo.services.impl;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import fi.fuuso.demo.dao.impl.HibernateUserInputDAO;
import fi.fuuso.demo.models.beans.InputData;
import fi.fuuso.demo.services.UserInputService;
import fi.fuuso.demo.utils.HibernateUtil;

public class UserInputServiceImpl implements UserInputService, InitializingBean {

	private HibernateUserInputDAO userInputDAO;
	
	public HibernateUserInputDAO getUserInputDAO() {
		return userInputDAO;
	}

	@Autowired
	public void setUserInputDAO(HibernateUserInputDAO userInputDAO) {
		this.userInputDAO = userInputDAO;
	}

	public void storeUserInput(InputData userInput) {
        try {
            HibernateUtil.beginTransaction();
            getUserInputDAO().store(userInput);
            HibernateUtil.commitTransaction();
        } catch (HibernateException e) {
            e.printStackTrace();
            HibernateUtil.rollbackTransaction();
        }
	}

	public void afterPropertiesSet() throws Exception {
		Assert.notNull(userInputDAO, "userInputDAO must not be null");
	}

}
