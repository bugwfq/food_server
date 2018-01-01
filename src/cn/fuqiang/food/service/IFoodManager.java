package cn.fuqiang.food.service;

import cn.fuqiang.food.entity.Food;
import cn.fuqiang.food.utilities.PageTools;

public interface IFoodManager {
	/**
	 * 根据传入的信息将新值插入数据库
	 * @param typeId     菜系id
	 * @param foodName   菜名
	 * @param price		  单价
	 * @param imgPath	  图片路径
	 * @return ture 为成功   false 为失败
	 */
	public boolean addFood(String typeId,String foodName,String price,String imgPath);
	/**
	 * 根据传入的信息修改指定的数据
	 * @param foodId  要修改的菜品id
	 * @param typeId  要修改的菜系id
	 * @param foodName 要修改的菜名
	 * @param price    要修改的单价
	 * @param imgPath  要修改的图片路径
	 * @return
	 */
	public boolean updateFood(String foodId,String typeId,String foodName,String price,String imgPath);
	
	/**
	 * 根据指定条件获取一个分页工具对象
	 * @param name    需要查询的菜名  若无则为空
	 * @param curPage   当前页
	 * @param lineNumber  每页显示的行数
	 * @return
	 */
	public PageTools getPageTools(String name,String curPage, String lineNumber);
	/**
	 * 传入一个id删除对应的菜品信息
	 * @param id   某个菜品的id
	 * @return
	 */
	public boolean deleteFood(String id);
}
