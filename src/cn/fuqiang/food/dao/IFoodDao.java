package cn.fuqiang.food.dao;

import java.util.List;
import java.util.Map;

import cn.fuqiang.food.entity.Food;

public interface IFoodDao {
	/**
	 * 根据条件分页查询  返回一个查询的list结果集
	 * @param name   模糊查找的姓名
	 * @param beginLine  开始的条数
	 * @param endLine    结束的条数
	 * @return  List<Food> 的结果集
	 */
	public List<Map> getFoodsByName(String name,Integer beginLine,Integer endLine);
	/**
	 * 根据id返回一个查询的Food对象
	 * @param id 需要操作的id
	 * @return food对象
	 */
	public Food getFoodById(String id);
	/**
	 * 根据模糊查询的姓名返回符合条件的行数
	 * @param name 模糊查找的姓名
	 * @return 返回符合条件的行数
	 */
	public int getFoodsCountByName(String name);
	/**
	 * 传入一个Food实体存入数据库中
	 * @param newFood 需要存入数据库中的实体
	 * @return 0 为插入失败其他为成功
	 */
	public int addFood(Food newFood);
	/**
	 *传入一个修改的内容
	 *@param 修改成功的food对象
	 *@return 0修改失败  其他为成功
	 */
	public int updateFood(Food updateFood);
	/**
	 * 传入一个需要删除的id
	 * @param id 需要删除数据的id
	 * @return 0修改失败 其他为成功
	 */
	public int deleteFoodById(String id);
}
