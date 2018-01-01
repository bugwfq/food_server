package cn.fuqiang.food.entity;

public class FoodType {
	/**
	 * ²ËÏµid
	 */
	private Integer typeId;
	/**
	 * ²ËÏµÃû³Æ
	 */
	private String typeName;
	public FoodType() {}
	public FoodType(Integer typeId, String typeName) {
		this.typeId = typeId;
		this.typeName = typeName;
	}
	public FoodType( String typeName) {
		this.typeName = typeName;
	}
	public Integer getTypeId() {
		return typeId;
	}
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	
}
