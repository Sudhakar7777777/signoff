package com.sbk.signoff.coreapp.jpa.repository;

import com.sbk.signoff.coreapp.jpa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

	@Override
	Optional<UserEntity> findById(@Param("id") Long id);

	@Override
	List<UserEntity> findAll();

	@Override
	<S extends UserEntity> S save(S entity);

	@Override
	boolean existsById(Long id);

	@Override
	void deleteById(Long id);
}
