package com.ramkarlapudi.poc.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ramkarlapudi.poc.entity.UserProfileEntity;

@EnableJpaRepositories
@Repository
public interface UserProfile extends JpaRepository<UserProfileEntity, Integer> {

	@Transactional
	@Modifying
	@Query("UPDATE UserProfileEntity SET verified='YES' where userid=?1")
	public void updateprofile(int userid);

}
