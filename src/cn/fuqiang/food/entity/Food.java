package cn.fuqiang.food.entity;
/**
 * ��Ʒʵ��
 * @author Administrator
 *
 */
public class Food {
	/**
	 * ��Ʒid
	 */
	private Integer foodId;
	/**
	 * ��ϵid
	 */
	private Integer typeId;
	/**
	 * ����
	 */
	private String foodName;
	/**
	 * �۸�
	 */
	private Double price;
	/**
	 * ��Ա��   ��ͨ���ۿ۵ı����Զ����㣩
	 */
	private Double discountPrice=0.98;
	/**
	 * ͼƬ·��
	 */
	private String imgPath;
	public Food() {}
	public Food(Integer foodId, Integer typeId, String foodName, Double price, String imgPath) {
		this.foodId = foodId;
		this.typeId = typeId;
		this.foodName = foodName;
		this.price = price;
		//�����Ա�۸�
		this.discountPrice = price*this.discountPrice;
		this.imgPath = imgPath;
	}
	public Food(Integer typeId, String foodName, Double price, String imgPath) {
		this.typeId = typeId;
		this.foodName = foodName;
		this.price = price;
		//�����Ա�۸�
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
