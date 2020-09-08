package com.sbk.signoff.coreapp.jpa.provider;

import com.sbk.signoff.coreapp.api.model.Case;
import com.sbk.signoff.coreapp.jpa.entity.CaseEntity;
import com.sbk.signoff.coreapp.jpa.repository.CaseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CaseDataProviderImpl implements CaseDataProvider {
	private static final Logger logger = LoggerFactory.getLogger(CaseDataProviderImpl.class);
	private CaseRepository caseRepository;
	private CaseDataMapper caseDataMapper;

	@Autowired
	public void setCaseRepository(CaseRepository caseRepository) {
		this.caseRepository = caseRepository;
	}

	@Autowired
	public void setCaseDataMapper(CaseDataMapper caseDataMapper) {
		this.caseDataMapper = caseDataMapper;
	}

	@Override
	public Case readCase(Long id) throws Exception {
		logger.info("Select case by id :" + id);
		Optional<CaseEntity> entity = caseRepository.findById(id);
		if(entity.isEmpty()) {
			throw new RuntimeException("Case record not found in database.");
		}
		return caseDataMapper.mapEntityToModel(entity.get());
	}

	@Override
	public List<Case> readCases() throws Exception {
		logger.info("Select all users...");
		return caseDataMapper.mapEntityToModel(caseRepository.findAll());
	}

	@Override
	public Case addCase(Case aCase) throws Exception {
		logger.info("Creating new case : " + aCase);
		CaseEntity caseEntity = caseDataMapper.mapModelToEntity(aCase);
		logger.info("New case data : " + caseEntity);
		CaseEntity entity = caseRepository.save(caseEntity);
		if(entity.getId() < 1) {
			logger.error("Case record creation failed, User:" + entity);
			throw new RuntimeException("Case creation failed for user id:" + aCase.getId());
		}
		return caseDataMapper.mapEntityToModel(entity);
	}

	@Override
	public Boolean deleteCase(Long id) throws Exception {
		logger.info("Delete case by ID:" + id);
		caseRepository.deleteById(id);

		boolean foundId = caseRepository.existsById(id);
		return !foundId;
	}
}
