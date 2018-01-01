package cn.fuqiang.food.service.imp;

import java.util.Date;

import cn.fuqiang.food.dao.imp.DeskDao;
import cn.fuqiang.food.entity.Desk;
import cn.fuqiang.food.service.IDeskManager;
import cn.fuqiang.food.utilities.DateUtils;
import cn.fuqiang.food.utilities.PageTools;

public class DeskManager implements IDeskManager {
	private DeskDao deskDao = new DeskDao();
	@Override
	public boolean addDesk(String dName, String dCondition, String targetDate) {
		
		//判断传入的数据是否为空如果不为空则转换类型
		Integer condition = null;
		Date date= null;
		//如果不为null则转换
		if(dCondition !=null){
			condition = Integer.parseInt(dCondition);
		}
		if(targetDate!=null){
			date = DateUtils.stringToDate(targetDate);
		}	
		Desk desk = new Desk(dName,condition,date);
		//获取执行结果
		int result = deskDao.addDesk(desk);
		//若为0则失败，其他则成功
		return result>0?true:false;
	}

	@Override
	public boolean updateDesk(String dId, String dName, String dCondition, String targetDate) {
		//判断传入的数据是否为空如果不为空则转换类型
		Integer id = null;
		Integer condition = null;
		Date date= null;
		//如果不为null则转换
		if(dId!=null){
			id = Integer.parseInt(dId);
		}
		if(dCondition !=null){
			condition = Integer.parseInt(dCondition);
		}
		if(targetDate!=null && !"".equals(targetDate)){
			date = DateUtils.stringToDate(targetDate);
		}	
		Desk desk = new Desk(id,dName,condition,date);
		//获取执行结果
		int result = deskDao.updateDesk(desk);
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
		if(lineNumber!=null){
			line=Integer.parseInt(lineNumber);
		}
		//获取该数据在数据库中的总条数
		Integer totalNumber = deskDao.getDesksCountByName(name);
		//创建分页工具对象
		PageTools pageTools = new PageTools(cPage, totalNumber, line);
		//将查到的数据存入到工具类中
		pageTools.setData(deskDao.getDesksByName(name, pageTools.getBeginLine(), pageTools.getEndLine()));
		return pageTools;
	}

	@Override
	public boolean deleteDesk(String id) {
		if(id==null || id.equals("")){
			return false;
		}
		int result = deskDao.deleteDeskById(id);
		return result>0?true:false;
	}

}
