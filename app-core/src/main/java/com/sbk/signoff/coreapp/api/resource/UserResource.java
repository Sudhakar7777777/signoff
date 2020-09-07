package com.sbk.signoff.coreapp.api.resource;

import com.sbk.signoff.coreapp.api.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.Valid;
import java.util.List;

@RequestMapping(
		value = "/users",
		consumes = "application/json",
		produces = "application/json; charset=UTF-8")
public interface UserResource {

	@GetMapping("/{id}")
	User readUser(@PathVariable Long id) throws Exception;

	@GetMapping("/")
	List<User> readUsers() throws Exception;

	@PostMapping("/")
	User addUser(@Valid @RequestBody User user) throws Exception;

	@PutMapping("/{id}")
	User updateUser(@PathVariable Long id, @Valid @RequestBody User user) throws Exception;

	@PutMapping("/{id}/password/{password}")
	User updatePassword(@PathVariable Long id, @PathVariable String password) throws Exception;

	@DeleteMapping("/{id}")
	Boolean deleteUser(@PathVariable Long id) throws Exception;

}
