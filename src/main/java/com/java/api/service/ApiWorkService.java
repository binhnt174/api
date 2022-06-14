package com.java.api.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.java.api.dto.ApiRequestNewWorkDto;
import com.java.api.dto.ApiRequestUpdateWorkDto;
import com.java.api.dto.ApiResponseListWorkDto;
import com.java.api.dto.Work01Dto;
import com.java.api.dto.Work02Dto;
import com.java.api.entites.WorkEntity;
import com.java.api.exception.BusinessException;
import com.java.api.repository.WorkRepository;
import com.java.api.utills.ApiConstants;

/**
 * The Class WorkService.
 */
@Service
public class ApiWorkService {
	/** The work repository. */
	@Autowired
	WorkRepository workRepository;

	/**
	 * List work.
	 *
	 * @param page the page
	 * @return the api response list work dto
	 */
	public ApiResponseListWorkDto listAll(int page) {

		// seting size page and sorting
		Pageable pageable = PageRequest.of(page - 1, ApiConstants.DEFAULT_PAGE_SIZE, Sort.by("startDt").ascending());

		// call DB
		Page<WorkEntity> pageWorks = workRepository.findAll(pageable);

		// set data response
		ApiResponseListWorkDto apiResponseListWorkDto = new ApiResponseListWorkDto();
		apiResponseListWorkDto.setPage(page);

		// check exist data get from DB
		if (pageWorks.hasContent()) {

			List<Work01Dto> listWork01Dto = new ArrayList<>();
			List<WorkEntity> list = pageWorks.getContent();

			// tranfer object
			for (WorkEntity workEntity : list) {
				Work01Dto temp = new Work01Dto();
				BeanUtils.copyProperties(workEntity, temp);
				listWork01Dto.add(temp);
			}

			apiResponseListWorkDto.setListWork01Dto(listWork01Dto);
			apiResponseListWorkDto.setSize(listWork01Dto.size());
		}

		return apiResponseListWorkDto;

	}

	/**
	 * Insert list work.
	 *
	 * @param apiRequestNewWorkDto the api request new work dto
	 * @throws Exception
	 */
	public void insertListWork(ApiRequestNewWorkDto apiRequestNewWorkDto) throws BusinessException {

		List<WorkEntity> listWorkEntity = new ArrayList<>();

		// tranfer object
		for (Work02Dto work02Dto : apiRequestNewWorkDto.getListWork02Dto()) {
			if (work02Dto.getStartDt().compareTo(work02Dto.getEndDt()) >= 0) {
				throw new BusinessException(work02Dto.getWorkName(), ApiConstants.FILED_DATE);
			}
			WorkEntity temp = new WorkEntity();
			BeanUtils.copyProperties(work02Dto, temp);
			temp.setCrtDt(new Date());
			listWorkEntity.add(temp);
		}

		// insert list data
		workRepository.saveAll(listWorkEntity);

	}

	/**
	 * Update list work.
	 *
	 * @param apiRequestUpdateWorkDto the api request update work dto
	 * @throws Exception
	 */
	public void updateListWork(ApiRequestUpdateWorkDto apiRequestUpdateWorkDto) throws BusinessException {

		List<WorkEntity> listWorkEntity = new ArrayList<>();

		// tranfer object
		for (Work01Dto work01Dto : apiRequestUpdateWorkDto.getListWork01Dto()) {
			// validate
			if (work01Dto.getStartDt().compareTo(work01Dto.getEndDt()) >= 0) {
				throw new BusinessException(work01Dto.getWorkName(), ApiConstants.FILED_DATE);
			}
			WorkEntity temp = workRepository.findByWorkId(work01Dto.getWorkId());
			BeanUtils.copyProperties(work01Dto, temp);
			temp.setUptDt(new Date());
			listWorkEntity.add(temp);
		}

		// update list data
		workRepository.saveAll(listWorkEntity);

	}

	/**
	 * Delete list work.
	 *
	 * @param list id work
	 */
	public void deleteListWork(List<Integer> list) {

		// delete list data by id
		workRepository.deleteByWorkIdIn(list);

	}

}
