package com.sbk.signoff.coreapp.jpa.provider;

import com.sbk.signoff.coreapp.api.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserDataProviderImpl implements UserDataProvider {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserDataProvider.class);

	private UserDataProvider userDataProvider;
	private UserDataMapper userDataMapper;

	@Autowired
	public void setUserDataProvider(UserDataProvider userDataProvider) {
		this.userDataProvider = userDataProvider;
	}

	@Autowired
	public void setUserDataMapper(UserDataMapper userDataMapper) {
		this.userDataMapper = userDataMapper;
	}

	@Override
	public Boolean createUser(User user) {
		return null;
	}

	@Override
	public List<User> getUsers() {
		return null;
	}

	@Override
	public User getUser(Long id) {
		return null;
	}
}
