package cn.fuqiang.food.service;

import cn.fuqiang.food.utilities.PageTools;

public interface IOrderFormManager {
	
	/**
	 * 根据传入的信息创建一条数据到数据库
	 * @param foodID  菜品id
	 * @param did	餐桌id
	 * @param count 菜品数量
	 * @return
	 */
	public boolean addOrderFormList(String foodID,String did,String count);
	
	/**
	 * 根据传入的信息修改数据库中的信息
	 * @param fid 要修改的id
	 * @param foodID  要修改的菜品id
	 * @param did 要修改的餐桌id、
	 * @param count 预定数量
	 * @return
	 */
	public boolean updateOrderFormList(String fid,String foodID,String did,String count);
	
	
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
	public boolean deleteOrderForm(String id);
}
