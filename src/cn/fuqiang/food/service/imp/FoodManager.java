package cn.fuqiang.food.service.imp;

import cn.fuqiang.food.dao.imp.FoodDao;
import cn.fuqiang.food.entity.Food;
import cn.fuqiang.food.service.IFoodManager;
import cn.fuqiang.food.utilities.PageTools;

public class FoodManager implements IFoodManager {
	private FoodDao foodDao = new FoodDao();

	@Override
	public boolean addFood(String typeId, String foodName, String price,
			String imgPath) {
		//判断传入的数据是否为空如果不为空则转换类型
		Integer tId = null;
		Double p = null;
		//如果不为null则转换
		if(typeId!=null){
			tId = Integer.parseInt(typeId);
		}
		//如果不为null则转换
		if(price!=null){
			p = Double.parseDouble(price);
		}
		//创建对象
		Food food = new Food(tId,foodName,p,imgPath);
		//获取执行结果
		int result = foodDao.addFood(food);
		//若为0则失败，其他则成功
		return result>0?true:false;
	}

	@Override
	public boolean updateFood(String foodId, String typeId, String foodName, String price, String imgPath) {
		//判断传入的数据是否为空如果不为空则转换类型
		Integer fId = null;
		Integer tId = null;
		Double p = null;
		//若要修改的id为null则直接返回false
		if(foodId==null){
			return false;
		}
		//若不为空则转换
		fId = Integer.parseInt(foodId);
		if(typeId!=null){
			tId = Integer.parseInt(typeId);
		}
		if(price!=null){
			p = Double.parseDouble(price);
		}
		//创建对象
		Food food = new Food(fId,tId,foodName,p,imgPath);
		//获取执行结果
		int result = foodDao.updateFood(food);
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
		Integer totalNumber = foodDao.getFoodsCountByName(name);
		//创建分页工具对象
		PageTools pageTools = new PageTools(cPage, totalNumber, line);
		//将查到的数据存入到工具类中
		pageTools.setData(foodDao.getFoodsByName(name, pageTools.getBeginLine(), pageTools.getEndLine()));
		return pageTools;
	}

	@Override
	public boolean deleteFood(String id) {
		if(id==null || id.equals("")){
			return false;
		}
		int result = foodDao.deleteFoodById(id);
		return result>0?true:false;
	}

}
