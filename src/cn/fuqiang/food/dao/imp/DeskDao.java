package cn.fuqiang.food.dao.imp;

import java.util.Date;
import java.util.List;
import java.util.Map;

import cn.fuqiang.food.dao.IDeskDao;
import cn.fuqiang.food.entity.Desk;
import cn.fuqiang.food.utilities.DBUtils;
import cn.fuqiang.food.utilities.DateUtils;

public class DeskDao implements IDeskDao {

	@Override
	public List<Map> getDesksByName(String name, Integer beginLine, Integer endLine) {
		String sql = "select * from (select f.*,ROWNUM rn from DESK f where DNAME like '%"+name+"%') t where t.rn between "+beginLine+" and "+endLine;
		List<Map> data = DBUtils.queryData(sql);
		return data;
	}

	@Override
	public Desk getDeskById(String id) {
		//根据一个id查出该id对应的数据
		String sql = "select * from DESK where DID="+id;
		//获取数据
		Map values = DBUtils.queryData(sql).get(0);
		//获取id
		Integer dId = values.get("DID")==null?null:Integer.parseInt(values.get("DID").toString());
		//获取名称
		String dName = values.get("DNAME")==null?null:(String) values.get("DNAME");
		//获取状态
		Integer dCondition = values.get("DCONDITION")==null?null:Integer.parseInt(values.get("DCONDITION").toString());
		//获取日期
		Date targetDate = values.get("TARGETDATE")==null?null:DateUtils.stringToDate(values.get("TARGETDATE").toString());
		//创建实体
		Desk desk = new Desk(dId, dName, dCondition, targetDate);
		return desk;
	}

	@Override
	public int getDesksCountByName(String name) {
		//根据一个姓名统计出符合条件的数据条数
		String sql = "select COUNT(ROWID) C from DESK where DNAME like '%"+name+"%'";
		//将获取的内容强转为Integer类型
		Integer count = Integer.parseInt(DBUtils.queryData(sql).get(0).get("C").toString());
		return count;
	}

	@Override
	public int addDesk(Desk newDesk) {
		//获取桌子的name
		String dName = newDesk.getdName();
		//获取桌子的状态
		Integer dCondition = newDesk.getdCondition();
		//获取桌子的预定日期
		Date targetDate = newDesk.getTargetDate();
		if(targetDate==null){
			targetDate = new Date();
		}
		String sql = "insert into DESK values((select nvl(max(DID),0)+1 from DESK),'"+dName+"',"+dCondition+",to_date('"+DateUtils.dateToString(targetDate)+"','YYYY/MM/DD hh24:mi:ss'))";
		//执行sql语句并且返回执行结果
		int result = DBUtils.execute(sql);
		return result;
	}

	@Override
	public int updateDesk(Desk updateDesk) {
		Integer dId = updateDesk.getdId();
		String dName = updateDesk.getdName();
		Integer dCondition = updateDesk.getdCondition();
		Date targetDate = updateDesk.getTargetDate();
		String sysdate = "sysdate";
		if(targetDate!=null){
			sysdate = "to_date('"+DateUtils.dateToString(targetDate)+"','YYYY/MM/DD hh24:mi:ss')";
		}
		if(dCondition==0){
			sysdate = null;
		}
		String sql = "update DESK set DNAME='"+dName+"',DCONDITION='"+dCondition+"',TARGETDATE="+sysdate+" where DID="+dId;
		//执行sql语句并且返回执行结果
		int result = DBUtils.execute(sql);
		return result;
	}

	@Override
	public int deleteDeskById(String id) {
		//根据一个id创建对应的删除语句
		String sql = "delete from DESK where DID="+id;
		//执行删除的语句
		int result = DBUtils.execute(sql);
		return result;
	}
	public static void main(String[] args) {
		DeskDao dd = new DeskDao();
		Date d = new Date();
		Desk de = new Desk(0, "炼丹房", 0, d);
		dd.addDesk(de);
	}
}
