package cn.fuqiang.food.dao;

import java.util.List;
import java.util.Map;

import cn.fuqiang.food.entity.FoodType;


public interface IFoodTypeDao {
	/**
	 * 根据条件分页查询  返回一个查询的list结果集
	 * @param name   模糊查找的姓名
	 * @param beginLine  开始的条数
	 * @param endLine    结束的条数
	 * @return  List<FoodType> 的结果集
	 */
	public List<Map> getFoodTypesByName(String name,Integer beginLine,Integer endLine);
	/**
	 * 根据id返回一个查询的FoodType对象
	 * @param id 需要操作的id
	 * @return FoodType对象
	 */
	public FoodType getFoodTypeById(String id);
	/**
	 * 根据模糊查询的姓名返回符合条件的行数
	 * @param name 模糊查找的姓名
	 * @return 返回符合条件的行数
	 */
	public int getFoodTypesCountByName(String name);
	/**
	 * 传入一个FoodType实体存入数据库中
	 * @param newFoodType 需要存入数据库中的实体
	 * @return 0 为插入失败其他为成功
	 */
	public int addFoodType(FoodType newFoodType);
	/**
	 *传入一个修改的内容
	 *@param 修改成功的FoodType对象
	 *@return 0修改失败  其他为成功
	 */
	public int updateFoodType(FoodType updateFoodType);
	/**
	 * 传入一个需要删除的id
	 * @param id 需要删除数据的id
	 * @return 0修改失败 其他为成功
	 */
	public int deleteFoodTypeById(String id);
}
