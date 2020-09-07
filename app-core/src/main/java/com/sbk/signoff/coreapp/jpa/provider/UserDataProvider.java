package com.sbk.signoff.coreapp.jpa.provider;

import com.sbk.signoff.coreapp.api.model.User;

import javax.transaction.Transactional;
import java.util.List;

public interface UserDataProvider {

	User readUser(Long id) throws Exception;

	List<User> readUsers() throws Exception;

//	@Transactional
	User createNewUser(User user) throws Exception;

//	@Transactional
	User updateExistingUser(Long id, User user) throws Exception;

	User updatePassword(Long id, String password) throws Exception;

//	@Transactional
	Boolean deleteUser(Long id) throws Exception;

}
