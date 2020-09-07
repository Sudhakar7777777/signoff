package com.sbk.signoff.coreapp.api.service;

import com.sbk.signoff.coreapp.api.model.User;

import java.util.List;

public interface UserService {

	User readUser(Long id) throws Exception;

	List<User> readUsers() throws Exception;

	User addUser(User user) throws Exception;

	User updateUser(Long id, User user) throws Exception;

	User updatePassword(Long id, String password) throws Exception;

	Boolean deleteUser(Long id) throws Exception;
}
