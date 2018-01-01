package cn.fuqiang.food.service.imp;

import java.util.Date;

import cn.fuqiang.food.dao.imp.OrderFormListDao;
import cn.fuqiang.food.entity.OrderFormList;
import cn.fuqiang.food.service.IOrderFormListManager;
import cn.fuqiang.food.utilities.DateUtils;
import cn.fuqiang.food.utilities.PageTools;

public class OrderFormListManager implements IOrderFormListManager {
	private OrderFormListDao listDao = new OrderFormListDao();
	@Override
	public boolean addOrderForm(String fId, String orderdate, String condition) {
		//�жϴ���������Ƿ�Ϊ�������Ϊ����ת������
		Integer id = null;
		Date date= null;
		Integer cond = null;
		//�����Ϊnull��ת��
		if(fId!=null){
			id = Integer.parseInt(fId);
		}
		//�����Ϊnull��ת��
		if(orderdate!=null){
			date = DateUtils.stringToDate(orderdate);
		}
		if(condition!=null){
			cond = Integer.parseInt(condition);
		}
		//��������
		OrderFormList orderlsi = new OrderFormList(id, date, cond);
		//��ȡִ�н��
		int result = listDao.addOrderFormList(orderlsi);
		//��Ϊ0��ʧ�ܣ�������ɹ�
		return result>0?true:false;
	}

	@Override
	public boolean updateOrderForm(String listId, String fId, String orderdate, String condition) {
		//�жϴ���������Ƿ�Ϊ�������Ϊ����ת������
		Integer id = null;
		Integer fid = null;
		Date date= null;
		Integer cond = null;
		//�����Ϊnull��ת��
		if(listId !=null){
			id = Integer.parseInt(fId);
		}
		if(fId!=null){
			fid = Integer.parseInt(fId);
		}
		//�����Ϊnull��ת��
		if(orderdate!=null || "".equals(orderdate)){
			date = DateUtils.stringToDate(orderdate);
		}
		if(condition!=null){
			cond = Integer.parseInt(condition);
		}
		//��������
		OrderFormList orderlist = new OrderFormList(id,fid, date, cond);
		//��ȡִ�н��
		int result = listDao.updateOrderFormList(orderlist);
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
		Integer totalNumber = listDao.getOrderFormListsCountByName(name);
		//������ҳ���߶���
		PageTools pageTools = new PageTools(cPage, totalNumber, line);
		//���鵽�����ݴ��뵽��������
		pageTools.setData(listDao.getOrderFormListsByName(name, pageTools.getBeginLine(), pageTools.getEndLine()));
		return pageTools;
	}

	@Override
	public boolean deleteOrderFormList(String id) {
		//�ж��Ƿ���id
		if(id==null || id.equals("")){
			return false;
		}
		int result = listDao.deleteOrderFormListById(id);
		return result>0?true:false;
	}

	

}
