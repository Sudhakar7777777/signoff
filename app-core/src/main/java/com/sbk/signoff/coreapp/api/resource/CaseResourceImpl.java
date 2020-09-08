package com.sbk.signoff.coreapp.api.resource;

import com.sbk.signoff.coreapp.api.gateway.CaseGateway;
import com.sbk.signoff.coreapp.api.model.Case;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CaseResourceImpl implements CaseResource {
	private static final Logger logger = LoggerFactory.getLogger(CaseResourceImpl.class);
	private CaseGateway caseGateway;

	@Autowired
	public void setUserGateway(CaseGateway caseGateway) {
		this.caseGateway = caseGateway;
	}

	@Override
	public Case readCase(Long id) throws Exception {
		validateId(id);
		return caseGateway.readCase(id);
	}

	@Override
	public List<Case> readCases() throws Exception {
		return caseGateway.readCases();
	}

	@Override
	public Case addCase(Case aCase) throws Exception {
		validateCase(aCase);
		return caseGateway.addCase(aCase);
	}

	@Override
	public Boolean deleteCase(Long id) throws Exception {
		validateId(id);
		return caseGateway.deleteCase(id);
	}

	private void validateId(Long id) throws Exception {
		if(id < 1) {
			throw new Exception("Invalid id.  Case lookup ignored.");
		}
	}

	private void validateCase(Case aCase) throws Exception {
		if(aCase == null) {
			throw new Exception("Empty Case object.  Retry the action.");
		}
	}

}
