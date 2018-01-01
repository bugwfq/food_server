package cn.fuqiang.food.entity;

import java.util.Date;

public class OrderFormList {
	/**
	 * �б�id
	 */
	private Integer listId;
	/**
	 * ����id
	 */
	private Integer fId;
	/**
	 * �µ�����
	 */
	private Date orderDate;
	/**
	 * ����״̬  0 δ֧��  1�Ѹ���
	 */
	private Integer condition;
	public OrderFormList() {}
	public OrderFormList( Integer fId, Date orderDate, Integer condition) {
		this.fId = fId;
		this.orderDate = orderDate;
		this.condition = condition;
	}
	public OrderFormList(Integer listId, Integer fId, Date orderDate, Integer condition) {
		this.listId = listId;
		this.fId = fId;
		this.orderDate = orderDate;
		this.condition = condition;
	}
	public Integer getListId() {
		return listId;
	}
	public void setListId(Integer listId) {
		this.listId = listId;
	}
	public Integer getfId() {
		return fId;
	}
	public void setfId(Integer fId) {
		this.fId = fId;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public Integer getCondition() {
		return condition;
	}
	public void setCondition(Integer condition) {
		this.condition = condition;
	}
	
}
