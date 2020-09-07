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
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RequestMapping(
		consumes = "{\"application/json\"}",
		produces = "{\"application/json\"}")
public interface UserResource {

	@GetMapping("/users/{id}")
	User readUser(@PathVariable Long id) throws Exception;

	@GetMapping("/users")
	List<User> readUsers() throws Exception;

	@PostMapping("/users")
	@ResponseStatus(HttpStatus.CREATED)
	User addUser(@RequestParam("user") @Valid @RequestBody User user) throws Exception;

	@PutMapping("/users")
	User updateUser(@Valid @RequestBody User user) throws Exception;

	@DeleteMapping("/users/{id}")
	Boolean deleteUser(@PathVariable Long id) throws Exception;

}
