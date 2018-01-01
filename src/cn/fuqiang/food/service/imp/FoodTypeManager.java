package cn.fuqiang.food.service.imp;

import java.util.List;
import java.util.Map;

import cn.fuqiang.food.dao.imp.FoodTypeDao;
import cn.fuqiang.food.entity.FoodType;
import cn.fuqiang.food.service.IFoodTypeManager;
import cn.fuqiang.food.utilities.PageTools;

public class FoodTypeManager implements IFoodTypeManager {
	private FoodTypeDao typeDao = new FoodTypeDao();
	@Override
	public boolean addFoodType(String typeName) {
		FoodType type = new FoodType(typeName);
		//获取执行结果
		int result = typeDao.addFoodType(type);
		//若为0则失败，其他则成功
		return result>0?true:false;
	}

	@Override
	public boolean updateFoodType(String typeId, String typeName) {
		Integer id = null;
		if(typeId!=null){
			id = Integer.parseInt(typeId);
		}
		FoodType type = new FoodType(id,typeName);
		//获取执行结果
		int result = typeDao.updateFoodType(type);
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
		Integer totalNumber = typeDao.getFoodTypesCountByName(name);
		//创建分页工具对象
		PageTools pageTools = new PageTools(cPage, totalNumber, line);
		//将查到的数据存入到工具类中
		pageTools.setData(typeDao.getFoodTypesByName(name, pageTools.getBeginLine(),pageTools.getEndLine()));
		return pageTools;
	}

	@Override
	public boolean deleteFoodType(String id) {
		if(id==null || id.equals("")){
			return false;
		}
		int result = typeDao.deleteFoodTypeById(id);
		return result>0?true:false;
	}
	public List<Map> getTypeAll(){
		return typeDao.getTypeAll();
	}
}
