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
		//根据一个id查出该id对应的数据
		String sql = "select * from FOODTYPE where TYPEID="+id;
		//获取数据
		Map values = DBUtils.queryData(sql).get(0);
		//获取一个菜系id
		Integer typeId = values.get("TYPEID")==null?null:Integer.parseInt(values.get("TYPEID").toString());
		//获取一个菜系名称
		String typeName =  values.get("TYPENAME")==null?null:(String)values.get("TYPENAME");
		FoodType type = new FoodType(typeId, typeName);
		return type;
	}

	@Override
	public int getFoodTypesCountByName(String name) {
		//根据一个姓名统计出符合条件的数据条数
		String sql = "select COUNT(ROWID) C from FOODTYPE where TYPENAME like '%"+name+"%'";
		//将获取的内容强转为Integer类型
		Integer count = Integer.parseInt(DBUtils.queryData(sql).get(0).get("C").toString());
		return count;
	}

	@Override
	public int addFoodType(FoodType newFoodType) {
		//获取菜系的id
		Integer typeId = newFoodType.getTypeId();
		//获取菜系名称
		String typeName = newFoodType.getTypeName();
		String sql = "insert into FOODTYPE values((select nvl(max(TYPEID),0)+1 from FOODTYPE),'"+typeName+"')";
		//执行sql语句并且返回执行结果
		int result = DBUtils.execute(sql);
		return result;
	}

	@Override
	public int updateFoodType(FoodType updateFoodType) {
		Integer typeId = updateFoodType.getTypeId();
		String typeName = updateFoodType.getTypeName();
		String sql = "update FOODTYPE set TYPENAME='"+typeName+"' where TYPEID="+typeId;
		//执行sql语句并且返回执行结果
		int result = DBUtils.execute(sql);
		return result;
	}

	@Override
	public int deleteFoodTypeById(String id) {
		//根据一个id创建对应的删除语句
		String sql = "delete from FOODTYPE where TYPEID="+id;
		//执行删除的语句
		int result = DBUtils.execute(sql);
		return result;
	}
	
	public List<Map> getTypeAll(){
		String sql = "select * from FOODTYPE";
		List<Map> data = DBUtils.queryData(sql);
		return data;
	}
}
