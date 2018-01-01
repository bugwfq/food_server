package cn.fuqiang.food.entity;

import java.util.Date;

public class Desk {
	/**
	 * �������
	 */
	private Integer dId;
	/**
	 * ��������
	 */
	private String dName;
	/**
	 * Ԥ��״̬   0 ��  1��Ԥ��
	 */
	private Integer dCondition;
	/**
	 * Ԥ������
	 */
	private Date targetDate;
	public Desk() {}
	public Desk(Integer dId, String dName, Integer dCondition, Date targetDate) {
		this.dId = dId;
		this.dName = dName;
		this.dCondition = dCondition;
		this.targetDate = targetDate;
	}
	public Desk(String dName, Integer dCondition, Date targetDate) {
		this.dName = dName;
		this.dCondition = dCondition;
		this.targetDate = targetDate;
	}
	public Integer getdId() {
		return dId;
	}
	public void setdId(Integer dId) {
		this.dId = dId;
	}
	public String getdName() {
		return dName;
	}
	public void setdName(String dName) {
		this.dName = dName;
	}
	public Integer getdCondition() {
		return dCondition;
	}
	public void setdCondition(Integer dCondition) {
		this.dCondition = dCondition;
	}
	public Date getTargetDate() {
		return targetDate;
	}
	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}
	
	
}
