package com.java.api.entites;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.java.api.enums.WorkStatus;

/**
 * The Class WorkEntity.
 */
@Entity
@Table(name = "WORK")
public class WorkEntity {

	/** The work id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "WORK_ID")
	private int workId;

	/** The work name. */
	@Column(name = "WORK_NAME")
	private String workName;

	/** The status. */
	@Column(name = "STATUS")
	private WorkStatus status;

	/** The start date. */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "START_DT")
	private Date startDt;

	/** The end date. */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "END_DT")
	private Date endDt;

	/** The create date. */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CRT_DT")
	private Date crtDt;

	/** The update date. */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPT_DT")
	private Date uptDt;

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
	 * Gets the start dt.
	 *
	 * @return the start dt
	 */
	public Date getStartDt() {
		return startDt;
	}

	/**
	 * Sets the start dt.
	 *
	 * @param startDt the new start dt
	 */
	public void setStartDt(Date startDt) {
		this.startDt = startDt;
	}

	/**
	 * Gets the end dt.
	 *
	 * @return the end dt
	 */
	public Date getEndDt() {
		return endDt;
	}

	/**
	 * Sets the end dt.
	 *
	 * @param endDt the new end dt
	 */
	public void setEndDt(Date endDt) {
		this.endDt = endDt;
	}

	/**
	 * Gets the crt dt.
	 *
	 * @return the crt dt
	 */
	public Date getCrtDt() {
		return crtDt;
	}

	/**
	 * Sets the crt dt.
	 *
	 * @param crtDt the new crt dt
	 */
	public void setCrtDt(Date crtDt) {
		this.crtDt = crtDt;
	}

	/**
	 * Gets the upt dt.
	 *
	 * @return the upt dt
	 */
	public Date getUptDt() {
		return uptDt;
	}

	/**
	 * Sets the upt dt.
	 *
	 * @param uptDt the new upt dt
	 */
	public void setUptDt(Date uptDt) {
		this.uptDt = uptDt;
	}

}
