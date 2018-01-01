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
		//�жϴ���������Ƿ�Ϊ�������Ϊ����ת������
		Integer tId = null;
		Double p = null;
		//�����Ϊnull��ת��
		if(typeId!=null){
			tId = Integer.parseInt(typeId);
		}
		//�����Ϊnull��ת��
		if(price!=null){
			p = Double.parseDouble(price);
		}
		//��������
		Food food = new Food(tId,foodName,p,imgPath);
		//��ȡִ�н��
		int result = foodDao.addFood(food);
		//��Ϊ0��ʧ�ܣ�������ɹ�
		return result>0?true:false;
	}

	@Override
	public boolean updateFood(String foodId, String typeId, String foodName, String price, String imgPath) {
		//�жϴ���������Ƿ�Ϊ�������Ϊ����ת������
		Integer fId = null;
		Integer tId = null;
		Double p = null;
		//��Ҫ�޸ĵ�idΪnull��ֱ�ӷ���false
		if(foodId==null){
			return false;
		}
		//����Ϊ����ת��
		fId = Integer.parseInt(foodId);
		if(typeId!=null){
			tId = Integer.parseInt(typeId);
		}
		if(price!=null){
			p = Double.parseDouble(price);
		}
		//��������
		Food food = new Food(fId,tId,foodName,p,imgPath);
		//��ȡִ�н��
		int result = foodDao.updateFood(food);
		//��Ϊ0��ʧ�ܣ�������ɹ�
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
		//��ȡ�����������ݿ��е�������
		Integer totalNumber = foodDao.getFoodsCountByName(name);
		//������ҳ���߶���
		PageTools pageTools = new PageTools(cPage, totalNumber, line);
		//���鵽�����ݴ��뵽��������
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
