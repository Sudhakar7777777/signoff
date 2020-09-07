package com.sbk.signoff.coreapp.jpa.provider;

import com.sbk.signoff.coreapp.api.model.User;
import com.sbk.signoff.coreapp.jpa.entity.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserDataMapper {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserDataMapper.class);

	public UserEntity mapModelToEntity(User user) {
		return new UserEntity(
				user.getId(),
				user.getUserName(),
				user.getFirstName(),
				user.getLastName(),
				user.getEmail(),
				user.getPhone()
				);
	}

	public List<UserEntity> mapModelToEntity(List<User> users) {
		return users.stream().map(u -> mapModelToEntity(u)).collect(Collectors.toList());
	}

	public User mapEntityToModel(UserEntity entity) {
		return new User(
				entity.getId(),
				entity.getUserName(),
				entity.getFirstName(),
				entity.getLastName(),
				entity.getEmail(),
				entity.getPhone()
				);
	}

	public List<User> mapEntityToModel(List<UserEntity> entities) {
		return entities.stream().map(e -> mapEntityToModel(e)).collect(Collectors.toList());
	}
}
