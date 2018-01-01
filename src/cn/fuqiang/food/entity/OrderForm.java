package cn.fuqiang.food.entity;

public class OrderForm {
	/**
	 * ����id
	 */
	private Integer fid;
	/**
	 * ��Ʒid
	 */
	private Integer foodId;
	/**
	 * �������
	 */
	private Integer did;
	/**
	 * ����
	 */
	private Integer count;
	public OrderForm() {}
	public OrderForm(Integer fid, Integer foodId, Integer did, Integer count) {
		this.fid = fid;
		this.foodId = foodId;
		this.did = did;
		this.count = count;
	}
	public OrderForm(Integer foodId, Integer did, Integer count) {
		this.foodId = foodId;
		this.did = did;
		this.count = count;
	}
	public Integer getFid() {
		return fid;
	}
	public void setFid(Integer fid) {
		this.fid = fid;
	}
	public Integer getFoodId() {
		return foodId;
	}
	public void setFoodId(Integer foodId) {
		this.foodId = foodId;
	}
	public Integer getDid() {
		return did;
	}
	public void setDid(Integer did) {
		this.did = did;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	
}
