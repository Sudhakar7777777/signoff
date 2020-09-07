package com.sbk.signoff.coreapp.jpa.provider;

import com.sbk.signoff.coreapp.api.model.User;
import com.sbk.signoff.coreapp.jpa.entity.UserEntity;
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
	public User createNewUser(User user) throws Exception {
		LOGGER.info("Creating new user : " + user);
		UserEntity userEntity = userDataMapper.mapModelToEntity(user);
		LOGGER.info("New data : " + userEntity);
		UserEntity entity = userRepository.save(userEntity);
		if(entity.getId() < 1) {
			LOGGER.error("User record creation failed, User:" + entity);
			throw new RuntimeException("User creation failed for user id:" + user.getId());
		}
		return userDataMapper.mapEntityToModel(entity);
	}

	@Override
	public User updateExistingUser(Long id, User user) throws Exception {
		LOGGER.info("Updating existing user : " + id);
		Optional<UserEntity> entity = userRepository.findById(id);
		if(entity.isEmpty()) {
			LOGGER.error("User record does not exist, UserID:" + id);
			throw new RuntimeException("User update failed.  ID does not pre-exist:" + id);
		}

		LOGGER.info("Existing record:" + entity.get());
		LOGGER.info("New incoming data:" + user);
		UserEntity entity1 = userDataMapper.mapUpdateEntity(entity.get(), user);
		LOGGER.info("Modified data:" + entity1);
		UserEntity entity2 = userRepository.save(entity1);
		LOGGER.info("Updated record:" + entity2);
		if(entity2.getId() < 1) {
			LOGGER.error("User update failed, User:" + entity2);
			throw new RuntimeException("User update failed for user id:" + user.getId());
		}
		return userDataMapper.mapEntityToModel(entity2);
	}

	@Override
	public User updatePassword(Long id, String password) throws Exception {
		LOGGER.info("Updating existing user : " + id);
		Optional<UserEntity> entity = userRepository.findById(id);
		if(entity.isEmpty()) {
			LOGGER.error("User record does not exist, UserID:" + id);
			throw new RuntimeException("User update failed.  ID does not pre-exist:" + id);
		}

		UserEntity currentEntity = entity.get();
		if(currentEntity.getPassword().equals(password)) {
			LOGGER.error("User password same is old password, OldPass:" + currentEntity.getPassword() + "NewPass:" + password);
			throw new RuntimeException("User password same is old password.");
		}

		currentEntity.setPassword(password);
		UserEntity newEntity = userRepository.save(currentEntity);
		LOGGER.info("Updated record:" + newEntity);
		if(newEntity.getId() < 1) {
			LOGGER.error("User update failed, User:" + newEntity);
			throw new RuntimeException("User update failed for user id:" + id);
		}
		return userDataMapper.mapEntityToModel(newEntity);
	}

	@Override
	public Boolean deleteUser(Long id) throws Exception {
		LOGGER.info("Delete user by ID:" + id);
		userRepository.deleteById(id);

		boolean foundId = userRepository.existsById(id);
		return !foundId;
	}
}
