package com.java.api.dto;

import java.util.List;

/**
 * The Class ApiResponseListWorkDto.
 */
public class ApiResponseListWorkDto {

	/** The page. */
	private int page;
	
	/** The size. */
	private int size;
	
	/** The list work 01 dto. */
	private List<Work01Dto> listWork01Dto;

	/**
	 * Gets the page.
	 *
	 * @return the page
	 */
	public int getPage() {
		return page;
	}

	/**
	 * Sets the page.
	 *
	 * @param page the new page
	 */
	public void setPage(int page) {
		this.page = page;
	}

	/**
	 * Gets the the size.
	 *
	 * @return the the size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Sets the the size.
	 *
	 * @param size the new the size
	 */
	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * Gets the list work 01 dto.
	 *
	 * @return the list work 01 dto
	 */
	public List<Work01Dto> getListWork01Dto() {
		return listWork01Dto;
	}

	/**
	 * Sets the list work 01 dto.
	 *
	 * @param listWork01Dto the new list work 01 dto
	 */
	public void setListWork01Dto(List<Work01Dto> listWork01Dto) {
		this.listWork01Dto = listWork01Dto;
	}

}
