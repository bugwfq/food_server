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
		//����һ��id�����id��Ӧ������
		String sql = "select * from DESK where DID="+id;
		//��ȡ����
		Map values = DBUtils.queryData(sql).get(0);
		//��ȡid
		Integer dId = values.get("DID")==null?null:Integer.parseInt(values.get("DID").toString());
		//��ȡ����
		String dName = values.get("DNAME")==null?null:(String) values.get("DNAME");
		//��ȡ״̬
		Integer dCondition = values.get("DCONDITION")==null?null:Integer.parseInt(values.get("DCONDITION").toString());
		//��ȡ����
		Date targetDate = values.get("TARGETDATE")==null?null:DateUtils.stringToDate(values.get("TARGETDATE").toString());
		//����ʵ��
		Desk desk = new Desk(dId, dName, dCondition, targetDate);
		return desk;
	}

	@Override
	public int getDesksCountByName(String name) {
		//����һ������ͳ�Ƴ�������������������
		String sql = "select COUNT(ROWID) C from DESK where DNAME like '%"+name+"%'";
		//����ȡ������ǿתΪInteger����
		Integer count = Integer.parseInt(DBUtils.queryData(sql).get(0).get("C").toString());
		return count;
	}

	@Override
	public int addDesk(Desk newDesk) {
		//��ȡ���ӵ�name
		String dName = newDesk.getdName();
		//��ȡ���ӵ�״̬
		Integer dCondition = newDesk.getdCondition();
		//��ȡ���ӵ�Ԥ������
		Date targetDate = newDesk.getTargetDate();
		if(targetDate==null){
			targetDate = new Date();
		}
		String sql = "insert into DESK values((select nvl(max(DID),0)+1 from DESK),'"+dName+"',"+dCondition+",to_date('"+DateUtils.dateToString(targetDate)+"','YYYY/MM/DD hh24:mi:ss'))";
		//ִ��sql��䲢�ҷ���ִ�н��
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
		//ִ��sql��䲢�ҷ���ִ�н��
		int result = DBUtils.execute(sql);
		return result;
	}

	@Override
	public int deleteDeskById(String id) {
		//����һ��id������Ӧ��ɾ�����
		String sql = "delete from DESK where DID="+id;
		//ִ��ɾ�������
		int result = DBUtils.execute(sql);
		return result;
	}
	public static void main(String[] args) {
		DeskDao dd = new DeskDao();
		Date d = new Date();
		Desk de = new Desk(0, "������", 0, d);
		dd.addDesk(de);
	}
}
