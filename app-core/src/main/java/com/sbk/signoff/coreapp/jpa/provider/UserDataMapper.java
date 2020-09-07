package com.sbk.signoff.coreapp.jpa.provider;

import com.sbk.signoff.coreapp.api.model.User;
import com.sbk.signoff.coreapp.jpa.entity.UserEntity;
import io.micrometer.core.instrument.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserDataMapper {
	private static final Logger logger = LoggerFactory.getLogger(UserDataMapper.class);

	public UserEntity mapModelToEntity(User user) {
		UserEntity entity = new UserEntity(
				user.getId(),
				user.getUserName(),
				user.getPassword(),
				user.getUserType(),
				user.getUserRole(),
				user.getFirstName(),
				user.getLastName(),
				user.getEmail(),
				user.getPhone(),
				user.getAddress(),
				user.getState(),
				user.getCountry(),
				user.getZip(),
				user.getLastLogin()
				);
//		entity.setCreated(new Date());
//		entity.setUpdated(new Date());
//		entity.setCreatedBy(SYSTEM_USER);	//ideally get the data from client
//		entity.setUpdatedBy(SYSTEM_USER);	//ideally get the data from client
		logger.debug("mapModelToEntity:" + entity);
		return entity;
	}

	public List<UserEntity> mapModelToEntity(List<User> users) {
		List<UserEntity> entities = users.stream()
										.map(this::mapModelToEntity)
										.collect(Collectors.toList());
		logger.debug("mapModelToEntity:" + entities);
		return entities;
	}

	public User mapEntityToModel(UserEntity entity) {
		User user = new User(
				entity.getId(),
				entity.getUserName(),
				entity.getPassword(),
				entity.getUserType(),
				entity.getUserRole(),
				entity.getFirstName(),
				entity.getLastName(),
				entity.getEmail(),
				entity.getPhone(),
				entity.getAddress(),
				entity.getState(),
				entity.getCountry(),
				entity.getZip(),
				entity.getLastLogin()
				);
		logger.debug("mapEntityToModel:" + user);
		return user;
	}

	public List<User> mapEntityToModel(List<UserEntity> entities) {
		List<User> users = entities.stream()
								.map(this::mapEntityToModel)
								.collect(Collectors.toList());
		logger.debug("mapEntityToModel:" + users);
		return users;
	}

	public UserEntity mapUpdateEntity(UserEntity entity, User user) {
		if (StringUtils.isNotEmpty(user.getUserName())) entity.setUserName(user.getUserName());
		if (StringUtils.isNotEmpty(user.getPassword())) entity.setPassword(user.getPassword());
		if (StringUtils.isNotEmpty(user.getUserType())) entity.setUserType(user.getUserType());
		if (StringUtils.isNotEmpty(user.getUserRole())) entity.setUserRole(user.getUserRole());
		if (StringUtils.isNotEmpty(user.getFirstName())) entity.setFirstName(user.getFirstName());
		if (StringUtils.isNotEmpty(user.getLastName())) entity.setLastName(user.getLastName());
		if (StringUtils.isNotEmpty(user.getEmail())) entity.setEmail(user.getEmail());
		if (StringUtils.isNotEmpty(user.getPhone())) entity.setPhone(user.getPhone());
		if (StringUtils.isNotEmpty(user.getAddress())) entity.setAddress(user.getAddress());
		if (StringUtils.isNotEmpty(user.getState())) entity.setState(user.getState());
		if (StringUtils.isNotEmpty(user.getCountry())) entity.setCountry(user.getCountry());
		if (null != user.getLastLogin()) entity.setLastLogin(user.getLastLogin());
		logger.debug("mapUpdateEntity:" + entity);
		return entity;
	}
}
