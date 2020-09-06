package com.sbk.signoff.coreapp.jpa.provider;

import com.sbk.signoff.coreapp.api.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public interface UserDataProvider {

	@Transactional
	Boolean createUser(User user);

	List<User> getUsers();

	User getUser(Long id);

}
