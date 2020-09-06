package com.sbk.signoff.coreapp.jpa.repository;

import com.sbk.signoff.coreapp.jpa.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
