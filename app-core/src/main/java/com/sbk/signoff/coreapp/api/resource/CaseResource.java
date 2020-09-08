package com.sbk.signoff.coreapp.api.resource;

import com.sbk.signoff.coreapp.api.model.Case;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@RequestMapping(
		value = "/cases",
		consumes = "application/json; charset=UTF-8",
		produces = "application/json; charset=UTF-8")
public interface CaseResource {

	@GetMapping("/{id}")
	Case readCase(@PathVariable Long id) throws Exception;

	@GetMapping("/")
	List<Case> readCases() throws Exception;

	@PostMapping("/")
	Case addCase(@Valid @RequestBody Case aCase) throws Exception;

	@DeleteMapping("/{id}")
	Boolean deleteCase(@PathVariable Long id) throws Exception;

}
