package cn.fuqiang.food.dao;

import java.util.List;
import java.util.Map;

import cn.fuqiang.food.entity.OrderFormList;

public interface IOrderFormListDao {
	/**
	 * ����������ҳ��ѯ  ����һ����ѯ��list�����
	 * @param name   ģ�����ҵ�����
	 * @param beginLine  ��ʼ������
	 * @param endLine    ����������
	 * @return  List<OrderFormList> �Ľ����
	 */
	public List<Map> getOrderFormListsByName(String name,Integer beginLine,Integer endLine);
	/**
	 * ����id����һ����ѯ��OrderFormList����
	 * @param id ��Ҫ������id
	 * @return OrderFormList����
	 */
	public OrderFormList getOrderFormListById(String id);
	/**
	 * ����ģ����ѯ���������ط�������������
	 * @param name ģ�����ҵ�����
	 * @return ���ط�������������
	 */
	public int getOrderFormListsCountByName(String name);
	/**
	 * ����һ��OrderFormListʵ��������ݿ���
	 * @param newOrderFormList ��Ҫ�������ݿ��е�ʵ��
	 * @return 0 Ϊ����ʧ������Ϊ�ɹ�
	 */
	public int addOrderFormList(OrderFormList newOrderFormList);
	/**
	 *����һ���޸ĵ�����
	 *@param �޸ĳɹ���OrderFormList����
	 *@return 0�޸�ʧ��  ����Ϊ�ɹ�
	 */
	public int updateOrderFormList(OrderFormList updateOrderFormList);
	/**
	 * ����һ����Ҫɾ����id
	 * @param id ��Ҫɾ�����ݵ�id
	 * @return 0�޸�ʧ�� ����Ϊ�ɹ�
	 */
	public int deleteOrderFormListById(String id);
}
