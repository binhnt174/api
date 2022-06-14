package com.java.api.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.java.api.entites.WorkEntity;

/**
 * The Interface WorkRepository.
 */
@Repository
public interface WorkRepository extends JpaRepository<WorkEntity, Long> {
	
	/**
	 * Find all.
	 *
	 * @param pageable the pageable
	 * @return the page
	 */
	Page<WorkEntity> findAll(Pageable pageable);
	
	/**
	 * Find by work id.
	 *
	 * @param workId the work id
	 * @return the work entity
	 */
	WorkEntity findByWorkId(int workId);
	
	/**
	 * Delete by list work.
	 *
	 * @param list work
	 */
	@Transactional
	void deleteByWorkIdIn(List<Integer> list);
}