package com.sbk.signoff.coreapp.jpa.repository;

import com.sbk.signoff.coreapp.jpa.entity.CaseEntity;
import com.sbk.signoff.coreapp.jpa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CaseRepository extends JpaRepository<CaseEntity, Long> {

	@Override
	Optional<CaseEntity> findById(@Param("id") Long id);

	@Override
	List<CaseEntity> findAll();

	@Override
	<S extends CaseEntity> S save(S entity);

	@Override
	boolean existsById(Long id);

	@Override
	void deleteById(Long id);

}
