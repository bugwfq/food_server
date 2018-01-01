package cn.fuqiang.food.dao;

import java.util.List;
import java.util.Map;

import cn.fuqiang.food.entity.OrderForm;

public interface IOrderFormDao {
	/**
	 * 根据条件分页查询  返回一个查询的list结果集
	 * @param name   模糊查找的姓名
	 * @param beginLine  开始的条数
	 * @param endLine    结束的条数
	 * @return  List<OrderForm> 的结果集
	 */
	public List<Map> getOrderFormsByName(String name,Integer beginLine,Integer endLine);
	/**
	 * 根据id返回一个查询的OrderForm对象
	 * @param id 需要操作的id
	 * @return OrderForm对象
	 */
	public OrderForm getOrderFormById(String id);
	/**
	 * 根据模糊查询的姓名返回符合条件的行数
	 * @param name 模糊查找的姓名
	 * @return 返回符合条件的行数
	 */
	public int getOrderFormsCountByName(String name);
	/**
	 * 传入一个OrderForm实体存入数据库中
	 * @param newOrderForm 需要存入数据库中的实体
	 * @return 0 为插入失败其他为成功
	 */
	public int addOrderForm(OrderForm newOrderForm);
	/**
	 *传入一个修改的内容
	 *@param 修改成功的OrderForm对象
	 *@return 0修改失败  其他为成功
	 */
	public int updateOrderForm(OrderForm updateOrderForm);
	/**
	 * 传入一个需要删除的id
	 * @param id 需要删除数据的id
	 * @return 0修改失败 其他为成功
	 */
	public int deleteOrderFormById(String id);
}
