package com.sbk.signoff.coreapp.api.service;

import com.sbk.signoff.coreapp.api.model.User;
import com.sbk.signoff.coreapp.jpa.provider.UserDataProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServiceImpl implements UserService {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
	private UserDataProvider userDataProvider;

	@Autowired
	public void setUserDataProvider(UserDataProvider userDataProvider) {
		this.userDataProvider = userDataProvider;
	}

	@Override
	public User readUser(Long id) throws Exception {
		LOGGER.info("UserServiceImpl: readUser");
		return userDataProvider.readUser(id);
	}

	@Override
	public List<User> readUsers() throws Exception {
		LOGGER.info("UserServiceImpl: readUsers");
		return userDataProvider.readUsers();
	}

	@Override
	public User addUser(User user) throws Exception {
		LOGGER.info("UserServiceImpl: addUser");
		return userDataProvider.createUser(user);
	}

	@Override
	public User updateUser(Long id, User user) throws Exception {
		LOGGER.info("UserServiceImpl: updateUser");
		return userDataProvider.updateUser(id, user);
	}

	@Override
	public Boolean deleteUser(Long id) throws Exception {
		LOGGER.info("UserServiceImpl: deleteUser");
		return userDataProvider.deleteUser(id);
	}
}
