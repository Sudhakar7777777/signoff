package com.sbk.signoff.coreapp.jpa.provider;

import com.sbk.signoff.coreapp.api.model.User;
import com.sbk.signoff.coreapp.jpa.model.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class UserDataMapper {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserDataMapper.class);

	public UserEntity mapModelToEntity(User user) {
		UserEntity userEntity = new UserEntity();
		userEntity.setFirstName("hi");
		return userEntity;
	}
}
