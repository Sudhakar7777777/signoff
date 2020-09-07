package com.sbk.signoff.coreapp.api.gateway;

import com.sbk.signoff.coreapp.api.model.User;
import com.sbk.signoff.coreapp.api.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserGatewayImpl implements UserGateway {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserGatewayImpl.class);

	@Autowired
	private UserService userService;

	@Override
	public User readUser(Long id) throws Exception {
		return userService.readUser(id);
	}

	@Override
	public List<User> readUsers() throws Exception {
		return userService.readUsers();
	}

	@Override
	public User addUser(User user) throws Exception {
		return userService.addUser(user);
	}

	@Override
	public User updateUser(User user) throws Exception {
		return userService.updateUser(user);
	}

	@Override
	public Boolean deleteUser(Long id) throws Exception {
		return userService.deleteUser(id);
	}
}
