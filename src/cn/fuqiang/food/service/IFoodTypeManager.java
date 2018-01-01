package cn.fuqiang.food.service;

import cn.fuqiang.food.utilities.PageTools;

public interface IFoodTypeManager {
	/**
	 * 跟据传入的菜系名称加入到数据库
	 * @param typeName 菜系名称
	 * @return
	 */
	public boolean addFoodType(String typeName);
	/**
	 * 根据传入的信息修改数据库中内容
	 * @param typeId   要修改的菜系Id
	 * @param typeName 要修改的菜系名称
	 * @return
	 */
	public boolean updateFoodType(String typeId,String typeName);
	/**
	 * 根据传入的姓名和当前页查询指定范围数据，若不传默认查所有
	 * @param name  查询的桌名
	 * @param curPage  当前页
	 * @param lineNumber 每页显示的行数
	 * @return
	 */
	public PageTools getPageTools(String name,String curPage, String lineNumber);
	/**
	 * 根据传入的id删除数据库中制定数据
	 * @param id  要删除数据的id
	 * @return
	 */
	public boolean deleteFoodType(String id);
}
