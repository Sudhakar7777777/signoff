package com.sbk.signoff.coreapp.jpa.provider;

import com.sbk.signoff.coreapp.api.model.Case;
import com.sbk.signoff.coreapp.jpa.entity.CaseEntity;
import io.micrometer.core.instrument.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Component
public class CaseDataMapper {
	private static final Logger logger = LoggerFactory.getLogger(CaseDataMapper.class);

	public CaseEntity mapModelToEntity(Case aCase) {
		CaseEntity entity = new CaseEntity(
				aCase.getId(),
				aCase.getSid(),
				aCase.getName(),
				isNull(aCase.getIsActive())?"Y":aCase.getIsActive()
		);
		logger.debug("mapModelToEntity:" + entity);
		return entity;
	}

	public List<CaseEntity> mapModelToEntity(List<Case> Cases) {
		List<CaseEntity> entities = Cases.stream()
				.map(this::mapModelToEntity)
				.collect(Collectors.toList());
		logger.debug("mapModelToEntity:" + entities);
		return entities;
	}

	public Case mapEntityToModel(CaseEntity entity) {
		Case Case = new Case(
				entity.getId(),
				entity.getSid(),
				entity.getName(),
				entity.getIsActive()
		);
		logger.debug("mapEntityToModel:" + Case);
		return Case;
	}

	public List<Case> mapEntityToModel(List<CaseEntity> entities) {
		List<Case> Cases = entities.stream()
				.map(this::mapEntityToModel)
				.collect(Collectors.toList());
		logger.debug("mapEntityToModel:" + Cases);
		return Cases;
	}

	public CaseEntity mapUpdateEntity(CaseEntity entity, Case Case) {
		if (Case.getId() > 0) entity.setId(Case.getId());
		if (Case.getSid() > 0) entity.setSid(Case.getSid());
		if (StringUtils.isNotEmpty(Case.getName())) entity.setName(Case.getName());
		if (StringUtils.isNotEmpty(Case.getIsActive())) entity.setIsActive(Case.getIsActive());
		logger.debug("mapUpdateEntity:" + entity);
		return entity;
	}

}
