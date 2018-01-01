package cn.fuqiang.food.dao.imp;

import java.util.List;
import java.util.Map;

import cn.fuqiang.food.dao.IFoodDao;
import cn.fuqiang.food.entity.Food;
import cn.fuqiang.food.utilities.DBUtils;

public class FoodDao implements IFoodDao {

	@Override
	public List<Map> getFoodsByName(String name, Integer beginLine, Integer endLine) {
		String sql = "select * from (select f.*,ROWNUM rn from FOOD f where FOODNAME like '%"+name+"%') t where t.rn between "+beginLine+" and "+endLine;
		List<Map> data = DBUtils.queryData(sql);
		return data;
	}

	@Override
	public Food getFoodById(String id) {
		//����һ��id�����id��Ӧ������
		String sql = "select * from FOOD where FOODID="+id;
		//��ȡ����
		Map foodValue = DBUtils.queryData(sql).get(0);
		//�ж��Ƿ�Ϊ�������Ϊ����ǿת
		Integer foodId = foodValue.get("FOODID")==null?null:Integer.parseInt(foodValue.get("FOODID").toString());
		Integer typeId = foodValue.get("TYPEID")==null?null:Integer.parseInt(foodValue.get("TYPEID").toString()); 
		String foodName = foodValue.get("FOODNAME")==null?null:(String)foodValue.get("FOODNAME");
		Double price = foodValue.get("PRICE")==null?null:Double.parseDouble(foodValue.get("PRICE").toString());
		String imgPath = foodValue.get("IMGPATH")==null?null:(String)foodValue.get("IMGPATH");
		//����һ��foodʵ��
		Food food = new Food(foodId, typeId, foodName, price, imgPath);
		return food;
	}

	@Override
	public int getFoodsCountByName(String name) {
		//����һ������ͳ�Ƴ�������������������
		String sql = "select COUNT(ROWID) C from FOOD where FOODNAME like '%"+name+"%'";
		//����ȡ������ǿתΪInteger����
		Integer count = Integer.parseInt(DBUtils.queryData(sql).get(0).get("C").toString());
		return count;
	}

	@Override
	public int addFood(Food newFood) {
		//��ȡ��ϵid
		Integer typeId = newFood.getTypeId();
		//��ȡ����
		String foodName=newFood.getFoodName();
		//��ȡ����
		Double price = newFood.getPrice();
		//��ȡ�ۿۼ�
		Double discountPrice = newFood.getDiscountPrice();
		//��ȡͼƬ·��
		String imgPath = newFood.getImgPath();
		//ƴ������ִ�е�sql���
		String sql = "insert into food values((select nvl(max(FOODID),0)+1 from FOOD),"+typeId+","+foodName+","+price+","+discountPrice+","+imgPath+")";
		//ִ��sql��䲢�ҷ���ִ�н��
		int result = DBUtils.execute(sql);
		return result;
	}

	@Override
	public int updateFood(Food updateFood) {
		Integer foodId = updateFood.getFoodId();
		//��ȡ��ϵid
		Integer typeId = updateFood.getTypeId();
		//��ȡ����
		String foodName=updateFood.getFoodName();
		//��ȡ����
		Double price = updateFood.getPrice();
		//��ȡ�ۿۼ�
		Double discountPrice = updateFood.getDiscountPrice();
		//��ȡͼƬ·��
		String imgPath = updateFood.getImgPath();
		//ƴ������ִ�е�sql���
		String sql = "update food set TYPEID="+typeId+",FOODNAME='"+foodName+"',PRICE="+price+",DISCOUNTPRICE="+discountPrice+",IMGPATH='"+imgPath+"' where FOODID="+foodId;
		//ִ��sql��䲢�ҷ���ִ�н��
		int result = DBUtils.execute(sql);
		return result;
	}

	@Override
	public int deleteFoodById(String id) {
		//����һ��id������Ӧ��ɾ�����
		String sql = "delete from FOOD where FOODID="+id;
		//ִ��ɾ�������
		int result = DBUtils.execute(sql);
		return result;
	}
}
