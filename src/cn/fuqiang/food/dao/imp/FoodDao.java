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
		//根据一个id查出该id对应的数据
		String sql = "select * from FOOD where FOODID="+id;
		//获取数据
		Map foodValue = DBUtils.queryData(sql).get(0);
		//判断是否为空如果不为空则强转
		Integer foodId = foodValue.get("FOODID")==null?null:Integer.parseInt(foodValue.get("FOODID").toString());
		Integer typeId = foodValue.get("TYPEID")==null?null:Integer.parseInt(foodValue.get("TYPEID").toString()); 
		String foodName = foodValue.get("FOODNAME")==null?null:(String)foodValue.get("FOODNAME");
		Double price = foodValue.get("PRICE")==null?null:Double.parseDouble(foodValue.get("PRICE").toString());
		String imgPath = foodValue.get("IMGPATH")==null?null:(String)foodValue.get("IMGPATH");
		//创建一个food实体
		Food food = new Food(foodId, typeId, foodName, price, imgPath);
		return food;
	}

	@Override
	public int getFoodsCountByName(String name) {
		//根据一个姓名统计出符合条件的数据条数
		String sql = "select COUNT(ROWID) C from FOOD where FOODNAME like '%"+name+"%'";
		//将获取的内容强转为Integer类型
		Integer count = Integer.parseInt(DBUtils.queryData(sql).get(0).get("C").toString());
		return count;
	}

	@Override
	public int addFood(Food newFood) {
		//获取菜系id
		Integer typeId = newFood.getTypeId();
		//获取菜名
		String foodName=newFood.getFoodName();
		//获取单价
		Double price = newFood.getPrice();
		//获取折扣价
		Double discountPrice = newFood.getDiscountPrice();
		//获取图片路径
		String imgPath = newFood.getImgPath();
		//拼接用于执行的sql语句
		String sql = "insert into food values((select nvl(max(FOODID),0)+1 from FOOD),"+typeId+","+foodName+","+price+","+discountPrice+","+imgPath+")";
		//执行sql语句并且返回执行结果
		int result = DBUtils.execute(sql);
		return result;
	}

	@Override
	public int updateFood(Food updateFood) {
		Integer foodId = updateFood.getFoodId();
		//获取菜系id
		Integer typeId = updateFood.getTypeId();
		//获取菜名
		String foodName=updateFood.getFoodName();
		//获取单价
		Double price = updateFood.getPrice();
		//获取折扣价
		Double discountPrice = updateFood.getDiscountPrice();
		//获取图片路径
		String imgPath = updateFood.getImgPath();
		//拼接用于执行的sql语句
		String sql = "update food set TYPEID="+typeId+",FOODNAME='"+foodName+"',PRICE="+price+",DISCOUNTPRICE="+discountPrice+",IMGPATH='"+imgPath+"' where FOODID="+foodId;
		//执行sql语句并且返回执行结果
		int result = DBUtils.execute(sql);
		return result;
	}

	@Override
	public int deleteFoodById(String id) {
		//根据一个id创建对应的删除语句
		String sql = "delete from FOOD where FOODID="+id;
		//执行删除的语句
		int result = DBUtils.execute(sql);
		return result;
	}
}
