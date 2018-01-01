package cn.fuqiang.food.dao;

import java.util.List;
import java.util.Map;

import cn.fuqiang.food.entity.OrderForm;

public interface IOrderFormDao {
	/**
	 * ����������ҳ��ѯ  ����һ����ѯ��list�����
	 * @param name   ģ�����ҵ�����
	 * @param beginLine  ��ʼ������
	 * @param endLine    ����������
	 * @return  List<OrderForm> �Ľ����
	 */
	public List<Map> getOrderFormsByName(String name,Integer beginLine,Integer endLine);
	/**
	 * ����id����һ����ѯ��OrderForm����
	 * @param id ��Ҫ������id
	 * @return OrderForm����
	 */
	public OrderForm getOrderFormById(String id);
	/**
	 * ����ģ����ѯ���������ط�������������
	 * @param name ģ�����ҵ�����
	 * @return ���ط�������������
	 */
	public int getOrderFormsCountByName(String name);
	/**
	 * ����һ��OrderFormʵ��������ݿ���
	 * @param newOrderForm ��Ҫ�������ݿ��е�ʵ��
	 * @return 0 Ϊ����ʧ������Ϊ�ɹ�
	 */
	public int addOrderForm(OrderForm newOrderForm);
	/**
	 *����һ���޸ĵ�����
	 *@param �޸ĳɹ���OrderForm����
	 *@return 0�޸�ʧ��  ����Ϊ�ɹ�
	 */
	public int updateOrderForm(OrderForm updateOrderForm);
	/**
	 * ����һ����Ҫɾ����id
	 * @param id ��Ҫɾ�����ݵ�id
	 * @return 0�޸�ʧ�� ����Ϊ�ɹ�
	 */
	public int deleteOrderFormById(String id);
}
