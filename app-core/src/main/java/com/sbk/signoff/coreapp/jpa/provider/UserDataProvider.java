package com.sbk.signoff.coreapp.jpa.provider;

import com.sbk.signoff.coreapp.api.model.User;

import javax.transaction.Transactional;
import java.util.List;

public interface UserDataProvider {

	User readUser(Long id) throws Exception;

	List<User> readUsers() throws Exception;

//	@Transactional
	User createUser(User user) throws Exception;

//	@Transactional
	User updateUser(User user) throws Exception;

//	@Transactional
	Boolean deleteUser(Long id) throws Exception;

}
