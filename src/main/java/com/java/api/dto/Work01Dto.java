package com.java.api.dto;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.java.api.enums.WorkStatus;

/**
 * The Class Work01Dto.
 */
public class Work01Dto {

	/** The work id. */
	private int workId;

	/** The work name. */
	private String workName;

	/** The status. */
	private WorkStatus status;

	/** The start date. */
	@Temporal(TemporalType.TIMESTAMP)
	private Date startDt;

	/** The end date. */
	@Temporal(TemporalType.TIMESTAMP)
	private Date endDt;

	/**
	 * Gets the work id.
	 *
	 * @return the work id
	 */
	public int getWorkId() {
		return workId;
	}

	/**
	 * Sets the work id.
	 *
	 * @param workId the new work id
	 */
	public void setWorkId(int workId) {
		this.workId = workId;
	}

	/**
	 * Gets the work name.
	 *
	 * @return the work name
	 */
	public String getWorkName() {
		return workName;
	}

	/**
	 * Sets the work name.
	 *
	 * @param workName the new work name
	 */
	public void setWorkName(String workName) {
		this.workName = workName;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public WorkStatus getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(WorkStatus status) {
		this.status = status;
	}

	/**
	 * Gets the start date.
	 *
	 * @return the start date
	 */
	public Date getStartDt() {
		return startDt;
	}

	/**
	 * Sets the start date.
	 *
	 * @param startDt the new start date
	 */
	public void setStartDt(Date startDt) {
		this.startDt = startDt;
	}

	/**
	 * Gets the end date.
	 *
	 * @return the end date
	 */
	public Date getEndDt() {
		return endDt;
	}

	/**
	 * Sets the end date.
	 *
	 * @param endDt the new end date
	 */
	public void setEndDt(Date endDt) {
		this.endDt = endDt;
	}
}
