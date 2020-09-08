package com.sbk.signoff.coreapp.api.gateway;

import com.sbk.signoff.coreapp.api.model.Case;
import com.sbk.signoff.coreapp.api.service.CaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CaseGatewayImpl implements CaseGateway {
	private static final Logger logger = LoggerFactory.getLogger(CaseGatewayImpl.class);
	private CaseService caseService;

	@Autowired
	public void setUserGateway(CaseService caseService) {
		this.caseService = caseService;
	}

	@Override
	public Case readCase(Long id) throws Exception {
		return caseService.readCase(id);
	}

	@Override
	public List<Case> readCases() throws Exception {
		return caseService.readCases();
	}

	@Override
	public Case addCase(Case aCase) throws Exception {
		return caseService.addCase(aCase);
	}

	@Override
	public Boolean deleteCase(Long id) throws Exception {
		return caseService.deleteCase(id);
	}

}
