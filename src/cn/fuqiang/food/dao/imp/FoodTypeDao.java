package cn.fuqiang.food.dao.imp;

import java.util.Date;
import java.util.List;
import java.util.Map;

import cn.fuqiang.food.dao.IFoodTypeDao;
import cn.fuqiang.food.entity.FoodType;
import cn.fuqiang.food.utilities.DBUtils;

public class FoodTypeDao implements IFoodTypeDao {

	@Override
	public List<Map> getFoodTypesByName(String name, Integer beginLine, Integer endLine) {
		String sql = "select * from (select f.*,ROWNUM rn from FOODTYPE f where TYPENAME like '%"+name+"%') t where t.rn between "+beginLine+" and "+endLine;
		List<Map> data = DBUtils.queryData(sql);
		return data;
	}

	@Override
	public FoodType getFoodTypeById(String id) {
		//����һ��id�����id��Ӧ������
		String sql = "select * from FOODTYPE where TYPEID="+id;
		//��ȡ����
		Map values = DBUtils.queryData(sql).get(0);
		//��ȡһ����ϵid
		Integer typeId = values.get("TYPEID")==null?null:Integer.parseInt(values.get("TYPEID").toString());
		//��ȡһ����ϵ����
		String typeName =  values.get("TYPENAME")==null?null:(String)values.get("TYPENAME");
		FoodType type = new FoodType(typeId, typeName);
		return type;
	}

	@Override
	public int getFoodTypesCountByName(String name) {
		//����һ������ͳ�Ƴ�������������������
		String sql = "select COUNT(ROWID) C from FOODTYPE where TYPENAME like '%"+name+"%'";
		//����ȡ������ǿתΪInteger����
		Integer count = Integer.parseInt(DBUtils.queryData(sql).get(0).get("C").toString());
		return count;
	}

	@Override
	public int addFoodType(FoodType newFoodType) {
		//��ȡ��ϵ��id
		Integer typeId = newFoodType.getTypeId();
		//��ȡ��ϵ����
		String typeName = newFoodType.getTypeName();
		String sql = "insert into FOODTYPE values((select nvl(max(TYPEID),0)+1 from FOODTYPE),'"+typeName+"')";
		//ִ��sql��䲢�ҷ���ִ�н��
		int result = DBUtils.execute(sql);
		return result;
	}

	@Override
	public int updateFoodType(FoodType updateFoodType) {
		Integer typeId = updateFoodType.getTypeId();
		String typeName = updateFoodType.getTypeName();
		String sql = "update FOODTYPE set TYPENAME='"+typeName+"' where TYPEID="+typeId;
		//ִ��sql��䲢�ҷ���ִ�н��
		int result = DBUtils.execute(sql);
		return result;
	}

	@Override
	public int deleteFoodTypeById(String id) {
		//����һ��id������Ӧ��ɾ�����
		String sql = "delete from FOODTYPE where TYPEID="+id;
		//ִ��ɾ�������
		int result = DBUtils.execute(sql);
		return result;
	}
	
	public List<Map> getTypeAll(){
		String sql = "select * from FOODTYPE";
		List<Map> data = DBUtils.queryData(sql);
		return data;
	}
}
