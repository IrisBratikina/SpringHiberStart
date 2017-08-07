package org.itstep.service;

import org.itstep.dao.pojo.User;

public interface UserService {

	public User getUser(String email, String password);
	
	public User createAndUpdateUser(User user);
	
	public void deleteUser(long userId);
}
