package cn.fuqiang.food.service.imp;

import cn.fuqiang.food.dao.imp.OrderFormDao;
import cn.fuqiang.food.entity.OrderForm;
import cn.fuqiang.food.service.IOrderFormManager;
import cn.fuqiang.food.utilities.PageTools;

public class OrderFormManager implements IOrderFormManager {
	private OrderFormDao orderForm = new OrderFormDao();
	
	@Override
	public boolean addOrderFormList(String foodID, String did, String count) {
		//判断传入的数据是否为空如果不为空则转换类型
		Integer	id = null;
		Integer dId= null;
		Integer co = null;
		//如果不为null则转换
		if(foodID!=null){
			id = Integer.parseInt(foodID);
		}
		//如果不为null则转换
		if(did!=null){
			dId = Integer.parseInt(did);
		}
		if(count!=null){
			co = Integer.parseInt(count);
		}
		//创建对象
		OrderForm order = new OrderForm(id, dId, co);
		//获取执行结果
		int result = orderForm.addOrderForm(order);
		//若为0则失败，其他则成功
		return result>0?true:false;
	}

	@Override
	public boolean updateOrderFormList(String fid, String foodID, String did, String count) {
		//判断传入的数据是否为空如果不为空则转换类型
		Integer	id = null;
		Integer foodid= null;
		Integer dId = null;
		Integer co = null;
		//如果不为null则转换
		if(fid!=null){
			id = Integer.parseInt(fid);
		}
		if(foodID!=null){
			foodid = Integer.parseInt(foodID);
		}
		//如果不为null则转换
		if(did!=null){
			dId = Integer.parseInt(did);
		}
		if(count!=null){
			co = Integer.parseInt(count);
		}
		//创建对象
		OrderForm order = new OrderForm(id, foodid, dId, co);
		//获取执行结果
		int result = orderForm.updateOrderForm(order);
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
		Integer totalNumber = orderForm.getOrderFormsCountByName(name);
		//创建分页工具对象
		PageTools pageTools = new PageTools(cPage, totalNumber, line);
		//将查到的数据存入到工具类中
		pageTools.setData(orderForm.getOrderFormsByName(name, pageTools.getBeginLine(), pageTools.getEndLine()));
		return pageTools;
	}

	@Override
	public boolean deleteOrderForm(String id) {
		if(id==null || id.equals("")){
			return false;
		}
		int result = orderForm.deleteOrderFormById(id);
		return result>0?true:false;
	}

	

}
