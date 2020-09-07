package com.sbk.signoff.coreapp.jpa.provider;

import com.sbk.signoff.coreapp.api.model.User;
import com.sbk.signoff.coreapp.jpa.entity.UserEntity;
import io.micrometer.core.instrument.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static com.sbk.signoff.coreapp.common.Constant.SYSTEM_USER;
import static org.apache.logging.log4j.ThreadContext.isEmpty;

@Component
public class UserDataMapper {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserDataMapper.class);

	public UserEntity mapModelToEntity(User user) {
		UserEntity entity = new UserEntity(
				user.getId(),
				user.getUserName(),
				user.getFirstName(),
				user.getLastName(),
				user.getEmail(),
				user.getPhone()
				);
//		entity.setCreated(new Date());
//		entity.setUpdated(new Date());
//		entity.setCreatedBy(SYSTEM_USER);	//ideally get the data from client
//		entity.setUpdatedBy(SYSTEM_USER);	//ideally get the data from client
		return entity;
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

	public UserEntity mapUpdateEntity(UserEntity entity, User user) {
		if (StringUtils.isNotEmpty(user.getUserName())) entity.setUserName(user.getUserName());
		if (StringUtils.isNotEmpty(user.getFirstName())) entity.setFirstName(user.getFirstName());
		if (StringUtils.isNotEmpty(user.getLastName())) entity.setLastName(user.getLastName());
		if (StringUtils.isNotEmpty(user.getEmail())) entity.setEmail(user.getEmail());
		if (StringUtils.isNotEmpty(user.getPhone())) entity.setPhone(user.getPhone());
		return entity;
	}
}
