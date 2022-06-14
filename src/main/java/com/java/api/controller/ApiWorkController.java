package com.java.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.api.dto.ApiRequestDeleteWork;
import com.java.api.dto.ApiRequestNewWorkDto;
import com.java.api.dto.ApiRequestUpdateWorkDto;
import com.java.api.dto.ApiResponseDto;
import com.java.api.dto.ApiResponseListWorkDto;
import com.java.api.exception.BusinessException;
import com.java.api.service.ApiWorkService;
import com.java.api.utills.ApiConstants;

/**
 * The Class ApiWorkController.
 */
@RestController
@RequestMapping("/")
public class ApiWorkController {

	/** The work service. */
	@Autowired
	ApiWorkService workService;

	/**
	 * Say hello.
	 *
	 * @return the api response dto
	 */
	@GetMapping
	public ApiResponseDto sayHello() {
		ApiResponseDto response = new ApiResponseDto();
		response.setStatus(ApiConstants.SUCCESS);
		response.setMessage(ApiConstants.SAY_HELLO);
		return response;
	}

	/**
	 * Post rest API response.
	 *
	 * @param page the page
	 * @return the api response list work dto
	 * @throws Exception the exception
	 */
	@GetMapping(value = "/list/{page}")
	public ApiResponseListWorkDto getListWork(@PathVariable(value = "page") int page) {

		return workService.listAll(page);
	}

	/**
	 * Adds the list work.
	 *
	 * @param apiRequestNewWorkDto the api request new work dto
	 * @return the api response dto
	 * @throws Exception the exception
	 */
	@PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponseDto addListWork(@RequestBody ApiRequestNewWorkDto apiRequestNewWorkDto) {

		ApiResponseDto response = new ApiResponseDto();
		try {
			workService.insertListWork(apiRequestNewWorkDto);
			response.setStatus(ApiConstants.SUCCESS);
			response.setMessage(ApiConstants.MESS_SUCCESS);
		} catch (BusinessException e) {
			throw e;
		} catch (Exception e) {
			response.setStatus(ApiConstants.ERROR);
			response.setMessage(ApiConstants.MESS_ERROR);
		}
		return response;
	}

	/**
	 * Update list work.
	 *
	 * @param apiRequestUpdateWorkDto the api request update work dto
	 * @return the api response dto
	 * @throws Exception the exception
	 */
	@PostMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponseDto updateListWork(@RequestBody ApiRequestUpdateWorkDto apiRequestUpdateWorkDto) {
		ApiResponseDto response = new ApiResponseDto();
		try {
			workService.updateListWork(apiRequestUpdateWorkDto);
			response.setStatus(ApiConstants.SUCCESS);
			response.setMessage(ApiConstants.MESS_SUCCESS);
		} catch (BusinessException e) {
			throw e;
		} catch (Exception e) {
			response.setStatus(ApiConstants.ERROR);
			response.setMessage(ApiConstants.MESS_ERROR);
		}
		return response;
	}

	/**
	 * Update list work.
	 *
	 * @param apiRequestDeleteWork the api request delete work
	 * @return the api response dto
	 * @throws Exception the exception
	 */
	@PostMapping(value = "/delete", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponseDto updateListWork(@RequestBody ApiRequestDeleteWork apiRequestDeleteWork) {
		ApiResponseDto response = new ApiResponseDto();
		try {
			workService.deleteListWork(apiRequestDeleteWork.getListDel());
			response.setStatus(ApiConstants.SUCCESS);
			response.setMessage(ApiConstants.MESS_SUCCESS);
		} catch (Exception e) {
			response.setStatus(ApiConstants.ERROR);
			response.setMessage(ApiConstants.MESS_ERROR);
		}
		return response;
	}

}