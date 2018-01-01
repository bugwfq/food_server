package cn.fuqiang.food.entity;
/**
 * 菜品实体
 * @author Administrator
 *
 */
public class Food {
	/**
	 * 菜品id
	 */
	private Integer foodId;
	/**
	 * 菜系id
	 */
	private Integer typeId;
	/**
	 * 菜名
	 */
	private String foodName;
	/**
	 * 价格
	 */
	private Double price;
	/**
	 * 会员价   （通过折扣的比例自动计算）
	 */
	private Double discountPrice=0.98;
	/**
	 * 图片路径
	 */
	private String imgPath;
	public Food() {}
	public Food(Integer foodId, Integer typeId, String foodName, Double price, String imgPath) {
		this.foodId = foodId;
		this.typeId = typeId;
		this.foodName = foodName;
		this.price = price;
		//计算会员价格
		this.discountPrice = price*this.discountPrice;
		this.imgPath = imgPath;
	}
	public Food(Integer typeId, String foodName, Double price, String imgPath) {
		this.typeId = typeId;
		this.foodName = foodName;
		this.price = price;
		//计算会员价格
		this.discountPrice = price*this.discountPrice;
		this.imgPath = imgPath;
	}
	public Integer getFoodId() {
		return foodId;
	}
	public void setFoodId(Integer foodId) {
		this.foodId = foodId;
	}
	public Integer getTypeId() {
		return typeId;
	}
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getDiscountPrice() {
		return discountPrice;
	}
	public void setDiscountPrice(Double discountPrice) {
		this.discountPrice = discountPrice;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	
}
