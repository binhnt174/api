package com.java.api.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.api.controller.ApiWorkController;
import com.java.api.dto.ApiRequestNewWorkDto;
import com.java.api.dto.ApiRequestUpdateWorkDto;
import com.java.api.dto.ApiResponseListWorkDto;
import com.java.api.dto.Work01Dto;
import com.java.api.dto.Work02Dto;
import com.java.api.entites.WorkEntity;
import com.java.api.enums.WorkStatus;
import com.java.api.repository.WorkRepository;
import com.java.api.service.ApiWorkService;
import com.java.api.utills.ApiConstants;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * The Class ApiApplicationTests.
 */
@SpringBootTest
@AutoConfigureMockMvc
class ApiApplicationTests {

	/** The api work controller. */
	@Autowired
	ApiWorkController apiWorkController;

	/** The api work service. */
	@Autowired
	ApiWorkService apiWorkService;

	/** The work repository. */
	@Autowired
	WorkRepository workRepository;

	/** The mock mvc. */
	@Autowired
	private MockMvc mockMvc;

	/**
	 * Context loads.
	 *
	 * @throws Exception the exception
	 */
	@Test
	void contextLoads() throws Exception {
		assertThat(apiWorkController).isNotNull();
		assertThat(apiWorkService).isNotNull();
		assertThat(workRepository).isNotNull();
	}

	/**
	 * Should return default message.
	 *
	 * @throws Exception the exception
	 */
	@Test
	void shouldReturnDefaultMessage() throws Exception {
		this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk()).andExpect(
				content().string(containsString("{\"status\":\"200\",\"message\":\"Wellcome to API Work service\"}")));
	}

	/**
	 * Test list data.
	 *
	 * @throws Exception the exception
	 */
	@Test
	void testListData() throws Exception {

		ApiResponseListWorkDto apiResponseListWorkDto = apiWorkController.getListWork(1);

		this.mockMvc.perform(get("/list/1")).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.size").value(apiResponseListWorkDto.getSize()))
				.andExpect(jsonPath("$.page").value(1));
	}

	/**
	 * Test insert data.
	 *
	 * @throws Exception the exception
	 */
	@Test
	void testInsertData() throws Exception {

		ApiRequestNewWorkDto apiRequestNewWorkDto = new ApiRequestNewWorkDto();
		List<Work02Dto> listWork02Dto = new ArrayList<>();
		Work02Dto Work02Dto = new Work02Dto();
		Work02Dto.setStatus(WorkStatus.DONGING);
		Work02Dto.setWorkName("Coding");
		Work02Dto.setStartDt(new Date());
		Date dt = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(dt);
		c.add(Calendar.DATE, 1);
		dt = c.getTime();
		Work02Dto.setEndDt(dt);
		listWork02Dto.add(Work02Dto);

		apiRequestNewWorkDto.setListWork02Dto(listWork02Dto);

		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(apiRequestNewWorkDto);

		this.mockMvc.perform(post("/add").contentType(MediaType.APPLICATION_JSON).content(json))
				.andExpect(jsonPath("$.status").value(ApiConstants.SUCCESS))
				.andExpect(jsonPath("$.message").value(ApiConstants.MESS_SUCCESS));
	}
	
	/**
	 * Test insert data Fail.
	 *
	 * @throws Exception the exception
	 */
	@Test
	void testInsertDataFail() throws Exception {

		ApiRequestNewWorkDto apiRequestNewWorkDto = new ApiRequestNewWorkDto();
		List<Work02Dto> listWork02Dto = new ArrayList<>();
		Work02Dto Work02Dto = new Work02Dto();
		Work02Dto.setStatus(WorkStatus.DONGING);
		Work02Dto.setWorkName("Coding");
		Work02Dto.setStartDt(new Date());
		Work02Dto.setEndDt(new Date());
		listWork02Dto.add(Work02Dto);

		apiRequestNewWorkDto.setListWork02Dto(listWork02Dto);

		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(apiRequestNewWorkDto);

		this.mockMvc.perform(post("/add").contentType(MediaType.APPLICATION_JSON).content(json))
				.andExpect(status().is(501));
	}

	/**
	 * Test update data.
	 *
	 * @throws Exception the exception
	 */
	@Test
	void testUpdateData() throws Exception {

		Work02Dto Work02Dto = new Work02Dto();
		Work02Dto.setStatus(WorkStatus.DONGING);
		Work02Dto.setWorkName("Coding");
		Work02Dto.setStartDt(new Date());
		Work02Dto.setEndDt(new Date());

		WorkEntity temp = new WorkEntity();
		BeanUtils.copyProperties(Work02Dto, temp);
		workRepository.save(temp);

		ApiRequestUpdateWorkDto apiRequestUpdateWorkDto = new ApiRequestUpdateWorkDto();
		List<Work01Dto> listWork01Dto = new ArrayList<>();
		Work01Dto work01Dto = new Work01Dto();
		work01Dto.setStatus(WorkStatus.DONGING);
		work01Dto.setWorkName("Coding");
		work01Dto.setWorkId(temp.getWorkId());
		work01Dto.setStartDt(new Date());
		Date dt = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(dt);
		c.add(Calendar.DATE, 1);
		dt = c.getTime();
		work01Dto.setEndDt(dt);
		listWork01Dto.add(work01Dto);

		apiRequestUpdateWorkDto.setListWork01Dto(listWork01Dto);

		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(apiRequestUpdateWorkDto);

		this.mockMvc.perform(post("/update").contentType(MediaType.APPLICATION_JSON).content(json))
				.andExpect(jsonPath("$.status").value("200"))
				.andExpect(jsonPath("$.message").value("The request has been processed for success"));
	}

	/**
	 * Test update data Fail.
	 *
	 * @throws Exception the exception
	 */
	@Test
	void testUpdateFail() throws Exception {

		Work02Dto Work02Dto = new Work02Dto();
		Work02Dto.setStatus(WorkStatus.DONGING);
		Work02Dto.setWorkName("Coding");
		Work02Dto.setStartDt(new Date());
		Work02Dto.setEndDt(new Date());

		WorkEntity temp = new WorkEntity();
		BeanUtils.copyProperties(Work02Dto, temp);
		workRepository.save(temp);

		ApiRequestUpdateWorkDto apiRequestUpdateWorkDto = new ApiRequestUpdateWorkDto();
		List<Work01Dto> listWork01Dto = new ArrayList<>();
		Work01Dto work01Dto = new Work01Dto();
		work01Dto.setStatus(WorkStatus.DONGING);
		work01Dto.setWorkName("Coding");
		work01Dto.setWorkId(temp.getWorkId());
		work01Dto.setStartDt(new Date());
		work01Dto.setEndDt(new Date());
		listWork01Dto.add(work01Dto);

		apiRequestUpdateWorkDto.setListWork01Dto(listWork01Dto);

		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(apiRequestUpdateWorkDto);

		this.mockMvc.perform(post("/update").contentType(MediaType.APPLICATION_JSON).content(json))
				.andExpect(status().is(501));
	}

	/**
	 * Test delete.
	 *
	 * @throws Exception the exception
	 */
	@Test
	void testDelete() throws Exception {

		this.mockMvc.perform(post("/delete").contentType(MediaType.APPLICATION_JSON).content("{\"listDel\":[7,8]}"))
				.andExpect(jsonPath("$.status").value("200"))
				.andExpect(jsonPath("$.message").value("The request has been processed for success"));
	}

}
