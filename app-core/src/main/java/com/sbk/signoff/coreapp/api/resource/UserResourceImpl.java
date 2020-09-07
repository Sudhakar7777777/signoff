package com.sbk.signoff.coreapp.api.resource;

import com.sbk.signoff.coreapp.api.gateway.UserGateway;
import com.sbk.signoff.coreapp.api.model.User;
import com.sbk.signoff.coreapp.api.model.UserRole;
import com.sbk.signoff.coreapp.api.model.UserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserResourceImpl implements UserResource {
	private static final Logger logger = LoggerFactory.getLogger(UserResourceImpl.class);

	@Autowired
	private UserGateway userGateway;

	@Override
	public User readUser(Long id) throws Exception {
		validateId(id);
		return userGateway.readUser(id);
	}

	@Override
	public List<User> readUsers() throws Exception {
		logger.info("Testing GET ALL users");
		System.out.println("Testing GET all users");
		return userGateway.readUsers();
	}

	@Override
	public User addUser(User user) throws Exception {
		logger.info("Adding new user:" + user);
		validateUser(user);
		return userGateway.addUser(user);
	}

	@Override
	public User updateUser(Long id, User user) throws Exception {
		validateUser(user);
		return userGateway.updateUser(id, user);
	}

	@Override
	public User updatePassword(Long id, String password) throws Exception {
		validateId(id);
		if(StringUtils.isEmpty(password)) {
			throw new Exception("Password is empty.  Retry again.");
		}
		return userGateway.updatePassword(id, password);
	}

	@Override
	public Boolean deleteUser(Long id) throws Exception {
		validateId(id);
		return userGateway.deleteUser(id);
	}

	private void validateId(Long id) throws Exception {
		if(id < 1) {
			throw new Exception("Invalid id.  User lookup ignored.");
		}
	}

	private void validateUser(User user) throws Exception {
		if(user == null) {
			throw new Exception("Empty User object.  Retry the action.");
		}
		try {
			UserType type = UserType.fromValue(user.getUserType());
			logger.info("Valid userType value found.  userType:" + type.getValue());
		} catch(Exception e) {
			throw new Exception("Invalid input param User.userType.");
		}
		try {
			UserRole role = UserRole.fromValue(user.getUserRole());
			logger.info("Valid userRole value found.  userRole:" + role.getValue());
		} catch(Exception e) {
			throw new Exception("Invalid input param User.userRole.");
		}
	}

	//Method handles error messaging for the @Valid User argument.
//	@ResponseStatus(HttpStatus.BAD_REQUEST)
//	@ExceptionHandler(MethodArgumentNotValidException.class)
//	public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
//		Map<String, String> errors = new HashMap<>();
//		ex.getBindingResult().getAllErrors().forEach((error) -> {
//			String fieldName = ((FieldError) error).getField();
//			String errorMessage = error.getDefaultMessage();
//			errors.put(fieldName, errorMessage);
//		});
//		return errors;
//	}
}
