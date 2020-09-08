package com.sbk.signoff.coreapp.api.service;

import com.sbk.signoff.coreapp.api.model.Case;
import com.sbk.signoff.coreapp.jpa.provider.CaseDataProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CaseServiceImpl implements CaseService {
	private static final Logger logger = LoggerFactory.getLogger(CaseServiceImpl.class);
	private CaseDataProvider caseDataProvider;

	@Autowired
	public void setCaseDataProvider(CaseDataProvider caseDataProvider) {
		this.caseDataProvider = caseDataProvider;
	}

	@Override
	public Case readCase(Long id) throws Exception {
		return caseDataProvider.readCase(id);
	}

	@Override
	public List<Case> readCases() throws Exception {
		return caseDataProvider.readCases();
	}

	@Override
	public Case addCase(Case aCase) throws Exception {
		return caseDataProvider.addCase(aCase);
	}

	@Override
	public Boolean deleteCase(Long id) throws Exception {
		return caseDataProvider.deleteCase(id);
	}

}
