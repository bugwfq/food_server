package cn.fuqiang.food.service;

import cn.fuqiang.food.utilities.PageTools;

public interface IDeskManager {
	/**
	 * 根据传入的值新建一条数据到数据库
	 * @param dName   桌子的名称
	 * @param dCondition  桌子的预定状态
	 * @param targetDate  桌子的预定日期
	 * @return  返回添加的状态 true成功
	 */
	public boolean addDesk(String dName,String dCondition,String targetDate);
	/**
	 *根据传入的信息修改数据库中的内容
	 * @param dId 修改的餐桌id
	 * @param dName 修改的餐桌名称
	 * @param dCondition 修改的餐桌的状态
	 * @param targetDate 修改的餐桌的预定日期
	 * @return  true为成功  false为失败
	 */
	public boolean updateDesk(String dId,String dName,String dCondition,String targetDate);
	
	/**
	 * 根据传入的姓名和当前页查询指定范围数据，若不传默认查所有
	 * @param name  查询的桌名
	 * @param curPage  当前页
	 * @param lineNumber 每页显示的行数
	 * @return
	 */
	public PageTools getPageTools(String name,String curPage, String lineNumber);
	/**
	 * 根据传入的id删除指定数据
	 * @param id 要删除的id
	 * @return
	 */
	public boolean deleteDesk(String id);
	
}
