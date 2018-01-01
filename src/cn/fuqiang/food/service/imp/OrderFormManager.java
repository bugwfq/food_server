package cn.fuqiang.food.service.imp;

import cn.fuqiang.food.dao.imp.OrderFormDao;
import cn.fuqiang.food.entity.OrderForm;
import cn.fuqiang.food.service.IOrderFormManager;
import cn.fuqiang.food.utilities.PageTools;

public class OrderFormManager implements IOrderFormManager {
	private OrderFormDao orderForm = new OrderFormDao();
	
	@Override
	public boolean addOrderFormList(String foodID, String did, String count) {
		//�жϴ���������Ƿ�Ϊ�������Ϊ����ת������
		Integer	id = null;
		Integer dId= null;
		Integer co = null;
		//�����Ϊnull��ת��
		if(foodID!=null){
			id = Integer.parseInt(foodID);
		}
		//�����Ϊnull��ת��
		if(did!=null){
			dId = Integer.parseInt(did);
		}
		if(count!=null){
			co = Integer.parseInt(count);
		}
		//��������
		OrderForm order = new OrderForm(id, dId, co);
		//��ȡִ�н��
		int result = orderForm.addOrderForm(order);
		//��Ϊ0��ʧ�ܣ�������ɹ�
		return result>0?true:false;
	}

	@Override
	public boolean updateOrderFormList(String fid, String foodID, String did, String count) {
		//�жϴ���������Ƿ�Ϊ�������Ϊ����ת������
		Integer	id = null;
		Integer foodid= null;
		Integer dId = null;
		Integer co = null;
		//�����Ϊnull��ת��
		if(fid!=null){
			id = Integer.parseInt(fid);
		}
		if(foodID!=null){
			foodid = Integer.parseInt(foodID);
		}
		//�����Ϊnull��ת��
		if(did!=null){
			dId = Integer.parseInt(did);
		}
		if(count!=null){
			co = Integer.parseInt(count);
		}
		//��������
		OrderForm order = new OrderForm(id, foodid, dId, co);
		//��ȡִ�н��
		int result = orderForm.updateOrderForm(order);
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
		Integer totalNumber = orderForm.getOrderFormsCountByName(name);
		//������ҳ���߶���
		PageTools pageTools = new PageTools(cPage, totalNumber, line);
		//���鵽�����ݴ��뵽��������
		pageTools.setData(orderForm.getOrderFormsByName(name, pageTools.getBeginLine(), pageTools.getEndLine()));
		return pageTools;
	}

	@Override
	public boolean deleteOrderForm(String id) {
		if(id==null || id.equals("")){
			return false;
		}
		int result = orderForm.deleteOrderFormById(id);
		return result>0?true:false;
	}

	

}
