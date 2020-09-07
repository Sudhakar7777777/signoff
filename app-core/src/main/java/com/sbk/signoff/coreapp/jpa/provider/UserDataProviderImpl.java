package com.sbk.signoff.coreapp.jpa.provider;

import com.sbk.signoff.coreapp.api.model.User;
import com.sbk.signoff.coreapp.jpa.model.UserEntity;
import com.sbk.signoff.coreapp.jpa.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserDataProviderImpl implements UserDataProvider {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserDataProvider.class);

	private UserRepository userRepository;
	private UserDataMapper userDataMapper;

	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Autowired
	public void setUserDataMapper(UserDataMapper userDataMapper) {
		this.userDataMapper = userDataMapper;
	}

	@Override
	public User readUser(Long id) throws Exception {
		LOGGER.info("Select user by id :" + id);
		Optional<UserEntity> entity = userRepository.findById(id);
		if(entity.isEmpty()) {
			throw new RuntimeException("User record not found in database.");
		}
		return userDataMapper.mapEntityToModel(entity.get());
	}

	@Override
	public List<User> readUsers() throws Exception {
		LOGGER.info("Select all users...");
		return userDataMapper.mapEntityToModel(userRepository.findAll());
	}

	@Override
	public User createUser(User user) throws Exception {
		LOGGER.info("Creating new user : " + user);
		UserEntity entity = userRepository.save(userDataMapper.mapModelToEntity(user));
		if(entity.getId() < 1) {
			LOGGER.error("User record creation failed, User:" + entity);
			throw new RuntimeException("User creation failed for user id:" + user.getId());
		}
		return userDataMapper.mapEntityToModel(entity);
	}

	@Override
	public User updateUser(User user) throws Exception {
		LOGGER.info("Updating existing user : " + user);
		boolean foundId = userRepository.existsById(user.getId());
		if(!foundId) {
			LOGGER.error("User record does not exist, UserID:" + user.getId());
			throw new RuntimeException("User update failed.  ID does not pre-exist:" + user.getId());
		}

		UserEntity entity = userRepository.save(userDataMapper.mapModelToEntity(user));
		if(entity.getId() < 1) {
			LOGGER.error("User update failed, User:" + entity);
			throw new RuntimeException("User update failed for user id:" + user.getId());
		}
		return userDataMapper.mapEntityToModel(entity);
	}

	@Override
	public Boolean deleteUser(Long id) throws Exception {
		LOGGER.info("Delete user by ID:" + id);
		userRepository.deleteById(id);

		boolean foundId = userRepository.existsById(id);
		return !foundId;
	}
}
