package com.sbk.signoff.coreapp.api.gateway;

import com.sbk.signoff.coreapp.api.model.Case;

import java.util.List;

public interface CaseGateway {

	Case readCase(Long id) throws Exception;

	List<Case> readCases() throws Exception;

	Case addCase(Case aCase) throws Exception;

	Boolean deleteCase(Long id) throws Exception;

}
