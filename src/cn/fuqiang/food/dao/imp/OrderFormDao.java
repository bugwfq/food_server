package cn.fuqiang.food.dao.imp;

import java.util.List;
import java.util.Map;

import cn.fuqiang.food.dao.IOrderFormDao;
import cn.fuqiang.food.entity.FoodType;
import cn.fuqiang.food.entity.OrderForm;
import cn.fuqiang.food.utilities.DBUtils;

public class OrderFormDao implements IOrderFormDao {

	@Override
	public List<Map> getOrderFormsByName(String foodID, Integer beginLine, Integer endLine) {
		String sql = "select * from (select f.*,ROWNUM rn from ORDERFORM f where FOODID like '%"+foodID+"%') t where t.rn between "+beginLine+" and "+endLine;
		List<Map> data = DBUtils.queryData(sql);
		return data;
	}

	@Override
	public OrderForm getOrderFormById(String id) {
		//根据一个id查出该id对应的数据
		String sql = "select * from ORDERFORM where FID="+id;
		//获取数据
		Map values = DBUtils.queryData(sql).get(0);
		Integer fid = values.get("FID")==null?null:Integer.parseInt(values.get("FID").toString());
		Integer foodId = values.get("FOODID")==null?null:Integer.parseInt(values.get("FOODID").toString());
		Integer did = values.get("DID")==null?null:Integer.parseInt(values.get("DID").toString());
		Integer count = values.get("COUNT")==null?null:Integer.parseInt(values.get("COUNT").toString());
		OrderForm orderForm = new OrderForm(fid, foodId, did, count);
		return orderForm;
	}

	@Override
	public int getOrderFormsCountByName(String foodId) {
		//根据一个姓名统计出符合条件的数据条数
		String sql = "select COUNT(ROWID) C from ORDERFORM where FOODID like '%"+foodId+"%'";
		//将获取的内容强转为Integer类型
		Integer count = Integer.parseInt(DBUtils.queryData(sql).get(0).get("C").toString());
		return count;
	}

	@Override
	public int addOrderForm(OrderForm newOrderForm) {
		Integer foodId = newOrderForm.getFoodId();
		Integer did = newOrderForm.getDid();
		Integer count = newOrderForm.getCount();
		String sql = "insert into ORDERFORM values((select nvl(max(FID),0)+1 from ORDERFORM),"+foodId+","+did+","+count+")";
		//执行sql语句并且返回执行结果
		int result = DBUtils.execute(sql);
		return result;
	}

	@Override
	public int updateOrderForm(OrderForm updateOrderForm) {
		Integer fId = updateOrderForm.getFid();
		Integer foodId = updateOrderForm.getFoodId();
		Integer did = updateOrderForm.getDid();
		Integer count = updateOrderForm.getCount();
		String sql = "update ORDERFORM set FOODID="+foodId+",DID="+did+",COUNT="+count+" where FID="+fId;
		//执行sql语句并且返回执行结果
		int result = DBUtils.execute(sql);
		return result;
	}

	@Override
	public int deleteOrderFormById(String id) {
		//根据一个id创建对应的删除语句
		String sql = "delete from ORDERFORM where FID="+id;
		//执行删除的语句
		int result = DBUtils.execute(sql);
		return result;
	}

}
