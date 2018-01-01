package cn.fuqiang.food.service.imp;

import java.util.Date;

import cn.fuqiang.food.dao.imp.OrderFormListDao;
import cn.fuqiang.food.entity.OrderFormList;
import cn.fuqiang.food.service.IOrderFormListManager;
import cn.fuqiang.food.utilities.DateUtils;
import cn.fuqiang.food.utilities.PageTools;

public class OrderFormListManager implements IOrderFormListManager {
	private OrderFormListDao listDao = new OrderFormListDao();
	@Override
	public boolean addOrderForm(String fId, String orderdate, String condition) {
		//判断传入的数据是否为空如果不为空则转换类型
		Integer id = null;
		Date date= null;
		Integer cond = null;
		//如果不为null则转换
		if(fId!=null){
			id = Integer.parseInt(fId);
		}
		//如果不为null则转换
		if(orderdate!=null){
			date = DateUtils.stringToDate(orderdate);
		}
		if(condition!=null){
			cond = Integer.parseInt(condition);
		}
		//创建对象
		OrderFormList orderlsi = new OrderFormList(id, date, cond);
		//获取执行结果
		int result = listDao.addOrderFormList(orderlsi);
		//若为0则失败，其他则成功
		return result>0?true:false;
	}

	@Override
	public boolean updateOrderForm(String listId, String fId, String orderdate, String condition) {
		//判断传入的数据是否为空如果不为空则转换类型
		Integer id = null;
		Integer fid = null;
		Date date= null;
		Integer cond = null;
		//如果不为null则转换
		if(listId !=null){
			id = Integer.parseInt(fId);
		}
		if(fId!=null){
			fid = Integer.parseInt(fId);
		}
		//如果不为null则转换
		if(orderdate!=null || "".equals(orderdate)){
			date = DateUtils.stringToDate(orderdate);
		}
		if(condition!=null){
			cond = Integer.parseInt(condition);
		}
		//创建对象
		OrderFormList orderlist = new OrderFormList(id,fid, date, cond);
		//获取执行结果
		int result = listDao.updateOrderFormList(orderlist);
		//若为0则失败，其他则成功
		return result>0?true:false;
	}
	@Override
	public PageTools getPageTools(String name, String curPage, String lineNumber) {
		Integer cPage = 1;
		Integer line = 0;
		if(name==null){
			name="";
		}
		if(curPage!=null){
			cPage = Integer.parseInt(curPage);
		}
		if(lineNumber==null){
			line=Integer.parseInt(lineNumber);
		}
		//获取该数据在数据库中的总条数
		Integer totalNumber = listDao.getOrderFormListsCountByName(name);
		//创建分页工具对象
		PageTools pageTools = new PageTools(cPage, totalNumber, line);
		//将查到的数据存入到工具类中
		pageTools.setData(listDao.getOrderFormListsByName(name, pageTools.getBeginLine(), pageTools.getEndLine()));
		return pageTools;
	}

	@Override
	public boolean deleteOrderFormList(String id) {
		//判断是否传入id
		if(id==null || id.equals("")){
			return false;
		}
		int result = listDao.deleteOrderFormListById(id);
		return result>0?true:false;
	}

	

}
