package cn.fuqiang.food.service;

import cn.fuqiang.food.utilities.PageTools;

public interface IOrderFormListManager {
	/**
	 * 根据传入的内容创建一条数据到数据库
	 * @param fId 要添加的订单id
	 * @param orderdate 订单的日期
	 * @param condition 订单的支付状态
	 * @return
	 */
	public boolean addOrderForm(String fId,String orderdate,String condition);
	/**
	 * 
	 * @param listId订单列表的id
	 *@param fId 要修改的订单id
	 * @param orderdate 订单的日期
	 * @param condition 订单的支付状态
	 * @return
	 */
	public boolean updateOrderForm(String listId,String fId,String orderdate,String condition);
	
	
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
	public boolean deleteOrderFormList(String id);
}
