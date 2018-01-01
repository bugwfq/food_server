package cn.fuqiang.food.dao.imp;

import java.util.Date;
import java.util.List;
import java.util.Map;

import cn.fuqiang.food.dao.IOrderFormListDao;
import cn.fuqiang.food.entity.OrderForm;
import cn.fuqiang.food.entity.OrderFormList;
import cn.fuqiang.food.utilities.DBUtils;
import cn.fuqiang.food.utilities.DateUtils;

public class OrderFormListDao implements IOrderFormListDao {

	@Override
	public List<Map> getOrderFormListsByName(String fId, Integer beginLine,
			Integer endLine) {
		String sql = "select * from (select f.*,ROWNUM rn from ORDERFORMLIST f where FID like '%"+fId+"%') t where t.rn between "+beginLine+" and "+endLine;
		List<Map> data = DBUtils.queryData(sql);
		return data;
	}

	@Override
	public OrderFormList getOrderFormListById(String id) {
		//根据一个id查出该id对应的数据
		String sql = "select * from ORDERFORM where LISTID="+id;
		//获取数据
		Map values = DBUtils.queryData(sql).get(0);
		Integer listId = values.get("LISTID")==null?null:Integer.parseInt(values.get("LISTID").toString());;
		Integer fId = values.get("FID")==null?null:Integer.parseInt(values.get("FID").toString());;
		Date orderDate = values.get("ORDERDATE")==null?null:DateUtils.stringToDate(values.get("ORDERDATE").toString());
		Integer condition = values.get("CONDITION")==null?null:Integer.parseInt(values.get("CONDITION").toString());;
		OrderFormList  order = new OrderFormList(listId, fId, orderDate, condition);
		return order;
	}

	@Override
	public int getOrderFormListsCountByName(String fId) {
		//根据一个姓名统计出符合条件的数据条数
		String sql = "select COUNT(ROWID) C from ORDERFORMLIST where FID like '%"+fId+"%'";
		//将获取的内容强转为Integer类型
		Integer count = Integer.parseInt(DBUtils.queryData(sql).get(0).get("C").toString());
		return count;
	}

	@Override
	public int addOrderFormList(OrderFormList newOrderFormList) {
		Integer fId = newOrderFormList.getfId();
		Date orderDate = newOrderFormList.getOrderDate();
		Integer condition = newOrderFormList.getCondition();
		
		String sql = "insert into ORDERFORMLIST values((select nvl(max(LISTID),0)+1 from ORDERFORMLIST),"+fId+",to_date("+DateUtils.dateToString(orderDate)+",'YYYY/MM/DD hh24:mi:ss'),"+condition+")";
		//执行sql语句并且返回执行结果
		int result = DBUtils.execute(sql);
		return result;
	}

	@Override
	public int updateOrderFormList(OrderFormList updateOrderFormList) {
		Integer listId = updateOrderFormList.getListId();
		Integer fId = updateOrderFormList.getfId();
		Date orderDate = updateOrderFormList.getOrderDate();
		Integer condition = updateOrderFormList.getCondition();
		String sql = "update ORDERFORMLIST set LISTID="+listId+",FID="+fId+",ORDERDATE=to_date("+DateUtils.dateToString(orderDate)+",'YYYY/MM/DD hh24:mi:ss'),CONDITION where LISTID="+listId;
		//执行sql语句并且返回执行结果
		int result = DBUtils.execute(sql);
		return result;
	}

	@Override
	public int deleteOrderFormListById(String id) {
		//根据一个id创建对应的删除语句
		String sql = "delete from ORDERFORMLIST where LISTID="+id;
		//执行删除的语句
		int result = DBUtils.execute(sql);
		return result;
	}

}
