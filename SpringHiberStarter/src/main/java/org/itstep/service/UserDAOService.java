package org.itstep.service;

import org.itstep.dao.UserDAO;
import org.itstep.dao.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDAOService{

	@Autowired
	UserDAO userDAO;
	
	public User getUser(String email, String password){
		return userDAO.findOneByEmailAndPassword(email, password);
	}
	
	public User createAndUpdateUser(User user){
		return userDAO.save(user);
	}
	
	public void deleteUser(long userId){
		userDAO.delete(userId);
	}

	public User findOne(Long userId) {
		User user = userDAO.findOne(userId);
		return user;
	}
	
}
